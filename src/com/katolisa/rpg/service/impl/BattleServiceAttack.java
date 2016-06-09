package com.katolisa.rpg.service.impl;

import java.util.ArrayList;
import java.util.Random;

import com.katolisa.rpg.character.Character;
import com.katolisa.rpg.character.impl.Boss;
import com.katolisa.rpg.service.BattleService;

public class BattleServiceAttack implements BattleService {

	@Override
	public void battle(ArrayList<Character> party, Boss boss) {
		int turn = 0;

		while(true) {
			turn++;
			System.out.println("---------- " + turn + "ターン目 ----------");

			// 味方パーティの行動
			for (Character character : party) {
				character.attack(boss);
				System.out.print("\n");
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
				int r = new Random().nextInt(party.size());
				Character target = party.get(r);
				boss.attack(target);

				if (target.getHp() <= 0) {
					System.out.println(target.getName() + "は力尽きた");
					party.remove(target);
				}
			}

			if (party.isEmpty()) {
				System.out.print("\n");
				System.out.println("味方が全滅した…");
				break;
			}
		}
	}
}
