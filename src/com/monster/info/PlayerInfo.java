package com.monster.info;

import com.monster.utils.Util;

import java.util.Scanner;

public class PlayerInfo {

    public String mName;
    public Roles mRoles;
    public String mRoleName;
    public int mHealth;
    public int mStrength;
    public int mShield;
    public boolean mLife = true;
    public boolean mProtection = false;
    public boolean mDodge = false;

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

    public void status() {
        Util.println(mName, "<"+mRoleName+">", "health:", getHealth(), "strength:", getStrength(), "shield:", getShield());
        // System.out.printlnln(mName+mRoles.getRole()+getHealth()+getStrength());
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
    public String getRole() {
        return mRoleName;
    }

    public boolean isProtected() {
        if (mProtection) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDodged() {
        if (mDodge) {
            return true;
        } else {
            return false;
        }
    }
}