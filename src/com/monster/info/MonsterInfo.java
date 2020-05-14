package com.monster.info;

import com.monster.utils.*;
import java.lang.Math;

public class MonsterInfo {
    public String mMonsterKind;
    public String mName;
    public int mHealth;
    public int mStrength;
    public boolean mSleep = false;
    
    private String[] mMonsterNames = new String[]{
        "Wangui", 
        "Nomusa", 
        "Pua", 
        "Vaso", 
        "Toril", 
        "Hulda", 
        "Chinweike", 
        "Nkechi", 
        "Olufunke", 
        "Chioma", 
        "Simisola", 
        "Imamu",
        "Mahtab", 
        "Mirembe", 
        "Mandlenkosi"
    };
    
    public MonsterInfo(String monsterKind) {
        mMonsterKind = monsterKind;
        mName = namePicker();    
        if (mMonsterKind == "slime") {
            mHealth = 20;
            mStrength = 10;
        } else if (mMonsterKind == "spider") {
            mHealth = 40;
            mStrength = 20;
        } else if (mMonsterKind == "orc") {
            mHealth = 60;
            mStrength = 30;
        } else if (mMonsterKind == "ogre") {
            mHealth = 100;
            mStrength = 40;
        } else if (mMonsterKind == "dragon") {
            mHealth = 200;
            mStrength = 50;
        }
    }

    public boolean isDead() {
        if (mHealth <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void status() {
        Util.println(mName, "<"+mMonsterKind+">", "health:", getHealth(), "strength:", getStrength());
    }

    public int getHealth() {
        return mHealth;
    }

    public int getStrength() {
        return mStrength;
    }

    public String getName() {
        return mName;
    }

    public String getKind() {
        return mMonsterKind;
    }

    public boolean isSleep() {
        if (mSleep) {
            return true;
        } else {
            return false;
        }
    }

    public String namePicker() {
        int picker;
        if (mMonsterKind == "slime") {
        picker = Util.randomNumberGen(1, 2);
        if (picker == 0) {return mMonsterNames[picker];}
        else if (picker == 1) {return mMonsterNames[picker];}
        else if (picker == 2) {return mMonsterNames[picker];}
      }
      else if(mMonsterKind == "spider") {
        picker = Util.randomNumberGen(3, 5);
        if (picker == 3) {return mMonsterNames[picker];}
        else if (picker == 4) {return mMonsterNames[picker];}
        else if (picker == 5) {return mMonsterNames[picker];}
      }
      else if (mMonsterKind == "orc") {
        picker = Util.randomNumberGen(6, 8);
        if (picker == 6) {return mMonsterNames[picker];}
        else if (picker == 7) {return mMonsterNames[picker];}
        else if (picker == 8) {return mMonsterNames[picker];}
      }
      else if (mMonsterKind == "ogre") { 
        picker = Util.randomNumberGen(9, 11);
        if (picker == 9) {return mMonsterNames[picker];}
        else if (picker == 10) {return mMonsterNames[picker];}
        else if (picker == 11) {return mMonsterNames[picker];}
      }
      else if (mMonsterKind == "dragon") {
        picker = Util.randomNumberGen(12, 14);
        if (picker == 12) {return mMonsterNames[picker];}
        else if (picker == 13) {return mMonsterNames[picker];}
        else if (picker == 14) {return mMonsterNames[picker];}
      }
      return "namePickerError";

    }

    public void printMonster() {
        if (mMonsterKind == "slime") {
            printSlime();
        } else if (mMonsterKind == "spider") {
            printSpider();
        } else if (mMonsterKind == "orc") {
            printOrc();
        } else if (mMonsterKind == "ogre") {
            printOgre();
        } else if (mMonsterKind == "dragon") {
            printDragon();
        }
    }

    public void printSlime(){
        Util.println( "   O       _____ ");
        Util.println( " / | \\    ( * * )");
        Util.println( "  / \\      TTTTT ");
    }

    public void printSpider(){
        Util.println( "   O         ");
        Util.println( " / | \\    /\\_____/\\ ");
        Util.println( "  / \\    / ( * * ) \\");
    }

    public void printOrc(){
        Util.println( "");
        Util.println( "   O       (**)   ");
        Util.println( " / | \\    /|__|\\ ");
        Util.println( "  / \\      /  \\  ");
    }

    public void printOgre(){
        Util.println( "           ");
        Util.println( "             [**]   ");
        Util.println( "   O      O--|  |--O");
        Util.println( " / | \\       |__|   ");
        Util.println( "  / \\       _|  |_  ");
    }

    public void printDragon(){
        Util.println( "              _______        ");
        Util.println( "          ^ ^ |              ");
        Util.println( "   O     {* *}--------       ");
        Util.println( " / | \\    \\_/________=====>>");
        Util.println( "  / \\       //       \\\\    ");
    }
}