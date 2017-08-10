package actions;

import exceptions.MissingParametersException;
import map.Direction;
import map.Location;
import players.Player;
import structure.Action;
import structure.RequiredParameter;

public class WalkAction extends Action {
	
	private final static String NAME = "Walk";
	
	public WalkAction() {
		super(NAME, NAME.toLowerCase());
	}

	private Direction direction;
	
	@RequiredParameter
	public void setDirection(String dir) {
		this.direction = Direction.getDirection(dir);
	}
	
	@Override
	public boolean performOn(Player player) throws MissingParametersException {
		if (direction == null) throw new MissingParametersException();
		Location oldLoc = player.getLocation();
		Location newLoc = oldLoc.hasPath(direction);
		System.out.println(player.getName() + " - ");
		if (newLoc != null) {
			player.changeLocation(newLoc);
			System.out.println("You walked to " + newLoc.getName() + ".");
		} else System.out.println("You cannot go that way.");
		direction = null;
		return true;
	}
}