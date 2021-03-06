package mvc.action;

import mvc.control.*;
import java.io.*;
import javax.servlet.http.*;

public class IndexAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("IndexAcionÀÇ execute() ¼öÇàµÊ");
		return new ActionForward("index.jsp", false);
	}

}
