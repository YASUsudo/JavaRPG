package com.katolisa.rpg.character.impl;

import com.katolisa.rpg.character.Character;

public class Boss extends Character {

	public Boss(String name, int hp, int blood) {
		super(name, hp, blood);
	}

	@Override
	public void attack(Character character) {
		System.out.println(this.getName() + "は" + character.getName() + "を攻撃した");
		character.setHp(character.getHp() - 50);
	}

	public void defend() {
		System.out.println(this.getName() + "は身を守っている…");
	}

}
