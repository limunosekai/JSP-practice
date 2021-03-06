package jdbc;

import java.sql.*;
import java.util.*;

public class ConnectionPool {
	// DB 드라이버 불러오기
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 초기 커넥션 저장
	private ArrayList<Connection> free;
	private ArrayList<Connection> used; // 사용중인 커넥션 저장
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String user = "mytest";
	private String passwd = "mytest";
	private int initialCons = 10; // 초기 커넥션 수
	private int maxCons = 20; // 최대 커넥션 수
	private int numCons = 0; // 총 커넥션 수
	private static ConnectionPool cp;
	
	// DB 연결 후 ConnectionPool 리턴
	public static ConnectionPool getInstance() {
		try {
			if(cp == null) {
				synchronized(ConnectionPool.class) {
					cp = new ConnectionPool();
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cp;
	}
	
	
	private ConnectionPool() throws SQLException {
		// 초기 커넥션 수만큼 ArrayList 생성
		free = new ArrayList<Connection>(initialCons);
		used = new ArrayList<Connection>(initialCons);
		
		// 초기 커넥션 수만큼 커넥션 생성
		while(numCons < initialCons) {
			addConnection();
		}
	}
	
	// free에 커넥션 객체를 저장
	private void addConnection() throws SQLException {
		free.add(getNewConnection());
	}
	
	// 새로운 커넥션 생성
	private Connection getNewConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, passwd);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("About to connect to"+ con);
		++numCons; // 커넥션 생성될 때마다 커넥선 수 증가
		return con;
	}
	
	// free에 있는 커넥션을 used로 옮기는 작업
	public synchronized Connection getConnection() throws SQLException {
		// free에 커넥션이 없으면 maxCons만큼 커넥션 생성
		if(free.isEmpty()) {
			while(numCons < maxCons) {
				addConnection();
			}
		}
		Connection _con;
		_con = free.get(free.size() -1);
		free.remove(_con);
		used.add(_con);
		return _con;
	}
	
	// used에 있는 커넥션을 free로 반납
	public synchronized void releaseConnection(Connection _con) throws SQLException {
		boolean flag = false;
		if(used.contains(_con)) {
			used.remove(_con);
			numCons--;
			flag = true;
		} else {
			throw new SQLException("ConnectionPool 없음");
		}
		try {
			if(flag) {
				free.add(_con);
				numCons++;
			} else {
				_con.close();
			}
		} catch(SQLException e) {
			try {
				_con.close();
			} catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
