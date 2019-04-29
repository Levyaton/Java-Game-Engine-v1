/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Object;
import java.util.Scanner;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Species.Species;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import java.util.ArrayList;

/**
 *
 * @author czech
 */
public class Player extends Object {

    protected static Equipment equipped = new Equipment();
    protected static Species species = new Species();
    protected Specie human = species.getBasicHuman();
    protected int maxHealth;
    protected int speed;
    protected int str;
    protected Double luck;
    protected int def;
    protected int currentHealth;
    protected int wealth;
    final protected static String name = nameSetter();

    Inventory inv = new Inventory();

    public Player() {
        super(name, "Player Controlled", "user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");
        properties();
       
    }
    
    public Player(String givenName) {
        super(givenName, "Player Controlled", "user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");
        properties();
    }

   
    public static String nameSetter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter player name: ");
        String name = sc.nextLine();
        return name;
    }

    public void updatePlayerStats() {
        maxHealth = (int) Math.round((human.getHP() + equipped.getHead().getStatModefier()) * equipped.bonusMod("maxHealth") + 0.5);
        speed = (int) Math.round((human.getSpeed() + equipped.getLeftLeg().getStatModefier() + equipped.getRightLeg().getStatModefier()) * equipped.bonusMod("speed")+0.5);
        str = (int) Math.round((human.getStr() + equipped.getLeftHand().getStatModefier() + equipped.getRightHand().getStatModefier()) * equipped.bonusMod("str")+0.5);
        luck = ((human.getLuck() + equipped.getTail().getLuckModefier()) * equipped.bonusMod("luck") + 0.5);
        def = (int) Math.round((human.getDef() + equipped.getTorso().getStatModefier()) * equipped.bonusMod("def") + 0.5);
        
    }
    

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int hpChange) {
        currentHealth = currentHealth + hpChange;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDef() {
        return def;
    }

    public int getStr() {
        return str;
    }

    public Double getLuck() {
        return luck;
    }

    public ArrayList<Attack> getAvailableAttacks() 
    {

        return equipped.getAvailableAttacks();

    }
    
    public Equipment getEquipment()
    {
        return equipped;
    }

    public Bodypart[] getEquipped() {
        return equipped.getEquipment();
    }

    public void levelAttack(Attack attack, int exp) {
        equipped.levelAttack(attack, exp);
    }
    
    public void setLevelAttack(Attack attack, int level) {
        equipped.setLevelAttack(attack, level);
    }

    public void addItemToInv(Item item) {
        if (item.getName().equals("Gold Coin")) {
            wealth += item.getValue();
        } else {
            
            inv.incrementItem(item);
        }
    }
    
   public void setWealth(int number)
   {
       this.wealth = number;
   }
   
   public int getWealth()
   {
       return wealth;
   }
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
    
    public void setRightHand(Bodypart giveHand)
    {
       equipped.setRightHand(giveHand);
       updatePlayerStats();
       if(!inv.costumes.contains(giveHand))
        {
            inv.costumes.add(giveHand);
        }
    }
    
    public void setLeftHand(Bodypart giveHand)
    {
        equipped.setLeftHand(giveHand);
        updatePlayerStats();
        if(!inv.costumes.contains(giveHand))
        {
            inv.costumes.add(giveHand);
        }
    }
    
    public void setTorso(Bodypart giveTorso)
    {
        equipped.setTorso(giveTorso);
        updatePlayerStats();
        if(!inv.costumes.contains(giveTorso))
        {
            inv.costumes.add(giveTorso);
        }
    }
    
    public void setRightLeg(Bodypart giveLeg)
    {
        equipped.setRightLeg(giveLeg);
        updatePlayerStats();
        if(!inv.costumes.contains(giveLeg))
        {
            inv.costumes.add(giveLeg);
        }
    }
    
    public void setLeftLeg(Bodypart giveLeg)
    {
        equipped.getLeftLeg();
        updatePlayerStats();
        if(!inv.costumes.contains(giveLeg))
        {
            inv.costumes.add(giveLeg);
        }
    }
    
    public void setTail(Bodypart giveTail)
    {
        equipped.setTail(giveTail);
        updatePlayerStats();
        if(!inv.costumes.contains(giveTail))
        {
            inv.costumes.add(giveTail);
        }
    }
    
    public ArrayList<Attack> getAllAttacks()
    {
       return equipped.getAllAttacks();
    }
    
    public ArrayList<Item> getInventory()
    {
        return inv.getInventory();
    }
    
    public Inventory getInv()
    {
        return inv;
    }
    
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
