package com.katolisa.rpg;

import static com.katolisa.rpg.common.Constants.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.katolisa.rpg.character.Character;
import com.katolisa.rpg.character.impl.Boss;
import com.katolisa.rpg.character.impl.Hero;
import com.katolisa.rpg.character.impl.Wizard;
import com.katolisa.rpg.service.BattleService;
import com.katolisa.rpg.service.impl.BattleServiceAttack;
import com.katolisa.rpg.service.impl.BattleServiceEscape;
import com.katolisa.rpg.service.impl.BattleServiceSummon;

public class BattleJob {

	public static void main(String[] args) {
		//コマンドライン引数の処理
		int command = Integer.parseInt(args[0]);
		SimpleDateFormat dateFormat = new SimpleDateFormat(args[1]);

		// 初期パーティを作成
		ArrayList<Character> party = new ArrayList<Character>();
		Hero hero = new Hero("ゆうしゃ", HP_HERO, A);
		party.add(hero);
		Wizard wizard = new Wizard("まほうつかい", HP_WIZARD, A);
		party.add(wizard);

		// ボスの生成
		Boss boss = new Boss("ぼす", HP_BOSS, AB);

		Date now = new Date();
		String date = dateFormat.format(now);
		System.out.println(date + "：バトルを開始します");

		if (command == ATTACK) {
			BattleService battleService = new BattleServiceAttack();
			battleService.battle(party, boss);
		} else if (command == ESCAPE) {
			BattleService battleService = new BattleServiceEscape();
			battleService.battle(party, boss);
		} else if (command == SUMMON) {
			BattleService battleService = new BattleServiceSummon();
			battleService.battle(party, boss);
		} else {
			// 例外
		}

		now = new Date();
		date = dateFormat.format(now);
		System.out.println(date + "：バトルを終了しました");
	}
}