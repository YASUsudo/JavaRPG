package com.katolisa.rpg.character.impl;

import com.katolisa.rpg.character.Character;

public class Wizard extends Character {

	public Wizard(String name, int hp, int blood) {
		super(name, hp, blood);
	}

	@Override
	public void attack(Character enemy) {
		System.out.println("魔法使い" + this.getName() + "は" + enemy.getName() + "を攻撃した");
		enemy.setHp(enemy.getHp() - 50);
	}

	public boolean run() {
		System.out.println("魔法使い" + this.getName() + "は逃げ出した");
		int r = new java.util.Random().nextInt(3);
		if (r < 1) {
			System.out.println("魔法使い" + this.getName() + "は逃げ切れた！");
			return true;
		} else {
			System.out.println("魔法使い" + this.getName() + "はうまく逃げ切れなかった");
			return false;
		}
	}
}
