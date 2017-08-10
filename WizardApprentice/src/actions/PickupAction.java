package actions;

import exceptions.MissingParametersException;
import players.Player;
import structure.Action;
import structure.Inventory;
import structure.RequiredParameter;

public class PickupAction extends Action {

	private String item;
	private final static String NAME = "Pickup";
	
	public PickupAction() {
		super(NAME, NAME.toLowerCase());
	}
	
	@RequiredParameter
	public void setItem(String item) {
		this.item = item;
	}
	
	@Override
	public boolean performOn(Player player) throws MissingParametersException {
		if (item == null) throw new MissingParametersException();
		Inventory locInv = player.getLocation().getInventory();
		Inventory playerInv = player.getInventory();
		if (locInv.contains(item)) {
			playerInv.addItem(locInv.removeItem(item));
			System.out.println(player.getName() + " -");
			System.out.println("You are now carrying " + playerInv.getItem(item).getName() + ".");
		} else System.out.println("You cannot get that.");
		item = null;
		return true;
	}
}
