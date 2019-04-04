/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Legs.Leg_Bear;

/**
 *
 * @author czech
 */
public class Charge extends Attack{
    final private static String effect = "Burries feet deep into the ground and stores energy, before charging full strength into the opponent";
    final private static int turnLength = 2;
    final private static int damage = 35;//Adds up with stats and modefiers
    final private static String name = "Charge";
    final private static Leg_Bear lb = new Leg_Bear();
    final private static Bodypart[] bodypart = {lb.getLeg()};

    public Charge() {
        super(name, damage, turnLength, effect, bodypart);
    }
}
