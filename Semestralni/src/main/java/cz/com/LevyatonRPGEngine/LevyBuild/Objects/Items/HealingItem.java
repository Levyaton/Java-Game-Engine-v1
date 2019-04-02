/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items;

/**
 *
 * @author czech
 */

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
public class HealingItem extends Item {
    protected int healthGain;//How much health will the consumable Item restore
    public HealingItem(String giveName, String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription,int giveValue,int giveHealthGain)
    {
        super(giveName, giveStatus, giveSpriteLocation, giveDropRate,giveDescription,giveValue);
        healthGain = giveHealthGain;
    }
    
    public int getHealthGain()
    {
        return healthGain;
    }
}
