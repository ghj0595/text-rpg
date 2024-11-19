package textrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import units.Player;

public class Guild {
	
	private Guild() {
		
	}
	
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
		for(int i=0; i<guildList.size(); i++) {
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

	

}
