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
public class Bodypart extends Item{
    
    protected String category;
    protected int statModefier;
    protected Double luckModefier;
    protected Attack correspondingAttack;
    protected int level = 1;
    
    
    public Bodypart(String giveName, String giveCategory,String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, int giveStatModefier, Attack giveAttack) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        statModefier = giveStatModefier;   
        correspondingAttack = giveAttack;
        category = giveCategory;
    }
    
    public Bodypart(String giveName, String giveCategory,String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, int giveStatModefier, Attack giveAttack, int giveLevel) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        statModefier = giveStatModefier;   
        correspondingAttack = giveAttack;
        category = giveCategory;
        level = giveLevel;
    }
    
    public Bodypart(String giveName, String giveCategory,String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, Double giveLuckModefier, Attack giveAttack, int giveLevel) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        luckModefier = giveLuckModefier;
        category = giveCategory;
        correspondingAttack = giveAttack;
        level = giveLevel;
    }
    
    public Bodypart(String giveName, String giveCategory,String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, Double giveLuckModefier, Attack giveAttack) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        luckModefier = giveLuckModefier;
        category = giveCategory;
        correspondingAttack = giveAttack;
    }
    
    public void setLevel(int getLevel)
    {
        level = getLevel;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public int getLevel()
    {
        return level;
    }
    
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
    
    public Double getLuckModefier()
    {
        return (luckModefier + level/1000);
    }
    
    public Attack getAttack()
    {
        return correspondingAttack;
    }
}
