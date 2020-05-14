package com.monster;

import com.monster.info.*;
import com.monster.utils.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(final String args[]) {
        // int i = 0;
        
        // while (i < 100) {
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

        Util.println("1. Swordmaster:  moderate health, high attack");
        Util.println("2. Mage:         low health, high attack, attack/enervate/sleep enemy or make protection");
        Util.println("3. Shieldsman:   high health, low attack, heal every round");
        Util.println("4. Ninja:        moderate health, moderate attack, counterattack with double damage if dodge attack");
        Util.print("Choose you role: ");
        char[] target = {'1', '2', '3', '4', 'a'};
        roleNumber = Util.trueInput(target);

        PlayerInfo player = new PlayerInfo(name, roleNumber);
        Map map = new Map();

        player.status();
        map.move(player);
        map.move(player);
        map.move(player);
    }
}