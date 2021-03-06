package memberone;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

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
		} catch(Exception e) {
			System.out.println("Connection 생성 실패");
		}
		return conn;
	}
	
	// id check method
	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from student where id=?");
			pstm.setString(1,id);
			rs = pstm.executeQuery();
			// DB에 id가 없으면 결과값은 false
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
	
	// find zipcode method
	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
		try {
			conn = getConnection();
			String query = "select * from zipcode where dong like '"+ dong +"%'";
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			while(rs.next()) {
				ZipCodeVO tempZip = new ZipCodeVO();
				tempZip.setZipcode(rs.getString("zipcode"));
				tempZip.setSido(rs.getString("sido"));
				tempZip.setGugun(rs.getString("gugun"));
				tempZip.setDong(rs.getString("dong"));
				tempZip.setRi(rs.getString("ri"));
				tempZip.setBunji(rs.getString("bunji"));
				vecList.addElement(tempZip);
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
	
	// 회원가입 처리
	public boolean memberInsert(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = getConnection();
			String query = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(query);
			pstm.setString(1,vo.getId());
			pstm.setString(2,vo.getPass());
			pstm.setString(3,vo.getName());
			pstm.setString(4,vo.getPhone1());
			pstm.setString(5,vo.getPhone2());
			pstm.setString(6,vo.getPhone3());
			pstm.setString(7,vo.getEmail());
			pstm.setString(8,vo.getZipcode());
			pstm.setString(9,vo.getAddress1());
			pstm.setString(10,vo.getAddress2());
			int count = pstm.executeUpdate();
			if(count > 0) flag = true;
		} catch(Exception e) {
			System.out.println("Exception " + e);
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return flag;
	}
	
	// 로그인 체크   1: 성공, 0: 비번오류, -1: 아이디 없음
	public int loginCheck(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int check = -1;
		try {
			conn = getConnection();
			String query = "select pass from student where id=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				String dbPass = rs.getString("pass");
				if(pass.equals(dbPass)) {
					check = 1;
				} else {
					check = 0;
				}
			}
		} catch(Exception e) {
			System.out.println("Exception" + e);
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return check;
	}
	
	// 회원정보 불러오기
	public StudentVO getMember(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		StudentVO vo = null;
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from student where id=?");
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) { // 해당 회원이 존재
				vo = new StudentVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("address1"));
				vo.setAddress2(rs.getString("address2"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return vo;
	}
	
	// 회원 정보 수정
	public void updateMember(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("update student set pass=?, phone1=?, phone2=?, phone3=?, email=?,"
					+ "zipcode=?, address1=?, address2=? where id=?");
			pstm.setString(1, vo.getPass());
			pstm.setString(2, vo.getPhone1());
			pstm.setString(3, vo.getPhone2());
			pstm.setString(4, vo.getPhone3());
			pstm.setString(5, vo.getEmail());
			pstm.setString(6, vo.getZipcode());
			pstm.setString(7, vo.getAddress1());
			pstm.setString(8, vo.getAddress2());
			pstm.setString(9, vo.getId());
			pstm.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
	
	// 회원 탈퇴
	public int deleteMember(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int result = -1;
		try {
			String dbPass = getPass(id);
			if(dbPass.equals(pass)) {
				conn = getConnection();
				pstm = conn.prepareStatement("delete from student where id=?");
				pstm.setString(1, id);
				pstm.executeUpdate();
				result = 1; // 삭제 성공
			} else {
				result = 0; // 비밀번호 오류
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	
	// 비밀번호 얻어오기
	public String getPass(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String dbPass = "";
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select pass from student where id=?");
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				dbPass = rs.getString("pass");
			} else {
				System.out.println("결과 없음");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstm != null) try {pstm.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return dbPass;
	}
}
