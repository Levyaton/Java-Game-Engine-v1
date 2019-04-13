/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Object;
import java.util.Scanner;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Species.BaseHuman;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;


/**
 *
 * @author czech
 */
public class Player extends Object {
    
    private Equipment equipped = new Equipment();
    private BaseHuman human = new BaseHuman();
    private int maxHealth = equipped.bonusMod("maxHealth",(human.getHP() + equipped.getHead().getStatModefier()));
    private int speed = equipped.bonusMod("speed",human.getSpeed() + equipped.getLeftLeg().getStatModefier() + equipped.getRightLeg().getStatModefier());
    private int str = equipped.bonusMod("str",human.getStr() + equipped.getLeftHand().getStatModefier() + equipped.getRightHand().getStatModefier());
    private Double luck = equipped.luckMod(human.getLuck() + equipped.getTail().getLuckModefier());
    private int def = equipped.bonusMod("def",human.getDef() + equipped.getTorso().getStatModefier());
    private int currentHealth = maxHealth;
    private int wealth = 0;
    
    final static String name = nameSetter();
    
    
    
   
   Inventory inv = new Inventory();
    
    
    public Player() 
    {
        super(name, "Player Controlled", "user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");
    }
    
    public Player(Bodypart head, Bodypart rightHand, Bodypart leftHand, Bodypart torso, Bodypart rightLeg, Bodypart leftLeg, Bodypart tail) //For testing
    {
        super(name,"Player Controlled","user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");
        equipped.setHead(head);
        equipped.setLeftHand(leftHand);
        equipped.setLeftLeg(leftLeg);
        equipped.setTorso(torso);
        equipped.setRightHand(leftHand);
        equipped.setRightLeg(leftLeg);
        equipped.setTail(tail);
        equipped.setlevlAttack(rightHand.getAttack(), 3);
        equipped.setlevlAttack(head.getAttack(), 5);
        equipped.setlevlAttack(torso.getAttack(), 3);
        equipped.setlevlAttack(tail.getAttack(), 3);
        
    }
    
    public static String nameSetter()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the protagonist's name?\n");
        String name = sc.nextLine();
        return name;
    }
    
    
   public void updatePlayerStats()
   {
       maxHealth = (human.getHP() + equipped.getHead().getStatModefier())*equipped.bonusMod("maxHealth", maxHealth);
       speed = (human.getSpeed() + equipped.getLeftLeg().getStatModefier() + equipped.getRightLeg().getStatModefier())*equipped.bonusMod("speed",speed);
       str = (human.getStr() + equipped.getLeftHand().getStatModefier() + equipped.getRightHand().getStatModefier())*equipped.bonusMod("str",str);
       luck = (human.getLuck() + equipped.getTail().getLuckModefier())*equipped.luckMod(luck);
       def = (human.getDef() + equipped.getTorso().getStatModefier())*equipped.bonusMod("def", def);
   }
   
   
   public int getCurrentHealth()
   {
       return currentHealth;
   }
   
   public void setCurrentHealth(int hpChange)
   {
       currentHealth = currentHealth + hpChange;
   }
   
   public int getMaxHealth()
   {
       return maxHealth;
   }
   
   public int getSpeed()
   {
       return speed;
   }
   
   public int getDef()
   {
       return def;
   }
   
   public int getStr()
   {
       return str;
   }
   
   public Double getLuck()
   {
       return luck;
   }
   
   
   
   public Attack[] getAvailableAttacks()
   {
       
       Attack[] allAvailableAttacks = equipped.getAvailableAttacks();
       Attack[] usableAvailavleAttacks = new Attack[allAvailableAttacks.length];
       int x = 0;
       for(Attack attack : allAvailableAttacks)
       {
           if(attack.getLevel()>0)
           {
               usableAvailavleAttacks[x] = attack;
           }
       }
       return usableAvailavleAttacks;
       
   }
   
   public Bodypart[] getEquipped()
   {
       return equipped.getEquipment();
   }
   
   public void levelAttack(Attack attack, int exp)
   {
        equipped.appendAttack(attack);
        equipped.levlAttack(attack, exp);
   }
   
   public void addItemToInv(Item item)
   {
       if(item.getName().equals("Gold Coin"))
       {
           wealth += item.getValue();
       }
       else
       {
           inv.addItem(item);
       }
   }
   
   
   
   
   
   
   
   
    
    
    
}