/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Misc;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
public class BearBlood extends Item{
    
    final private static int value = 1;//The value of a single gold coin
    final private static String description = "A single gold coin";
    final private static String location = System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");//Currently doesn't exist
    final private static String name = "Gold Coin";
    final private static String status = "Interactable";
    final private static Double dropRate = 0.6;
    
    public BearBlood() {
        super(name, status, location, dropRate, description, value);
    }
    
    public Item getBearBlood()
    {
        return this;
    }
}
