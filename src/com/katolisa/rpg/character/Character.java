package com.katolisa.rpg.character;

public abstract class Character {

	public Character(String name, int hp, int blood) {
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

	public int getBlood() {
		return blood;
	}

	public abstract void attack(Character c);

	public void damaged(int damage) {
		if (this.hp < damage) {
			this.hp = 0;
		} else {
			this.hp -= damage;
		}
	}
}
