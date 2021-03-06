package board.action;

import javax.servlet.http.*;

public class WriteFormAction implements CommandAction {
	// �� �Է��� ó��
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse resoponse) throws Throwable {
		// ����۰� �亯���� ����
		int num = 0;
		int ref = 0;
		int step = 0;
		int depth = 0;
		try {
			if(request.getParameter("num") != null) {
				num = Integer.parseInt(request.getParameter("num"));
				ref = Integer.parseInt(request.getParameter("ref"));
				step = Integer.parseInt(request.getParameter("step"));
				depth = Integer.parseInt(request.getParameter("depth"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		// �ش� �信�� ����� �Ӽ�
		request.setAttribute("num", new Integer(num));
		request.setAttribute("ref", new Integer(ref));
		request.setAttribute("step", new Integer(step));
		request.setAttribute("depth", new Integer(depth));
		return "/board/writeForm.jsp";
	}
}
