package textrpg;

import java.io.IOException;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		try {
			writer.write("==== TEXT RPG ====\n");
			writer.write("[시작] 을 입력하세요\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}

		try {
			String input = reader.readLine();

			if (input.equals("시작"))	{
				System.out.println("됐냐!?");
				GameManager.nextStage = "LOBBY";				
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
