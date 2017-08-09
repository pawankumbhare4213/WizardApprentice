package actions;

import players.Player;
import structure.Action;
import structure.Direction;
import structure.Location;

public class Walk extends Action {

	private static final String NAME = "Walk";
	private Direction direction;
	
	public Walk() {
		super(NAME, NAME.toLowerCase());
	}
	
	public Walk setDirection(String dir) {
		this.direction = Direction.CMD_DIRECTION_MAP.get(dir);
		return this;
	}
	
	@Override
	public void performOn(Player player) throws Exception {
		if (direction == null) throw new Exception("Required parameter(s) is/are missing");
		Location oldLoc = player.getLocation();
		Location newLoc = oldLoc.hasPath(direction);
		System.out.println(player.getName() + " - ");
		if (newLoc != null) {
			player.changeLocation(newLoc);
			System.out.println("You walked to " + newLoc.getName() + ".");
		} else System.out.println("You cannot go that way.");
		direction = null;
	}
}