package item;

import exception.IllegalCommandException;

public class UnpickableItem extends Item {

	private String description;

	public UnpickableItem(String name, String decription) throws IllegalCommandException {
		super(name);
		this.description = decription;
	}

	public String getDescription() {
		return this.description;
	}
}
