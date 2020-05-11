package info;

import utils.Util;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Vector;

//TODO: In the future maybe have a grid-shaped map
public class Map {
    Scanner mScanner = new Scanner(System.in);
    Vector<Integer> mCurrentPosition = new Vector<Integer>();
    
    public void move() {
        printMap();
        Util.println("Which door would you like to go? (r/l)");
        String door = mScanner.nextLine();

        if (door.equals("r")) {
            mCurrentPosition.add(1);
        } else if (door.equals("l")) {
            mCurrentPosition.add(2);
        }

        if (mCurrentPosition.size() == 3) {
            boss();
        }
    }

    public void boss() {
        
    }

    // Currently it is two doors
    public void printMap() {
        String overbar = new String(new int[] { 0x1F601 }, 0, 1);
        Util.println("                             "+overbar);
        Util.println(" |‾‾‾‾‾‾‾‾‾|     |‾‾‾‾‾‾‾‾‾| ");
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