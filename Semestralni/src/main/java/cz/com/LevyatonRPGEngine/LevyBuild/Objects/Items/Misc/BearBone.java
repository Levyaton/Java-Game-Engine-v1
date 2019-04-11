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
public class BearBone extends Item{
    
    final private static int value = 7;//The value of a single gold coin
    final private static String description = "A single gold coin";
    final private static String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearBone.png";//Currently doesn't exist
    final private static String name = "Gold Coin";
    final private static String status = "Interactable";
    final private static Double dropRate = 0.3;
    
    public BearBone() {
       super(name, status, location, dropRate, description, value);
    }
    
    
}
