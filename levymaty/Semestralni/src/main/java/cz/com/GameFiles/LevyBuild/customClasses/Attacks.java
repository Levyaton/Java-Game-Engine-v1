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
import java.util.ArrayList;

/**
 *  A class containing all the Attacks
 * @author czech
 */
public class Attacks {
    
    //properties
    
    Items items;
    
    Attack emptyAttack;
   
    Attack doNothing;
    
    Attack eatUp;
   
    Attack onePunch;
    
    Attack slash;
    
    Attack tailPeacocking;
    
    Attack thickSkin;
    
    Attack charge;
    
    ArrayList<Attack> allAttacks = new ArrayList<Attack>();
    
    /**
     *  creates the emptyAttack attack
     */
    public void emptyAttack()
    {
        boolean effect = false;//Do nothing
        int turnLength = 1;
        int damage = 0;//Adds up with stats and modefiers
        String name = "NullAttack";
        String type = "null";
        
        emptyAttack = new Attack(name, damage, turnLength, true,true,0,effect,1,type);
        allAttacks.add(emptyAttack);
    }
    
    /**
     *  creates the doNothing ATtack
     */
    public void doNothing()
    {
        boolean effect = false;//Do nothing
        int turnLength = 1;
        int damage = 0;//Adds up with stats and modefiers
        String name = "Do nothing";
        String type = "nothing";
        
        doNothing = new Attack(name, damage, turnLength, true,true,0,effect,1,type);
        doNothing.setAvailability(true);
        doNothing.setLevel(1);
        allAttacks.add(doNothing);
    }
    
    /**
     *  creates the eatUp attack
     * @param giveHealth
     */
    public void eatUp(int giveHealth)
    //There seems to be a strange glitch here, which causes the the player to use tailPeacocking automaticly. I still dont know what causes this, but since it doesnt break the game, I will come back to it later
    //Found another glitch. The number of health points given by the attack seems to differ from the real gain in some cases. My theory is that his happens when the given hp surpasses the max, though it seems to always happen when gaining 70 hp
    {
        boolean enemyCanMove = true;//Run off and find some food to heal yourself with
        boolean playerCanMove = true;
        boolean hasEffect = true;
    
        Item[] tier1 = {items.getApple(),items.getFish(), items.getHoney()};
        Item[] tier2 = {items.getJerky(),items.getBloodDrink(),items.getBearMeat()};
        Item[] tier3 = {items.getHealingPotion()};
        Item[][] allTiers = {tier1, tier2, tier3};
        
        int turnLength = 2;
        int damage = 0;//Adds up with stats and modefiers
        String name = "Eat Up!";
        int strMod = 0;
        int defMod = 0;
        int speedMod = 0;
        Double luckMod = 0.0;
        int hpMod = 5;
        String type = "head";
        String[] text = {" is scavenging the area in search of food\n", " is still looking for food", " found and consumed the content of a basket of food that someone left behind! "};
    
        eatUp = new Attack(name, damage, turnLength, enemyCanMove, playerCanMove,0,hasEffect,allTiers,type, text,strMod,defMod,speedMod,luckMod,hpMod);
        allAttacks.add(eatUp);
        
    }
    
    /**
     *  creates the onePunch attack
     */
    public void onePunch()
    {
        boolean effect = false;//Do nothing
        int turnLength = 1;
        int damage = 20;//Adds up with stats and modefiers
        String name = "One Punch";
        String type = "hand";
        
        onePunch = new Attack(name, damage, turnLength, true, true,0,effect,1,type);
        allAttacks.add(onePunch);
    }
    
    /**
     *  creates the Slash attack
     */
    public void slash()
    {
        boolean enemyCanMove = true;
        boolean playerCanMove = true;
        boolean hasEffect = false; //Slashes the oppopnent with mighty claws
        int turnLength = 1;
        int damage = 4;//Adds up with stats and modefiers
        String name = "Slash";
        String type = "hand";
        
        slash = new Attack(name, damage, turnLength, enemyCanMove, playerCanMove,0,hasEffect,type);
        allAttacks.add(slash);
    }
    
    /**
     *  creates the tailPeacocking attack
     */
    public void tailPeacocking()
    {
        boolean enemyCanMove = false;
        boolean characterCanMove = true;
        boolean hasEffect = false;
        int turnLength = 1;
        int enemyBLockedForTurns = 15; //1-5 turns
        int damage = 0;//Adds up with stats and modefiers
        String name = "Tail Peacocking";
        String[] textToBeWritten = {" stops everything they are doing to turn around and flaunt their beutifull tail. What magnifisance, what astounding beuty!\n"," stares in admiration, thinking 'What a glorious tail! I can't possably harm such perfection\n", " stops everything they are doing to turn around and flaunt their beutifull tail, but to no avail!\n", " looses interest and they are no longer focused on the tail (they are still totes jelly, though)\n"};
        String type = "tail";
        
        tailPeacocking = new Attack(name, damage, turnLength, enemyCanMove, characterCanMove,enemyBLockedForTurns,hasEffect, textToBeWritten,type);
        allAttacks.add(tailPeacocking);
    }
    
    /**
     *  creates the thickSkin attack
     */
    public void thickSkin()
    {
        boolean enemyCanMove = true;
        boolean playerCanMove = true;
        boolean hasEffect = true; //Slashes the oppopnent with mighty claws
        int turnLength = 1;
        int damage = 0;//Adds up with stats and modefiers
        int strMod = 0;
        int defMod = 5;
        int speedMod = 0;
        int hpMod = 0;
        Double luckMod = 0.0;
        String name = "Thick Skin";
        String type = "torso";
        
        thickSkin = new Attack(name, damage, turnLength, enemyCanMove, playerCanMove,0,hasEffect, strMod, defMod, speedMod, luckMod,hpMod,type);
        allAttacks.add(thickSkin);
    }
    
    /**
     *  creates the charge attack
     */
    public void charge()
    {
        int eBlockLength = 0;//how many turns is the enemy immobilized
        boolean enemyCanMove = true;
        boolean playerCanMove = false;
        boolean hasEffect = false;//Burries feet deep into the ground and stores energy, before charging full strength into the opponent
        int turnLength = 2;
        int damage = 50;//Adds up with stats and modefiers
        String name = "Charge";
        String[] text = {" prepares to charge!\n", " is still mentally preparing for their charge\n", " finnally charges!\n", ""};
        String type = "leg";
        
        charge = new Attack(name, damage, turnLength, enemyCanMove, playerCanMove,0,hasEffect,text,type);
        allAttacks.add(charge);
    }
    
    
    //Initializator

    /**
     *  Initializes Attacks
     * @param giveHealth
     * @param giveDef
     */
    
    public Attacks(int giveHealth, int giveDef)
    {
        items = new Items(giveHealth, giveDef);
        emptyAttack();
        doNothing();
        eatUp(giveHealth);
        onePunch();
        slash();
        tailPeacocking();
        thickSkin();
        charge();
    }
    
    /**
     *  Initializes Attacks
     */
    public Attacks()
    {
        emptyAttack();
        doNothing();
        onePunch();
        slash();
        tailPeacocking();
        thickSkin();
        charge();
    }
    
    
    //Getters

    /**
     *  returns an ArrayList containing all of the attacks
     * @return
     */
    
    public ArrayList<Attack> getAllAttacks()
    {
        return allAttacks;
    }
    
    /**
     *  returns the emptyAttack attack 
     * @return
     */
    public Attack getEmptyAttack()
    {
        return emptyAttack;
    }
    
    /**
     *  returns the doNothing attack 
     * @return
     */
    public Attack getDoNothing()
    {
        return doNothing;
    }
    
    /**
     *  returns the eatUp attack 
     * @return
     */
    public Attack getEatUp()
    {
        return eatUp;
    }
    
    /**
     *  returns the onePunch attack 
     * @return
     */
    public Attack getOnePunch()
    {
        return onePunch;
    }
    
    /**
     *  returns the Slash attack 
     * @return
     */
    public Attack getSlash()
    {
        return slash;
    }
    
    /**
     *  returns the tailPeacocking attack 
     * @return
     */
    public Attack getTailPeacocking()
    {
        return tailPeacocking;
    }
    
    /**
     *  returns the thickSkin attack 
     * @return
     */
    public Attack getThickSkin()
    {
        return thickSkin;
    }
    
    /**
     *  returns the charge attack 
     * @return
     */
    public Attack getCharge()
    {
        return charge;
    }
    
    /**
     *  returns the index of a specific Attack within Attacks
     * @param attack
     * @return
     */
    public int getAttackIndex(Attack attack)
    {
        int attackIndex = 0;
        for(int x = 0; x<getAllAttacks().size(); x++)
        {
            if(attack.getName().equals(getAllAttacks().get(x).getName()))
            {
                attackIndex = x;
                break;
            }
        }
        return attackIndex;
    }
    
}

