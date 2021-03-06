package board.action;

import javax.servlet.http.*;
import board.model.*;

public class ContentAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
	// �ش� �۹�ȣ
	int num = Integer.parseInt(request.getParameter("num"));
	// �ش� ������ ��ȣ
	String pageNum = request.getParameter("pageNum");
	BoardDAO dbPro = BoardDAO.getInstance(); // DBó��
	// �ش� �۹�ȣ�� ���� �ش� ���ڵ�
	BoardVO article = dbPro.getArticle(num);
	// �ش� �信�� ����� �Ӽ�
	request.setAttribute("num", new Integer(num));
	request.setAttribute("pageNum", new Integer(pageNum));
	request.setAttribute("article", article);
	
	return "/board/content.jsp";
	}
}
