package logon;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class LogonDBBean {
	private static LogonDBBean instance = new LogonDBBean();
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	private LogonDBBean() {}
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/myOracle");
		return ds.getConnection();
	}
	
	public int userCheck(String id, String passwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1;
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select passwd from tempmember where id = ?");
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					x = 1; // 인증 성공
				} else {
					x = 0; // 비밀번호 틀림
				} 
			} else {
				x = -1; // 해당 아이디 없음
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null)rs.close();}catch(SQLException e) {};
			try {if(pstm != null)pstm.close();}catch(SQLException e) {};
    		try {if(conn != null)pstm.close();}catch(SQLException e) {};
		}
		return x;
	}
}
