package board.action;

import java.sql.*;
import javax.servlet.http.*;
import board.model.*;

public class WriteProAction implements CommandAction{
	// �Էµ� �� ó��
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse resoponse) throws Throwable {
		// �ѱ� ���ڵ�
		request.setCharacterEncoding("utf-8");
		BoardVO article = new BoardVO();
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPass(request.getParameter("pass"));
		article.setRegdate(new Timestamp(System.currentTimeMillis()));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setStep(Integer.parseInt(request.getParameter("step")));
		article.setDepth(Integer.parseInt(request.getParameter("depth")));
		article.setContent(request.getParameter("content"));
		article.setIp(request.getRemoteAddr());
		BoardDAO dbPro = BoardDAO.getInstance();
		dbPro.insertArticle(article);
		return "/board/writePro.jsp";
	}
}
