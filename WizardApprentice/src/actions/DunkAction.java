package actions;

import exceptions.MissingParametersException;
import items.Bucket;
import items.Chain;
import locations.Garden;
import players.Player;
import structure.Action;
import structure.Inventory;
import structure.Item;

public class DunkAction extends Action {

	private static final String NAME = "Dunk";

	public DunkAction() {
		super(NAME, NAME.toLowerCase());
	}

	@Override
	public boolean performOn(Player player) throws MissingParametersException {
		if (!(player.getLocation() instanceof Garden)) {
			System.out.println("You cannot do that here.");
			return true;
		}
		Inventory playerInv = player.getInventory();
		boolean hasChain = false, hasBucket = false;
		Chain chain = null;
		Bucket bucket = null;
		for (Item item : playerInv.getItems()) {
			if (item instanceof Chain) {
				hasChain = true;
				chain = (Chain) item;
			}
			else if (item instanceof Bucket) {
				hasBucket = true;
				bucket = (Bucket) item;
			}
		}
		if (!(hasChain && hasBucket)) {
			System.out.println("You do not have the necessary items to do that.");
			return true;
		}
		if (!chain.isWelded()) {
			System.out.println("The water level is too low to reach.");
			return true;
		}
		bucket.setFilled(true);
		System.out.println("The bucket is now full of water.");
		return true;
	}
}
