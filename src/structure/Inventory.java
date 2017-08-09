package structure;

import java.util.HashSet;
import java.util.Set;

public class Inventory implements Nameable, Commandable {

	private static final String NAME = "Inventory"; 

	private Set<Item> items;
	private final String cmd; 
	
	public Inventory() {
		this.items = new HashSet<>();
		this.cmd = NAME.toLowerCase();
	}
	
	public Iterable<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public boolean contains(Item item) {
		return this.items.contains(item);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Item item : items)
			sb.append("There is " + item.getName() + " on the floor\n");
		return sb.toString();
	}

	@Override
	public String getCMD() {
		return this.cmd;
	}

	@Override
	public String getName() {
		return Inventory.NAME;
	}
}
