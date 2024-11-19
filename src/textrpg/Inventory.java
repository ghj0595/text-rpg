package textrpg;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> itemList = new ArrayList<>();
	
	public void addItem(Item item) {
		itemList.add(item);
	}

}
