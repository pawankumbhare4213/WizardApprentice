package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import item.Item;
import item.PickableItem;

/**
 * @author pawan
 *
 */
public class Inventory<E extends Item> {

	private Map<String, Set<E>> items;

	public Inventory() {
		this.items = new HashMap<>();
	}

	public Iterable<E> getItems() {
		List<E> list = new ArrayList<>();
		for (Set<E> set : this.items.values())
			list.addAll(set);
		return list;
	}

	public void addItem(E item) {
		String command = (item instanceof PickableItem ? ((PickableItem) item).getCommand() : item.getName());
		if (this.items.containsKey(command)) {
			Set<E> set = this.items.get(command);
			set.add(item);
		} else {
			Set<E> set = new HashSet<>();
			set.add(item);
			this.items.put(command, set);
		}
	}

	public E removeItem(String command) {
		E removed = null;
		if (this.items.containsKey(command)) {
			Iterator<E> itr = this.items.get(command).iterator();
			if (itr.hasNext()) {
				removed = itr.next();
				itr.remove();
			}
			if (this.items.get(command).size() == 0)
				this.items.remove(command);
		}
		return removed;
	}

	public E removeItem(E item) {
		String command = (item instanceof PickableItem ? ((PickableItem) item).getCommand() : item.getName());
		return removeItem(command);
	}

	public E getItem(String command) {
		if (this.items.get(command) != null)
			return this.items.get(command).iterator().next();
		return null;
	}

	public E getItem(E item) {
		String command = (item instanceof PickableItem ? ((PickableItem) item).getCommand() : item.getName());
		return getItem(command);
	}

	public boolean contains(String command) {
		return this.items.containsKey(command);
	}

	public boolean contains(E item) {
		String command = (item instanceof PickableItem ? ((PickableItem) item).getCommand() : item.getName());
		return contains(command);
	}
}
