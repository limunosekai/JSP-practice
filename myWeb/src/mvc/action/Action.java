package mvc.action;

import mvc.control.ActionForward;
import java.io.*;
import javax.servlet.http.*;

public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
