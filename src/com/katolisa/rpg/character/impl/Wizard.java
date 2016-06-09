package com.katolisa.rpg.character.impl;

import static com.katolisa.rpg.common.Constants.*;

import java.util.Random;

import com.katolisa.rpg.character.BloodTypeA;
import com.katolisa.rpg.character.Character;

public class Wizard extends Character implements BloodTypeA {

	public Wizard(String name, int hp, int blood) {
		super(name, hp, blood);
	}

	public void attack(Character target) {
		System.out.println(this.getName() + "は" + target.getName() + "を攻撃した");
		target.damaged(POWER_WIZARD);
	}

	public boolean run() {
		System.out.println(this.getName() + "は逃げ出そうとした");

		int random = new Random().nextInt(3);
		if (random < 1) {
			System.out.println("うまく逃げ切れた！");
			return true;
		} else {
			System.out.println("しかし逃げ切れなかった…");
			return false;
		}
	}
}
