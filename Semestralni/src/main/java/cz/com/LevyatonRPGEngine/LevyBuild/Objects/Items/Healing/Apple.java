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

public class Apple {
    
    private HealingItem apple;
    private int healthGain = 5;//How much health will the Apple restore
    private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
    private String description = "A juicy looking apple";
    int value = 3;
    public Apple()
    {
        
        apple = new HealingItem("Apple", "Movable", spriteLocation, 0.8,description,value,healthGain);
    }
    
    public HealingItem getApple()
    {
        return apple;
    }
}
