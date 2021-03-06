package mvcMem.action;

import java.io.*;
import java.util.Vector;
import javax.servlet.http.*;
import mvcMem.model.*;
import mvcMem.control.ActionForward;
import mvcMem.model.StudentDAO;

public class ZipCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		StudentDAO dao = StudentDAO.getInstance();
		String check = request.getParameter("check");
		String dong = request.getParameter("dong");
		Vector<ZipCodeVO> zipcodeList = dao.zipcodeRead(dong);
		int totalList = zipcodeList.size();
		request.setAttribute("check", check);
		request.setAttribute("dong", dong);
		request.setAttribute("zipcodeList", zipcodeList);
		request.setAttribute("totalList", totalList);
		return new ActionForward("/mvcMem/zipcheck.jsp", false);
	}

}
