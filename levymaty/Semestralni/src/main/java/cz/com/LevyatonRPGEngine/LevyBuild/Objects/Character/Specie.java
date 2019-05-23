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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.basicGameObject;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;

/**
 *
 * @author czech
 */
public class Specie extends basicGameObject{
    
    /**
     *
     */
    protected int str;//Strength

    /**
     *
     */
    protected int speed;

    /**
     *
     */
    protected Double luck;

    /**
     *
     */
    protected int def;//Defense

    /**
     *
     */
    protected int hp;//Health Points

    /**
     *
     */
    protected Item[] loot; //What loot will be possible

    /**
     *
     */
    protected Attack[] attacks;

    /**
     *
     */
    protected int givenExp;

    /**
     *
     */
    protected int levelAttacks = 1;

    /**
     *
     */
    protected String focus;
    
    /**
     *
     * @param givenName
     * @param status
     * @param spriteLocation
     * @param giveStr
     * @param giveSpeed
     * @param giveLuck
     * @param giveDef
     * @param giveHP
     * @param giveLoot
     * @param giveAttacks
     * @param giveFocus
     */
    public Specie(String givenName,String status,String  spriteLocation,int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot, Attack[] giveAttacks, String giveFocus) {
        super(givenName,status, spriteLocation);
        properties(giveStr,giveSpeed,giveLuck,giveDef,giveHP,giveLoot,giveAttacks, giveFocus);
    
    }
    
    /**
     *
     * @param givenName
     * @param status
     * @param spriteLocation
     * @param giveStr
     * @param giveSpeed
     * @param giveLuck
     * @param giveDef
     * @param giveHP
     * @param giveLoot
     * @param giveAttacks
     * @param giveAttackLevel
     * @param giveFocus
     */
    public Specie(String givenName, String status,String  spriteLocation,int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot, Attack[] giveAttacks, int giveAttackLevel, String giveFocus) {
        super(givenName,status, spriteLocation);
        properties(giveStr,giveSpeed,giveLuck,giveDef,giveHP,giveLoot,giveAttacks,giveAttackLevel, giveFocus);
    }
    
    /**
     *
     * @param giveStr
     * @param giveSpeed
     * @param giveLuck
     * @param giveDef
     * @param giveHP
     * @param giveLoot
     * @param giveAttacks
     * @param giveFocus
     */
    protected void properties(int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot, Attack[] giveAttacks, String giveFocus)
    {
        str = giveStr;
        speed = giveSpeed;
        luck = giveLuck;
        def = giveDef;
        hp = giveHP;
        loot = giveLoot;
        attacks = giveAttacks;
        givenExp = Math.round(this.str*(this.hp/10 + this.speed/4 + this.def/2)*this.attacks.length); 
        focus = giveFocus;
    }
    
    /**
     *
     * @param giveStr
     * @param giveSpeed
     * @param giveLuck
     * @param giveDef
     * @param giveHP
     * @param giveLoot
     * @param giveAttacks
     * @param giveAttackLevel
     * @param giveFocus
     */
    protected void properties(int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot, Attack[] giveAttacks,  int giveAttackLevel,String giveFocus)
    {
        str = giveStr;
        speed = giveSpeed;
        luck = giveLuck;
        def = giveDef;
        hp = giveHP;
        loot = giveLoot;
        attacks = giveAttacks;
        levelAttacks = giveAttackLevel;
        setLevels(levelAttacks);
        givenExp = Math.round(this.str*(this.hp/10 + this.speed/4 + this.def/2)*this.attacks.length); 
        focus = giveFocus;
    }
    
    /**
     *
     * @return
     */
    public String getFocus()
    {
        return focus;
    }
    
    private void setLevels(int levelAttacks)
    {
        for(Attack attack : attacks)
        {
            attack.setLevel(levelAttacks);
        }
    }
    
    /**
     *
     * @return
     */
    public int getStr()
    {
        return str;
    }
    
    /**
     *
     * @return
     */
    public int getSpeed()
    {
        return speed;
    }
    
    /**
     *
     * @return
     */
    public Double getLuck()
    {
        return luck;
    }
    
    /**
     *
     * @return
     */
    public int getDef()
    {
        
        return def;
    }
    
    /**
     *
     * @return
     */
    public int getHP()
    {
        return hp;
    }
    
    /**
     *
     * @return
     */
    public int getExp()
    {
        return givenExp;
    }
    
    /**
     *
     * @return
     */
    public Item[] getLoot()
    {
        return loot;
    }
    
    /**
     *
     * @return
     */
    public String getStringLoot()
    {
        String lootStats = null;
        
        
        for (Item loot1 : loot) {
            lootStats = lootStats +  "Loot name: " + loot1.getName() + " Loot Drop Rate: " + loot1.getDropRate() + " ";
        }
        
        return lootStats;
    }
    
    /**
     *
     * @return
     */
    public Attack[] getAttacks()
    {
        return attacks;
    }
    
    /**
     *
     * @param chosenAttack
     * @param giveLevel
     */
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
