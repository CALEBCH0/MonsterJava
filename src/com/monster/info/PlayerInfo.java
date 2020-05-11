package info;

import utils.Util;

import java.util.Scanner;

public class PlayerInfo {

    private String mName;
    private Roles mRoles;
    private String mRoleName;
    private int mHealth;
    private int mStrength;
    private int mShield;
    private boolean mLife;

    public PlayerInfo(String name, String roleNumber) {
        mName = name;
        mRoles = new Roles(roleNumber);
        //TODO: Difference between mRoles.health vs. mRoles.getHealth()?
        mRoleName = mRoles.getRole();
        mHealth = mRoles.getHealth();
        mStrength = mRoles.getStrength();
        mShield = mRoles.getshield();
    }

    public boolean isDead() {
        if (mHealth <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void statusPlayer() {
        Util.print(mName, "<"+mRoleName+">", "health:", getHealth(), "strength:", getStrength(), "shield:", getShield());
        // System.out.println(mName+mRoles.getRole()+getHealth()+getStrength());
    }

    //TODO: Is this necessary?
    public void setPlayer() {
        // get name and role
        // put it as the parameter for the playerinfo
    }

    public int getHealth() {
        return mHealth;
    }

    public int getStrength() {
        return mStrength;
    }

    public int getShield() {
        return mShield;
    }
}