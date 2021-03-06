package board.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import board.action.*;

public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ��ɾ�� ���� ó�� Ŭ������ ������ ����
	private Map<String,Object> commandMap = new HashMap<>();
	// ��ɾ�� ó�� Ŭ������ ���εǾ��ִ� properties������ �о Map ��ü��
	// commandMap�� ����
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		//dd���� propertyConfig�� �ش��ϴ� init-param�� ���� ����
		String props = config.getInitParameter("propertyConfig");
		// ��ɾ�� ó��Ŭ������ ���������� ������ Properties ��ü ����
		Properties pr = new Properties();
		FileInputStream f = null;
		String path = config.getServletContext().getRealPath("/WEB-INF");
		try {
			// Command.properties ������ ������ �о��
			f = new FileInputStream(new File(path, props));
			// Command.properties ������ ������ Properties ��ü�� ����
			pr.load(f);
		} catch(IOException e) {
			throw new ServletException(e);
		} finally {
			if(f != null) try {f.close();} catch(IOException e) {}
		}
		// Iterator ��ü�� Enumeration ��ü�� Ȯ���Ų ������ ��ü
		Iterator<Object> keyIter = pr.keySet().iterator();
		// ��ü�� �ϳ��� ������ �� ��ü������ Properties ��ü�� ����� ��ü�� ����
		while(keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String className = pr.getProperty(command);
			try {
				// �ش� ���ڿ��� Ŭ������ �����
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance(); // �ش� Ŭ������ ��ü ����
				// Map ��ü�� commandMap�� ��ü ����
				commandMap.put(command, commandInstance);
			} catch(ClassNotFoundException e) {
				throw new ServletException(e);
			} catch(InstantiationException e) {
				throw new ServletException(e);
			} catch(IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	// get ����� ���� �޼ҵ�
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	// post ����� ���� �޼ҵ�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}
	
	// ������� ��û�� �м��ؼ� �ش� �۾��� ó��
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		try {
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandAction) commandMap.get(command);
			view = com.requestPro(request, response);
		} catch(Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
