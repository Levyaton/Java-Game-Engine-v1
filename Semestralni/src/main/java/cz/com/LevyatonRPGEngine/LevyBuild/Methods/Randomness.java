/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;

/**
 *
 * @author czech
 */

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;

public class Randomness {
    
    Random rand = new Random();
    
    public int numberFromSequence(int numberAfterLast)
    {
        int chosenNum = rand.nextInt(numberAfterLast);
        return chosenNum;
    }
    
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
    
    public boolean success(Double modifier)
    {
        return Math.random() <= modifier;
    }
    
    public int getRandomFromRange(int min, int max)
    {
        int result = ThreadLocalRandom.current().nextInt(min,max+1);
        return result;
    }
    
    public int getRandomObjectFromSelection(Attack[] obj)
    {
        int chosen = numberFromSequence(obj.length);
        return chosen;
    }
    
    public int getRandomObjectFromSelection(Item[] obj)
    {
        int chosen = numberFromSequence(obj.length);
        return chosen;
    }
    
     public int getRandomObjectFromSelection(String[] obj)
    {
        int chosen = numberFromSequence(obj.length);
        return chosen;
    }
     
     public int getRandomObjectFromSelection(Clerk[] obj)
    {
        int chosen = numberFromSequence(obj.length);
        return chosen;
    }
    
    public int getChanceOfEffect(Double chanceOfEffect, int effectActivated, int effectFailed)
    {
        if(success(chanceOfEffect))
        {
           return effectActivated;
        }
       return effectFailed;
    }
    
     public Double getChanceOfEffect(Double chanceOfEffect, Double effectActivated, Double effectFailed)
    {
        if(success(chanceOfEffect))
        {
           return effectActivated;
        }
       return effectFailed;
    }
     
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


