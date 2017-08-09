package actions;

import players.Player;
import structure.Action;

public class Look extends Action {
	
	private static final String NAME = "Look";
	
	public Look() {
		super(NAME, NAME.toLowerCase());
	}
	
	@Override
	public void performOn(Player player) {
		System.out.print(player.getName() + " - \n");
		System.out.print(player.getLocation() + "\n");
	}
}
