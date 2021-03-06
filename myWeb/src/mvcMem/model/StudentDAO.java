package mvcMem.model;

import java.sql.*;
import java.util.Vector;
import javax.naming.*;
import javax.sql.DataSource;

public class StudentDAO {
	private static StudentDAO instance = null;
	private StudentDAO() {}
	public static StudentDAO getInstance() {
		if(instance == null) {
			synchronized(StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();
		} catch(NamingException e) {
			System.out.println("Connection 积己角菩");
		} catch(SQLException e) {
			System.out.println("Connection 积己角菩");
		}
		return conn;
	}
	
	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from student where id=?");
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(!rs.next()) result = false;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	
	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Vector<ZipCodeVO> vecList = new Vector<>();
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from zipcode where dong like '"+dong+"%'");
			rs = pstm.executeQuery();
			while(rs.next()) {
				ZipCodeVO temp = new ZipCodeVO();
				temp.setZipcode(rs.getString("zipcode"));
				temp.setSido(rs.getString("sido"));
				temp.setGugun(rs.getString("gugun"));
				temp.setDong(rs.getString("dong"));
				temp.setRi(rs.getString("ri"));
				temp.setBunji(rs.getString("bunji"));
				vecList.addElement(temp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return vecList;
	}
}
