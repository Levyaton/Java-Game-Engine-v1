/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Legs.Leg_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.HealingItem;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Healing.*;

/**
 *
 * @author czech
 */
public class EatUp {
    final private static String effect = "Run off and find some food to heal yourself with";
    
    Apple apple = new Apple();
    Fish fish = new Fish();
    
    HealingItem[] tier1 = {apple.getApple(),fish.getFish()};
    Healing
    java.util.Random random = new java.util.Random();
    random.nextInt(5)
    final private static int turnLength = 2;
    final private static int damage = 35;//Adds up with stats and modefiers
    final private static String name = "Eat Up!";
    final private static Leg_Bear lb = new Leg_Bear();
    final private static Bodypart[] bodypart = {lb.getLeg()};

    public EatUp() {
        super(name, damage, turnLength, effect, bodypart);
    }
}
