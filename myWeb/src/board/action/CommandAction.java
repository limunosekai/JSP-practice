package board.action;

import javax.servlet.http.*;

public interface CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse resoponse) throws Throwable;
}
