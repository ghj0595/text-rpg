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

	public Store() {

		Item item = new Item();
		item.kind = WEAPON;
		item.name = "나무막대";
		item.power = 10;
		item.price = 1000;
		itemList.add(item);

		item = new Item();
		item.kind = WEAPON;
		item.name = "양날도끼";
		item.power = 15;
		item.price = 1500;
		itemList.add(item);

		item = new Item();
		item.kind = WEAPON;
		item.name = "목검";
		item.power = 20;
		item.price = 2000;
		itemList.add(item);

		item = new Item();
		item.kind = ARMOR;
		item.name = "반팔티셔츠";
		item.power = 5;
		item.price = 1000;
		itemList.add(item);

		item = new Item();
		item.kind = ARMOR;
		item.name = "파란조끼";
		item.power = 7;
		item.price = 1500;
		itemList.add(item);

		item = new Item();
		item.kind = ARMOR;
		item.name = "방탄조끼";
		item.power = 10;
		item.price = 2000;
		itemList.add(item);

		item = new Item();
		item.kind = RING;
		item.name = "실버링";
		item.power = 3;
		item.price = 500;
		itemList.add(item);

		item = new Item();
		item.kind = RING;
		item.name = "골드링";
		item.power = 5;
		item.price = 1000;
		itemList.add(item);

		item = new Item();
		item.kind = RING;
		item.name = "루비반지";
		item.power = 7;
		item.price = 1500;
		itemList.add(item);
	}

	public void shopping() {
		while(true) {
			
			try {
				writer.write("========[상점]========\n");
				writer.write("1.무기\t2.갑옷\t3.반지\n0.뒤로가기\n");
				writer.flush();
				
				int input = Integer.parseInt(reader.readLine());
				if (input == WEAPON) {
					printItem(WEAPON);
				} else if (input == ARMOR) {
					printItem(ARMOR);
				} else if (input == RING) {
					printItem(RING);
				} else if (input == EXIT) {
					return;
				}
				
				writer.write("구매할 아이템 번호 입력\n");
				writer.flush();
				
				int sel = Integer.parseInt(reader.readLine());
				
				buyItem(input, sel);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void printItem(int kind) {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).kind == kind) {
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
	}

	private void buyItem(int kind, int input) {
		buffer.setLength(0);
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).kind == kind) {
				count++;
				if (count == input) {
					// 아이템 구매
					// 플레이어 money - 구현
					// Inventory에 아이템 추가
					Guild.instance.guildList.get(0).money -= itemList.get(i).price;
					Inventory.instance.addItem(itemList.get(i));
					buffer.append("[");
					buffer.append(itemList.get(i).name);
					buffer.append("]을 구입했습니다.\n");
					try {
						writer.append(buffer);
						writer.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

}
