package actions;

import exceptions.MissingParametersException;
import items.Bucket;
import items.Frog;
import locations.LivingRoom;
import players.Player;
import structure.Action;
import structure.Inventory;
import structure.Item;

public class SplashAction extends Action {

	private static final String NAME = "Splash";

	public SplashAction() {
		super(NAME, NAME.toLowerCase());
	}

	@Override
	public boolean performOn(Player player) throws MissingParametersException {
		if (!(player.getLocation() instanceof LivingRoom)) {
			System.out.println("You cannot do that here.");
			return true;
		}
		Inventory playerInv = player.getInventory();
		boolean hasBucket = false, hasFrog = false;
		Bucket bucket = null;
		for (Item item : playerInv.getItems()) {
			if (item instanceof Bucket) {
				hasBucket = true;
				bucket = (Bucket) item;
			} else if (item instanceof Frog) {
				hasFrog = true;
			}
		}
		if (!(hasBucket)) {
			System.out.println("You have nothing to splash with.");
			return true;
		}
		if (!bucket.isFilled()) {
			System.out.println("The bucket is empty.");
			return true;
		}
		if (hasFrog) {
			System.out.println("The wizard awakens and sees that you stole his frog. " 
					+ "He is so upset that he banishes you to the netherworlds. You lose! The end.");
		} else {
			System.out.println("The wizard awakens from his slumber and greets you warmly. " 
					+ "He hands you the magic low-carb donut. You win. The end.");
		}
		return false;
	}
}
