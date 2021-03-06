package board.action;

import java.util.*;
import javax.servlet.http.*;
import board.model.*;

public class ListAction implements CommandAction { // 글 목록 처리
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse resoponse) throws Throwable {
		String pageNum = request.getParameter("pageNum"); // 페이지 번호
		if(pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 5; // 한 페이지의 글 개수
		int currentPage = Integer.parseInt(pageNum);
		// 한 페이지의 시작글 번호
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize; // 한 페이지의 마지막 글 번호
		int count = 0;
		int number = 0;
		List<BoardVO> articleList = null;
		BoardDAO dbPro = BoardDAO.getInstance(); // DB 연동
		count = dbPro.getArticleCount(); // 전체 글 개수
		if(count > 0) { // 현재 페이지에 해당하는 글 개수
			articleList = dbPro.getAriticles(startRow, endRow);
		} else {
			articleList = Collections.emptyList();
		}
		number = count - (currentPage - 1) * pageSize; // 글 목록에 표시할 글 번호
		// 해당 뷰에서 사용할 속성
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
		return "/board/list.jsp"; // 해당 뷰
	}
}
