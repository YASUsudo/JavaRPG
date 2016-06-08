package com.katolisa.rpg.service.impl;

import java.util.ArrayList;

import com.katolisa.rpg.character.Character;
import com.katolisa.rpg.character.impl.Boss;
import com.katolisa.rpg.service.BattleService;

public class BattleServiceImpl implements BattleService {

	@Override
	public void attack(ArrayList<Character> party, Boss boss) {
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
		}
		System.out.println("おわり");

	}

}
