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
public class ThickSkin extends Attack{
    final private static boolean enemyCanMove = true;
    final private static boolean playerCanMove = true;
    final private static boolean hasEffect = true; //Slashes the oppopnent with mighty claws
    final private static int turnLength = 1;
    final private static int damage = 0;//Adds up with stats and modefiers
    final private static String name = "Thick Skin";
    final private static int strMod = 0;
    final private static int defMod = 3;
    final private static int speedMod = 0;
    final private static Double luckMod = 0.0;
    final private static int hpMod = 0;
    
    
    public ThickSkin()
    {
        //int giveStrMod, int giveDefMod, int giveSpeedMod, Double giveLuckMod, int giveHpMod
        super(name, damage, turnLength, enemyCanMove, playerCanMove,0,hasEffect, strMod, defMod, speedMod, luckMod,hpMod);
    }
}
