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
    public class Tail_Bear {
        private Bodypart tail;
        private Double baseLuckMod = 0.4; //This number is doubled while wearing the full bear costume
        private String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Tailes\\Tail_Bear.png";//Currently doesn't exist
        private String description = "The severed tail of a bear";
        private int value = 30;
        private Double dropRate = 0.2;
        public Tail_Bear()
        {
            tail = new Bodypart("Bear Front Leg", "Movable", spriteLocation, dropRate,description,value,baseLuckMod);
        }

        public Bodypart getTail()
        {
            return tail;
        }
    }
