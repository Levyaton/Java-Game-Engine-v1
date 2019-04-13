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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;

public class Specie extends Object{
    
    protected int str;//Strength
    protected int speed;
    protected Double luck;
    protected int def;//Defense
    protected int hp;//Health Points
    protected Item[] loot; //What loot will be possible
    protected Attack[] attacks;
    protected int givenExp;
    
    public Specie(String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot, Attack[] giveAttacks) {
        super(givenName);
        str = giveStr;
        speed = giveSpeed;
        luck = giveLuck;
        def = giveDef;
        hp = giveHP;
        loot = giveLoot;
        attacks = giveAttacks;
        givenExp = str*(hp/10 + speed/4 + def/2)*attacks.length;
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
    
    public int getExp()
    {
        return givenExp;
    }
    
    public Item[] getLoot()
    {
        return loot;
    }
    
    public String getStringLoot()
    {
        String lootStats = null;
        
        
        for (Item loot1 : loot) {
            lootStats = lootStats +  "Loot name: " + loot1.getName() + " Loot Drop Rate: " + loot1.getDropRate() + " ";
        }
        
        return lootStats;
    }
    
    public Attack[] getAttacks()
    {
        return attacks;
    }
    
    public void setLevelOfAttack(Attack chosenAttack, int giveLevel)
    {
        int x = 0;
        boolean exists = false;
        for(Attack attack : attacks)
        {
            if(attack.getName().equals(chosenAttack.getName()))
            {
                attacks[x].setLevel(giveLevel);
                exists = true;
            }
            x++;
        }
        if(exists == false)
        {
            System.out.println("The attack was not found\n");
        }
       
        
    }
}
