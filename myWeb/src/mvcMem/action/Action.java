package mvcMem.action;

import java.io.*;
import javax.servlet.http.*;
import mvcMem.control.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
