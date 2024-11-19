package units;

import textrpg.Guild;
import textrpg.Inventory;

public class Player extends Unit {

	static Guild guild = new Guild();
	static Inventory inven = new Inventory();

	static int money;

	public Player(String name, int level, int hp, int att, int def, int exp) {
		super(name, level, hp, att, def, exp);
		this.money = 10000;
	}

}
