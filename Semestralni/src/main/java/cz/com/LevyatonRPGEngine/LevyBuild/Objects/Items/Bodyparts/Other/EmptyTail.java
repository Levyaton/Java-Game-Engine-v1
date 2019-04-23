/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Other;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.OnePunch;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;

/**
 *
 * @author czech
 */
public class EmptyTail extends Bodypart{
    final static private Double noMod = 0.0; 
    final static private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Hands\\Head_Bear.png";//Currently doesn't exist
    final static private String description = "A mortal punch";
    final static private int value = 0;
    final static private Double dropRate = 0.0;
    final static private OnePunch attack = new OnePunch();
    private static String category = "Nothing";

    public EmptyTail() {
         super("One Punch", category,"Static", spriteLocation, dropRate,description,value,noMod,attack);
    }
    
    public Bodypart getEmptyTailSlot()
    {
        return this;
    }
}
