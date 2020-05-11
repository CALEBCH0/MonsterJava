import info.*;
import utils.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(final String args[]) {
        Scanner scanner = new Scanner(System.in);
        boolean trueInput = false;
        String name = "";
        String roleNumber = "";

        Util.println("What is your name? : ");
        name = scanner.nextLine();

        Util.println("1. warrior:      high attack, moderate health");
        Util.println("2. shieldsman:   high health, low attack, heal every round");
        Util.println("3. ninja:        moderate attack, moderate attack, counterattack if dodge attack");
        Util.println("4. mage:         low health, high attack, attack/blind/sleep enemy or make protection");
        char[] target = {'1', '2', '3', '4'};
        roleNumber = Util.trueInput(target);
        Util.println("role "+roleNumber);

        PlayerInfo player = new PlayerInfo(name, roleNumber);
        MonsterInfo monster = new MonsterInfo("slime");
        Map map = new Map();

        // monster.encounter();
        // map.move();
        // Util.println(map.getPosition());
        // Util.println(Arrays.toString(map.getStage()));
        // map.move();
        // Util.println(Arrays.toString(map.getStage()));
        // map.move();
        // Util.println(Arrays.toString(map.getStage()));

        player.status();
        map.move(player);
        map.move(player);
        map.move(player);
        // monster.statusMonster();
        // monster.printMonster();
        // monster.printSpider();
        // monster.printOrc();
        // monster.printOgre();
        // monster.printDragon();
    }
}