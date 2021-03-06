package mvc.control;

import mvc.action.*;

public class ActionFactory {
	private static ActionFactory factory;
	private ActionFactory() {}
	public static synchronized ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("index")) {
			action = new IndexAction();
		} // 이 곳에 액션을 계속 추가
		return action;
	}
}
