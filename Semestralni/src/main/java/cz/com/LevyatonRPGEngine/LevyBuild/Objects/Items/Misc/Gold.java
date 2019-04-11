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

public class Gold extends Item
{
    
    final static int value = 1;//The value of a single gold coin
    final static String description = "A single gold coin";
    final static String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\Gold_Coin.png";//Currently doesn't exist
    final static String name = "Gold Coin";
    final static String status = "Interactable";
    final static Double dropRate = 1.0;
    
    public Gold()
    {
        super(name, status, location, dropRate, description, value);
    }
    
   
    
}
