package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

import units.Player;

public class Guild {

	private Guild() {

	}

	private final int LIST = 1;
	private final int JOIN = 2;
	private final int LEAVE = 3;
	private final int PARTY = 4;
	private final int EXIT = 0;

	private Random random = new Random();

	public static Guild instance = new Guild();

	public static Guild getInstance() {
		return instance;
	}

	private StringBuffer buffer = new StringBuffer();
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	ArrayList<Player> guildList = new ArrayList<>();

	public void setGuild() {
		guildList.add(new Player("전사", 1, 1000, 50, 70, 0));
		guildList.add(new Player("마법사", 1, 500, 70, 50, 0));
		guildList.add(new Player("암살자", 1, 700, 70, 50, 0));
	}

	public void printGuildMembers() {
		for (int i = 0; i < guildList.size(); i++) {
			buffer.setLength(0);
			buffer.append(i + 1 + "번.\n");
			buffer.append("[직업] : " + guildList.get(i).name + "\n");
			buffer.append("[레벨] : " + guildList.get(i).level + "\n");
			buffer.append("[공격력] : " + guildList.get(i).att + "\n");
			try {
				writer.append(buffer);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Player getGuildMember(int index) {
		return guildList.get(index);
	}

	public void guildMenu() {
		while (true) {
			buffer.setLength(0);
			buffer.append("=====[길드관리]=====\n");
			buffer.append("1.길드원 목록\n");
			buffer.append("2.길드원 영입\n");
			buffer.append("3.길드원 추방\n");
			buffer.append("4.파티원 교체\n");
			buffer.append("0.뒤로가기\n");

			try {
				writer.append(buffer);
				writer.flush();

				int input = Integer.parseInt(reader.readLine());

				if (input == LIST) {
					printGuildMembers();
				} else if (input == JOIN) {
					joinGuild();
				} else if (input == LEAVE) {
				} else if (input == PARTY) {
				} else if (input == EXIT) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void joinGuild() {
		String[] names = { "전사", "마법사", "암살자", "치유사", "궁사" };
		String name = names[random.nextInt(names.length)];

		int rNum = random.nextInt(9) + 1;

		int hp = rNum * 100;
		int att = rNum * 10;
		int def = rNum * 10;

		Player member = new Player(name, 1, hp, att, def, 0);
		buffer.setLength(0);
		buffer.append("=============================\n");
		buffer.append("[직업] : " + name + "\n");
		buffer.append("[HP] : " + hp + "\n");
		buffer.append("[공격력] : " + att + "\n");
		buffer.append("[방어력] : " + def + "\n");
		buffer.append("길드원을 영입합니다.\n");
		buffer.append("=============================\n");

		try {
			writer.append(buffer);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		guildList.add(member);
	}

}
