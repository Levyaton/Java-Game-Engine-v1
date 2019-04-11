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
public class BearSkin extends Item{
    
    final private static int value = 10;//The value of a single gold coin
    final private static String description = "The skin of a bear - Fur included! Will suit all you furry needs :-b";
    final private static String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearSkin.png";//Currently doesn't exist
    final private static String name = "Bear Skin";
    final private static String status = "Interactable";
    final private static Double dropRate = 0.15;
    
    public BearSkin() {
        super(name, status, location, dropRate, description, value);
    }
    
    
}
