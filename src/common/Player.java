package common;

import action.Action;
import exception.IllegalParameterException;
import exception.MissingParameterException;
import item.PickableItem;
import location.Location;

/**
 * @author pawan
 *
 */
public class Player implements Name {

	private final String name;
	private Location location;
	private final Inventory<PickableItem> inventory;

	public Player(String name, Location defaultLoc) {
		this.name = name;
		this.location = defaultLoc;
		this.inventory = new Inventory<>();
	}

	public void changeLocation(Location newLocation) {
		this.location = newLocation;
	}

	public Location getLocation() {
		return this.location;
	}

	public Inventory<PickableItem> getInventory() {
		return this.inventory;
	}

	public void addToInventory(PickableItem item) {
		this.inventory.addItem(item);
	}

	public void perform(Action action) throws MissingParameterException, IllegalParameterException {
		action.performOn(this);
		System.out.println();
	}

	@Override
	public String getName() {
		return name;
	}
}
