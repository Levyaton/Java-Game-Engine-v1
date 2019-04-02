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
public class Torso_Bear {
    private Bodypart torso;
        private int baseDefMod = 14; //This number is doubled while wearing the full bear costume
        private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Torsos\\Torso_Bear.png";//Currently doesn't exist
        private String description = "The severed torso of a bear";
        private int value = 70;
        private Double dropRate = 0.1;
        public Torso_Bear()
        {
            torso = new Bodypart("Bear Front Leg", "Movable", spriteLocation, dropRate,description,value,baseDefMod);
        }

        public Bodypart getTorso()
        {
            return torso;
        }
}
