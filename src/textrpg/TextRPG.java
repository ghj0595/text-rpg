package textrpg;

public class TextRPG {
	
	private TextRPG() {
		
	}
	
	public static TextRPG instance = new TextRPG();
	
	public static TextRPG getInstance() {
		return instance;
	}
	
	private InputManager input;
	private Thread inputThread;
	private StageManager stage;
	private Thread stageThread;
	
	public void run() {
		init();
		play();
	}
	
	private void init() {
		input = InputManager.getInstance();
		inputThread = new Thread(input);	
		
		stage = StageManager.getInstance();
		stageThread = new Thread(stage);
	}
	
	private void play() {
		inputThread.start();
		stageThread.start();
	}

}
