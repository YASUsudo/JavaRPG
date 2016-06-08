package com.katolisa.rpg.service;

import static com.katolisa.rpg.common.Constants.*;

import java.util.ArrayList;

import com.katolisa.rpg.character.Character;
import com.katolisa.rpg.character.impl.Boss;
import com.katolisa.rpg.character.impl.Hero;
import com.katolisa.rpg.character.impl.Wizard;

public class Main {

	public static void main(String[] args) {

		// 初期パーティを作成
		ArrayList<Character> party = new ArrayList<Character>();

		Hero hero = new Hero("ゆうしゃ", HP_HERO, A);
		System.out.print("勇者を生成しました\n");
		System.out.printf("名前：%s、HP：%d、血液型：%d\n\n", hero.getName(), hero.getHp(), hero.getBlood());
		party.add(hero);

		Wizard wizard = new Wizard("まほうつかい", HP_WIZARD, A);
		System.out.print("魔法使いを生成しました\n");
		System.out.printf("名前：%s、HP：%d、血液型：%d\n\n", wizard.getName(), wizard.getHp(), wizard.getBlood());
		party.add(wizard);

		Boss boss = new Boss("ぼす", HP_BOSS, AB);
		System.out.print("ボスを生成しました\n");
		System.out.printf("名前：%s、HP：%d、血液型：%d\n\n", boss.getName(), boss.getHp(), boss.getBlood());


		int turn = 0;

		// 攻撃コマンドパターン
		while(turn < 10) {
			turn++;
			System.out.println("========== " + turn + "ターン目 ==========");

			// パーティの行動
			for (Character character : party) {
				character.attack(boss);
			}

			if (boss.getHp() <= 0) {
				System.out.println(boss.getName() + "を倒した！");
				break;
			}

			// ボスの行動
			if (turn % 2 == 0) {
				boss.defend();
			} else {
				// 攻撃対象の選定
				int r = new java.util.Random().nextInt(party.size());
				Character target = party.get(r);

				boss.attack(target);
				if (target.getHp() <= 0) {
					System.out.println(target.getName() + "は力尽きた");
					party.remove(target);
				}
			}

			if (party.isEmpty()) {
				System.out.println("味方が全滅した…");
				break;
			}

			System.out.printf("\nボスHP：%d、勇者HP：%d、魔法使いHP：%d\n\n", boss.getHp(), hero.getHp(), wizard.getHp());
		}
		System.out.println("おわり");
	}

}
