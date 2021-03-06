package jdbc;

import java.sql.*;
import java.util.*;

public class ConnectionPool {
	// DB ����̹� �ҷ�����
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// �ʱ� Ŀ�ؼ� ����
	private ArrayList<Connection> free;
	private ArrayList<Connection> used; // ������� Ŀ�ؼ� ����
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String user = "mytest";
	private String passwd = "mytest";
	private int initialCons = 10; // �ʱ� Ŀ�ؼ� ��
	private int maxCons = 20; // �ִ� Ŀ�ؼ� ��
	private int numCons = 0; // �� Ŀ�ؼ� ��
	private static ConnectionPool cp;
	
	// DB ���� �� ConnectionPool ����
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
		// �ʱ� Ŀ�ؼ� ����ŭ ArrayList ����
		free = new ArrayList<Connection>(initialCons);
		used = new ArrayList<Connection>(initialCons);
		
		// �ʱ� Ŀ�ؼ� ����ŭ Ŀ�ؼ� ����
		while(numCons < initialCons) {
			addConnection();
		}
	}
	
	// free�� Ŀ�ؼ� ��ü�� ����
	private void addConnection() throws SQLException {
		free.add(getNewConnection());
	}
	
	// ���ο� Ŀ�ؼ� ����
	private Connection getNewConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, passwd);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("About to connect to"+ con);
		++numCons; // Ŀ�ؼ� ������ ������ Ŀ�ؼ� �� ����
		return con;
	}
	
	// free�� �ִ� Ŀ�ؼ��� used�� �ű�� �۾�
	public synchronized Connection getConnection() throws SQLException {
		// free�� Ŀ�ؼ��� ������ maxCons��ŭ Ŀ�ؼ� ����
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
	
	// used�� �ִ� Ŀ�ؼ��� free�� �ݳ�
	public synchronized void releaseConnection(Connection _con) throws SQLException {
		boolean flag = false;
		if(used.contains(_con)) {
			used.remove(_con);
			numCons--;
			flag = true;
		} else {
			throw new SQLException("ConnectionPool ����");
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
