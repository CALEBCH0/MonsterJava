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
    MonsterInfo monster;
    Action action = new Action();
    Vector<Integer> mCurrentPosition = new Vector<Integer>(3);
    
    public void move(PlayerInfo player) {
        Util.println("\n\n\n\n\n\n\n\n");
        printMap();
        // TODO: if input "rl", returns arrayindexoutofboundsexception.
        Util.print("Choose a door (r/l)");
        char[] target = {'r', 'l', 't'};
        String door = Util.trueInput(target);
        Util.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        if (door.equals("l")) {
            mCurrentPosition.add(1);
        } else if (door.equals("r")) {
            mCurrentPosition.add(2);
        } else if (door.equals("t")) {
            monster = new MonsterInfo("Target");
            action.action(player, monster);
        }

        if (mCurrentPosition.size() == 3) {
            Util.wait(1000);
            Util.println("----------------------------------------");
            Util.println("           Entering Boss Room!          ");
            Util.println("----------------------------------------");
            Util.println("\n\n\n\n\n\n\n");
            Util.wait(2000);
            encounter(player, true);
        } else {
            Util.wait(1000);
            encounter(player, false);
        }
    }

    public void encounter(PlayerInfo player, boolean boss) {
        String monsterKind = "";
        if (boss == false) {
            if (mCurrentPosition.get(0) == 1) {
                if (mCurrentPosition.lastIndexOf(mCurrentPosition.lastElement()) > 0) {
                    if (mCurrentPosition.get(1) == 1) {
                        monsterKind = "Spider";
                    } else if (mCurrentPosition.get(1) == 2) {
                        monsterKind = "Orc";  
                    }
                } else {
                    monsterKind = "Slime";
                }
            } else if (mCurrentPosition.get(0) == 2) {
                if (mCurrentPosition.lastIndexOf(mCurrentPosition.lastElement()) > 0) {
                    if (mCurrentPosition.get(1) == 1) {
                        monsterKind = "Orc";
                    } else if (mCurrentPosition.get(1) == 2) {
                        monsterKind = "Ogre";
                    }
                } else {
                    monsterKind = "Spider";
                }
            }
            monster = new MonsterInfo(monsterKind);
        } else if (boss == true) {
            monster = new MonsterInfo("Dragon");
        }

        Util.println("\n----------------------------------------");
        Util.println("You encountered:", monster.getName(), "<"+monster.getKind()+">", "!");
        Util.println("----------------------------------------");
        Util.println("\n\n\n\n\n\n");
        Util.wait(2000);
        Util.println("\n\n\n\n\n\n\n");
        action.action(player, monster);
    }

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
        Util.println("                             ");
    }

    public Vector<Integer> getPosition() {
        return mCurrentPosition;
    }
}