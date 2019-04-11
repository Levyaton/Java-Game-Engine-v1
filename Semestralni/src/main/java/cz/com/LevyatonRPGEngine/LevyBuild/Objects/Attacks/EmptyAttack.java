/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;

/**
 *
 * @author czech
 */
public class EmptyAttack extends Attack {
    final private static String effect = "Do nothing";
    final private static int turnLength = 1;
    final private static int damage = 0;//Adds up with stats and modefiers
    final private static String name = "Do nothing";
    

    public EmptyAttack() {
        super(name, damage, turnLength, effect);
    }
}
