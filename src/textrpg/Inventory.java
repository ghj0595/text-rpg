package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Inventory {
	
	private Inventory() {
		
	}
	
	public static Inventory instance = new Inventory();
	
	public static Inventory getInstance() {
		return instance;
	}
	
	private StringBuffer buffer = new StringBuffer();
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	
	private ArrayList<Item> itemList = new ArrayList<>();
	
	public void inventoryMenu() {
		while(true) {
			
		}
		
	}
	
	public void addItem(Item item) {
		itemList.add(item);
	}

}
