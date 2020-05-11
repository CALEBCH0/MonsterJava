package info;

import utils.Util;

public class Roles {

    private int mHealth;
    private int mStrength;
    private int mShield;
    private String mRoleName;

    public Roles(String roleNumber) {
        // high attack, moderate health 
        if (roleNumber.equals("1")) {
            System.out.println("in 1");
            mRoleName = "Swordmaster";
            mHealth = 2;
            mStrength = 3;
            mShield = 1;
        // high attack, low health, uses magic
        } else if (roleNumber.equals("2")) {
            System.out.println("in 2");
            mRoleName = "Mage";
            mHealth = 1;
            mStrength = 3;
            mShield = 2;
        // high health, low attack, heal regen round
        } else if (roleNumber.equals("3")) {
            System.out.println("in 3");
            mRoleName = "Shieldsman";
            mHealth = 3;
            mStrength = 1;
            mShield = 3;
        //  moderate attack, moderate health, counterattack if dodge attack
        } else if (roleNumber.equals("4")) {
            System.out.println("in 4");
            mRoleName = "Ninja";
            mHealth = 2;
            mStrength = 2;
            mShield = 0;
        }
    }

    public int getHealth() {
        return mHealth;
    }

    public int getStrength() {
        return mStrength;
    }

    public int getshield() {
        return mShield;
    }

    public String getRole(){
        return mRoleName;
    }
}
