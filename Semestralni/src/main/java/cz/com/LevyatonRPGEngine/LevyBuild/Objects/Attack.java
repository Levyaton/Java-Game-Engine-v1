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
    
    
    public Attack(String giveName, int giveDamage, int giveTurnLength, boolean giveEnemyStatus, boolean giveCharacterStatus, int enemyBlockedForTurns, boolean giveHasEffect) {
        super(giveName);
        enemyCanMove = giveEnemyStatus;
        characterCanMove = giveCharacterStatus;
        eBlockLength = enemyBlockedForTurns;
        turnLength = giveTurnLength;
        damage = giveDamage;
        hasEffect = giveHasEffect;
        if(turnLength>1)
        {
            experienceNeeded = (level*1000)/turnLength + 500;
        }
        else
        {
            experienceNeeded = level*1000 + 500;
        }
    }
    
     public Attack(String giveName, int giveDamage, int giveTurnLength, boolean giveEnemyStatus, boolean giveCharacterStatus, int enemyBlockedForTurns, boolean giveHasEffect, Item[] randomSelection) {
        super(giveName);
        enemyCanMove = giveEnemyStatus;
        characterCanMove = giveCharacterStatus;
        eBlockLength = enemyBlockedForTurns;
        turnLength = giveTurnLength;
        damage = giveDamage;
        hasEffect = giveHasEffect;
        randomStat = true;
        
        if(turnLength>1)
        {
            experienceNeeded = (level*1000)/turnLength + 500;
        }
        else
        {
            experienceNeeded = level*1000 + 500;
        }
    }
    
    public Attack(String giveName, int giveDamage, int giveTurnLength, boolean giveEnemyStatus, boolean giveCharacterStatus, int enemyBlockedForTurns, boolean giveHasEffect, String[] giveBlockedText) {
        super(giveName);
        enemyCanMove = giveEnemyStatus;
        characterCanMove = giveCharacterStatus;
        eBlockLength = enemyBlockedForTurns;
        turnLength = giveTurnLength;
        damage = giveDamage;
        hasEffect = giveHasEffect;
        if(turnLength>1)
        {
            experienceNeeded = (level*1000)/turnLength + 500;
        }
        else
        {
            experienceNeeded = level*1000 + 500;
        }
    }
    
    public Attack(String giveName, int giveDamage, int giveTurnLength, boolean giveEnemyStatus, boolean giveCharacterStatus,int enemyBlockedForTurns, boolean giveHasEffect, int giveStrMod, int giveDefMod, int giveSpeedMod, Double giveLuckMod, int giveHpMod) {
        super(giveName);
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
        setExp();
    }
    
    
    public void makeRandomHealthFromItems(Item[] selection)
    {
        int numberOfHealth = rand.getRandomFromRange(1, selection.length +1);
        for(int x = 0; x<numberOfHealth; x++)
        {
            hPMod += selection[rand.getRandomObjectFromSelection(selection)].healthGain;
        }
    }
    
    public void setLevel(int giveLevel)
    {
        level = giveLevel;
        setExp();
    }
    
    public void setExp()
    {
        if(turnLength>1)
        {
            experienceNeeded = (level*1000)/turnLength + 500*strMod/4;
        }
        else
        {
            experienceNeeded = level*1000 + 500;
        }
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
                String stringMax = new String(charMax);
                int min = digits[0];
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
        levelUpStat(level);
        levelUpStat(damage);
        levelUpStat(eBlockLength);
        levelUpStat(strMod);
        levelUpStat(defMod);
        levelUpStat(speedMod);
        levelUpStat(luckMod);
        levelUpStat(hPMod);
        setExp();
    }
    
    public void levelUpStat(int stat)
    {
        if(stat>0)
        {
            stat++;
        }
    }
    
    public void levelUpStat(Double stat)
    {
        if(stat>0)
        {
            stat++;
        }
    }
    
    public void gainExp(int expGained)
    {
        experience += expGained;
        if(experience>experienceNeeded-1)
        {
            if(level == 0)
            {
                System.out.println("Congratulations! You just learned how to use the move " + name + "! You can use it while wearing the right equipment/n");
            }
            else
            {
                System.out.println("All of you observation has paid of! By watching your enemies use the move " + name + ", you have improved your own performance! " + name + " has leveled up/n");
            }
            experience = experience - experienceNeeded;
            levelUp();
        }
    }
    
    public int getStrMod()
    {
        return strMod;
    }
    
    public int getDefMod()
    {
        return defMod;
    }
    
    public int getSpeedMod()
    {
        return speedMod;
    }
    
    public Double getLuckMod()
    {
        return luckMod;
    }
    
    public int getHpMod()
    {
        return hPMod;
    }
    
    public String[] getBlockedText()
    {
        return blockedText;
    }
}
