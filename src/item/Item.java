package item;

import common.Name;
import exception.IllegalCommandException;

/**
 * @author pawan
 *
 */
public class Item implements Name {

	private String name;

	protected Item(String name) throws IllegalCommandException {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
