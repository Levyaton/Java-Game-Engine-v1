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

public class SandWitch extends Item{
     
     final static private Randomness rand = new Randomness();
     final static private String name = "SandWitch";
     final static private String state = "Movable";
     final static private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
     final static private String description = "It seems to yell curses at you, as if to indicate it's sentience. The sandwich also seems to contain a lot of sand. Still, there is now way the sandwich is a person...right?";
     final static int value = 0;
     final static Double dropRate = 0.2;

    public SandWitch(int getPlayerDef, int getPlayerMaxHealth) {
        super(name, state, spriteLocation, dropRate, description, value, rand.healthGiver(getPlayerDef, getPlayerMaxHealth, 30, 200, 0.75));
    }
    
    private int healthGiver(int getPlayerDef, int getPlayerMaxHealth)
    {
        int witchAttack = rand.getRandomFromRange(30, 200);
        if(getPlayerDef>witchAttack)
        {
            return getPlayerMaxHealth;
        }
        return -((int) Math.round(getPlayerMaxHealth*0.75));
    }
}
