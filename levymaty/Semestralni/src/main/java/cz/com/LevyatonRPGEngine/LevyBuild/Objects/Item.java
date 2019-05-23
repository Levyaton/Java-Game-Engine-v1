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


public class Item extends basicGameObject{
    
    /**
     *
     */
    protected Double dropRate;

    /**
     *
     */
    protected String description;

    /**
     *
     */
    protected int value;

    /**
     *
     */
    protected int itemCount = 0;

    /**
     *
     */
    protected int gain = 0;

    /**
     *
     */
    protected boolean countable = true;
    
    /**
     *
     * @param giveName
     * @param giveStatus
     * @param giveSpriteLocation
     * @param giveDropRate
     * @param giveDescription
     * @param giveValue
     */
    public Item(String giveName, String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue) {
        super(giveName, giveStatus, giveSpriteLocation);
        dropRate = giveDropRate;
        description = giveDescription;
        value = giveValue;
    }
    
    /**
     *
     * @param giveName
     * @param giveStatus
     * @param giveSpriteLocation
     * @param giveDropRate
     * @param giveDescription
     * @param giveValue
     * @param giveHealthGain
     */
    public Item(String giveName, String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, int giveHealthGain) {
        super(giveName, giveStatus, giveSpriteLocation);
        dropRate = giveDropRate;
        description = giveDescription;
        value = giveValue;
        gain = giveHealthGain;
    }
    
    /**
     *
     * @param giveValue
     */
    public void setValue(int giveValue)
    {
        value = giveValue;
    }
     
    /**
     *
     * @return
     */
    public boolean isCountable() 
    {
        return countable;
    }

    /**
     *
     * @param giveTrueOrFalse
     */
    public void countable(boolean giveTrueOrFalse)
    {
        countable = giveTrueOrFalse;
    } 

    /**
     *
     * @return
     */
    public Double getDropRate()
    {
        return dropRate;
    }
    
    /**
     *
     * @return
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     *
     * @return
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     *
     * @return
     */
    public int getItemCount()
    {
        return itemCount;
    }
    
    /**
     *
     */
    public void addItem()
    {
        itemCount++;
    }

    /**
     *
     * @param x
     */
    public void incrementItemCOunt(int x)
    {
        itemCount += x;
    }
    
    /**
     *
     * @return
     */
    public Item getThis()
    {
        return this;
    }
    
    /**
     *
     * @return
     */
    public int getGain()
    {
        return gain;
    }
}
