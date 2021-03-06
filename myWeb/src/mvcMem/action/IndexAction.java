package mvcMem.action;

import java.io.*;
import javax.servlet.http.*;
import mvcMem.control.*;

public class IndexAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return new ActionForward("/mvcMem/index.jsp", false);
	}
}
