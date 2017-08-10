package structure;

public abstract class Item implements Nameable, Commandable {

	private String name;
	private String cmd;
	
	public Item(String name, String cmd) {
		this.name = name;
		this.cmd = cmd;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getCMD() {
		return this.cmd;
	}
}
