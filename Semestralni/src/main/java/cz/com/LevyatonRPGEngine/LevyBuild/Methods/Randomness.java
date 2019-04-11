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

public class Randomness {
    
    Random rand = new Random();
    
    public int numberFromSequence(int numberAfterLast)
    {
        int chosenNum = rand.nextInt(50);
        return chosenNum;
    }
}
