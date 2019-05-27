/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items;


import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;

/**
 *  a class containing the properties of a Bodypart
 * @author czech
 */
public class Bodypart extends Item{
    
    /**
     *  every Bodypart must contain the category to which it belongs
     */
    protected String category;

    /**
     *   every Bodypart must contain a stat modifier number 
     */
    protected int statModefier;

    /**
     *   every Bodypart must contain a stat modifier number 
     */
    protected Double luckModefier;

    /**
     *   every Bodypart must contain a corresponding attack
     */
    protected Attack correspondingAttack;

    /**
     *  every Bodypart must have a level
     */
    protected int level = 1;
    
    /**
     *  initializes and sets the Bodypart
     * @param giveName
     * @param giveCategory
     * @param giveStatus
     * @param giveSpriteLocation
     * @param giveDropRate
     * @param giveDescription
     * @param giveValue
     * @param giveStatModefier
     * @param giveAttack
     */
    public Bodypart(String giveName, String giveCategory,String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, int giveStatModefier, Attack giveAttack) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        statModefier = giveStatModefier;   
        correspondingAttack = giveAttack;
        category = giveCategory;
    }
    
    /**
     *   initializes and sets the Bodypart
     * @param giveName
     * @param giveCategory
     * @param giveStatus
     * @param giveSpriteLocation
     * @param giveDropRate
     * @param giveDescription
     * @param giveValue
     * @param giveStatModefier
     * @param giveAttack
     * @param giveLevel
     */
    public Bodypart(String giveName, String giveCategory,String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, int giveStatModefier, Attack giveAttack, int giveLevel) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        statModefier = giveStatModefier;   
        correspondingAttack = giveAttack;
        category = giveCategory;
        level = giveLevel;
    }
    
    /**
     * initializes and sets the Bodypart
     * @param giveName
     * @param giveCategory
     * @param giveStatus
     * @param giveSpriteLocation
     * @param giveDropRate
     * @param giveDescription
     * @param giveValue
     * @param giveLuckModefier
     * @param giveAttack
     * @param giveLevel
     */
    public Bodypart(String giveName, String giveCategory,String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, Double giveLuckModefier, Attack giveAttack, int giveLevel) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        luckModefier = giveLuckModefier;
        category = giveCategory;
        correspondingAttack = giveAttack;
        level = giveLevel;
    }
    
    /**
     *   initializes and sets the Bodypart
     * @param giveName
     * @param giveCategory
     * @param giveStatus
     * @param giveSpriteLocation
     * @param giveDropRate
     * @param giveDescription
     * @param giveValue
     * @param giveLuckModefier
     * @param giveAttack
     */
    public Bodypart(String giveName, String giveCategory,String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, Double giveLuckModefier, Attack giveAttack) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        luckModefier = giveLuckModefier;
        category = giveCategory;
        correspondingAttack = giveAttack;
    }
    
    /**
     *   sets the Bodypart level
     * @param getLevel
     */
    public void setLevel(int getLevel)
    {
        level = getLevel;
    }
    
    /**
     *  returns the category to which the Bodypart belongs to
     * @return
     */
    public String getCategory()
    {
        return category;
    }
    
    /**
     *  returns the Bodyparts level
     * @return
     */
    public int getLevel()
    {
        return level;
    }
    
    /**
     *  returns the Bodyparts stat modifier
     * @return
     */
    public int getStatModefier()
    {
        if(this.spriteLocation.contains("Heads"))
        {
            return (statModefier + level*5);
        }
        else
        {
            return (statModefier + level);
        }
        
    }
    
    /**
     *  returns the luck modifier
     * @return
     */
    public Double getLuckModefier()
    {
        return (luckModefier + level/1000);
    }
    
    /**
     *  returns the attack corresponding to the Bodypart
     * @return
     */
    public Attack getAttack()
    {
        return correspondingAttack;
    }
}
