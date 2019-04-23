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
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Randomness;

public class HealthPotion extends Item{
     
    final static private Randomness rand = new Randomness();
     final static private String name = "Health Potion";
     final static private String state = "Movable";
     final static private Double chanceOfNegativeEffect = 0.08;
     final static private Double goodHealing = 0.75;
     final static private Double badHealing = -0.5;
     final static private Double healthGain = rand.getChanceOfEffect(chanceOfNegativeEffect, badHealing, goodHealing);//How much health will the Apple restore
     final static private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
     final static private String description = "Will heal you...probably";
     final static int value = 50;
     final static Double dropRate = 0.1;

    public HealthPotion(int playerHealth) {
        super(name, state, spriteLocation, dropRate, description, ((int) Math.round(playerHealth*healthGain)) );
    }
    
    
}

