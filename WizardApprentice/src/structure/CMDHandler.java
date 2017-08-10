package structure;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import exceptions.IllegalCommandException;
import exceptions.MissingParametersException;
import players.Player;

public final class CMDHandler {

	private static final Map<String, Action> CMD_ACTION_MAP;
	private static final Set<Method> ANNOTATED_METHODS;
	
	private CMDHandler() {}
	
	static {
		CMD_ACTION_MAP = new HashMap<>();

		Reflections reflections1 = new Reflections("actions");
		Set<Class<? extends Action>> subTypes1 = reflections1.getSubTypesOf(Action.class);
		for (Class<? extends Action> cls : subTypes1) {
			try {
				Action newAction = cls.newInstance();
				if (CMD_ACTION_MAP.put(newAction.getCMD(), newAction) != null)
					System.err.println("Duplicate actions detected");
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		Reflections reflections3 = new Reflections(new ConfigurationBuilder()
	            .setUrls(ClasspathHelper.forPackage("actions"))
	            .setScanners(new MethodAnnotationsScanner()));
		ANNOTATED_METHODS = reflections3.getMethodsAnnotatedWith(RequiredParameter.class);
	}
	
	public static boolean executeCMD(Player player, String cmd) throws IllegalCommandException, MissingParametersException {
		if (cmd == null) throw new IllegalCommandException();
		cmd = cmd.trim().replaceAll("( )+", " ").toLowerCase();
		if (cmd.length() < 1) throw new IllegalCommandException();
		String[] cmds = cmd.split(" ");
		System.out.println();
		boolean continues = true;
		switch (cmds.length) {
			case 1:
				Action baseAction = CMD_ACTION_MAP.get(cmds[0]);
				if (baseAction != null) continues = baseAction.performOn(player);
				else throw new IllegalCommandException();
				break;				
			default:
				try {
					int i = 0;
					Action action = CMD_ACTION_MAP.get(cmds[i++]);
					for (Method method : ANNOTATED_METHODS) {
						if (!method.getDeclaringClass().equals(action.getClass())) continue;
						method.invoke(action, cmds[i++]);
					}
					if (i != cmds.length) throw new IllegalCommandException();
					continues = CMD_ACTION_MAP.get(cmds[0]).performOn(player);
				} catch (Exception e) {
					throw new IllegalCommandException();
				}
		}
		return continues;
	}
}
