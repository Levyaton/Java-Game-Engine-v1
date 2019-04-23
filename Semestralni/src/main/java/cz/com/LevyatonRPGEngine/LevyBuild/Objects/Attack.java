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
public abstract class Attack extends Object {
    
    //Manditory information
    protected int eBlockLength;//how many turns is the enemy immobilized
    protected boolean enemyCanMove;
    protected int turnLength;
    protected int damage;
    //Stat modefiers
    protected int strMod;
    protected int defMod;
    protected int speedMod;
    protected Double luckMod;
    protected int hPMod;
    protected int level = 0;
    protected int experience = 0;
    protected int experienceNeeded;
    protected boolean hasEffect;
    protected String statName;
    protected boolean characterCanMove;
    protected Randomness rand = new Randomness();
    protected String[] blockedText = new String[4]; //0 - succesfull attack, 1 - when opponent is blocked, 2 - when attack fails, 3 - when attack ends   
    protected boolean randomStat = false;
    protected String type;
    protected Item[][] items;
    
    
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
    
   
    
    public void setLevel(int giveLevel)
    {
        level = giveLevel;
        setExp();
    }
    
    public void setExp()
    {
        experienceNeeded = (level*1000)/turnLength + 500*strMod/4 + 500*damage/4 + 500*defMod/4 + 500*speedMod/4 + 500*hPMod/4 + 500;
    }
    
    public boolean characterCanMove()
    {
        return characterCanMove;
    }
    
    public boolean hasEffect()
    {
        return hasEffect;
    }
    
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
    
    public int getEBlockLength()
    {
        return getRandomOrNormLength(eBlockLength);
    }
    
    public int getTurnLength()
    {
        return getRandomOrNormLength(turnLength);
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public int getExp()
    {
        return experience;
    }
    
    public void levelUp()
    {
        level = levelUpStat(level);
        damage =levelUpStat(damage);
        eBlockLength = levelUpStat(eBlockLength);
        strMod = levelUpStat(strMod);
        defMod = levelUpStat(defMod);
        speedMod = levelUpStat(speedMod);
        levelUpLuck();
        hPMod = levelUpStat(hPMod);
        setExp();
    }
    
    public int levelUpStat(int stat)
    {
        if(stat>0)
        {
            return stat++;
        }
        return 0;
    }
    
    
    public void levelUpLuck()
    {
        
        if(luckMod != 0)
        {
           luckMod += 0.01;
        }
       
    }
    
    public void gainExp(int expGained)
    {
        experience += expGained;
        if(experience>experienceNeeded-1)
            
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
    
    public int getStrMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(strMod);
        }
        return strMod;
    }
    
    public int getDefMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(defMod);
        }
        return defMod;
    }
    
    public int getSpeedMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(speedMod);
        }
        return speedMod;
    }
    
    public Double getLuckMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(luckMod);
        }
        return luckMod;
    }
    
    public int getHpMod()
    {
        if(this.randomStat)
        {
            return this.setRandomStatFromItems(hPMod);
        }
        return hPMod;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String[] getBlockedText()
    {
        return blockedText;
    }
    
    public int getExperienceNeeded()
    {
        return experienceNeeded;
    }
    
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
