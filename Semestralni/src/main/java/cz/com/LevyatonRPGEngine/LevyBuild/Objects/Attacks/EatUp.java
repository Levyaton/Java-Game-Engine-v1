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
    final private static boolean hasEffect = true;
    
    
     final private static Apple apple = new Apple();
     final private static Fish fish = new Fish();
     final private static Honey honey = new Honey();
     final private static Jerky jerky = new Jerky();
     final private static BloodDrink bloodDrink = new BloodDrink();
     final private static BearMeat bearMeat = new BearMeat();
     final private static HealthPotion potion = new HealthPotion(1000);
    
    final private static Item[] tier1 = {apple.getThis(),fish.getThis(), honey.getThis()};
    final private static Item[] tier2 = {jerky.getThis(),bloodDrink.getThis(),bearMeat};
    final private static Item[] tier3 = {potion};
    final private static Item[][] allTiers = {tier1, tier2, tier3};
    
    final private static int turnLength = 2;
    final private static int damage = 0;//Adds up with stats and modefiers
    final private static String name = "Eat Up!";
    final private static int strMod = 0;
    final private static int defMod = 0;
    final private static int speedMod = 0;
    final private static Double luckMod = 0.0;
    final private static int hpMod = 5;
    final private static String type = "head";
    final private static String[] text = {" is scavenging the area in search of food\n", " is still looking for food", " found and consumed the content of a basket of food that someone left behind! "};

// int giveStrMod, int giveDefMod, int giveSpeedMod, Double giveLuckMod, int giveHpMod

    public EatUp() {
        super(name, damage, turnLength, enemyCanMove, playerCanMove,0,hasEffect,allTiers,type, text,strMod,defMod,speedMod,luckMod,hpMod);
    }
}
