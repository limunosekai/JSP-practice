package jdbc;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

public class TempMemberDAO {
//	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
//	private final String USER = "mytest";
//	private final String PASSWD = "mytest";
//	private ConnectionPool pool = null;
	
	public TempMemberDAO() {
//		try {
////			Class.forName(JDBC_DRIVER);
//			pool = ConnectionPool.getInstance();
//		} catch(Exception e) {
////			System.out.println("ERROR : JDBC 드라이버 로딩 실패");
//			System.out.println("ERROR : 커넥션 얻어오기 실패");
//		}
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();
		} catch(NamingException ne) {
			ne.printStackTrace();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return conn;
	}
	
	// DB에서 데이터 받아서 벡터에 저장
	public Vector<TempMemberVO> getMemberList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Vector<TempMemberVO> vecList = new Vector<TempMemberVO>();
		try {
//			conn = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
//			conn = pool.getConnection();
			conn = getConnection();
			String query = "select * from tempmember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				TempMemberVO vo = new TempMemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMem_num1(rs.getString("mem_num1"));
				vo.setMem_num2(rs.getString("mem_num2"));
				vo.setEmail(rs.getString("e_mail"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setJob(rs.getString("job"));
				vecList.add(vo);
			}
		} catch(Exception e) {
			System.out.println("Exception" + e);
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException e){}
			if(stmt != null) try {stmt.close();}catch(SQLException e){}
//			if(conn != null) try {conn.close();}catch(Exception e){}
//			if(conn != null) try {pool.releaseConnection(conn);}catch(Exception e) {}
			if(conn != null) try {conn.close();}catch(Exception e){}
		}
		return vecList;
	}
}
