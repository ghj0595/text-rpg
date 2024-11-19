package textrpg;

import java.io.IOException;

public class StageSetting extends Stage {
	private final int STORE = 1;
	private final int INVENTORY = 2;
	private final int GUILD = 3;
	private final int SAVE = 4;
	private final int LOAD = 5;
	private final int EXIT = 0;
	
	Store store = new Store();

	@Override
	public boolean update() {
		
		try {
			writer.write("=======[MENU]=======\n");
			writer.write("1.상점\t2.인벤토리\t3.길드관리\n");
			writer.write("4.저장\t5.로드\t0.종료\n");
			writer.flush();
			
			int input = Integer.parseInt(reader.readLine());
			
			if(input == STORE) {
				store.shopping();
			}
			else if(input == INVENTORY) {}
			else if(input == GUILD) {}
			else if(input == SAVE) {}
			else if(input == LOAD) {}
			else if(input == EXIT) {
				GameManager.nextStage = "";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void init() {

	}

}
