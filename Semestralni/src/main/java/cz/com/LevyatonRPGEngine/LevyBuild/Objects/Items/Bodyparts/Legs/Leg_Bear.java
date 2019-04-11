/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Legs;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
    public class Leg_Bear extends Bodypart{
       
        private static int baseSpeedMod = 4; //This number is doubled while equipped with both hands of the same class and then doubled yet aggain while wearing the full bear costume
        private static String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Legs\\Leg_Bear.png";//Currently doesn't exist
        private static String description = "The severed back leg of a bear";
        private static int value = 20;
        private static Double dropRate = 0.3;
        public Leg_Bear()
        {
            super("Bear Front Leg", "Movable", spriteLocation, dropRate,description,value,baseSpeedMod);
        }

        public Bodypart getLeg()
        {
            return this;
        }
}
