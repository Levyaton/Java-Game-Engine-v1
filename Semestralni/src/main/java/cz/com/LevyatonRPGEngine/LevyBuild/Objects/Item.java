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


public abstract class Item extends Object{
    
    protected Double dropRate;
    protected String description;
    protected int value;
    
    public Item(String giveName, String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue) {
        super(giveName, giveStatus, giveSpriteLocation);
        dropRate = giveDropRate;
        description = giveDescription;
        value = giveValue;
    }
    
    public Double getDropRate()
    {
        return dropRate;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public int getValue()
    {
        return value;
    }
}
