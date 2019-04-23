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

    protected static Equipment equipped = new Equipment();
    protected BaseHuman human;
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
        this.human = new BaseHuman();
        properties();
    }

   
    public static String nameSetter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter player name: ");
        String name = sc.nextLine();
        return name;
    }

    public void updatePlayerStats() {
        maxHealth = (human.getHP() + equipped.getHead().getStatModefier()) * equipped.bonusMod("maxHealth", maxHealth);
        speed = (human.getSpeed() + equipped.getLeftLeg().getStatModefier() + equipped.getRightLeg().getStatModefier()) * equipped.bonusMod("speed", speed);
        str = (human.getStr() + equipped.getLeftHand().getStatModefier() + equipped.getRightHand().getStatModefier()) * equipped.bonusMod("str", str);
        luck = (human.getLuck() + equipped.getTail().getLuckModefier()) * equipped.luckMod(luck);
        def = (human.getDef() + equipped.getTorso().getStatModefier()) * equipped.bonusMod("def", def);
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

    public Attack[] getAvailableAttacks() 
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
        equipped.appendAttack(attack);
        equipped.levelAttack(attack, exp);
    }
    
    public void setLevelAttack(Attack attack, int level) {
        equipped.setLevelAttack(attack, level);
    }

    public void addItemToInv(Item item) {
        if (item.getName().equals("Gold Coin")) {
            wealth += item.getValue();
        } else {
            inv.addItem(item);
        }
    }
    
   
     public void setHead(Bodypart giveHead)
    {
        equipped.setHead(giveHead);
    }
    
    public void setRightHand(Bodypart giveHand)
    {
       equipped.setRightHand(giveHand);
    }
    
    public void setLeftHand(Bodypart giveHand)
    {
        equipped.setLeftHand(giveHand);
    }
    
    public void setTorso(Bodypart giveTorso)
    {
        equipped.setTorso(giveTorso);
    }
    
    public void setRightLeg(Bodypart giveLeg)
    {
        equipped.setRightLeg(giveLeg);
    }
    
    public void setLeftLeg(Bodypart giveLeg)
    {
        equipped.getLeftLeg();
    }
    
    public void setTail(Bodypart giveTail)
    {
        equipped.setTail(giveTail);
    }
    
    private void properties() {
        
        this.maxHealth = equipped.bonusMod("maxHealth", (human.getHP() + equipped.getHead().getStatModefier()));
        this.speed = equipped.bonusMod("speed", human.getSpeed() + equipped.getLeftLeg().getStatModefier() + equipped.getRightLeg().getStatModefier());
        
        this.str = equipped.bonusMod("str", human.getStr() + equipped.getLeftHand().getStatModefier() + equipped.getRightHand().getStatModefier());
   
        this.luck = equipped.luckMod(human.getLuck() + equipped.getTail().getLuckModefier());
       
        this.def = equipped.bonusMod("def", human.getDef() + equipped.getTorso().getStatModefier());
   
       
        this.currentHealth = maxHealth;
       
        this.wealth = 0;
    }

}
