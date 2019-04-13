/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Healing.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;

/**
 *
 * @author czech
 */
public class EatUp extends Attack {
    final private static boolean enemyCanMove = true;//Run off and find some food to heal yourself with
    final private static boolean playerCanMove = true;
    final private static boolean hasEffect = false;
    
    
     final private static Apple apple = new Apple();
     final private static Fish fish = new Fish();
    
    final private static Item[] tier1 = {apple.getThis(),fish.getThis()};
    
    final private static int turnLength = 2;
    final private static int damage = 0;//Adds up with stats and modefiers
    final private static String name = "Eat Up!";
    final private static int strMod = 0;
    final private static int defMod = 0;
    final private static int speedMod = 0;
    final private static Double luckMod = 0.0;
    final private static int hpMod = 5;
    


    public EatUp() {
        super(name, damage, turnLength, enemyCanMove, playerCanMove,0,hasEffect,tier1);
    }
}
