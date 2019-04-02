/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Heads;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;

public class Head_Bear {
    private Bodypart head;
    private int baseHpMod = 30; //This number is doubled while equipped with the full bear costume
    private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Heads\\Head_Bear.png";//Currently doesn't exist
    private String description = "The severed head of a bear";
    private int value = 50;
    private Double dropRate = 0.15;
    public Head_Bear()
    {
        head = new Bodypart("Bear Head", "Movable", spriteLocation, dropRate,description,value,baseHpMod);
    }
    
    public Bodypart getHead()
    {
        return head;
    }
}
