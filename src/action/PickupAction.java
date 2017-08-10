package action;

import common.Inventory;
import common.Player;
import exception.IllegalParameterException;
import exception.MissingParameterException;
import item.PickableItem;
import item.UnpickableItem;

/**
 * @author pawan
 *
 */
public class PickupAction extends Action {

	private String itemCmd;
	private final static String NAME = "Pickup";

	public PickupAction() {
		super(NAME, NAME.toLowerCase());
	}

	@RequiredParameter
	public void setItem(String itemCmd) {
		this.itemCmd = itemCmd;
	}

	@Override
	public boolean performOn(Player player) throws MissingParameterException, IllegalParameterException {
		if (this.itemCmd == null)
			throw new MissingParameterException();
		
		Inventory<UnpickableItem> locObj = player.getLocation().getObjects();
		if (locObj.contains(this.itemCmd))
			throw new IllegalParameterException();
		
		Inventory<PickableItem> locInv = player.getLocation().getInventory();
		Inventory<PickableItem> playerInv = player.getInventory();
		
		if (locInv.contains(this.itemCmd)) {
			playerInv.addItem(locInv.removeItem(this.itemCmd));
			System.out.println(player.getName() + " -");
			PickableItem item = playerInv.getItem(this.itemCmd);
			System.out.println("You are now carrying " + item.getName() + ".");
		} else
			System.out.println("You cannot get that.");
		this.itemCmd = null;
		return true;
	}
}
