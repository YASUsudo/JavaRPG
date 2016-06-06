package com.katolisa.rpg;

public class Wizard extends Human {

	@Override
	public void attack(Human enemy) {
		System.out.println("魔法使いは" + enemy.getName() + "を攻撃した");
		enemy.setHp(enemy.getHp() - 50);
	}

	public void run() {
		System.out.println("魔法使いは逃げ出した");
	}
}
