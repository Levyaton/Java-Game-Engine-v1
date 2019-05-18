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


public class Item extends GameObject{
    
    protected Double dropRate;
    protected String description;
    protected int value;
    protected int itemCount = 0;
    protected int gain = 0;
    protected boolean countable = true;
    
    public Item(String giveName, String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue) {
        super(giveName, giveStatus, giveSpriteLocation);
        dropRate = giveDropRate;
        description = giveDescription;
        value = giveValue;
    }
    
     public Item(String giveName, String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, int giveHealthGain) {
        super(giveName, giveStatus, giveSpriteLocation);
        dropRate = giveDropRate;
        description = giveDescription;
        value = giveValue;
        gain = giveHealthGain;
    }
    
    public void setValue(int giveValue)
    {
        value = giveValue;
    }
     
    public boolean isCountable() 
    {
        return countable;
    }
    public void countable(boolean giveTrueOrFalse)
    {
        countable = giveTrueOrFalse;
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
    
    public int getItemCount()
    {
        return itemCount;
    }
    
    public void addItem()
    {
        itemCount++;
    }
    public void incrementItemCOunt(int x)
    {
        itemCount += x;
    }
    
    public Item getThis()
    {
        return this;
    }
    
    public int getGain()
    {
        return gain;
    }
}
