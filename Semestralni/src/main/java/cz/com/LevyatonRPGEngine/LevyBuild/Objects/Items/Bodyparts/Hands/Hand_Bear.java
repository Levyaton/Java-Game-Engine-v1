/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Hands;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
    
public class Hand_Bear extends Bodypart{
    
    final static private int baseStrMod = 8; //This number is doubled while equipped with both hands of the same class and then doubled yet aggain while wearing the full bear costume
    final static private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Hands\\Hand_Bear.png";//Currently doesn't exist
    final static private String description = "The severed front leg of a bear";
    final static private int value = 20;
    final static private Double dropRate = 0.35;
    public Hand_Bear()
    {
        super("Bear Front Leg", "Movable", spriteLocation, dropRate,description,value,baseStrMod);
    }
    
    public Bodypart getHand()
    {
        return this;
    }
}
    
