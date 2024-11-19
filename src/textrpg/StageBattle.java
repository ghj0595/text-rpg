package textrpg;

import units.MonsterBear;
import units.Player;

public class StageBattle extends Stage {
	private Guild guild = Guild.getInstance();

	@Override
	public boolean update() {
		boolean isRun = true;
		MonsterBear bear = new MonsterBear();
		while (isRun) {
			for (int i = 0; i < guild.guildList.size(); i++) {
				guild.guildList.get(i).attack(bear);
				if (bear.hp == 0) {
					isRun = false;
					break;
				}
				bear.attack(guild.guildList.get(i));
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}

}
