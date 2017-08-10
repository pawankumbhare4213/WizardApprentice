package action;

import common.Command;
import common.Direction;
import common.Player;
import common.RequiredParameter;
import exception.IllegalParameterException;
import exception.MissingParameterException;
import location.Location;

/**
 * @author pawan
 *
 */
public class WalkAction extends Action {

	private final static String NAME = "Walk";

	public WalkAction() {
		super(NAME, NAME.toLowerCase());
	}

	private Direction direction;

	@RequiredParameter
	public void setDirection(String dir) throws IllegalParameterException {
		this.direction = Direction.getDirection(dir);
		if (!(this.direction instanceof Command)) throw new IllegalParameterException();
		if (this.direction == null)
			throw new IllegalParameterException();
	}

	@Override
	public boolean performOn(Player player) throws MissingParameterException {
		if (direction == null)
			throw new MissingParameterException();
		Location oldLoc = player.getLocation();
		Location newLoc = oldLoc.hasPath(direction);
		System.out.println(player.getName() + " - ");
		if (newLoc != null) {
			player.changeLocation(newLoc);
			System.out.println("You walked to " + newLoc.getName() + ".");
		} else
			System.out.println("You cannot go that way.");
		direction = null;
		return true;
	}
}