package textrpg;

import java.util.ArrayList;

public class Inventory {
	
	private Inventory() {
		
	}
	
	public static Inventory instance = new Inventory();
	
	public static Inventory getInstance() {
		return instance;
	}
	
	private ArrayList<Item> itemList = new ArrayList<>();
	
	public void addItem(Item item) {
		itemList.add(item);
	}

}
