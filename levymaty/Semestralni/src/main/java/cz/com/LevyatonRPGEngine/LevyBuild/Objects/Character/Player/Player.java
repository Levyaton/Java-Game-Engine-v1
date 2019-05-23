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

    /**
     *
     */
    private static Equipment equipped = new Equipment();

    /**
     *
     */
    private static Species species = new Species();

    /**
     *
     */
    private Specie human = species.getBasicHuman();

    /**
     *
     */
    private int maxHealth;

    /**
     *
     */
    private int speed;

    /**
     *
     */
    private int str;

    /**
     *
     */
    private Double luck;

    /**
     *
     */
    private int def;

    /**
     *
     */
    private int currentHealth;

    /**
     *
     */
    private int wealth;

    Inventory inv = new Inventory();

    /**
     *  Set's up the Player class
     */
    public Player() {
       super(Player.nameSetter(), "Player Controlled", System.getProperty("user.dir") + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");
      properties();
       
    }
    
    /**
     *Set's up the Player class with a 
     * @param givenName
     */
    public Player(String givenName) {
        super(givenName, "Player Controlled", System.getProperty("user.dir") + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");
        properties();
    }

    /**
     *
     * @return
     */
    public static String nameSetter() {
        Scanner sc = new Scanner(System.in);
        
        String name = sc.nextLine();
        return name;
    }

    /**
     *
     */
    public void updatePlayerStats() {
        maxHealth = (int) Math.round((human.getHP() + equipped.getHead().getStatModefier()) * equipped.bonusMod("maxHealth") + 0.5);
        speed = (int) Math.round((human.getSpeed() + equipped.getLeftLeg().getStatModefier() + equipped.getRightLeg().getStatModefier()) * equipped.bonusMod("speed")+0.5);
        str = (int) Math.round((human.getStr() + equipped.getLeftHand().getStatModefier() + equipped.getRightHand().getStatModefier()) * equipped.bonusMod("str")+0.5);
        luck = ((human.getLuck() + equipped.getTail().getLuckModefier()) * equipped.bonusMod("luck") + 0.5);
        def = (int) Math.round((human.getDef() + equipped.getTorso().getStatModefier()) * equipped.bonusMod("def") + 0.5);
        
    }
    
    /**
     *
     * @return
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     *
     * @param hpChange
     */
    public void incrementCurrentHealth(int hpChange) {
        currentHealth = currentHealth + hpChange;
    }
    
    /**
     *
     * @param hpChange
     */
    public void setCurrentHealth(int hpChange) {
        currentHealth = hpChange;
    }

    /**
     *
     * @return
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     *
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     *
     * @return
     */
    public int getDef() {
        return def;
    }

    /**
     *
     * @return
     */
    public int getStr() {
        return str;
    }

    /**
     *
     * @return
     */
    public Double getLuck() {
        return luck;
    }

    /**
     *
     * @return
     */
    public ArrayList<Attack> getAvailableAttacks() 
    {
        return equipped.getAvailableAttacks();

    }
    
    /**
     *
     * @return
     */
    public Equipment getEquipment()
    {
        return equipped;
    }

    /**
     *
     * @return
     */
    public Bodypart[] getEquipped() {
        return equipped.getEquipment();
    }

    /**
     *
     * @param attack
     * @param exp
     * @throws InterruptedException
     */
    public void levelAttack(Attack attack, int exp) throws InterruptedException {
        equipped.levelAttack(attack, exp);
    }
    
    /**
     *
     * @param attack
     * @param level
     */
    public void setLevelAttack(Attack attack, int level) {
        equipped.setLevelAttack(attack, level);
    }

    /**
     *
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
     *
     * @param number
     */
    public void setWealth(int number)
   {
       this.wealth = number;
   }
   
    /**
     *
     * @return
     */
    public int getWealth()
   {
       return wealth;
   }

    /**
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     * @param giveLeg
     */
    public void setLeftLeg(Bodypart giveLeg)
    {
        equipped.getLeftLeg();
        updatePlayerStats();
        if(!inv.costumes.contains(giveLeg))
        {
            inv.costumes.add(giveLeg);
        }
    }
    
    /**
     *
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
     *
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
     *
     * @return
     */
    public Inventory getInv()
    {
        return inv;
    }
    
    /**
     *
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
