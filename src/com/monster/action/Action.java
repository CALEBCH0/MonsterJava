package action;

import info.*;
import utils.Util;

public class Action {

    public void action(PlayerInfo player, MonsterInfo monster) {
        char[] target = {'a', 'd'};

        while (!player.isDead() || !monster.isDead()) {
            monster.status();
            player.status();
            Util.print("Attack or Dodge?: ");
            String action = Util.trueInput(target);
            if (action.equals("a")) {
                attack();
            } else if (action.equals("d")) {
                dodge();
            }
            counterAttack();
        }
        if (player.isDead()) {
            Util.println("Game Over");
        }
        if (monster.isDead()) {
            Util.println("Victory!");
        }
    }   

    public void attack(PlayerInfo player, MonsterInfo monster) {
        // crit
        if (player.getRole().equals("Swordmaster")) {
            if (Util.randomNumberGen(0, 3) == 1) {
                monster.mHealth =- 2 * player.getSterngth();
            } else {
                monster.mHealth =- player.getSterngth();
            }
        } 
        // fireball / blind, sleep, protect
        else if (player.getRole().equals("Mage")) {
        
        } 
        // normal attack
        else if (player.getRole().equals("Shieldsman")) {

        } 
        // attack, counterattck
        else if (player.getRole().equals("Ninja")) {

        } 
        // normal attack
        else if (player.getRole().equals("Admin")) {

        }
    }

    public void dodge(PlayerInfo player, MonsterInfo monster) {

    }

    public void counterAttack(PlayerInfo player, MonsterInfo monster) {

    }
}