package players;

import structure.Action;
import structure.Inventory;
import structure.Item;
import structure.Location;
import structure.Nameable;

public class Player implements Nameable {

	private final String name;
	private Location location;
	private final Inventory inventory;

	public Player(String name, Location defaultLoc) {
		this.name = name;
		this.location = defaultLoc;
		this.inventory = new Inventory();
	}
	
	public void changeLocation(Location newLocation) {
		this.location = newLocation;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
	public void addToInventory(Item item) {
		this.inventory.addItem(item);
	}
	
	public void perform(Action action) throws Exception {
		action.performOn(this);
		System.out.println();
	}
	
	@Override
	public String getName() {
		return name;
	}
}
