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
import java.util.Arrays;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Randomness;
import cz.com.LevyatonRPGEngine.LevyBuild.Window.BattlePanel;
import cz.com.LevyatonRPGEngine.LevyBuild.Window.MainFrame;

/**
 * a class containing the Attack properties
 * @author czech
 */
public class Attack extends basicGameObject {
    
    //Manditory information

    /**
     *  how many turns is the enemy immobilized
     */
    protected int eBlockLength;

    /**
     *  can the opponent move?
     */
    protected boolean enemyCanMove;

    /**
     *  How long does the attack last?
     */
    protected int turnLength;

    /**
     *  How much damage will the attack do?
     */
    protected int damage;
    //Stat modefiers

    /**
     *  What is the attacks strength modifier?
     */
    protected int strMod;

    /**
     *  What is the attacks defense modifier?
     */
    protected int defMod;

    /**
     *  What is the attacks speed modifier?
     */
    protected int speedMod;

    /**
     *  What is the attacks luck modifier?
     */
    protected Double luckMod;

    /**
     *  What is the attacks health point modifier?
     */
    protected int hPMod;

    /**
     *  What level does the attack have?
     */
    protected int level = 0;

    /**
     *  How many experience points does the level have?
     */ 
    protected int experience = 0;

    /**
     * How much experience does the Attack need to level up?
     */
    protected int experienceNeeded;

    /**
     *  Does the attack have an effect other then Damage?
     */
    protected boolean hasEffect;

   
    /**
     *  Does using the move cause its user to get stunned?
     */
    protected boolean characterCanMove;

    /**
     *  every Attack has access to randomness methods
     */
    protected Randomness rand = new Randomness();

    /**
     *  0 - successful attack, 1 - when opponent is blocked, 2 - when attack fails, 3 - when attack ends   
     */
    protected String[] blockedText = new String[4]; //

    /**
     *  does the attack use randomness?
     */
    protected boolean randomStat = false;

    /**
     *  What tye is the attack?
     */
    protected String type;

    /**
     *  What items can the attack use?
     */
    protected Item[][] items;

    /**
     *  Is the attack available?
     */
    protected boolean available = false;
    
    /**
     *  Initializes and sets up the Attack
     * @param giveName
     * @param giveDamage
     * @param giveTurnLength
     * @param giveEnemyStatus
     * @param giveCharacterStatus
     * @param enemyBlockedForTurns
     * @param giveHasEffect
     * @param giveType
     */
    public Attack(String giveName, int giveDamage, int giveTurnLength, boolean giveEnemyStatus, boolean giveCharacterStatus, int enemyBlockedForTurns, boolean giveHasEffect, String giveType) {
        super(giveName);
        firstStatLoad();
        enemyCanMove = giveEnemyStatus;
        characterCanMove = giveCharacterStatus;
        eBlockLength = enemyBlockedForTurns;
        turnLength = giveTurnLength;
        damage = giveDamage;
        hasEffect = giveHasEffect;
        type = giveType;
        setExp();
    }
    
    /**
     *  Initializes and sets up the Attack
     * @param giveName
     * @param giveDamage
     * @param giveTurnLength
     * @param giveEnemyStatus
     * @param giveCharacterStatus
     * @param enemyBlockedForTurns
     * @param giveHasEffect
     * @param giveLevel
     * @param giveType
     */
    public Attack(String giveName, int giveDamage, int giveTurnLength, boolean giveEnemyStatus, boolean giveCharacterStatus, int enemyBlockedForTurns, boolean giveHasEffect, int giveLevel, String giveType) {
        super(giveName);
        firstStatLoad();
        enemyCanMove = giveEnemyStatus;
        characterCanMove = giveCharacterStatus;
        eBlockLength = enemyBlockedForTurns;
        turnLength = giveTurnLength;
        damage = giveDamage;
        hasEffect = giveHasEffect;
        level = giveLevel;
        type = giveType;
        setExp();
    }
    
    /**
     *  Initializes and sets up the Attack
     * @param giveName
     * @param giveDamage
     * @param giveTurnLength
     * @param giveEnemyStatus
     * @param giveCharacterStatus
     * @param enemyBlockedForTurns
     * @param giveHasEffect
     * @param giveItems
     * @param giveType
     * @param giveBlockedText
     * @param giveStrMod
     * @param giveDefMod
     * @param giveSpeedMod
     * @param giveLuckMod
     * @param giveHpMod
     */
    public Attack(String giveName, int giveDamage, int giveTurnLength, boolean giveEnemyStatus, boolean giveCharacterStatus, int enemyBlockedForTurns, boolean giveHasEffect, Item[][] giveItems, String giveType, String[] giveBlockedText, int giveStrMod, int giveDefMod, int giveSpeedMod, Double giveLuckMod, int giveHpMod) {
        super(giveName);
        firstStatLoad();
        enemyCanMove = giveEnemyStatus;
        characterCanMove = giveCharacterStatus;
        eBlockLength = enemyBlockedForTurns;
        turnLength = giveTurnLength;
        damage = giveDamage;
        hasEffect = giveHasEffect;
        randomStat = true;
        type = giveType;
        blockedText = giveBlockedText;
        strMod = giveStrMod;
        defMod = giveDefMod;
        speedMod = giveSpeedMod;
        luckMod = giveLuckMod;
        hPMod = giveHpMod;
        items = giveItems;
        setExp();
    }
    
    /**
     *  Initializes and sets up the Attack
     * @param giveName
     * @param giveDamage
     * @param giveTurnLength
     * @param giveEnemyStatus
     * @param giveCharacterStatus
     * @param enemyBlockedForTurns
     * @param giveHasEffect
     * @param giveBlockedText
     * @param giveType
     */
    public Attack(String giveName, int giveDamage, int giveTurnLength, boolean giveEnemyStatus, boolean giveCharacterStatus, int enemyBlockedForTurns, boolean giveHasEffect, String[] giveBlockedText, String giveType) {
        super(giveName);
        firstStatLoad();
        enemyCanMove = giveEnemyStatus;
        characterCanMove = giveCharacterStatus;
        eBlockLength = enemyBlockedForTurns;
        turnLength = giveTurnLength;
        damage = giveDamage;
        hasEffect = giveHasEffect;
        type = giveType;
        blockedText = giveBlockedText;
        setExp();
    }
    
    /**
     *  Initializes and sets up the Attack
     * @param giveName
     * @param giveDamage
     * @param giveTurnLength
     * @param giveEnemyStatus
     * @param giveCharacterStatus
     * @param enemyBlockedForTurns
     * @param giveHasEffect
     * @param giveStrMod
     * @param giveDefMod
     * @param giveSpeedMod
     * @param giveLuckMod
     * @param giveHpMod
     * @param giveType
     */
    public Attack(String giveName, int giveDamage, int giveTurnLength, boolean giveEnemyStatus, boolean giveCharacterStatus,int enemyBlockedForTurns, boolean giveHasEffect, int giveStrMod, int giveDefMod, int giveSpeedMod, Double giveLuckMod, int giveHpMod, String giveType) {
        super(giveName);
        firstStatLoad();
        characterCanMove = giveCharacterStatus;
        enemyCanMove = giveEnemyStatus;
        eBlockLength = enemyBlockedForTurns;
        turnLength = giveTurnLength;
        damage = giveDamage;
        strMod = giveStrMod;
        defMod = giveDefMod;
        speedMod = giveSpeedMod;
        luckMod = giveLuckMod;
        hPMod = giveHpMod;
        hasEffect = giveHasEffect;
        type = giveType;
        setExp();
    }
    
    private void firstStatLoad()//So that nothing is empty, to prevent us from forgetting about one
    {
        characterCanMove = true;
        enemyCanMove = true;
        eBlockLength = 0;
        turnLength = 1;
        damage = 0;
        strMod = 0;
        defMod = 0;
        speedMod = 0;
        luckMod = 0.0;
        hPMod = 0;
        hasEffect = false;
    }
    
    /**
     *  sets the availability of the attack to the given boolean
     * @param givenAvailability
     */
    public void setAvailability(boolean givenAvailability)
    {    
        available = givenAvailability;
    }
    
    /**
     *  returns a random number based on the given number
     * @param stat
     * @return
     */
    public int setRandomStatFromItems(int stat)
    {
        
        if(stat != 0)
        {
            
            int tier = rand.chanceOfMultiple(0.65, 0.24, 0.95);
            if(tier != 10 && tier != 666)
            {
                int points = stat;    
                int numberOfItems = rand.getRandomFromRange(3, 6);
                for(int x = 0; x<numberOfItems;x++)
                {
                    points += items[tier][rand.getRandomObjectFromSelection(items[tier])].gain;
                }
                return points;
            }
            else if(tier == 10)
            {
                return stat;
            }
            else
            {
                return 1;
            }
        }
        return stat;
    }
    
    /**
     *  returns a random number based on the given number
     * @param stat
     * @return
     */
    public Double setRandomStatFromItems(Double stat)
    {
            
        if(stat != 0)
        {
            
            int tier = rand.chanceOfMultiple(0.7, 0.24, 0.9);
            if(tier != 10 && tier != 666)
            {
                Double points = stat;    
                int numberOfItems = rand.getRandomFromRange(1, 4);
                for(int x = 0; x<numberOfItems;x++)
                {
                    points += items[tier][rand.getRandomObjectFromSelection(items[tier])].gain;
                }
                return points;
            }
            else
            {
                return stat+0.001;
            }
           
        }
        return stat;
    }
    
    /**
     *  sets the level of the attack to the given number
     * @param giveLevel
     */
    public void setLevel(int giveLevel)
    {
        level = giveLevel;
        setExp();
    }
    
    /**
     *  sets experienceNeeded of the attack to match the correct value
     */
    public void setExp()
    {
        experienceNeeded = (level*1000)/turnLength + 500*strMod/4 + 500*damage/4 + 500*defMod/4 + 500*speedMod/4 + 500*hPMod/4 + 500;
    }
    
    /**
     *  returns the characteCanMove variable
     * @return
     */
    public boolean characterCanMove()
    {
        return characterCanMove;
    }
    
    /**
     *  returns the hasEffect variable
     * @return
     */
    public boolean hasEffect()
    {
        return hasEffect;
    }
    
    /**
     *    returns the enemyCanMove variable
     * @return
     */
    public boolean enemyCanMove()
    {
        return enemyCanMove;
    }
   
    private int getRandomOrNormLength(int stat)
    {
        if(stat>10)
            {
                String number = String.valueOf(stat);
                char[] digits = number.toCharArray();
                char[] charMax = Arrays.copyOfRange(digits, 1, digits.length);
                char[] charMin = Arrays.copyOfRange(digits, 0, 1);
                String stringMax = new String(charMax);
                String stringMin = new String(charMin);
                int min = Integer.parseInt(stringMin);
                int max = Integer.parseInt(stringMax);
                int result = rand.getRandomFromRange(min, max);
                return result;
            }
            return stat;
    }
    
    /**
     *    returns availability of the attack
     * @return
     */
    public boolean getAvailability()
    {
        return available;
    }
    
    /**
     *  returns a random number that determines how long the enemy will be stunned for
     * @return
     */
    public int getEBlockLength()
    {
        return getRandomOrNormLength(eBlockLength);
    }
    
    /**
     *  returns a random number that determines the length of an attack
     * @return
     */
    public int getTurnLength()
    {
        return getRandomOrNormLength(turnLength);
    }
    
    /**
     *  returns the amount of damage the attack does
     * @return
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     *  returns the attack level
     * @return
     */
    public int getLevel()
    {
        return level;
    }
    
    /**
     *  returns the attack experience points
     * @return
     */
    public int getExp()
    {
        return experience;
    }
    
    /**
     *  levels up the attack
     */
    public void levelUp()
    {
        level ++;
        damage =levelUpStat(damage);
        eBlockLength = levelUpStat(eBlockLength);
        strMod = levelUpStat(strMod);
        defMod = levelUpStat(defMod);
        speedMod = levelUpStat(speedMod);
        levelUpLuck();
        hPMod = levelUpStat(hPMod);
        setExp();
        
    }
    
    /**
     *  levels up a given stat
     * @param stat
     * @return
     */
    public int levelUpStat(int stat)
    {
        if(stat>0)
        {
            return stat++;
        }
        return 0;
    }
    
    /**
     *  levels up luck
     */
    public void levelUpLuck()
    {
        
        if(luckMod != 0)
        {
           luckMod += 0.01;
        }
       
    }
    
    /**
     *  increments experience by the given amount
     * @param expGained
     * @throws InterruptedException
     */
    public void gainExp(int expGained) throws InterruptedException
    {
        experience += expGained;
        while(experience>=experienceNeeded){
            
        
        if(experience>=experienceNeeded)
        {
            if(level == 0)
            {
                 System.out.println("Congratulations! You just learned how to use the move " + name + "! You can use it while wearing the right equipment\n");
            }
 
            else if (name.equals("Do nothing"))
            {
                System.out.println("All of you observationand hard work has paid of! By using and watching your enemies do nothing, you have improved your own performance! " + name + " has leveled up\n");
            }
            else
            {
                System.out.println("All of you observation and hard work has paid of! By using and watching your enemies use the move " + name + ", you have improved your own performance! " + name + " has leveled up\n");
            }
            experience = experience - experienceNeeded;
            levelUp();
        }
      }
    }
    
    /**
     *  returns the strength modifier
     * @return
     */
    public int getStrMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(strMod);
        }
        return strMod;
    }
    
    /**
     * returns the defense modifier
     * @return
     */
    public int getDefMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(defMod);
        }
        return defMod;
    }
    
    /**
     * returns the speed modifier
     * @return
     */
    public int getSpeedMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(speedMod);
        }
        return speedMod;
    }
    
    /**
     *   returns the luck modifier
     * @return
     */
    public Double getLuckMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(luckMod);
        }
        return luckMod;
    }
    
    /**
     *   returns the hit points modifier
     * @return
     */
    public int getHpMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(hPMod);
        }
        return hPMod;
    }
    
    /**
     *  returns the attack type
     * @return
     */
    public String getType()
    {
        return type;
    }
    
    /** 
     *  returns the blocked text array
     * @return
     */
    public String[] getBlockedText()
    {
        return blockedText;
    }
    
    /**
     *  returns the experience needed variable
     * @return
     */
    public int getExperienceNeeded()
    {
        return experienceNeeded;
    }
    
    /**
     *`returns the total amount of experience the attack has collected based on the current level and experience
     * @return
     */
    public int getExpTotal()
    {
        int expTotal = 0;
        for(int currentLevel = 1; currentLevel<this.getLevel()+1; currentLevel++)
        {
            expTotal += (currentLevel*1000)/turnLength + 500*strMod/4 + 500*damage/4 + 500*defMod/4 + 500*speedMod/4 + 500*hPMod/4 + 500;
        }
        return expTotal;
    }
}
