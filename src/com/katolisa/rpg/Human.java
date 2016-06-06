package com.katolisa.rpg;

public abstract class Human {
	private String name;
	private int hp;
	private int blood;
	static final int A = 0;
	static final int B = 1;
	static final int O = 2;
	static final int AB = 3;

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
