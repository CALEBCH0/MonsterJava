package com.monster;

import com.monster.info.*;
import com.monster.utils.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(final String args[]) {
        // int i = 0;
        
        // while (i < 5) {
        //     Util.println(Util.randomNumberGen(1, 2));
        //     i++;
        // }

        Scanner scanner = new Scanner(System.in);
        boolean trueInput = false;
        String name = "";
        String roleNumber = "";

        Util.print("What is your name? : ");
        name = scanner.nextLine();
        Util.println("\n\n\n");

        Util.println("1. Swordmaster:  high attack, moderate health");
        Util.println("2. Mage:         low health, high attack, attack/blind/sleep enemy or make protection");
        Util.println("3. Shieldsman:   high health, low attack, heal every round");
        Util.println("4. Ninja:        moderate attack, moderate attack, counterattack if dodge attack");
        Util.print("Choose you role: ");
        char[] target = {'1', '2', '3', '4'};
        roleNumber = Util.trueInput(target);

        PlayerInfo player = new PlayerInfo(name, roleNumber);
        Map map = new Map();

        player.status();
        map.move(player);
        map.move(player);
        map.move(player);

        // monster.encounter();
        // map.move();
        // Util.println(map.getPosition());
        // Util.println(Arrays.toString(map.getStage()));
        // map.move();
        // Util.println(Arrays.toString(map.getStage()));
        // map.move();
        // Util.println(Arrays.toString(map.getStage()));

        // monster.statusMonster();
        // monster.printMonster();
        // monster.printSpider();
        // monster.printOrc();
        // monster.printOgre();
        // monster.printDragon();
    }
}