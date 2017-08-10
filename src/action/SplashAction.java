package action;

import common.Inventory;
import common.Player;
import exception.MissingParameterException;
import item.Bucket;
import item.Frog;
import item.PickableItem;
import item.Wizard;

/**
 * @author pawan
 *
 */
public class SplashAction extends Action {

	private static final String NAME = "Splash";

	public SplashAction() {
		super(NAME, NAME.toLowerCase());
	}

	@Override
	public boolean performOn(Player player) throws MissingParameterException {
		if (!player.getLocation().getObjects().contains(Wizard.NAME)) {
			System.out.println("You cannot do that here.");
			return true;
		}
		Inventory<PickableItem> playerInv = player.getInventory();
		boolean hasBucket = false, hasFrog = false;
		Bucket bucket = null;
		for (PickableItem item : playerInv.getItems()) {
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
