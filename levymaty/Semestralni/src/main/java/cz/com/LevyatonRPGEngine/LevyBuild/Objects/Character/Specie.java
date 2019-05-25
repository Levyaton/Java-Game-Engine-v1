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
 *  A class containing the properties of a Specie
 * @author czech
 */
public class Specie extends basicGameObject{
    
    /**
     *  every specie must have a strength stat
     */
    protected int str;//Strength

    /**
     *  every specie must have a speed stat
     */
    protected int speed;

    /**
     *  every specie must have a luck stat
     */
    protected Double luck;

    /**
     *  every specie must have a defense stat
     */
    protected int def;//Defense

    /**
     *  every specie must have a hit points stat
     */
    protected int hp;//Health Points

    /**
     *  every specie must contain an Item array of their possible loot
     */
    protected Item[] loot; //What loot will be possible

    /**
     *  every specie must contain an Attack array containing their attacks
     */
    protected Attack[] attacks;

    /**
     *  every specie must contain the amount of experience they give to the player when defeated
     */
    protected int givenExp;

    /**
     *  every specie must have their attacks at a level greater then 0
     */
    protected int levelAttacks = 1;

    /**
     *  every specie must have a focus stat
     */
    protected String focus;
    
    /**
     *  initializes and set's up the specie
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
     *   initializes and set's up the specie
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
     * set's up the specie
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
     * set's up the specie
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
     *  returns the focus of the specie
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
     *  returns the species strength stat
     * @return
     */
    public int getStr()
    {
        return str;
    }
    
    /**
     *  returns the species speed stat
     * @return
     */
    public int getSpeed()
    {
        return speed;
    }
    
    /**
     *  returns the species luck stat
     * @return
     */
    public Double getLuck()
    {
        return luck;
    }
    
    /**
     *  returns the species defense stat
     * @return
     */
    public int getDef()
    {
        
        return def;
    }
    
    /**
     *  returns the species hit points stat
     * @return
     */
    public int getHP()
    {
        return hp;
    }
    
    /**
     *  returns the amount of experience points given to the player by defeating the species
     * @return
     */
    public int getExp()
    {
        return givenExp;
    }
    
    /**
     *  returns an Item array containing the possible species loot
     * @return
     */
    public Item[] getLoot()
    {
        return loot;
    }
    
   
    
    /**
     *  returns an Array containing the Species attacks
     * @return
     */
    public Attack[] getAttacks()
    {
        return attacks;
    }
    
    /**
     *  Sets the level of a given Attack to the given number
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
