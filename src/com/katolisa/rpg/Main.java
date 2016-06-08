package com.katolisa.rpg;
import java.util.ArrayList;

public class Main {
	public static final int A = 0;
	public static final int B = 1;
	public static final int O = 2;
	public static final int AB = 3;

	public static void main(String[] args) {
		int turn = 0;
		ArrayList<Human> characters = new ArrayList<Human>();

		Hero hero = new Hero("コマドリ", 100, A);
		System.out.println("勇者を生成しました");
		System.out.println("名前：" + hero.getName() + "、HP：" + hero.getHp() + "、血液型：" + hero.getblood());
		characters.add(hero);

		Wizard wizard = new Wizard("マドカ", 50, A);
		System.out.println("魔法使いを生成しました");
		System.out.println("名前：" + wizard.getName() + "、HP：" + wizard.getHp() + "、血液型：" + wizard.getblood());
		characters.add(wizard);

		Boss boss = new Boss("ムテキ", 10000, AB);
		System.out.println("ボスを生成しました");
		System.out.println("名前：" + boss.getName() + "、HP：" + boss.getHp() + "、血液型：" + boss.getblood());

		while(turn < 10) {
			turn++;
			System.out.println("========== " + turn + "ターン目 ==========");
			for (Human h : characters) {
				h.attack(boss);
			}

			if (boss.getHp() <= 0) {
				System.out.println(boss.getName() + "を倒した！");
				break;
			}

			if (turn % 2 == 0) {
				boss.defend();
			} else {
				boss.attack(characters.get(0));
			}

			if (characters.contains(hero) && hero.getHp() <= 0) {
				System.out.println("勇者" + hero.getName() + "は力尽きた");
				characters.remove(hero);
			}
			if (characters.contains(wizard) && wizard.getHp() <= 0) {
				System.out.println("魔法使い" + wizard.getName() + "は力尽きた");
				characters.remove(wizard);
			}

			if (characters.isEmpty()) {
				System.out.println("味方が全滅した…");
				break;
			}

			System.out.println("ボスHP：" + boss.getHp() + "勇者HP：" + hero.getHp() + "魔法使いHP：" + wizard.getHp());
		}
		System.out.println("おわり");
	}

}
