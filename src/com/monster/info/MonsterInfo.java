package info;

import utils.Util;
import java.lang.Math;

public class MonsterInfo {
    private String mMonsterKind;
    private String mName;
    private int mHealth;
    private int mStrength;

    //TODO: maybe in a separate class?
    // private String slimeN1 = "Wangui";
    // private String slimeN2 = "Nomusa";
    // private String slimeN3 = "Pua";
    // private String spiderN1 = "Vaso";
    // private String spiderN2 = "Toril";
    // private String spiderN3 = "Hulda";
    // private String orcN1 = "Chinweike";
    // private String orcN2 = "Nkechi";
    // private String orcN3 = "Olufunke";
    // private String ogreN1 = "Chioma";
    // private String ogreN2 = "Simisola";
    // private String ogreN3 = "Imamu";
    // private String dragonN1 = "Mahtab";
    // private String dragonN2 = "Mirembe";
    // private String dragonN3 = "Mandlenkosi";
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

    public void statusMonster() {
        Util.println(mName, "health:", getHealth(), "strength:", getStrength());
    }

    public int getHealth() {
        return mHealth;
    }

    public int getStrength() {
        return mStrength;
    }

    public void encounter() {
        Util.println("--------------------");
        Util.println("You encountered:", mName, "<"+mMonsterKind+">", "!");
    }

    public String namePicker() {
        int picker;
        if (mMonsterKind == "slime") {
        picker = randomNumberGen(0, 2);
        if (picker == 0) {return mMonsterNames[picker];}
        else if (picker == 1) {return mMonsterNames[picker];}
        else if (picker == 2) {return mMonsterNames[picker];}
      }
      else if(mMonsterKind == "spider") {
        picker = randomNumberGen(3, 5);
        if (picker == 3) {return mMonsterNames[picker];}
        else if (picker == 4) {return mMonsterNames[picker];}
        else if (picker == 5) {return mMonsterNames[picker];}
      }
      else if (mMonsterKind == "orc") {
        picker = randomNumberGen(6, 8);
        if (picker == 6) {return mMonsterNames[picker];}
        else if (picker == 7) {return mMonsterNames[picker];}
        else if (picker == 8) {return mMonsterNames[picker];}
      }
      else if (mMonsterKind == "ogre") { 
        picker = randomNumberGen(9, 11);
        if (picker == 9) {return mMonsterNames[picker];}
        else if (picker == 10) {return mMonsterNames[picker];}
        else if (picker == 11) {return mMonsterNames[picker];}
      }
      else if (mMonsterKind == "dragon") {
        picker = randomNumberGen(12, 14);
        if (picker == 12) {return mMonsterNames[picker];}
        else if (picker == 13) {return mMonsterNames[picker];}
        else if (picker == 14) {return mMonsterNames[picker];}
      }
      return "namePickerError";

    }

    public int randomNumberGen(double min, double max) {
        return (int) Math.round((Math.random() * ((max - min) + 1)) + min);
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