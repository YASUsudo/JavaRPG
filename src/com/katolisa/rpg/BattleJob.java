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
import com.katolisa.rpg.service.impl.BattleServiceImpl;

public class BattleJob {

	public static void main(String[] args) {
		//コマンドライン引数の処理
		int command = Integer.parseInt(args[0]);
		SimpleDateFormat dateFormat = new SimpleDateFormat(args[1]);

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

		// ボスの生成
		Boss boss = new Boss("ぼす", HP_BOSS, AB);
		System.out.print("ボスを生成しました\n");
		System.out.printf("名前：%s、HP：%d、血液型：%d\n\n", boss.getName(), boss.getHp(), boss.getBlood());

		Date now = new Date();
		String date = dateFormat.format(now);
		System.out.println(date + "：バトルを開始します");

		BattleService battleService = new BattleServiceImpl();
		if (command == ATTACK) {
			battleService.attack(party, boss);
		} else if (command == ESCAPE) {
			battleService.escape(party, boss);
		} else {
			// 例外
		}

		now = new Date();
		date = dateFormat.format(now);
		System.out.println(date + "：バトル終了");
	}
}
