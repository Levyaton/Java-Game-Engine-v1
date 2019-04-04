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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Hands.*;

public class Slash extends Attack{
    
    final private static String effect = "Slashes the oppopnent with mighty claws";
    final private static int turnLength = 1;
    final private static int damage = 10;//Adds up with stats and modefiers
    final private static String name = "Slash";
    final private static Hand_Bear hb = new Hand_Bear();
    final private static Bodypart[] bodypart = {hb.getHand()};

    public Slash() {
        super(name, damage, turnLength, effect, bodypart);
    }
    
    
    
}
