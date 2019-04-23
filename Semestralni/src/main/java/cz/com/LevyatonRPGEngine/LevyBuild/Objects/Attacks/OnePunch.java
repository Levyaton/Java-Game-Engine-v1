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
public class OnePunch extends Attack {
    final private static boolean effect = false;//Do nothing
    final private static int turnLength = 1;
    final private static int damage = 20;//Adds up with stats and modefiers
    final private static String name = "One Punch";
    final private static String type = "hand";
    
    public OnePunch() {
        super(name, damage, turnLength, true, true,0,effect,1,type);
    }
}
