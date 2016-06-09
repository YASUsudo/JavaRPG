package com.katolisa.rpg.character.impl;

import static com.katolisa.rpg.common.Constants.*;

import java.util.List;

import com.katolisa.rpg.character.BloodTypeAB;
import com.katolisa.rpg.character.Character;

public class Boss extends Character implements BloodTypeAB{

	public Boss(String name, int hp, int blood) {
		super(name, hp, blood);
	}

	public void attack(Character target) {
		System.out.println(this.getName() + "は" + target.getName() + "を攻撃した");
		target.damaged(POWER_BOSS);
	}

	public void defend() {
		System.out.println(this.getName() + "は身を守っている");
	}

	public void endlessAttack(List<Character> targets) {
		for (Character target : targets) {
			while (target.isAlive() == true) {
				this.attack(target);
			}
			System.out.println(target.getName() + "は力尽きた");
		}
	}
}
