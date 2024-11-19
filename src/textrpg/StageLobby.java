package textrpg;

import java.io.IOException;

public class StageLobby extends Stage {
	private final String BATTLE = "1";
	private final String SETTING = "2";
	private final String EXIT = "3";
	
	private Guild guild = Guild.getInstance();

	@Override
	public boolean update() {
		try {
			writer.write("=== LOBBY ===\n");
			writer.write("1.전투\n");
			writer.write("2.설정\n");
			writer.write("3.종료\n");
			writer.flush();
			
			String input = reader.readLine();
			
			if(input.equals(BATTLE)) {
				GameManager.nextStage = "BATTLE";				
			} else if(input.equals(SETTING)) {
				GameManager.nextStage = "SETTING";				
			} else if(input.equals(EXIT)) {
				GameManager.nextStage = "";				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
		return false;
	}

	@Override
	public void init() {
		guild.setGuild();
	}

}
