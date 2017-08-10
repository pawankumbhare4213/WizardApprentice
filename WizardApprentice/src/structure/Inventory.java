package structure;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

	private Map<String, Item> items;
	
	public Inventory() {
		this.items = new HashMap<>();
	}
	
	public Iterable<Item> getItems() {
		return this.items.values();
	}
	
	public void addItem(Item item) {
		this.items.put(item.getCMD(), item);
	}
	
	public void addItem(String name, Item item) {
		this.items.put(name, item);
	}
	
	public Item removeItem(String item) {
		return this.items.remove(item);
	}
	
	public boolean contains(String item) {
		return this.items.containsKey(item);
	}
	
	public Item getItem(String item) {
		return this.items.get(item);
	}
	
	/*
	 * StringBuilder sb = new StringBuilder();
		for (Item item : this.items.values())
			sb.append("There is " + item.getName() + " on the floor\n");
		return sb.toString();
	 * */
}
