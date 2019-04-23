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

public class TailPeacocking extends Attack{
    
    
    final private static boolean enemyCanMove = false;
    final private static boolean characterCanMove = true;
    final private static boolean hasEffect = false;
    final private static int turnLength = 1;
    final private static int enemyBLockedForTurns = 15; //1-5 turns
    final private static int damage = 0;//Adds up with stats and modefiers
    final private static String name = "Tail Peacocking";
    final private static String[] textToBeWritten = {" stops everything they are doing to turn around and flaunt their beutifull tail. What magnifisance, what astounding beuty!\n"," stares in admiration, thinking 'What a glorious tail! I can't possably harm such perfection\n", " stops everything they are doing to turn around and flaunt their beutifull tail, but to no avail!\n", " looses interest and they are no longer focused on the tail (they are still totes jelly, though)\n"};
    final private static String type = "tail";
    
    public TailPeacocking() {
         super(name, damage, turnLength, enemyCanMove, characterCanMove,enemyBLockedForTurns,hasEffect, textToBeWritten,type);
    }
    
    
    
}
