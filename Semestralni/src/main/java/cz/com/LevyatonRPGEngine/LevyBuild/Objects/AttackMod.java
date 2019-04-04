/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;

/**
 *
 * @author czech
 */

public abstract class AttackMod extends Attack{
    protected int strMod;
    protected int defMod;
    protected int speedMod;
    protected int luckMod;
    protected int hPMod;
    
    public AttackMod(String giveName, int giveDamage, int giveTurnLength, String giveEffect, Bodypart[] giveBodypart, int giveStrMod, int giveDefMod, int giveSpeedMod, int giveLuckMod, int giveHpMod) 
    {
        super(giveName, giveDamage, giveTurnLength, giveEffect, giveBodypart);
        strMod = giveStrMod;
        defMod = giveDefMod;
        speedMod = giveSpeedMod;
        luckMod = giveLuckMod;
        hPMod = giveHpMod; 
    }
    
    public int getStrMod()
    {
        return strMod;
    }
    
    public int getDefMod()
    {
        return defMod;
    }
    
    public int getSpeedMod()
    {
        return speedMod;
    }
    
    public int getLuckMod()
    {
        return luckMod;
    }
    
    public int getHpMod()
    {
        return hPMod;
    }
    
}
