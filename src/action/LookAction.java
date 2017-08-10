package action;

import common.Player;

/**
 * @author pawan
 *
 */
public class LookAction extends Action {

	private final static String NAME = "Look";

	public LookAction() {
		super(NAME, NAME.toLowerCase());
	}

	@Override
	public boolean performOn(Player player) {
		System.out.print(player.getName() + " - \n");
		System.out.print(player.getLocation() + "\n");
		return true;
	}
}
