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
public class BearMeat extends Item{
    
    final static private int healthGain = 5;//How much health will the Apple restore
     final static private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\HealingItems\\BearMeat.png";//Currently doesn't exist
     final static private String description = "The meat of a bear";
     final static private String name = "Bear Meat";
     final static private int value = 10;
     final static private Double dropRate = 0.7;
     final static private String status = "Movable";
    
    public BearMeat() {
        super(BearMeat.name, BearMeat.status, BearMeat.spriteLocation, BearMeat.dropRate, BearMeat.description, BearMeat.value, BearMeat.healthGain);
        
    }
    
   
}
