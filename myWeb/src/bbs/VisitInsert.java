package bbs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8"); //한글처리
    	//client가  http 요청으로 전송한 값 읽기
    	String writer = request.getParameter("writer");
    	String memo = request.getParameter("memo");
    	System.out.println("작성자 : "+writer);
    	System.out.println("내용 : "+memo);
    	
    	StringBuffer sql = new StringBuffer();
    	sql.append("insert into visit(writer,memo,regdate)");
    	sql.append("values (?, ?, curdate())");
    	Connection con = null;
    	PreparedStatement pstm = null;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/visit_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","123456");
    		pstm = con.prepareStatement(sql.toString());
    		pstm.setString(1, writer);
    		pstm.setString(2, memo);
    		pstm.executeUpdate();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	} finally {
    		try {if(pstm != null)pstm.close();}catch(SQLException e) {};
    		try {if(con != null)pstm.close();}catch(SQLException e) {};
    	}
    	response.sendRedirect("VisitList");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
