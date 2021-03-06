package board.action;

import javax.servlet.http.*;
import board.model.*;

public class UpdateFormAction implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardVO article = dbPro.updateGetArticle(num);
		
		// �ش� �信�� ����� �Ӽ�
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/board/updateForm.jsp";
	}
}
