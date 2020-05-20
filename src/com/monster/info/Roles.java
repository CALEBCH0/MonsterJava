package com.monster.info;

public class Roles {

    private int mHealth;
    private int mStrength;
    private int mShield;
    private String mRoleName;

    public Roles(String roleNumber) {
        // high attack, moderate health 
        if (roleNumber.equals("1")) {
            mRoleName = "Swordmaster";
            mHealth = 120;
            mStrength = 40;
            mShield = 10;
        // high attack, low health, uses magic
        } else if (roleNumber.equals("2")) {
            mRoleName = "Mage";
            mHealth = 100;
            mStrength = 50;
            mShield = 20;
        // high health, low attack, heal regen round
        } else if (roleNumber.equals("3")) {
            mRoleName = "Shieldsman";
            mHealth = 150;
            mStrength = 20;
            mShield = 30;
        //  moderate attack, moderate health, counterattack if dodge attack
        } else if (roleNumber.equals("4")) {
            mRoleName = "Ninja";
            mHealth = 100;
            mStrength = 25;
            mShield = 0;
        } else if (roleNumber.equals("a")) {
            mRoleName = "Admin";
            mHealth = 999;
            mStrength = 999;
            mShield = 999;
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
