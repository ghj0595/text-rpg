package textrpg;

public class StageManager implements Runnable {
	
	private StageManager() {
		
	}
	
	public static StageManager instance = new StageManager();
	
	public static StageManager getInstance() {
		return instance;
	}
	
	private Title title  = Title.getInstance();

	@Override
	public void run() {
		title.printTitle();
		
	}

}
