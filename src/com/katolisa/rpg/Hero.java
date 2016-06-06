package com.katolisa.rpg;

public class Hero extends Human {

	@Override
	public void attack(Human enemy) {
		System.out.println("勇者は" + enemy.getName() + "を攻撃した");
		enemy.setHp(enemy.getHp() - 50);
	}

	public void run() {
		System.out.println("勇者は逃げ出した");
	}
}
