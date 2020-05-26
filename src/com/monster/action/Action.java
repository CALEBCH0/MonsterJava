package com.monster.action;

import com.monster.info.*;
import com.monster.utils.Util;

public class Action {
    private int waitTime = 1000;

    public void action(PlayerInfo player, MonsterInfo monster) {
        char[] target = {'a', 'd'};

        while (player.isDead() == false && monster.isDead() == false) {
            monster.status();
            player.status();
            monster.printMonster();
            Util.println("\n");
            Util.print("Attack or Dodge?(a/d): ");
            String action = Util.trueInput(target);
            Util.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            if (action.equals("a")) {
                attack(player, monster);
                if (deathCheck(player, monster) != 0) { break; }
            } else if (action.equals("d")) {
                dodge(player, monster);
                if (deathCheck(player, monster) != 0) { break; }
            }
            counterAttack(player, monster);
            if (deathCheck(player, monster) != 0) { break; }
            heal(player, 10, 30);
        }
    } 
    

    public void attack(PlayerInfo player, MonsterInfo monster) {
        Util.wait(waitTime);
        Util.println("----------------------------------------");
        switch(player.getRole()) {
            case "Swordmaster":
                int crit = Util.randomNumberGen(1, 3);
                if (crit == 1 || crit == 2) {
                    crit = Util.randomNumberGen(1, 3);
                    if (crit == 1 || crit == 2) {
                        monster.mHealth = monster.mHealth - (2 * player.getStrength());
                        Util.println("Critical! You dealt -"+(2 * player.getStrength()), "to", monster.getName());
                    } else if (crit == 3) {
                        monster.mHealth = monster.mHealth - player.getStrength();
                        Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                    }
                } else if (crit == 3) {
                    Util.println("Double strike!");
                    for (int i = 1; i <= 2; i++) {
                        crit = Util.randomNumberGen(1, 3);
                        if (crit == 1 || crit == 2) {
                            monster.mHealth = monster.mHealth - (2 * player.getStrength());
                            Util.println("Critical! You dealt -"+(2 * player.getStrength()), "to", monster.getName());
                        } else if (crit == 3) {
                            monster.mHealth = monster.mHealth - player.getStrength();
                            Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                        }
                    }
                }
                break;
            case "Mage":
                Util.println("1. fireball spell                                   ");
                Util.println("2. enervation spell ("+player.getSpellCount(1)+"/1) ");
                Util.println("3. sleep spell      ("+player.getSpellCount(2)+"/1) ");
                Util.println("4. protection spell ("+player.getSpellCount(3)+"/1) ");
                Util.print("Which magic?: ");
                char[] target = {'1', '2', '3', '4'};
                int magic = Integer.parseInt(Util.trueInput(target));
                if (magic != 1) {
                    while (player.getSpellCount(magic-1) <= 0) {
                        Util.print("No spell left. Please select other spell: ");
                        magic = Integer.parseInt(Util.trueInput(target));
                    }
                }
                Util.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                Util.wait(waitTime); // 2000
                Util.println("----------------------------------------");
                // Fireball
                if (magic == 1) {
                    monster.mHealth = monster.mHealth - player.getStrength();
                    Util.println("Fireball!");
                    Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                } 
                // Enervation
                else if (magic == 2) {
                    monster.mStrength = (int) Math.round(monster.getStrength() * 0.6);
                    player.mSpellCount[0] = player.getSpellCount(1) - 1;
                    Util.println("You decreased", monster.getName()+"'s strength by", (int) Math.round(monster.getStrength() * 0.6));
                } 
                // Sleep
                else if (magic == 3) {
                    player.mSpellCount[1] = player.getSpellCount(2) - 1;
                    Util.println("You put", monster.getName(),  "to sleep!");
                    monster.mSleep = true;
                } 
                // Protect
                else if (magic == 4) {
                    player.mSpellCount[2] = player.getSpellCount(3) - 1;
                    Util.println("Protection!  Next attack does no damage.");
                    player.mProtection = true;
                } 
                break;
            case "Shieldsman":
                monster.mHealth = monster.mHealth - player.getStrength();
                Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                break;
            case "Ninja":
                monster.mHealth = monster.mHealth - player.getStrength();
                Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                break;
            case "Admin":
                monster.mHealth = monster.mHealth - player.getStrength();
                Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                break;
        }
        monster.status();
        Util.println("----------------------------------------");
        Util.println("\n\n\n\n\n");
        Util.wait(waitTime); // 2000
        Util.println("\n\n\n\n\n\n\n\n\n");
    }

    public void dodge(PlayerInfo player, MonsterInfo monster) {
        Util.wait(waitTime);
        Util.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Util.println("----------------------------------------");
        Util.println("Trying to dodge...");

        if (player.getRole().equals("Ninja")) {
            int evasion = Util.randomNumberGen(1, 3);
            if (evasion == 1 || evasion == 2) {
                Util.println("Dodged successfully!");
                monster.mHealth = monster.mHealth - (2 * player.getStrength());
                Util.println("Ninja's counterattack! You dealt", (2 * player.getStrength()), "to", monster.getName());
                monster.status();
                Util.println("----------------------------------------");
                player.mDodge = true;
            } else if (evasion == 3) {
                Util.println("Failed to dodge!");
                player.mDodge = false;
            }
        } else {
            int evasion = Util.randomNumberGen(1, 2);
            if (evasion == 1) {
                // TODO: how much to recover?
                player.mHealth = player.getHealth() + monster.getStrength()/2;
                Util.println("Dodged successfully!");
                Util.println("Recovering health. +"+ monster.getStrength()/2);
                player.mDodge = true;
            } else if (evasion == 2) {
                Util.println("Failed to dodge!");
                player.mDodge = false;
            }
        }
        Util.println("----------------------------------------");
        Util.println("\n\n\n\n\n");
        Util.wait(waitTime); // 2000
        Util.println("\n\n\n\n\n\n\n\n\n\n\n"); 
    }

    public void counterAttack(PlayerInfo player, MonsterInfo monster) {
        Util.println("\n\n\n\n\n\n\n\n\n");
        Util.println("----------------------------------------");
        Util.println(monster.getName()+"'s turn!");

        if (player.isDodged() || player.isProtected() || monster.isSleep()) {
            Util.println("Nothing happened!");
            player.status();
            player.mDodge = false;
            player.mProtection = false;
            monster.mSleep = false;
        } else {
            player.mHealth = player.getHealth() - monster.getStrength();
            Util.println(monster.getName(), "dealt", "-"+monster.getStrength(), "to you!");
            player.status();
        }
        Util.println("----------------------------------------");
        Util.println("\n\n\n\n\n");
        Util.wait(waitTime); // 2000
        Util.println("\n\n\n\n\n\n");
    }

    public void heal(PlayerInfo player, int normalGen, int shieldGen) {
        Util.println("\n\n");
        Util.println("----------------------------------------");
        if (player.getRole().equals("Shieldsman")) {
            Util.println("End of turn. Regenerating health. +"+shieldGen);
            player.mHealth = player.getHealth() + shieldGen;
        } else {
            Util.println("End of turn. Regenerating health. +"+normalGen);
            player.mHealth = player.getHealth() + normalGen;
        }
        Util.println("----------------------------------------");
        Util.println("\n\n\n\n\n");
        Util.wait(waitTime); // 2000
        Util.println("\n\n\n\n\n\n\n\n\n\n\n");
    }

    public int deathCheck(PlayerInfo player, MonsterInfo monster) {
        if (player.isDead()) {
            Util.println("----------------------------------------");
            Util.println("               Game Over                ");
            Util.println("----------------------------------------");
            Util.println("\n\n\n\n\n");
            Util.wait(waitTime); // 2000
            Util.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            return 1;
        }
        if (monster.isDead()) {
            Util.println("\n\n\n");
            Util.println("----------------------------------------");
            Util.println("               Victory!                 ");
            Util.println("----------------------------------------");
            if (monster.getKind().equals("Dragon")) {
                Util.println("\n\n\n\n\n\n\n\n");
                Util.wait(waitTime);
                Util.println("----------------------------------------");
                Util.println("              Game Clear!               ");
                Util.println("----------------------------------------");
            }
            Util.println("\n\n\n\n\n");
            Util.wait(waitTime); // 2000
            Util.println("\n\n\n\n\n");
            if (!monster.getKind().equals("Dragon")) { heal(player, 10, 30); }
            Util.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            return 2;
        }
        return 0;
    }
}