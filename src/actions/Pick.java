package actions;

import players.Player;
import structure.Action;
import structure.Item;

public class Pick extends Action {

	private static final String NAME = "Pick";
	private Item item;
	
	public Pick() {
		super(NAME, NAME.toLowerCase());
	}
	
	public Pick setItem(Item item) {
		this.item = item;
		return this;
	}
	
	@Override
	public void performOn(Player player) throws Exception {
		if (item == null) throw new Exception("Required parameter(s) is/are missing");
		if (player.getLocation().getInventory().contains(item)) {
			player.getLocation().getInventory().removeItem(item);
			player.getInventory().addItem(item);
			System.out.println(player.getName() + " -");
			System.out.println("You are now carrying " + item.getName() + ".");
		} else System.out.println("You cannot get that.");
		item = null;
	}
}
