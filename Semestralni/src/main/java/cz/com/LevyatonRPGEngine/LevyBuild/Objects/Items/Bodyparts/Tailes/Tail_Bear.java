/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Tailes;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;

    public class Tail_Bear extends Bodypart{
       
        private static Double baseLuckMod = 0.1; //This number is doubled while wearing the full bear costume
        private static String spriteLocation;//Currently doesn't exist
        private static String description;
        private static int value;
        private static Double dropRate;
        private static String category;
        private static TailPeacocking tailPeacocking = new TailPeacocking(); 
        public Tail_Bear()
        {
            super("Bear Tail", category,"Movable", spriteLocation, dropRate,description,value,baseLuckMod, tailPeacocking);
            properties();
        }
        
        private void properties()
        {
            baseLuckMod = 0.1; //This number is doubled while wearing the full bear costume
            spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Tailes\\Tail_Bear.png";//Currently doesn't exist
            description = "The severed tail of a bear";
            value = 30;
            dropRate = 0.2;
            category = "Bear";
        }
        
        public Bodypart getTail()
        {
            return this;
        }
    }
