package textrpg;

import units.MonsterBear;
import units.Player;

public class StageBattle extends Stage {
	private Guild guild = Guild.getInstance();

	@Override
	public boolean update() {
		MonsterBear bear = new MonsterBear();
		while(true) {
			for(int i=0; i<guild.guildList.size(); i++) {
				guild.guildList.get(i).attack(bear);
				bear.attack(guild.guildList.get(i));
			}
			
			if(bear.hp == 0) {
				break;				
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}

}
