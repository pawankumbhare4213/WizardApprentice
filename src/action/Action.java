package action;

import common.Command;
import common.Name;
import common.Player;
import exception.IllegalParameterException;
import exception.MissingParameterException;

/**
 * @author pawan This is abstract class for Action
 */
public abstract class Action implements Name, Command {

	public abstract boolean performOn(Player player) throws MissingParameterException, IllegalParameterException;

	private String name;
	private String command;

	public Action(String name, String command) {
		this.name = name;
		this.command = command;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getCommand() {
		return this.command;
	}
}
