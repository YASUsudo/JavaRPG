package com.katolisa.rpg;

public class Main {
	public static final int A = 0;
	public static final int B = 1;
	public static final int O = 2;
	public static final int AB = 3;

	public static void main(String[] args) {
		int turn = 0;

		Hero hero = new Hero("コマドリ", 100, A);
		System.out.println("勇者を生成しました");
		System.out.println("名前：" + hero.getName() + "、HP：" + hero.getHp() + "、血液型：" + hero.getblood());

		Wizard wizard = new Wizard("マドカ", 50, A);
		System.out.println("魔法使いを生成しました");
		System.out.println("名前：" + wizard.getName() + "、HP：" + wizard.getHp() + "、血液型：" + wizard.getblood());

		Boss boss = new Boss("ムテキ", 10000, AB);
		System.out.println("ボスを生成しました");
		System.out.println("名前：" + boss.getName() + "、HP：" + boss.getHp() + "、血液型：" + boss.getblood());

		while(turn < 3) {
			turn++;
			System.out.println("========== " + turn + "ターン目 ==========");
			hero.attack(boss);
			wizard.attack(boss);
			if (turn % 2 == 0) {
				boss.defend();
			} else {
				boss.attack(hero);
			}
			System.out.println("ボスHP：" + boss.getHp() + "勇者HP：" + hero.getHp() + "魔法使いHP：" + wizard.getHp());
		}
	}

}