package mvcMem.control;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mvcMem.action.Action;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cmd = request.getParameter("cmd");
		if(cmd != null) {
			ActionFactory factory = ActionFactory.getInstance();
			Action action = factory.getAction(cmd);
			ActionForward af = action.execute(request, response);
			if(af.isRedirect()) {
				response.sendRedirect(af.getUrl());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
				rd.forward(request, response);
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			out.println("<h4>�ùٸ� ��û�� �ƴմϴ�.</h4>");
			out.println("<h4>http://localhost:8080/myWeb/mvcMem/member.mdo?cmd=��ûŰ����</h4>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
