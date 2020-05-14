package com.monster.info;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Vector;

//import com.monster.info.*;
import com.monster.utils.Util;
import com.monster.action.Action;

//TODO: In the future maybe have a grid-shaped map
public class Map {
    Scanner mScanner = new Scanner(System.in);
    Vector<Integer> mCurrentPosition = new Vector<Integer>(3);
    
    public void move(PlayerInfo player) {
        printMap();
        // TODO: if input "rl", returns arrayindexoutofboundsexception.
        Util.print("Choose a door (r/l)");
        char[] target = {'r', 'l', 't'};
        String door = Util.trueInput(target);
        // TODO: more spaces
        Util.println("\n\n\n");

        if (door.equals("l")) {
            mCurrentPosition.add(1);
        } else if (door.equals("r")) {
            mCurrentPosition.add(2);
        } else if (door.equals("t")) {
            monster = new MonsterInfo("Target");
            action.action(player, monster);
        }

        if (mCurrentPosition.size() == 3) {
            Util.println("--------------------");
            Util.println("Entering Boss Room!");
            Util.println("--------------------");
            Util.println("\n\n\n");
            encounter(player, true);
        } else {
            encounter(player, false);
        }
    }

    // TODO: make it private member and relocate
    MonsterInfo monster;
    Action action = new Action();

    public void encounter(PlayerInfo player, boolean boss) {
        
        if (boss == false) {
            if (mCurrentPosition.get(0) == 1) {
                if (mCurrentPosition.lastIndexOf(mCurrentPosition.lastElement()) > 0) {
                    if (mCurrentPosition.get(1) == 1) {
                        monster = new MonsterInfo("Spider");
                    } else if (mCurrentPosition.get(1) == 2) {
                        monster = new MonsterInfo("Orc");  
                    }
                } else {
                    monster = new MonsterInfo("Slime");
                }
            } else if (mCurrentPosition.get(0) == 2) {
                if (mCurrentPosition.lastIndexOf(mCurrentPosition.lastElement()) > 0) {
                    if (mCurrentPosition.get(1) == 1) {
                        monster = new MonsterInfo("Orc");
                    } else if (mCurrentPosition.get(1) == 2) {
                        monster = new MonsterInfo("Ogre");
                    }
                } else {
                    monster = new MonsterInfo("Spider");
                }
            }
        } else if (boss == true) {
            monster = new MonsterInfo("Dragon");
        }

        Util.println("--------------------");
        Util.println("You encountered:", monster.getName(), "<"+monster.getKind()+">", "!");
        Util.println("--------------------");
        Util.println("\n");
        action.action(player, monster);
    }

    // public void encounter(PlayerInfo player, boolean boss) {
    //     if (boss == false) {
    //         if (mCurrentPosition.get(0) == 1) {
    //             if (mCurrentPosition.get(1) == 1) {
    //                 MonsterInfo monster = new MonsterInfo("spider");
    //             } else if (mCurrentPosition.get(1) == 2) {
    //                 MonsterInfo monster = new MonsterInfo("orc");  
    //             } else {
    //                 MonsterInfo monster = new MonsterInfo("slime");
    //             }
    //         } else if (mCurrentPosition.get(0) == 2) {
    //             if (mCurrentPosition.get(1) == 1) {
    //                 MonsterInfo monster = new MonsterInfo("orc");
    //             } else if (mCurrentPosition.get(2) == 2) {
    //                 MonsterInfo monster = new MonsterInfo("ogre");
    //             } else {
    //                 MonsterInfo monster = new MonsterInfo("spider");
    //             }
    //         }
    //     } else if (boss == true) {
    //         MonsterInfo monster = new MonsterInfo("dragon");
    //     }

    //     Util.println("--------------------");
    //     Util.println("You encountered:", monster.getName(), "<"+monster.getKind()+">", "!");
    // }

    // Currently it is two doors
    // the console cannot print overbar ‾
    public void printMap() {
        Util.println(" ___________     ___________ ");
        Util.println(" |         |     |         | ");
        Util.println(" |^^^^^^^^^|     |   [-]   | ");
        Util.println(" |^  {=}  ^|     |[-][-][-]| ");
        Util.println(" |^^^^^^^^^|     |   [-]   | ");
        Util.println(" |_________|     |_________| ");
        Util.println("                             ");
        Util.println(" <----------     ----------> ");
    }

    public Vector<Integer> getPosition() {
        return mCurrentPosition;
    }
}