package textrpg;

public class TextRPG {
	
	private TextRPG() {
		
	}
	
	public static TextRPG instance = new TextRPG();
	
	public static TextRPG getInstance() {
		return instance;
	}
	
	private boolean isRun = true;

	
	public void run() {
		GameManager.instance.init();
		while(true) {
			isRun = GameManager.instance.changeStage();
			
			if(isRun == false) {
				break;
			}		
		}		
	}

}
