package com.monster;

import com.monster.info.*;
import com.monster.utils.*;

import java.util.Scanner;

public class Main {

    public static void main(final String args[]) {

        // int i = 0;
        // while (i < 5) {
        //     int n = Util.randomNumberGen(1, 3);
        //     Util.println(n);
        //     n = Util.randomNumberGen(1, 3);
        //     Util.println(n);
        //     Util.println("--------------------------");
        //     i++;
        // }

        // for (int i = 3; i > 0; i--) {
        //     Util.println(i);
        // }

        Scanner scanner = new Scanner(System.in);

        Util.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            Util.println(" <<<<<<<<<<<<<<<<<<<<< Monster RPG >>>>>>>>>>>>>>>>>>>>>>>> ");
            Util.println("\n\n\n\n\n\n\n");
            Util.wait(1000);
            Util.println("____________________________________________________________");
            for (int i = 0; i < 15; i++) {
            Util.println("|              Adjust the window to this box               |");
            }
            Util.println("|__________________________________________________________|");
        Util.print("When adjusting is done, press enter to continue: ");
        String adjust = scanner.nextLine();

        boolean gameOver = false;
        while (!gameOver) {
            String name = "";
            String roleNumber = "";
            
            Util.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            Util.print("What is your name? : ");
            name = scanner.nextLine();
            Util.println("\n\n\n\n\n\n\n\n\n\n\n\n");

            Util.println("1. Swordmaster:  moderate health, high attack");
            Util.println("2. Mage:         low health, high attack, attack/enervate/sleep enemy or make protection");
            Util.println("3. Shieldsman:   high health, low attack, heal every round");
            Util.println("4. Ninja:        moderate health, moderate attack, counterattack with double damage if dodge attack");
            Util.print("Choose you role: ");
            char[] target = {'1', '2', '3', '4', 'a'};
            roleNumber = Util.trueInput(target);
            Util.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            
            PlayerInfo player = new PlayerInfo(name, roleNumber);
            Map map = new Map();

            for (int stage = 3; stage > 0; stage--) {
                if (player.isDead()) { break; }
                player.status();
                map.move(player);
                Util.println("\n\n\n");
            }
            
            Util.print("retry? (y/n): ");
            target = new char[] { 'y', 'n' };
            String exitGame = Util.trueInput(target);
            if (exitGame.equals("n")) { 
                Util.wait(500);
                Util.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                Util.print("exiting");
                for (int i = 0; i < 3; i++) {
                    Util.wait(500);
                    Util.print(".");
                }
                Util.wait(1000);
                Util.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                gameOver = true; 
            }
        }
    }
}