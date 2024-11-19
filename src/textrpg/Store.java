package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Store {
	private final int WEAPON = 1;
	private final int ARMOR = 2;
	private final int RING = 3;
	private final int EXIT = 0;
	
	private StringBuffer buffer = new StringBuffer();	
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private ArrayList<Item> itemList = new ArrayList<>();
	
	private Item item = new Item(WEAPON, "나무막대", 10, 1000);
	
	
	public void shopping() {
		try {
			writer.write("========[상점]========\n");
			writer.write("1.무기\t2.갑옷\t3.반지\t0.뒤로가기\n");
			writer.flush();
			
			int input = Integer.parseInt(reader.readLine());
			if(input == WEAPON) {}
			else if(input == ARMOR) {}
			else if(input == RING) {}
			else if(input == EXIT) {
				return;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
