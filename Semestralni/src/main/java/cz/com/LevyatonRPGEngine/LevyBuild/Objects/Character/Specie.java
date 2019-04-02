/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Object;

public class Specie extends Object{
    
    protected int str;//Strength
    protected int speed;
    protected Double luck;
    protected int def;//Defense
    protected int hp;//Health Points
    protected Item[] loot; //What loot will be possible
    
    
    public Specie(String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot) {
        super(givenName);
        str = giveStr;
        speed = giveSpeed;
        luck = giveLuck;
        def = giveDef;
        hp = giveHP;
        loot = giveLoot;
    }
    
    public int getStr()
    {
        return str;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public Double getLuck()
    {
        return luck;
    }
    
    public int getDef()
    {
        return def;
    }
    
    public int getHP()
    {
        return hp;
    }
    
    public String getLoot()
    {
        String lootStats = null;
        
        
        for (Item loot1 : loot) {
            lootStats = lootStats +  "Loot name: " + loot1.getName() + " Loot Drop Rate: " + loot1.getDropRate() + " ";
        }
        
        return lootStats;
    }
}
