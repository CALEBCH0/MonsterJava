import info.*;
import utils.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(final String args[]) {
        Scanner scanner = new Scanner(System.in);

        Util.print("What is your name? : ");
        String name = scanner.nextLine();
        Util.print("Select your role : ");
        Util.print("1. warrior:      high attack, moderate health \n");
        Util.print("2. shieldsman:   high health, low attack, heal every round \n");
        Util.print("3. ninja:        moderate attack, moderate attack, counterattack if dodge attack \n");
        Util.print("4. mage:         low health, high attack, attack/blind/sleep enemy or make protection \n");
        String roleNumber = scanner.nextLine();

        PlayerInfo player = new PlayerInfo(name, roleNumber);
        MonsterInfo monster = new MonsterInfo("slime");
        Map map = new Map();

        // monster.encounter();
        // map.move();
        // map.move();
        // Util.print(map.getPosition());
        // Util.print(Arrays.toString(map.getStage()));
        // map.move();
        // Util.print(Arrays.toString(map.getStage()));
        // map.move();
        // Util.print(Arrays.toString(map.getStage()));

        player.statusPlayer();
        // monster.statusMonster();
        // monster.printMonster();
        // monster.printSpider();
        // monster.printOrc();
        // monster.printOgre();
        // monster.printDragon();
    }
}