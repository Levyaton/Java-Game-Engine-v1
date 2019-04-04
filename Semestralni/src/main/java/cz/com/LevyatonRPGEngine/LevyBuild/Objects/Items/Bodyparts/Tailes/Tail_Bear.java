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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
    public class Tail_Bear extends Bodypart{
       
        private static Double baseLuckMod = 0.4; //This number is doubled while wearing the full bear costume
        private static String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Tailes\\Tail_Bear.png";//Currently doesn't exist
        private static String description = "The severed tail of a bear";
        private static int value = 30;
        private static Double dropRate = 0.2;
        public Tail_Bear()
        {
            super("Bear Front Leg", "Movable", spriteLocation, dropRate,description,value,baseLuckMod);
        }

        public Bodypart getTail()
        {
            return this;
        }
    }
