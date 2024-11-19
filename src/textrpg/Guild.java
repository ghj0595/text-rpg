package textrpg;

import java.util.ArrayList;

import units.Player;

public class Guild {
	
	public Guild() {
		
	}
	
	public static Guild instance = new Guild();
	
	public static Guild getInstance() {
		return instance;
	}
	
	ArrayList<Player> guildList = new ArrayList<>();
	
	public void setGuild() {
		guildList.add(new Player("전사", 1, 1000, 50, 70, 0));
		guildList.add(new Player("마법사", 1, 500, 70, 50, 0));
		guildList.add(new Player("암살자", 1, 700, 70, 50, 0));
	}

	

}
