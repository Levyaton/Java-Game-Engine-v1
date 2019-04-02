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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.HealingItem;


public class Fish {
    private HealingItem fish;
    private int healthGain = 10;//How much health will the Fish restore

    public Fish()
    {
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Fish.png";//Currently doesn't exist
        String description = "A raw fish";
        int value = 7;
        fish = new HealingItem("Apple", "Movable", spriteLocation, 0.8,description,value,healthGain);
    }
    
    public HealingItem getFish()
    {
        return fish;
    }

}
