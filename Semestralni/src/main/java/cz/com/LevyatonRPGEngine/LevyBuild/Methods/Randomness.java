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

public class Randomness {
    
    Random rand = new Random();
    
    public int numberFromSequence(int numberAfterLast)
    {
        int chosenNum = rand.nextInt(numberAfterLast);
        return chosenNum;
    }
    
    public boolean success(Double modifier)
    {
        if(Math.random() <= modifier)
        {
            return true;
        }
        else
        {
            return false;
        }
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
    
}


