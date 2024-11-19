package textrpg;

import java.io.IOException;

public class StageLobby extends Stage {
	private final int BATTLE = 1;
	private final int SETTING = 2;
	private final int EXIT = 3;

	private Guild guild = Guild.getInstance();

	@Override
	public boolean update() {
		try {
			writer.write("==== LOBBY ===\n");
			writer.write("1.전투\n");
			writer.write("2.설정\n");
			writer.write("3.종료\n");
			writer.flush();

			int input = Integer.parseInt(reader.readLine());

			if (input == BATTLE) {
				GameManager.nextStage = "BATTLE";
			} else if (input == SETTING) {
				GameManager.nextStage = "SETTING";
			} else if (input == EXIT) {
				GameManager.nextStage = "";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void init() {
		guild.setGuild();
	}

}
