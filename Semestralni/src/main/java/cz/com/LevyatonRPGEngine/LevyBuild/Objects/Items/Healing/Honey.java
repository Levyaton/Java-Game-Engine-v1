/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Healing;

/**
 *
 * @author czech
 */

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;

public class Honey extends Item{
    
     final static private String name = "Honey";
     final static private String state = "Movable";
     final static private int healthGain = 20;//How much health will the Apple restore
     final static private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
     final static private String description = "\n  ...it's just honey, what more is there to say about it?";
     final static int value = 15;
     final static Double dropRate = 0.35;

    public Honey() {
        super(name, state, spriteLocation, dropRate, description, value, healthGain);
    }
    
     
}
