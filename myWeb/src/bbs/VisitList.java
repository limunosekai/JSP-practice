package bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	try {
    		out.println("<html>");
    		out.println("<head><title>방명록 리스트</title></head>");
    		out.println("<body>");
    		
    		StringBuffer sql = new StringBuffer();
    		sql.append("select * from visit");
    		Connection con = null;
    		PreparedStatement pstm = null;
    		ResultSet rs = null;
    		
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/visit_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","123456");
        		pstm = con.prepareStatement(sql.toString());
        		rs = pstm.executeQuery();
        		
        		while(rs.next()) {
        			int no = rs.getInt("no");
        			String writer = rs.getString("writer");
        			String memo = rs.getString("memo");
        			java.sql.Date regdate = rs.getDate("regdate");
        			out.println("<table align=center width=500 border=1>");
        			out.println("<tr>");
        			out.println("<th width=50>번호</th>");
        			out.println("<td width=50 align=center>"+no+"</td>");
        			out.println("<th width=70>작성자</th>");
        			out.println("<td width=180 align=center>"+writer+"</td>");
        			out.println("<th width=50>날짜</th>");
        			out.println("<td width=100 align=center>"+regdate+"</td>");
        			out.println("</tr>");
        			out.println("<tr>");
        			out.println("<th width=50>내용</th>");
        			out.println("<td colspan=5>&nbsp;<textarea rows=3 cols=50>"+memo+"</textarea></td>");
        			out.println("</tr>");
        			out.println("</table>");
        			out.println("<p>");
        		}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		} catch(ClassNotFoundException e) {
    			e.printStackTrace();
    		} finally {
    			try {if(pstm != null)pstm.close();}catch(SQLException e) {};
        		try {if(con != null)pstm.close();}catch(SQLException e) {};
    		}
    		out.println("<p align=center><a href=/myWeb/bbs/write.html>글쓰기</a></p>");
    		out.println("</body>");
    		out.println("</html>");
    	} finally {
    		out.close();
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
