package structure;

import exceptions.MissingParametersException;
import players.Player;

public abstract class Action implements Nameable, Commandable {
	
	public abstract boolean performOn(Player player) throws MissingParametersException;
	
	private String name;
	private String cmd;
	
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
