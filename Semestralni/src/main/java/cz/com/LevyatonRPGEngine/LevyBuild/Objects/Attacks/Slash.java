/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks;

/**
 *
 * @author czech
 */

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;


public class Slash extends Attack{
    final private static boolean enemyCanMove = true;
    final private static boolean playerCanMove = true;
    final private static boolean hasEffect = false; //Slashes the oppopnent with mighty claws
    final private static int turnLength = 1;
    final private static int damage = 4;//Adds up with stats and modefiers
    final private static String name = "Slash";
    final private static String type = "hand";
    
    public Slash() 
    {
        super(name, damage, turnLength, enemyCanMove, playerCanMove,0,hasEffect,type);
    }
    
    
    
}
