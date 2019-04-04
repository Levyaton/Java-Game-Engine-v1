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

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
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
    //Required Bodypart to use the attack
   protected Bodypart[] bodypart;
    
    
    
    public Attack(String giveName, int giveDamage, int giveTurnLength, String giveEffect, Bodypart[] giveBodypart) {
        super(giveName);
        effect = giveEffect;
        turnLength = giveTurnLength;
        damage = giveDamage;
        
        bodypart = giveBodypart;
        
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
    
    public Bodypart getBodypart(int i)
    {
        return bodypart[i];
    }
    
    
}
