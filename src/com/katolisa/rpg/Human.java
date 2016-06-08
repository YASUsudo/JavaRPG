package com.katolisa.rpg;

public abstract class Human {

	public Human(String name, int hp, int blood) {
		this.name = name;
		this.hp = hp;
		this.blood = blood;
	}

	private String name;
	private int hp;
	private int blood;

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getblood() {
		return blood;
	}

	public abstract void attack(Human h);
}
