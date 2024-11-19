package units;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public abstract class Monster {
	public String name;
	public int hp;
	public int maxHp;
	public int power;	
	
	private Monster(){
		
	}
	
	public Monster(String name, int hp, int power) {
		this.name = name;
		this.maxHp = hp;
		this.hp = maxHp;
		this.power = power;
	}
	
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	
	public void attack(Unit target) {
		target.hp -= (power - target.def);
		
		try {
			writer.write("[" + name + "]가(이) [" + target.name + "] 에게 " + (power - target.def) + "의 데미지를 입힙니다.\n");
			writer.flush();		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(target.hp <= 0) {
			try {
				writer.write("[" + target.name + "]을 처치했습니다.\n");
				writer.flush();
				target.hp = 0;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
