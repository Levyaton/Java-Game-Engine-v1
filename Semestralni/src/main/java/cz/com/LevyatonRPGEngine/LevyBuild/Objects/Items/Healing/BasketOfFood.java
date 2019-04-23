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

public class BasketOfFood extends Item{
    
     final static private String name = "Basket of Food";
     final static private String state = "Movable";
     final static private int healthGain = 5;//How much health will the Apple restore
     final static private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
     final static private String description = "A basket left by an unknown individual with varying content";
     final static int value = 3;
     final static Double dropRate = 0.8;

    public BasketOfFood() {
        super(name, state, spriteLocation, dropRate, description, value);
    }
     
}
