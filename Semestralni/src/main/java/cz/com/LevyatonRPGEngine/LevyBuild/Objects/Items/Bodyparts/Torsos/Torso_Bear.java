/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Torsos;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
public class Torso_Bear extends Bodypart{
    
        private static int baseDefMod = 4; //This number is doubled while wearing the full bear costume
        private static String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Torsos\\Torso_Bear.png";//Currently doesn't exist
        private static String description = "The severed torso of a bear";
        private static int value = 70;
        private static Double dropRate = 0.1;
        private static String category = "Bear";
         private static ThickSkin thickSkin = new ThickSkin();
        public Torso_Bear()
        {
            super("Bear Torso", category, "Movable", spriteLocation, dropRate,description,value,baseDefMod,thickSkin);
        }

        public Bodypart getTorso()
        {
            return this;
        }
}
