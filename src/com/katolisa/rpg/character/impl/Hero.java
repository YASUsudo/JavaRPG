package com.katolisa.rpg.character.impl;

import static com.katolisa.rpg.common.Constants.*;

import com.katolisa.rpg.character.Character;

public class Hero extends Character {

	public Hero(String name, int hp, int blood) {
		super(name, hp, blood);
	}

	@Override
	public void attack(Character target) {
		System.out.println(this.getName() + "は" + target.getName() + "を攻撃した");
		target.damaged(POWER_HERO);
	}

	public boolean run() {
		System.out.println(this.getName() + "は逃げ出した");
		int r = new java.util.Random().nextInt(2);
		if (r < 1) {
			System.out.println(this.getName() + "は逃げ切れた！");
			return true;
		} else {
			System.out.println(this.getName() + "はうまく逃げ切れなかった");
			return false;
		}
	}
}
