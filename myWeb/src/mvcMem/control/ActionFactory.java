package mvcMem.control;

import mvcMem.action.*;

public class ActionFactory {
	private static ActionFactory factory;
	private ActionFactory() {}
	// ΩÃ±€≈Ê ∆–≈œ
	public static synchronized ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		switch(cmd) {
		case "idCheck":
			action = new IdCheckAction();
		case "zipCheck":
			action = new ZipCheckAction();
		}
		return action;
	}
}
