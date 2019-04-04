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


public class Fish extends HealingItem {
    
        private static int healthGain = 10;//How much health will the Fish restore
        private static String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Fish.png";//Currently doesn't exist
        private static String description = "A raw fish";
        private static int value = 7;
        public Fish()
        {
           super("Apple", "Movable", spriteLocation, 0.8,description,value,healthGain);
        }

        public HealingItem getFish()
        {
            return this;
        }

}
