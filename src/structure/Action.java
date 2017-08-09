package structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import players.Player;

public abstract class Action implements Nameable, Commandable {
	
	public abstract void performOn(Player player) throws Exception;
	
	private String name;
	private String cmd;
	public static final Map<String, Action> CMD_ACTION_MAP;
	
	static {
		CMD_ACTION_MAP = new HashMap<>();
		Reflections reflections = new Reflections("actions");
		Set<Class<? extends Action>> subTypes = reflections.getSubTypesOf(Action.class);
		for (Class<? extends Action> cls : subTypes) {
			try {
				Action newAction = cls.newInstance();
				CMD_ACTION_MAP.put(newAction.getCMD(), newAction);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Action(String name, String cmd) {
		this.name = name;
		this.cmd = cmd;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getCMD() {
		return this.cmd;
	}
}
