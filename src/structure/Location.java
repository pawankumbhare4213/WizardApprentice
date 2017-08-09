package structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Location implements Nameable {
	
	private final String name;
	private final String description;
	private final Inventory inventory;
	private Map<Direction, Path> adj;
	private boolean hasWizard;
	
	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		this.inventory = new Inventory();
		this.hasWizard = false;
		this.adj = new HashMap<>();
	}
	
	public static void addPath(Path path) throws Exception {
        Location a = path.from();
        Location b = path.to();
        if (a == null || b == null) throw new Exception("Invalid Path");
        Path returnPath = path.cloneOpposite();
        a.adj.put(path.getDirection(), path);
        b.adj.put(returnPath.getDirection(), returnPath);
	}
	
	public void addItems(Item... items) {
		for (Item item : items) 
			this.inventory.addItem(item);
	}
	
	public void removeItem(Item item) {
		this.inventory.removeItem(item);
	}
	
	public Iterable<Item> getItems() {
		return this.inventory.getItems();
	}
	
	public Location hasPath(Direction direction) {
		Location newLoc = null;
		if (adj.containsKey(direction))
			newLoc = adj.get(direction).to();
		return newLoc;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public boolean hasWizard() {
		return hasWizard;
	}

	public void setHasWizard(boolean hasWizard) {
		this.hasWizard = hasWizard;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public String toFullString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 50; i++) sb.append("#");
		dfs(sb, this);
        for (int i = 0; i < 50; i++) sb.append("#");
        return sb.toString();
	}
	
	private static void dfs(StringBuilder sb, Location loc) {
		dfs(sb, loc, new HashSet<>());
	}
	
	public static void dfs(StringBuilder sb, Location loc, Set<Location> marked) {
		marked.add(loc);
		sb.append("\n").append(loc.getName()).append(" : ")
			.append((loc.hasWizard() ? "Has Wizard" : ""))
			.append("\nItems : ");
		
	    for (Item item : loc.getItems()) 
	    	sb.append(item.getName()).append(", ");

	    sb.append("\n");

        for (Entry<Direction, Path> entry : loc.adj.entrySet()) {
		    Location newLoc = entry.getValue().to();
        	sb.append(entry.getKey()).append(" : ");
			sb.append(newLoc.getName()).append(", ");
	    	sb.append("\n");
	    	
            if (!marked.contains(newLoc))
                dfs(sb, newLoc, marked);
        }
    }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("You are in ")
			.append(getName())
			.append(". ")
        	.append(description)
			.append(".");
    	for (Entry<Direction, Path> entry : adj.entrySet())
    		sb.append("\nThere is ")
    			.append(entry.getValue().getName())
    			.append(" going ")
    			.append(entry.getKey().getName())
    			.append(" from here.");
        for (Item item : inventory.getItems()) 
        	sb.append("\nThere is ")
        		.append(item.getName())
        		.append(" on floor.");
        return sb.toString();
    }
}
