/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects;

/**
 *
 * @author czech
 */

public abstract class Attack extends Object{
    
    //Manditory information
    protected String effect;
    protected int turnLength;
    protected int damage;
    //Stat modefiers
    protected int strMod;
    protected int defMod;
    protected int speedMod;
    protected int luckMod;
    protected int hPMod;
    protected int level = 0;
    protected int experience = 0;
    protected int experienceNeeded;
    
    
    
    
    public Attack(String giveName, int giveDamage, int giveTurnLength, String giveEffect) {
        super(giveName);
        effect = giveEffect;
        turnLength = giveTurnLength;
        damage = giveDamage;
        if(turnLength>1)
        {
            experienceNeeded = (level*1000)/turnLength + 500;
        }
        else
        {
            experienceNeeded = level*1000 + 500;
        }
    }
    
    
    
    public String getEffect()
    {
        return effect;
    }
    
    public int getTurnLength()
    {
        return turnLength;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public int getExp()
    {
        return experience;
    }
    
    public void levelUp()
    {
        level++;
    }
    
    public void gainExp(int expGained)
    {
        experience += expGained;
        if(experience>experienceNeeded-1)
        {
            experience = experience - experienceNeeded;
            levelUp();
        }
    }
    
}
