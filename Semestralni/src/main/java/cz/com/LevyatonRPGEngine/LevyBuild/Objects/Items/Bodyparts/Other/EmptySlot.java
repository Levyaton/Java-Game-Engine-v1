/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Other;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
/**
 *
 * @author czech
 */
public class EmptySlot extends Bodypart{
    
    final static private int noMod = 0; 
    final static private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Hands\\Head_Bear.png";//Currently doesn't exist
    final static private String description = "An empty equipment slot";
    final static private int value = 0;
    final static private Double dropRate = 0.0;
    
    public EmptySlot()
    {
        super("Bear Front Leg", "Static", spriteLocation, dropRate,description,value,noMod);
    }
    
    
    public Bodypart getEmptySlot()
    {
        return this;
    }
}
