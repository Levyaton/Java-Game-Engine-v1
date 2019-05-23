/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.GameFiles.LevyBuild.customClasses;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.GameFiles.LevyBuild.customClasses.Attacks;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import java.util.ArrayList;

/**
 *
 * @author czech
 */
public class Bodyparts {
    
    Bodypart handBear;
    Bodypart headBear;
    Bodypart legBear;
    Bodypart emptySlot;
    Bodypart emptyTail;
    Bodypart tailBear;
    Bodypart torsoBear;
    
    ArrayList<Bodypart> heads = new ArrayList<Bodypart> (); 
    ArrayList<Bodypart> hands = new ArrayList<Bodypart> (); 
    ArrayList<Bodypart> torsos = new ArrayList<Bodypart> (); 
    ArrayList<Bodypart> legs = new ArrayList<Bodypart> (); 
    ArrayList<Bodypart> tails = new ArrayList<Bodypart> (); 
    ArrayList<Bodypart> empty = new ArrayList<Bodypart> (); 
    ArrayList<Bodypart> allBodyparts = new ArrayList<Bodypart> (); 
    
    Attacks attacks;
    
    /**
     *  A class containing all of the body parts (or costumes)
     * @param health
     * @param def
     */
    public Bodyparts(int health,int def)
    {
        attacks = new Attacks(health, def);
        this.handBear();
        this.headBear();
        this.legBear();
        this.emptySlot();
        this.emptyTail();
        this.tailBear();
        this.torsoBear();
    }
    
    /**
     *  returns the index of a specific Item within the ArrayList called allBodyParts
     * @param item
     * @return
     */
    public int getAllBodyPartsIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<allBodyparts.size(); x++)
        {
            if(item.getName().equals(allBodyparts.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    /**
     *     returns the index of a specific Item within the ArrayList called heads
     * @param item
     * @return
     */
    public int getHeadsIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<heads.size(); x++)
        {
            if(item.getName().equals(heads.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    /**
     *  returns the index of a specific Item within the ArrayList called hands
     * @param item
     * @return
     */
    public int getHandsIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<hands.size(); x++)
        {
            if(item.getName().equals(hands.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    /**
     *  returns the index of a specific Item within the ArrayList called torsos
     * @param item
     * @return
     */
    public int getTorsosIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<torsos.size(); x++)
        {
            if(item.getName().equals(torsos.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
     
    /**
     *   returns the index of a specific Item within the ArrayList called legs
     * @param item
     * @return
     */
    public int getLegsIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<legs.size(); x++)
        {
            if(item.getName().equals(legs.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    /**
     *   returns the index of a specific Item within the ArrayList called tails
     * @param item
     * @return
     */
    public int getTailsIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<tails.size(); x++)
        {
            if(item.getName().equals(tails.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    /**
     *   returns the index of a specific Item within the ArrayList called empty
     * @param item
     * @return
     */
    public int getEmptyIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<empty.size(); x++)
        {
            if(item.getName().equals(empty.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    /**
     *   sets the handBear body part
     */
    public void handBear()
    {
        int baseStrMod = 8; //This number is doubled while equipped with both hands of the same class and then doubled yet aggain while wearing the full bear costume
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Hands\\Hand_Bear.png";//Currently doesn't exist
        String description = "The severed front leg of a bear";
        int value = 20;
        Double dropRate = 0.35;
        Attack attack = attacks.getSlash();
        String category = "Bear";
        
        handBear = new Bodypart("Bear Front Leg", category,"Movable", spriteLocation, dropRate,description,value,baseStrMod, attack);
        allBodyparts.add(handBear);
        hands.add(handBear);
        
    }

    /**
     *   sets the headBear body part
     */
    public void headBear()
    {
        int baseHpMod = 30; //This number is doubled while equipped with the full bear costume
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Heads\\Head_Bear.png";//Currently doesn't exist
        String description = "The severed head of a bear";
        int value = 50;
        Double dropRate = 0.15;
        Attack attack = attacks.getEatUp();
        String category = "Bear";
        
        headBear = new Bodypart("Bear Head", category,"Movable", spriteLocation, dropRate,description,value,baseHpMod,attack);
        allBodyparts.add(headBear);
        heads.add(headBear);
    }

    /**
     *   sets the legBear body part
     */
    public void legBear()
    {
        int baseSpeedMod = 4; //This number is doubled while equipped with both hands of the same class and then doubled yet aggain while wearing the full bear costume
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Legs\\Leg_Bear.png";//Currently doesn't exist
        String description = "The severed back leg of a bear";
        int value = 20;
        Double dropRate = 0.3;
        Attack attack = attacks.getCharge();
        String category = "Bear";
        
        legBear = new Bodypart("Bear Back Leg", category,"Movable", spriteLocation, dropRate,description,value,baseSpeedMod,attack);
        allBodyparts.add(legBear);
        legs.add(legBear);
    }

    /**
     *   sets the emptySlot body part
     */
    public void emptySlot()
    {
        int noMod = 0; 
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\empty.png";//Currently doesn't exist
        String description = "An empty equipment slot";
        int value = 0;
        Double dropRate = 0.0;
        Attack attack = attacks.getDoNothing();
        String category = "Nothing";
        
        emptySlot = new Bodypart("Empty Slot", category,"Static", spriteLocation, dropRate,description,value,noMod,attack);
        allBodyparts.add(emptySlot);
        empty.add(emptySlot);
    }

    /**
     *   sets the emptyTail body part
     */
    public void emptyTail()
    {
        Double noMod = 0.0; 
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\empty.png";//Currently doesn't exist
        String description = "Nothing";
        int value = 0;
        Double dropRate = 0.0;
        Attack attack = attacks.getDoNothing();
        String category = "Nothing";
        
        emptyTail = new Bodypart("Empty Tail Slot", category,"Static", spriteLocation, dropRate,description,value,noMod,attack);
        allBodyparts.add(emptyTail);
        empty.add(emptyTail);
    }

    /**
     *  tailBear
     */
    public void tailBear()
    {
        Double baseLuckMod = 0.1; //This number is doubled while wearing the full bear costume
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Tailes\\Tail_Bear.png";//Currently doesn't exist
        String description = "The severed tail of a bear";
        int value = 30;
        Double dropRate = 0.2;
        String category = "Bear";
        Attack attack = attacks.getTailPeacocking();
        
        tailBear = new Bodypart("Bear Tail", category,"Movable", spriteLocation, dropRate,description,value,baseLuckMod, attack);
        allBodyparts.add(tailBear);
        tails.add(tailBear);
    }

    /**
     *   sets the torsoBear body part
     */
    public void torsoBear()
    {
        int baseDefMod = 4; //This number is doubled while wearing the full bear costume
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Bodyparts\\Torsos\\Torso_Bear.png";//Currently doesn't exist
        String description = "The severed torso of a bear";
        int value = 70;
        Double dropRate = 0.1;
        String category = "Bear";
        Attack attack = attacks.getThickSkin();
        
        torsoBear = new Bodypart("Bear Torso", category, "Movable", spriteLocation, dropRate,description,value,baseDefMod,attack);
        allBodyparts.add(torsoBear);
        torsos.add(torsoBear);
    }


    //Getters

    /**
     * returns an ArrayList containing all of the body parts
     * @return
     */
    
    public ArrayList<Bodypart> getAllBodyparts()
    {
        return allBodyparts;
    }
    
    /**
     * returns an ArrayList containing every in-game Head
     * @return
     */
    public ArrayList<Bodypart> getHeads()
    {
        return heads;
    }

    /**
     *  returns an ArrayList containing every in-game hand
     * @return
     */
    public ArrayList<Bodypart> getHands()
    {
        return hands;
    }

    /**
     * returns an ArrayList containing every in-game torso
     * @return
     */
    public ArrayList<Bodypart> getTorsos()
    {
        return torsos;
    }

    /**
     *   returns an ArrayList containing every in-game leg
     * @return
     */
    public ArrayList<Bodypart> getLegs()
    {
        return legs;
    }

    /**
     *   returns an ArrayList containing every in-game tail
     * @return
     */
    public ArrayList<Bodypart> getTails()
    {
        return tails;
    }

    /**  returns an ArrayList containing every empty body part
     *
     * @return
     */
    public ArrayList<Bodypart> getEmtpy()
    {
        return empty;
    }
    
    /**
     *   returns the handBear body part
     * @return
     */
    public Bodypart getHandBear()
    {
        return handBear;
    }
    
    /**
     *  returns the headBear body part
     * @return
     */
    public Bodypart getHeadBear()
    {
        return headBear;
    }
    
    /**
     *  returns the legBear body part
     * @return
     */
    public Bodypart getLegBear()
    {
        return legBear;
    }
    
    /**
     *  returns the emptySlot body part
     * @return
     */
    public Bodypart getEmptySlot()
    {
        return emptySlot;
    }
    
    /**
     *  returns the emptyTail body part
     * @return
     */
    public Bodypart getEmptyTail()
    {
        return emptyTail;
    }
    
    /**
     *  returns the tailBear body part
     * @return
     */
    public Bodypart getTailBear()
    {
        return tailBear;
    }
    
    /**
     *  returns the torsoBear body part
     * @return
     */
    public Bodypart getTorsoBear()
    {
        return torsoBear;
    }
}

