/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects;

/**
 *  a class responsible for the properties of an Item
 * @author czech
 */
public class Item extends basicGameObject{
    
    /**
     *  What is the chance of the item to drop?
     */
    protected Double dropRate;

    /**
     *  What is the items description?
     */
    protected String description;

    /**
     *  How much gold is the Item worth?
     */
    protected int value;

    /**
     *  How much of the item is in the Item stack?
     */
    protected int itemCount = 0;

    /**
     *  How much does the item boost a stat?
     */
    protected int gain = 0;

    /**
     *  Is the Item name countable?
     */
    protected boolean countable = true;
    
    /**
     *  Initializes and sets the class
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
     * Initializes and sets the class
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
     *  sets the items value
     * @param giveValue
     */
    public void setValue(int giveValue)
    {
        value = giveValue;
    }
     
    /**
     *  returns the countable variable
     * @return
     */
    public boolean isCountable() 
    {
        return countable;
    }

    /**
     *  sets the countable variable
     * @param giveTrueOrFalse
     */
    public void countable(boolean giveTrueOrFalse)
    {
        countable = giveTrueOrFalse;
    } 

    /**
     *  returns the Items drop rate
     * @return
     */
    public Double getDropRate()
    {
        return dropRate;
    }
    
    /**
     *  returns the Items description
     * @return
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     *  returns the Items value
     * @return
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     *  returns the number of the Item in it's item stack
     * @return
     */
    public int getItemCount()
    {
        return itemCount;
    }
    
    /**
     *  increments the Item count in it's item stack
     */
    public void addItem()
    {
        itemCount++;
    }

    /**
     *  increments the Item count in it's item stack by the given amount
     * @param x
     */
    public void incrementItemCOunt(int x)
    {
        itemCount += x;
    }
    
    /**
     *  returns the item
     * @return
     */
    public Item getThis()
    {
        return this;
    }
    
    /**
     *  returns the stat gain from the Item
     * @return
     */
    public int getGain()
    {
        return gain;
    }
}
