package com.katolisa.rpg.service.impl;

import java.util.ArrayList;

import com.katolisa.rpg.character.Character;
import com.katolisa.rpg.character.impl.Boss;
import com.katolisa.rpg.service.BattleService;

public class BattleServiceImpl implements BattleService {
	int turn = 0;

	@Override
	public void attack(ArrayList<Character> party, Boss boss) {
		while(true) {
			turn++;
			System.out.println("========== " + turn + "ターン目 ==========");

			// 味方パーティの行動
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
		}
		System.out.println("おわり");
	}

	@Override
	public void summon(ArrayList<Character> party, Boss boss) {
		while(true) {
			turn++;
			System.out.println("========== " + turn + "ターン目 ==========");

			// 味方パーティの行動
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
		}
		System.out.println("おわり");
	}

	@Override
	public void escape(ArrayList<Character> party, Boss boss) {
		while(true) {
			turn++;
			System.out.println("========== " + turn + "ターン目 ==========");

			// 味方パーティの行動
			boolean runResult = false;
			for (Character character : party) {
				// 逃げる
			}

			if (runResult == true) {
				System.out.println("逃げ切れた！");
				break;
			} else {
				System.out.println("逃げ切れなかった");
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
		}
		System.out.println("おわり");
	}

}
