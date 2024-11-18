package textrpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager extends Thread {
	
	private InputManager(){
		
	}
	
	public static InputManager instance = new InputManager();
	
	public static InputManager getInstance() {
		return instance;
	}
	
	private StringBuffer buffer = new StringBuffer();

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private static String input = "";
	
	@Override
	public void run() {
		while(true) {
			try {
				buffer.setLength(0);
				buffer.append(reader.readLine());
				input = buffer.toString();
				
				if(input.equals("next")) {
					System.out.println("Clear");
				} else {
					System.out.println("Beep-");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
