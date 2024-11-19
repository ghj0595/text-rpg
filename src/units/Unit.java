package units;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import textrpg.Item;

public abstract class Unit {
	public String name;
	public int hp;
	public int level;
	public int maxHp;
	public int att;
	public int def;
	public int exp;
	public Item weapon;
	public Item armor;
	public Item ring;
	public boolean party;
	
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	
	private Unit(){
		
	}
	
	public Unit(String name, int level, int hp, int att, int def, int exp) {
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
	}
	
	public void attack(Monster target) {
		target.hp -= att;
		
		try {
			writer.write("[" + name + "]가 [" + target.name + "]에게 " + att + "의 데미지를 입힙니다.\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(target.hp <= 0) {
			try {
				writer.write("[" + target.name + "]를 처치했습니다.\n");
				writer.flush();
				target.hp = 0;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
