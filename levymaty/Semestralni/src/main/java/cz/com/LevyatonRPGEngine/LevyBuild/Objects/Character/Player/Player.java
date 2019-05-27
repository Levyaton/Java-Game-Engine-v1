/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.basicGameObject;
import java.util.Scanner;
import cz.com.GameFiles.LevyBuild.customClasses.Species;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import java.util.ArrayList;

/**
 *  A class storing information about the player
 * @author czech
 */
public class Player extends basicGameObject {

   
    private static Equipment equipped = new Equipment();

  
    private static Species species = new Species();

    private Specie human = species.getBasicHuman();

   
    private int maxHealth;

    private int speed;

   
    private int str;

  
    private Double luck;

    private int def;

    private int currentHealth;

    private int wealth;

    Inventory inv = new Inventory();

    /**
     *  Set's up the Player class
     */
    /**
     *Set's up the Player class with a given Name
     * @param givenName
     */
    public Player(String givenName) {
        super(givenName, "Player Controlled", System.getProperty("user.dir") + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");
        properties();
    }

   

    /**
     *  updates the player stats to reflect the current equipment
     */
    public void updatePlayerStats() {
        maxHealth = (int) Math.round((human.getHP() + equipped.getHead().getStatModefier()) * equipped.bonusMod("maxHealth") + 0.5);
        speed = (int) Math.round((human.getSpeed() + equipped.getLeftLeg().getStatModefier() + equipped.getRightLeg().getStatModefier()) * equipped.bonusMod("speed")+0.5);
        str = (int) Math.round((human.getStr() + equipped.getLeftHand().getStatModefier() + equipped.getRightHand().getStatModefier()) * equipped.bonusMod("str")+0.5);
        luck = ((human.getLuck() + equipped.getTail().getLuckModefier()) * equipped.bonusMod("luck") + 0.5);
        def = (int) Math.round((human.getDef() + equipped.getTorso().getStatModefier()) * equipped.bonusMod("def") + 0.5);
        
    }
    
    /**
     *  returns the player current health
     * @return
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     *  increments the players current health by a given amount
     * @param hpChange
     */
    public void incrementCurrentHealth(int hpChange) {
        currentHealth = currentHealth + hpChange;
    }
    
    /**
     *  sets the players current health to a given number
     * @param hpChange
     */
    public void setCurrentHealth(int hpChange) {
        currentHealth = hpChange;
    }

    /**
     *  returns the Max health value the player can have
     * @return
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     *  returns the players speed stat
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     *  returns the players defense stat
     * @return
     */
    public int getDef() {
        return def;
    }

    /**
     *  returns the players strength stat
     * @return
     */
    public int getStr() {
        return str;
    }

    /**
     *  returns the players luck stat
     * @return
     */
    public Double getLuck() {
        return luck;
    }

    /**
     *  returns an ArrayList containing all of the players currently available attacks
     * @return
     */
    public ArrayList<Attack> getAvailableAttacks() 
    {
        return equipped.getAvailableAttacks();

    }
    
    /**
     *  returns the players equipment
     * @return
     */
    public Equipment getEquipment()
    {
        return equipped;
    }

    /**
     *  returns an Array containing the currently equipped items
     * @return
     */
    public Bodypart[] getEquipped() {
        return equipped.getEquipment();
    }

    /**
     *  increments the given Attack by an experience amount equal to the given number
     * @param attack
     * @param exp
     * @throws InterruptedException
     */
    public void levelAttack(Attack attack, int exp) throws InterruptedException {
        equipped.levelAttack(attack, exp);
    }
    
    /**
     *  sets the given attack to the given level
     * @param attack
     * @param level
     */
    public void setLevelAttack(Attack attack, int level) {
        equipped.setLevelAttack(attack, level);
    }

    /**
     *  adds the given Item to the players inventory
     * @param item
     */
    public void addItemToInv(Item item) {
        if (item.getName().equals("Gold Coin")) {
            wealth += item.getValue();
        } 
        else 
        {
            inv.addItem(item);
        }
    }
    
    /**
     *  sets the players wealth to the given amount
     * @param number
     */
    public void setWealth(int number)
   {
       this.wealth = number;
   }
   
    /**
     *  returns the players current wealth
     * @return
     */
    public int getWealth()
   {
       return wealth;
   }

    /**
     *`sets the given Bodypart to the head slot
     * @param giveHead
     */
    public void setHead(Bodypart giveHead)
    {
        Double percentageOfHealth = (currentHealth*100)/(maxHealth*1.0);
        equipped.setHead(giveHead);
        updatePlayerStats();
        currentHealth = (int) Math.round(maxHealth*percentageOfHealth +0.5);
        if(currentHealth>maxHealth)
        {
            currentHealth = maxHealth;
        }
        if(!inv.costumes.contains(giveHead))
        {
            inv.costumes.add(giveHead);
        }
    }   
    
    /**
     * sets the given Bodypart to the right hand slot
     * @param giveHand
     */
    public void setRightHand(Bodypart giveHand)
    {
       equipped.setRightHand(giveHand);
       updatePlayerStats();
       if(!inv.costumes.contains(giveHand))
        {
            inv.costumes.add(giveHand);
        }
    }
    
    /**
     *  sets the given Bodypart to the left hand slot
     * @param giveHand
     */
    public void setLeftHand(Bodypart giveHand)
    {
        equipped.setLeftHand(giveHand);
        updatePlayerStats();
        if(!inv.costumes.contains(giveHand))
        {
            inv.costumes.add(giveHand);
        }
    }
    
    /**
     *  sets the given Bodypart to the torso slot
     * @param giveTorso
     */
    public void setTorso(Bodypart giveTorso)
    {
        equipped.setTorso(giveTorso);
        updatePlayerStats();
        if(!inv.costumes.contains(giveTorso))
        {
            inv.costumes.add(giveTorso);
        }
    }
    
    /** 
     *  sets the given Bodypart to the right leg slot
     * @param giveLeg
     */
    public void setRightLeg(Bodypart giveLeg)
    {
        equipped.setRightLeg(giveLeg);
        updatePlayerStats();
        if(!inv.costumes.contains(giveLeg))
        {
            inv.costumes.add(giveLeg);
        }
    }
    
    /**
     *  sets the given Bodypart to the left leg slot
     * @param giveLeg
     */
    public void setLeftLeg(Bodypart giveLeg)
    {
        equipped.setLeftLeg(giveLeg);
        updatePlayerStats();
        if(!inv.costumes.contains(giveLeg))
        {
            inv.costumes.add(giveLeg);
        }
    }
    
    /**
     *  sets the given Bodypart to the tail slot
     * @param giveTail
     */
    public void setTail(Bodypart giveTail)
    {
        equipped.setTail(giveTail);
        updatePlayerStats();
        if(!inv.costumes.contains(giveTail))
        {
            inv.costumes.add(giveTail);
        }
    }
    
    /**
     *  returns an ArrayList containing every attack the player has
     * @return
     */
    public ArrayList<Attack> getAllAttacks()
    {
       return equipped.getAllAttacks();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Item> getInventory()
    {
        return inv.getInventory();
    }
    
    /**
     *  returns the players inventory
     * @return
     */
    public Inventory getInv()
    {
        return inv;
    }
    
    /**
     *  returns an ArrayList containing the costumes the player has
     * @return
     */
    public ArrayList<Bodypart> getCostumes()
    {
        return inv.getCostumes();
    }
    
    private void properties() {
        
        this.maxHealth = human.getHP();
        //System.out.println(maxHealth);
        //System.out.println(human.getHP());
        ///System.out.println(equipped.getHead().getName());
        //System.out.println(equipped.getHead().getStatModefier());
        this.speed = human.getSpeed()*2;
        
        this.str = human.getStr()*2;
   
        this.luck = human.getLuck();
       
        this.def = human.getDef();
   
       
        this.currentHealth = maxHealth;
       
        this.wealth = 0;

    }

}
