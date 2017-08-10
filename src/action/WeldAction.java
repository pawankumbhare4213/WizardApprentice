package action;

import common.Inventory;
import common.Player;
import exception.MissingParameterException;
import item.Bucket;
import item.Chain;
import item.PickableItem;
import item.WeldingTorch;

/**
 * @author pawan
 *
 */
public class WeldAction extends Action {

	private final static String NAME = "Weld";

	public WeldAction() {
		super(NAME, NAME.toLowerCase());
	}

	@Override
	public boolean performOn(Player player) throws MissingParameterException {
		if (!(player.getLocation().getObjects().contains(WeldingTorch.NAME))) {
			System.out.println("You cannot do that here.");
			return true;
		}
		Inventory<PickableItem> playerInv = player.getInventory();
		boolean hasChain = false, hasBucket = false;
		Chain chain = null;
		for (PickableItem item : playerInv.getItems()) {
			if (item instanceof Chain) {
				hasChain = true;
				chain = (Chain) item;
			} else if (item instanceof Bucket)
				hasBucket = true;
		}
		if (!(hasChain && hasBucket)) {
			System.out.println("You do not have the necessary items to do that.");
			return true;
		}
		if (chain.isWelded()) {
			System.out.println("The chain is already welded.");
			return true;
		}
		chain.setWelded(true);
		System.out.println("The chain is now securely welded to the bucket.");
		return true;
	}
}
