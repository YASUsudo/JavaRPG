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
	public void setName(String name) {
		this.name = name;
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
	public void setblood(int blood) {
		this.blood = blood;
	}

	public abstract void attack(Human h);
}
