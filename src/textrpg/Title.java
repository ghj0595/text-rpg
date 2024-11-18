package textrpg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Title {
	private final String PLAY = "1";
	private final String EXIT = "2";
	
	private Title() {
		
	}

	private StringBuffer buffer = new StringBuffer();
	

	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static Title instance = new Title();
	
	public static Title getInstance() {
		return instance;
	}

	public void printTitle() {
		try {
			writer.append("=====[Text RPG]=====\n");
			writer.append("1.시작\n");
			writer.append("2.종료\n");
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}

}
