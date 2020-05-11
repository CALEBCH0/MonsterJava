package info;

import utils.Util;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Vector;

import info.MonsterInfo;
import info.PlayerInfo;

//TODO: In the future maybe have a grid-shaped map
public class Map {
    Scanner mScanner = new Scanner(System.in);
    Vector<Integer> mCurrentPosition = new Vector<Integer>(3);
    
    public void move(PlayerInfo player) {
        printMap();
        Util.println("Which door would you like to go? (r/l)");
        //String door = mScanner.nextLine();
        char[] target = {'r', 'l'};
        String door = Util.trueInput(target);

        if (door.equals("l")) {
            mCurrentPosition.add(1);
        } else if (door.equals("r")) {
            mCurrentPosition.add(2);
        }

        Util.println(getPosition());

        if (mCurrentPosition.size() == 3) {
            Util.println("--------------------");
            Util.println("Entering Boss Room!");
            encounter(player, true);
        } else {
            encounter(player, false);
        }
    }

    MonsterInfo monster;

    public void encounter(PlayerInfo player, boolean boss) {
        
        if (boss == false) {
            if (mCurrentPosition.get(0) == 1) {
                if (mCurrentPosition.lastIndexOf(mCurrentPosition.lastElement()) > 0) {
                    if (mCurrentPosition.get(1) == 1) {
                        monster = new MonsterInfo("spider");
                    } else if (mCurrentPosition.get(1) == 2) {
                        monster = new MonsterInfo("orc");  
                    }
                } else {
                    monster = new MonsterInfo("slime");
                }
            } else if (mCurrentPosition.get(0) == 2) {
                if (mCurrentPosition.lastIndexOf(mCurrentPosition.lastElement()) > 0) {
                    if (mCurrentPosition.get(1) == 1) {
                        monster = new MonsterInfo("orc");
                    } else if (mCurrentPosition.get(1) == 2) {
                        monster = new MonsterInfo("ogre");
                    }
                } else {
                    monster = new MonsterInfo("spider");
                }
            }
        } else if (boss == true) {
            monster = new MonsterInfo("dragon");
        }

        Util.println("--------------------");
        Util.println("You encountered:", monster.getName(), "<"+monster.getKind()+">", "!");
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