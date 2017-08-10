package common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import action.Action;
import exception.IllegalCommandException;
import exception.IllegalParameterException;
import exception.MissingParameterException;
import item.PickableItem;

/**
 * @author pawan
 *
 */
public class CommandHandler {

	private static final Map<String, Action> CMD_ACTION_MAP;
	private static final Set<Method> ANNOTATED_METHODS;
	private static final Set<String> AVAILABLE_COMMANDS;

	private CommandHandler() {
	}

	static {
		CMD_ACTION_MAP = new HashMap<>();
		String pkgName1 = Action.class.getPackage().getName();
		Reflections reflections1 = new Reflections(pkgName1);
		Set<Class<? extends Action>> subTypes1 = reflections1.getSubTypesOf(Action.class);
		for (Class<? extends Action> cls : subTypes1) {
			try {
				Action newAction = cls.newInstance();
				if (CMD_ACTION_MAP.put(newAction.getCommand(), newAction) != null)
					System.err.println("Duplicate actions detected");
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		AVAILABLE_COMMANDS = new HashSet<>();
		String pkgName2 = Direction.class.getPackage().getName();
		Reflections reflections2 = new Reflections(pkgName2);
		Set<Class<? extends Command>> subTypes2 = reflections2.getSubTypesOf(Command.class);
		for (Class<? extends Command> cls : subTypes2) {
			try {
				if (cls.isEnum()) {
					for (Command enm : cls.getEnumConstants())
						if (!AVAILABLE_COMMANDS.add(enm.getCommand()))
							System.err.println("Duplicate commands detected");
				} else {
					Command cmd = cls.newInstance();
					if (!AVAILABLE_COMMANDS.add(cmd.getCommand()))
						System.err.println("Duplicate commands detected");
				}
			} catch (Exception e) {
			}
		}
		
		String pkgName3 = PickableItem.class.getPackage().getName();
		Reflections reflections3 = new Reflections(pkgName3);
		Set<Class<? extends PickableItem>> subTypes3 = reflections3.getSubTypesOf(PickableItem.class);
		for (Class<? extends PickableItem> cls : subTypes3) {
			try {
				if (cls.isEnum()) {
					for (Command enm : cls.getEnumConstants())
						if (!AVAILABLE_COMMANDS.add(enm.getCommand()))
							System.err.println("Duplicate commands detected");
				} else {
					Command cmd = cls.newInstance();
					if (!AVAILABLE_COMMANDS.add(cmd.getCommand()))
						System.err.println("Duplicate commands detected");
				}
			} catch (Exception e) {
			}
		}

		Reflections reflections4 = new Reflections(new ConfigurationBuilder()
				.setUrls(ClasspathHelper.forPackage(pkgName1)).setScanners(new MethodAnnotationsScanner()));
		ANNOTATED_METHODS = reflections4.getMethodsAnnotatedWith(RequiredParameter.class);
	}

	public static boolean executeCommand(Player player, String cmd) {
		boolean continues = true;
		try {
			if (cmd == null)
				throw new IllegalCommandException();
			cmd = cmd.trim().replaceAll("( )+", " ").toLowerCase();
			if (cmd.length() < 1)
				throw new IllegalCommandException();

			String[] cmds = cmd.split(" ");
			System.out.println();
			switch (cmds.length) {
			case 1:
				Action baseAction = CMD_ACTION_MAP.get(cmds[0]);
				if (baseAction == null)
					throw new IllegalCommandException();
				continues = baseAction.performOn(player);
				break;
			default:
				int i = 0;
				Action action = CMD_ACTION_MAP.get(cmds[i++]);
				if (action == null)
					throw new IllegalCommandException();
				for (Method method : ANNOTATED_METHODS) {
					if (!method.getDeclaringClass().equals(action.getClass()))
						continue;
					if (!AVAILABLE_COMMANDS.contains(cmds[i]))
						throw new IllegalParameterException();
					method.invoke(action, cmds[i++]);
				}
				if (i != cmds.length)
					throw new IllegalCommandException();
				continues = CMD_ACTION_MAP.get(cmds[0]).performOn(player);
			}
		} catch (IllegalCommandException | IllegalParameterException | MissingParameterException e) {
			System.err.println(e.getMessage());
		} catch (InvocationTargetException e) {
			try {
				throw new IllegalParameterException();
			} catch (IllegalParameterException e1) {
				System.err.println(e1.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return continues;
	}
}
