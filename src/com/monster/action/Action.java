package action;

import info.*;
import utils.Util;

public class Action {

    public void action(PlayerInfo player, MonsterInfo monster) {
        char[] target = {'a', 'd'};

        while (!player.isDead() || !monster.isDead()) {
            monster.status();
            player.status();
            Util.println("\n\n\n");
            Util.print("Attack or Dodge?(a/d): ");
            String action = Util.trueInput(target);
            Util.println("\n\n\n");

            if (action.equals("a")) {
                Util.println("inside action");
                attack(player, monster);
            } else if (action.equals("d")) {
                dodge(player, monster);
            }
            counterAttack(player, monster);
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
            Util.println("inside attack sword");
            if (Util.randomNumberGen(1, 2) == 2) {
                Util.println("You dealt -"+(2 * player.getStrength()), "to", monster.getName());
                monster.mHealth =- 2 * player.getStrength();
            } else {
                Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                monster.mHealth =- player.getStrength();
            }
        } else if (player.getRole().equals("Mage")) {
            Util.println("1. fireball spell   ");
            Util.println("2. enervation spell ");
            Util.println("3. sleep spell      ");
            Util.println("4. protection spell ");
            Util.print("Which magic?: ");
            String magic = Util.trueInput();
            Util.println("\n\n\n");

            // Fireball
            if (magic.equals("1")) {
                Util.println("Fireball!");
                Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                monster.mHealth =- player.getStrength();
            } 
            // Enervation
            else if (magic.equals("2")) {
                Util.println("You decreased", monster.getName()+"'s strength to", (int) Math.round(monster.getStrength() * 0.6));
                monster.mStrength = (int) Math.round(monster.getStrength() * 0.6);
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
            Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
            monster.mHealth =- player.getStrength();
        } else if (player.getRole().equals("Ninja")) {
            Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
            monster.mHealth =- player.getStrength();
        } else if (player.getRole().equals("Admin")) {
            Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
            monster.mHealth =- player.getStrength();
        }
        Util.println("\n\n\n");
    }

    public void dodge(PlayerInfo player, MonsterInfo monster) {
        Util.println("--------------------");
        Util.println("Trying to dodge...");
        if (Util.randomNumberGen(1, 2) == 2) {
            Util.println("Dodged successfully!");
            Util.println("--------------------");
            Util.println("\n\n\n");
            player.mDodge = true;
        } else {
            Util.println("Failed to dodge!");
            Util.println("--------------------");
            Util.println("\n\n\n");
            player.mDodge = false;
        }
    }

    public void counterAttack(PlayerInfo player, MonsterInfo monster) {
        Util.println("--------------------");
        Util.println(monster.getName()+"'s turn!'");

        if (player.isDodged() || player.isProtected() || monster.isSleep()) {
            Util.println("Nothing happened!");
            Util.println("--------------------");
            Util.println("\n\n\n");
            player.mDodge = false;
            player.mProtection = false;
            monster.mSleep = false;
        } else {
            Util.println(monster.getName(), "dealt", monster.getStrength(), "to you!");
            Util.println("--------------------");
            Util.println("\n\n\n");
            player.mHealth =- monster.getStrength();
        }
    }
}