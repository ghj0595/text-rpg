package textrpg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class GameManager {
	public static GameManager instance = new GameManager();

	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String nextStage = "";

	// 현재 스테이지
	private String curStage = "";

	private Map<String, Stage> stageList = new HashMap<String, Stage>();

	private GameManager() {

	}

	public void init() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("SETTING", new StageSetting());
		nextStage = "TITLE";
	}

	public boolean changeStage() {

		try {
			writer.write("curStage : " + curStage);
			writer.newLine();
			writer.write("nextStage : " + nextStage);
			writer.newLine();			
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (curStage.equals(nextStage)) {
			return true;			
		}

		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init(); // 초기화

		boolean run = true;
		while (run) {
			run = stage.update();
			if (run == false)
				break;
		}
		// 로비에서 종료를 선택하면 false 반환
		if (nextStage.equals(""))
			return false;
		else
			return true;

	}

}
