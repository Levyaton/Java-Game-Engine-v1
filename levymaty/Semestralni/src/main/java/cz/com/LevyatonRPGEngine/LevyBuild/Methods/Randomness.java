/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;



import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;

/**
 *  A class containing methods that use randomness for their results
 * @author czech
 */
public class Randomness {
    
    Random rand = new Random();
    
    /**
     *  returns a number between 0 and the given number
     * @param numberAfterLast
     * @return
     */
    public int numberFromSequence(int numberAfterLast)
    {
        int chosenNum = rand.nextInt(numberAfterLast);
        return chosenNum;
    }
    
    /**
     *  Generates a random number between 0 and 1. 
     *  Returns 0 if the generated number is is smaller then or equal to the first given number, but larger then the second given number. 
     *  Returns 1 if the generated number is smaller then or equal to the second given number, but larger then the third given number.
     *  Returns 2 if the generated number is larger then the first given number.
     *  Returns 10 if the generated number is smaller or equal to 0.02 but larger then 0.01, if none of the previous conditions have been met
     *  Otherwise, it returns 666
     * @param one
     * @param two
     * @param three
     * @return
     */
    public int chanceOfMultiple(Double one, Double two, Double three)
    {
        Double num = Math.random();
        if(num <= one && num > two)
        {
            return 0;
        }
        else if(num <=two && num> 0.02)
        {
            return 1;
        }
        else if(num>one)
        {
            return 2;
        }
        else if(num<=0.02 && num >0.01)
        {
            return 10;
        }
        else
        {
            return 666;
        }
    }
    
    /**
     *  Generates a random number between 0 and 1.
     *  Returns 0 if the generated number is smaller then or equal to the first given number
     *  Returns 1 if the previous conditions haven't been met and the generated number is smaller then or equal to the second given number.
     *  Otherwise, it returns 2.
     * @param one
     * @param two
     * @return
     */
    public int choiceOfThree(Double one, Double two)
    {
        Double num = Math.random();
        if(num<=one)
        {
            return 0;
        }
        else if(num<=two)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    
    /**
     *  Generates a number between 0 and 1, then checks to see if it is smaller then or equal to the given number, and returns the boolean as the result
     * @param modifier
     * @return
     */
    public boolean success(Double modifier)
    {
        return Math.random() <= modifier;
    }
    
    /**
     *   returns a number from the range between the given numbers
     * @param min
     * @param max
     * @return
     */
    public int getRandomFromRange(int min, int max)
    {
        int result = ThreadLocalRandom.current().nextInt(min,max+1);
        return result;
    }
    
    /**
     *  returns a random position from a given array
     * @param obj
     * @return
     */
    public int getRandomObjectFromSelection(Attack[] obj)
    {
        int chosen = numberFromSequence(obj.length);
        return chosen;
    }
    
    /**
     * returns a random position from a given array
     * @param obj
     * @return
     */
    public int getRandomObjectFromSelection(Item[] obj)
    {
        int chosen = numberFromSequence(obj.length);
        return chosen;
    }
    
    /**
     *  returns a random position from a given array
     * @param obj
     * @return
     */
    public int getRandomObjectFromSelection(String[] obj)
    {
        int chosen = numberFromSequence(obj.length);
        return chosen;
    }
     
    /**
     *  returns a random position from a given array
     * @param obj
     * @return
     */
    public int getRandomObjectFromSelection(Clerk[] obj)
    {
        int chosen = numberFromSequence(obj.length);
        return chosen;
    }
    
    /**
     *  decides on which number will be returned
     * @param chanceOfEffect
     * @param effectActivated
     * @param effectFailed
     * @return
     */
    public int getChanceOfEffect(Double chanceOfEffect, int effectActivated, int effectFailed)
    {
        if(success(chanceOfEffect))
        {
           return effectActivated;
        }
       return effectFailed;
    }
    
    /**
     * decides on which number will be returned
     * @param chanceOfEffect
     * @param effectActivated
     * @param effectFailed
     * @return
     */
    public Double getChanceOfEffect(Double chanceOfEffect, Double effectActivated, Double effectFailed)
    {
        if(success(chanceOfEffect))
        {
           return effectActivated;
        }
       return effectFailed;
    }
     
    /**
     *  returns a number based on many given stats
     * @param getPlayerDef
     * @param getPlayerMaxHealth
     * @param min
     * @param max
     * @param penalty
     * @return
     */
    public int healthGiver(int getPlayerDef, int getPlayerMaxHealth, int min, int max, Double penalty)
    {
        int witchAttack = getRandomFromRange(min, max);
        if(getPlayerDef>witchAttack)
        {
            return getPlayerMaxHealth;
        }
        return -((int) Math.round(getPlayerMaxHealth*penalty));
    }
    
}


