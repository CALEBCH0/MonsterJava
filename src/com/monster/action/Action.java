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
                attack(player, monster);
                if (player.isDead()) {
                    Util.println("Game Over");
                    break;
                }
                if (monster.isDead()) {
                    Util.println("Victory!");
                    if (monster.getName().equals("Dragon")) {
                        Util.println("Game Clear!");
                    }
                    break;
                }
            } else if (action.equals("d")) {
                dodge(player, monster);
                if (player.isDead()) {
                    Util.println("Game Over");
                    break;
                }
                if (monster.isDead()) {
                    Util.println("Victory!");
                    if (monster.getName().equals("Dragon")) {
                        Util.println("Game Clear!");
                    }
                    break;
                }
            }
            counterAttack(player, monster);
            if (player.isDead()) {
                Util.println("Game Over");
                break;
            }
            Util.println("--------------------");
            if (player.getRole().equals("Shieldsman")) {
                Util.println("End of turn. Regenerating health. +"+30);
                player.mHealth = player.getHealth() + 30;
            } else {
                Util.println("End of turn. Regenerating health. +"+10);
                player.mHealth = player.getHealth() + 10;
            }
            Util.println("--------------------");
            Util.println("\n\n\n");
        }
    }   

    public void attack(PlayerInfo player, MonsterInfo monster) {
        Util.println("--------------------");
        // crit
        if (player.getRole().equals("Swordmaster")) {
            if (Util.randomNumberGen(1, 2) == 1) {
                if (Util.randomNumberGen(1, 3) == 1 || Util.randomNumberGen(1, 3) == 2) {
                    monster.mHealth = monster.mHealth - (2 * player.getStrength());
                    Util.println("Critical! You dealt -"+(2 * player.getStrength()), "to", monster.getName());
                } else if (Util.randomNumberGen(1, 3) == 3) {
                    monster.mHealth = monster.mHealth - player.getStrength();
                    Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                }
            } else if (Util.randomNumberGen(1, 2) == 2) {
                Util.println("Double attack!");
                for (int i = 1; i <= 2; i++) {
                    if (Util.randomNumberGen(1, 3) == 1 || Util.randomNumberGen(1, 3) == 2) {
                        monster.mHealth = monster.mHealth - (2 * player.getStrength());
                        Util.println("Critical! You dealt -"+(2 * player.getStrength()), "to", monster.getName());
                    } else if (Util.randomNumberGen(1, 3) == 3) {
                        monster.mHealth = monster.mHealth - player.getStrength();
                        Util.println("You dealt -"+player.getStrength(), "to", monster.getName());
                    }
                }
            }
        } else if (player.getRole().equals("Mage")) {
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
            Util.println("\n\n\n");
            Util.println("--------------------");
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

        if (player.getRole().equals("Ninja")) {
            int evasion = Util.randomNumberGen(1, 3);
            Util.println(evasion);
            if (evasion == 1 || evasion == 2) {
                Util.println("Dodged successfully!");
                monster.mHealth = monster.mHealth - (2 * player.getStrength());
                Util.println("Ninja's counterattack! You dealt", (2 * player.getStrength()), "to", monster.getName());
                monster.status();
                Util.println("--------------------");
                player.mDodge = true;
            } else if (evasion == 3) {
                Util.println("Failed to dodge!");
                Util.println("--------------------");
                player.mDodge = false;
            }
        } else {
            // TODO: declare variable or straight to the if?
            // int evasion = Util.randomNumberGen(1, 2);
            // Util.println(evasion);
            // if (evasion == 1) {
            //     Util.println("Dodged successfully!");
            //     Util.println("--------------------");
            //     player.mDodge = true;
            // } else if (evasion == 2) {
            //     Util.println("Failed to dodge!");
            //     Util.println("--------------------");
            //     player.mDodge = false;
            // }
            if (Util.randomNumberGen(1, 2) == 1) {
                // TODO: how much to recover?
                player.mHealth = player.getHealth() + monster.getStrength()/2;
                Util.println("Dodged successfully!");
                Util.println("Recovering health. +"+ monster.getStrength()/2);
                Util.println("--------------------");
                player.mDodge = true;
            } else if (Util.randomNumberGen(1, 2) == 2) {
                Util.println("Failed to dodge!");
                Util.println("--------------------");
                player.mDodge = false;
            }
        } 
    }

    public void counterAttack(PlayerInfo player, MonsterInfo monster) {
        Util.println("--------------------");
        Util.println(monster.getName()+"'s turn!");

        if (player.isDodged() || player.isProtected() || monster.isSleep()) {
            Util.println("Nothing happened!");
            player.status();
            Util.println("--------------------");
            player.mDodge = false;
            player.mProtection = false;
            monster.mSleep = false;
        } else {
            player.mHealth = player.getHealth() - monster.getStrength();
            Util.println(monster.getName(), "dealt", monster.getStrength(), "to you!");
            player.status();
            Util.println("--------------------");
        }
    }
}