package location;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import common.Direction;
import common.Inventory;
import common.Name;
import doorway.Path;
import exception.IllegalPathException;
import item.Item;
import item.PickableItem;
import item.UnpickableItem;

/**
 * @author pawan This class is super class of all Location like Attic, etc. This
 *         is an undirected graph with edges as Path like Door, etc. Every
 *         location has its own inventory, parameter to indicate if there is a
 *         wizard, name, description and adjacent location connected via Path.
 */
public class Location implements Name {

	private final String name;
	private final Inventory<PickableItem> inventory;
	private final Inventory<UnpickableItem> objects;
	private final Map<Direction, Path> adj;

	public Location(String name, String description) {
		this.name = name;
		this.inventory = new Inventory<>();
		this.objects = new Inventory<>();
		this.adj = new HashMap<>();
	}

	/**
	 * To add Path between two locations of graph
	 */
	public static void addPath(Path path) throws IllegalPathException {
		Location a = path.from();
		Location b = path.to();
		// Check for null locations
		if (a == null || b == null)
			throw new IllegalPathException();
		// Creating reverse path
		Path returnPath = path.cloneOpposite();
		// Adding both paths
		a.adj.put(path.getDirection(), path);
		b.adj.put(returnPath.getDirection(), returnPath);
	}

	/**
	 * To add items in the location
	 */
	public void addItems(Item... items) {
		for (Item item : items) {
			if (item instanceof PickableItem)
				this.inventory.addItem((PickableItem) item);
			else if ((item instanceof UnpickableItem)) {
				this.objects.addItem((UnpickableItem) item);
			}
		}
	}

	/**
	 * To remove item from the location
	 */
	public void removePickableItem(String item) {
		this.inventory.removeItem(item);
	}

	/**
	 * To get all items in the location
	 */
	public Iterable<PickableItem> removePickableItems() {
		return this.inventory.getItems();
	}

	/**
	 * To check if there a path in a given direction. If present return the
	 * location else return null
	 */
	public Location hasPath(Direction direction) {
		Location newLoc = null;
		if (adj.containsKey(direction))
			newLoc = adj.get(direction).to();
		return newLoc;
	}

	/**
	 * To get the inventory of pickable items at the location
	 */
	public Inventory<PickableItem> getInventory() {
		return this.inventory;
	}

	/**
	 * To get the unpickable items at the location
	 */
	public Inventory<UnpickableItem> getObjects() {
		return this.objects;
	}

	/**
	 * To get the name of the location.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Provides full string representation of a level's map. Breadth First
	 * Search is used to print the entire level's map.
	 */
	public String toFullString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 50; i++)
			sb.append("#");
		bfs(sb, this);
		for (int i = 0; i < 50; i++)
			sb.append("#");
		return sb.toString();
	}

	/**
	 * Breadth First Search to traverse through the graph
	 */
	private static void bfs(StringBuilder sb, Location loc) {
		Set<Location> marked = new HashSet<>();
		Queue<Location> queue = new LinkedList<>();
		marked.add(loc);
		queue.add(loc);
		while (!queue.isEmpty()) {
			loc = queue.poll();
			sb.append("\n").append(loc.getName()).append(" : ");
			for (UnpickableItem item : loc.getObjects().getItems())
				sb.append("\n").append(item.getName()).append(".");
			sb.append("\nItems : ");
			for (PickableItem item : loc.getInventory().getItems())
				sb.append(item.getName()).append("\t");
			sb.append("\n");
			for (Entry<Direction, Path> entry : loc.adj.entrySet()) {
				Location nextLoc = entry.getValue().to();
				sb.append(entry.getKey()).append(" : ");
				sb.append(nextLoc.getName()).append("\t");
				sb.append("\n");
				if (!marked.contains(nextLoc)) {
					marked.add(nextLoc);
					queue.add(nextLoc);
				}
			}
		}
	}

	/**
	 * Provides string representation of a location
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("You are in ").append(getName()).append(". ");
		for (UnpickableItem item : objects.getItems())
			sb.append("\n").append(item.getDescription()).append(".");
		for (Entry<Direction, Path> entry : adj.entrySet())
			sb.append("\nThere is ").append(entry.getValue().getName()).append(" going ")
					.append(entry.getKey().getName()).append(" from here.");
		for (PickableItem item : inventory.getItems())
			sb.append("\nThere is ").append(item.getName()).append(" on the floor.");
		return sb.toString();
	}
}
