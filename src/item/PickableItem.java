package item;

import common.Command;
import exception.IllegalCommandException;

public class PickableItem extends Item implements Command {

	private String command;

	protected PickableItem(String name, String command) throws IllegalCommandException {
		super(name);
		if (command.contains(" "))
			throw new IllegalCommandException();
		this.command = command;
	}

	@Override
	public String getCommand() {
		return this.command;
	}
}
