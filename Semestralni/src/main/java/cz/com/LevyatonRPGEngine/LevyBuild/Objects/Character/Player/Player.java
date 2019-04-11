/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Object;
import java.util.Scanner;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Species.BaseHuman;


/**
 *
 * @author czech
 */
public class Player extends Object {
    
    Equipment equipped = new Equipment();
    BaseHuman human = new BaseHuman();
    int health = human.getHP() + equipped.getHead().getStatModefier();
    int speed = human.getSpeed() + equipped.getLeftLeg().getStatModefier() + equipped.getRightLeg().getStatModefier();
    int str = human.getStr() + equipped.getLeftHand().getStatModefier() + equipped.getRightHand().getStatModefier();
    Double luck = human.getLuck() + equipped.getTail().getLuckModefier();
    int def = human.getDef() + equipped.getTorso().getStatModefier();
    
    
    
    final static String name = nameSetter();
    
    
    
   
   Inventory inv = new Inventory();
    
    
    public Player() {
        super("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png", "Player Controlled", name);
    }
    
    public static String nameSetter()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the protagonist's name?\n");
        String name = sc.nextLine();
        return name;
    }
   
   public int getHealth()
   {
       return health;
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
   
   
}