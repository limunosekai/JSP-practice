package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	
    	// db에서 사용자 정보 조회
    	StringBuffer sql = new StringBuffer();
    	sql.append("select * from login");
    	Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
    	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/visit_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","123456");
    		pstm = con.prepareStatement(sql.toString());
    		rs = pstm.executeQuery();
    		
    		while(rs.next()) {
    			String dbId = rs.getString("id");
    			String dbPwd = rs.getString("pass");
    			
    			if(dbId.equals(id) && dbPwd.equals(pwd)) {
    	    		HttpSession session = request.getSession();
    	    		// 클라 정보를 HttpSession에 저장
    	    		session.setAttribute("user", id);
    	    	}
    		}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {if(rs != null)rs.close();}catch(SQLException e) {};
			try {if(pstm != null)pstm.close();}catch(SQLException e) {};
    		try {if(con != null)pstm.close();}catch(SQLException e) {};
		}
    	response.sendRedirect("Login");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
