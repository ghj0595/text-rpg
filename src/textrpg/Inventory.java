package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Inventory {

	private Inventory() {

	}

	private final int EQUIP = 1;
	private final int SELL = 2;
	private final int EXIT = 3;

	private final int WEAPON = 1;
	private final int ARMOR = 2;
	private final int RING = 3;

	public static Inventory instance = new Inventory();

	public static Inventory getInstance() {
		return instance;
	}

	private StringBuffer buffer = new StringBuffer();
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	private ArrayList<Item> itemList = new ArrayList<>();

	public void inventoryMenu() {
		while (true) {
			try {
				writer.write("=====[인벤토리 메뉴]=====\n");
				writer.write("1.장비 장착\n2.판매\n3.뒤로가기\n");
				writer.flush();

				int input = Integer.parseInt(reader.readLine());

				if (input == EQUIP) {
					equip();
				} else if (input == SELL) {
					sellItem();
				} else if (input == EXIT) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void equip() {
		int index = 0;
		int sel = 0;

		Guild.instance.printGuildMembers();

		try {
			writer.write("장착할 길드원 선택");
			writer.flush();

			index = Integer.parseInt(reader.readLine()) - 1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		printItemList();

		try {
			writer.write("장착할 장비 선택");
			writer.flush();

			sel = Integer.parseInt(reader.readLine()) - 1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (itemList.get(sel).kind == WEAPON) {
			Guild.getInstance().getGuildMember(index).weapon = itemList.get(sel);
		} else if (itemList.get(sel).kind == ARMOR) {
			Guild.getInstance().getGuildMember(index).armor = itemList.get(sel);
		} else if (itemList.get(sel).kind == RING) {
			Guild.getInstance().getGuildMember(index).ring = itemList.get(sel);
		}

		try {
			writer.write("장비 착용 완료!\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		itemList.remove(sel);
	}

	private void printItemList() {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			try {
				buffer.setLength(0);
				buffer.append(count + 1 + "번.\n");
				buffer.append("[이름 : " + itemList.get(i).name + "]\n");
				buffer.append("[파워 : " + itemList.get(i).power + "]\n");
				buffer.append("[가격 : " + itemList.get(i).price + "]\n");
				writer.append(buffer);
				writer.flush();
				count++;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private void sellItem() {
		int sel = 0;
		printItemList();

		try {
			writer.write("판매할 장비 선택");
			writer.flush();

			sel = Integer.parseInt(reader.readLine()) - 1;

		} catch (IOException e) {
			e.printStackTrace();
		}
		Guild.getInstance().getGuildMember(0).money += itemList.get(sel).price;
		itemList.remove(sel);

		try {
			writer.write("장비를 판매했습니다.\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

}
