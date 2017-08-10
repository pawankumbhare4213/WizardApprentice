package action;

import common.Player;
import item.PickableItem;

/**
 * @author pawan
 *
 */
public class InventoryAction extends Action {

	private final static String NAME = "Inventory";

	public InventoryAction() {
		super(NAME, NAME.toLowerCase());
	}

	@Override
	public boolean performOn(Player player) {
		Iterable<PickableItem> items = player.getInventory().getItems();
		System.out.println(player.getName() + " -");
		if (items == null)
			System.out.println("Inventory is Empty.");
		else {
			System.out.print("Inventory Items - ");
			for (PickableItem item : items)
				System.out.print(item.getName() + "  ");
			System.out.println();
		}
		return true;
	}
}
