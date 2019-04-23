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

public class Jerky extends Item{
    
     final static private String name = "Jerky";
     final static private String state = "Movable";
     final static private int healthGain = 10;//How much health will the Apple restore
     final static private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
     final static private String description = "Overprised, and oversalted dried meat, yet still delitious ";
     final static int value = 70;
     final static Double dropRate = 0.05;

    public Jerky() {
        super(name, state, spriteLocation, dropRate, description, value, healthGain);
    }
    
}
