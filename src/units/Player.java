package units;

import textrpg.Guild;
import textrpg.Inventory;

public class Player extends Unit {

	public int money;

	public Player(String name, int level, int hp, int att, int def, int exp) {
		super(name, level, hp, att, def, exp);
		this.money = 10000;
	}

}
