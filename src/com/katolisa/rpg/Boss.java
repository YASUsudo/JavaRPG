package com.katolisa.rpg;

public class Boss extends Human {

	public Boss(String name, int hp, int blood) {
		super(name, hp, blood);
	}

	@Override
	public void attack(Human character) {
		System.out.println(this.getName() + "は" + character.getName() + "を攻撃した");
		character.setHp(character.getHp() - 50);
	}

	public void defend() {
		System.out.println(this.getName() + "は身を守っている…");
	}

}
