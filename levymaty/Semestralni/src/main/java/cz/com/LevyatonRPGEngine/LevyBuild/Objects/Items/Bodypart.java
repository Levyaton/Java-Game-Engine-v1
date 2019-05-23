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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;

/**
 *
 * @author czech
 */
public class Bodypart extends Item{
    
    /**
     *
     */
    protected String category;

    /**
     *
     */
    protected int statModefier;

    /**
     *
     */
    protected Double luckModefier;

    /**
     *
     */
    protected Attack correspondingAttack;

    /**
     *
     */
    protected int level = 1;
    
    /**
     *
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
     *
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
     *
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
     *
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
     *
     * @param getLevel
     */
    public void setLevel(int getLevel)
    {
        level = getLevel;
    }
    
    /**
     *
     * @return
     */
    public String getCategory()
    {
        return category;
    }
    
    /**
     *
     * @return
     */
    public int getLevel()
    {
        return level;
    }
    
    /**
     *
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
     *
     * @return
     */
    public Double getLuckModefier()
    {
        return (luckModefier + level/1000);
    }
    
    /**
     *
     * @return
     */
    public Attack getAttack()
    {
        return correspondingAttack;
    }
}
