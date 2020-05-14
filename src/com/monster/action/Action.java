package com.monster.action;

import com.monster.info.*;
import com.monster.utils.Util;

public class Action {

    public void action(PlayerInfo player, MonsterInfo monster) {
        char[] target = {'a', 'd'};

        while (player.isDead() == false && monster.isDead() == false) {
            monster.status();
            player.status();
            monster.printMonster();
            Util.println("\n");
            Util.print("Attack or Dodge?(a/d): ");
            String action = Util.trueInput(target);
            Util.println("\n\n\n");

            if (action.equals("a")) {
                Util.println("inside action");
                Util.println("player:", player.getHealth(), "monster:", monster.getHealth());
                Util.println("player:", player.isDead(), "monster:", monster.isDead());
                attack(player, monster);
                Util.println("player:", player.getHealth(), "monster:", monster.getHealth());
                Util.println("player:", player.isDead(), "monster:", monster.isDead());;

                if (player.isDead()) {
                    Util.println("Game Over");
                    break;
                }
                if (monster.isDead()) {
                    Util.println("Victory!");
                    break;
                }
                Util.println("\n\n\n");
            } else if (action.equals("d")) {
                Util.println("player:", player.getHealth(), "monster:", monster.getHealth());
                Util.println("player:", player.isDead(), "monster:", monster.isDead());;
                dodge(player, monster);
                Util.println("player:", player.getHealth(), "monster:", monster.getHealth());
                Util.println("player:", player.isDead(), "monster:", monster.isDead());;
                if (player.isDead()) {
                    Util.println("Game Over");
                    break;
                }
                if (monster.isDead()) {
                    Util.println("Victory!");
                    break;
                }
                Util.println("\n\n\n");
            }
            counterAttack(player, monster);
            if (player.isDead()) {
                Util.println("Game Over");
                break;
            }
            if (monster.isDead()) {
                Util.println("Victory!");
                break;
            }
        }
        Util.println("\n\n\n");
    }   

    public void attack(PlayerInfo player, MonsterInfo monster) {
        Util.println("--------------------");
        // crit
        if (player.getRole().equals("Swordmaster")) {
            if (Util.randomNumberGen(1, 2) == 2) {
                monster.mHealth = monster.mHealth - (2 * player.getStrength());
                Util.println("Critical! You dealt -"+(2 * player.getStrength()), "to", monster.getName());
            } else {
                monster.mHealth = monster.mHealth - player.getStrength();
                Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
            }
        } else if (player.getRole().equals("Mage")) {
            Util.println("1. fireball spell   ");
            Util.println("2. enervation spell ");
            Util.println("3. sleep spell      ");
            Util.println("4. protection spell ");
            Util.print("Which magic?: ");
            char[] target = {'1', '2', '3', '4'};
            String magic = Util.trueInput(target);
            Util.println("\n\n\n");

            // Fireball
            if (magic.equals("1")) {
                monster.mHealth = monster.mHealth - player.getStrength();
                Util.println("Fireball!");
                Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
            } 
            // Enervation
            else if (magic.equals("2")) {
                monster.mStrength = (int) Math.round(monster.getStrength() * 0.6);
                Util.println("You decreased", monster.getName()+"'s strength to", monster.getStrength() * 0.6);
            } 
            // Sleep
            else if (magic.equals("3")) {
                Util.println("You put", monster.getName(),  "to sleep!");
                monster.mSleep = true;
            } 
            // Protect
            else if (magic.equals("4")) {
                Util.println("Next attack does no damage.");
                player.mProtection = true;
            } 
        } else if (player.getRole().equals("Shieldsman")) {
            monster.mHealth = monster.mHealth - player.getStrength();
            Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
        } else if (player.getRole().equals("Ninja")) {
            monster.mHealth = monster.mHealth - player.getStrength();
            Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
        } else if (player.getRole().equals("Admin")) {
            monster.mHealth = monster.mHealth - player.getStrength();
            Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
        }
        monster.status();
        Util.println("--------------------");
    }

    public void dodge(PlayerInfo player, MonsterInfo monster) {
        Util.println("--------------------");
        Util.println("Trying to dodge...");
        if (Util.randomNumberGen(1, 2) == 2) {
            Util.println("Dodged successfully!");
            Util.println("--------------------");
            player.mDodge = true;
        } else {
            Util.println("Failed to dodge!");
            Util.println("--------------------");
            player.mDodge = false;
        }
    }

    public void counterAttack(PlayerInfo player, MonsterInfo monster) {
        Util.println("--------------------");
        Util.println(monster.getName()+"'s turn!");

        if (player.isDodged() || player.isProtected() || monster.isSleep()) {
            Util.println("Nothing happened!");
            player.status();
            Util.println("--------------------");
            Util.println("\n\n\n");
            player.mDodge = false;
            player.mProtection = false;
            monster.mSleep = false;
        } else {
            player.mHealth = player.getHealth() - monster.getStrength();
            Util.println(monster.getName(), "dealt", monster.getStrength(), "to you!");
            player.status();
            Util.println("--------------------");
            Util.println("\n\n\n");
        }
    }
}