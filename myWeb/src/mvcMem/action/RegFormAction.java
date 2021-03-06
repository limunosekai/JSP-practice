package mvcMem.action;

import java.io.*;
import javax.servlet.http.*;
import mvcMem.control.ActionForward;

public class RegFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return new ActionForward("/mvcMem/regForm.jsp", false);
	}
}
