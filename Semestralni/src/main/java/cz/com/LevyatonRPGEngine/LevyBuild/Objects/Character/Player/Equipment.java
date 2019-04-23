/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player;

/**
 *
 * @author czech
 */
import java.util.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Species.BaseHuman;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Other.*;

public class Equipment {
    
    private EmptySlot nothing = new EmptySlot();
    private EmptyTail nothingt = new EmptyTail();
    private Bodypart head = nothing;
    private Bodypart rightHand = nothing;
    private Bodypart leftHand = nothing;
    private Bodypart torso = nothing;
    private Bodypart rightLeg = nothing;
    private Bodypart leftLeg = nothing;
    private Bodypart tail = nothingt;
    private Bodypart[] equipment = {head,rightHand,leftHand,torso,rightLeg,leftLeg,tail};
    private ArrayList<Attack> attacks = new ArrayList<Attack>();
    private Attack[] availableAttacks = {nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothingt.getAttack()};//{nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothingt.getAttack()};
    private Boolean playerFullSuitBonus = false;
    private Boolean playerHandBonus = false;
    private Boolean playerLegBonus = false;
    private BaseHuman human = new BaseHuman();
    
    
    
    /*/
    [0] = HEAD
    [1] = RIGHT HAND
    [2] = LEFT HAND
    [3] = TORSO
    [4] = RIGHT LEG
    [5] = LEFT LEG
    [6] = TAIL
    /*/    
    public Equipment()
    {
    
        this.setHead(nothing);

        this.setRightHand(nothing);
        this.setLeftHand(nothing);
        this.setTorso(nothing);
        this.setRightLeg(nothing);
        this.setLeftLeg(nothing);
        this.setTail(nothingt);
       //System.out.println(tail.getAttack().getName());
       //System.out.println(head.getAttack().getName());
       
        
    }
    
    public void setBonus()
    {
        if(rightHand.getCategory().equals(leftHand.getCategory()))
        {
            playerHandBonus = true;
        }
        if(rightLeg.getCategory().equals(leftLeg.getCategory()))
        {
            playerLegBonus = true;
        }
        if(playerLegBonus == true && playerHandBonus == true && head.getCategory().equals(tail.getCategory()) && head.getCategory().equals(rightHand.getCategory()) && rightHand.getCategory().equals(rightLeg.getCategory()))
        {
            playerFullSuitBonus = true;
        }
    }
    
    public int bonusMod(String bodypart, int stat)
    {
        switch(bodypart)
        {
            case "str": 
                if(playerFullSuitBonus==true)
                {
                    return stat*4;
                }
                else if(playerHandBonus == true)
                {
                    return (stat*2 + stat/2);
                }
                break;
                
            case "speed": 
                if(playerFullSuitBonus==true)
                {
                    return stat*4;
                }
                else if(playerLegBonus == true)
                {
                    return (stat*2 + stat/2);
                }
                break;
                
            case "maxHealth": 
                if(playerFullSuitBonus==true)
                {
                    return stat*2;
                }
                break;
            case "def": 
                if(playerFullSuitBonus==true)
                {
                    return stat*22;
                }
                break;
        }
    
            return stat;
    }
    public void updateEquipment()
    {
        this.equipment[0] = this.head;
        this.equipment[1] = this.rightHand;
        this.equipment[2] = this.leftHand;
        this.equipment[3] = this.torso;
        this.equipment[4] = this.rightLeg;
        this.equipment[5] = this.leftLeg;
        this.equipment[6] = this.tail;
        
    }
    
    public Double luckMod(Double luck)
    {
       if(playerFullSuitBonus==true)
        {
            return luck*2;
        }
       return luck;
    }
    //Attacks
   
    
    public int getAttackSlot(Attack attack)
    {
        int y = 666;
        for (int x = 0; x<attacks.size();x++)
        {
            if(attack.getName().equals(attack.getName()))
            {
                y = x;
                return y;
            }
        }
        return y;//If the index is out of bounds, the attack wasnt found
    }
    
    public void levelAttack(Attack attack, int exp)
    {
        if(attacks.contains(attack))
        {
            this.appendAttack(attack);
            attacks.get(attacks.indexOf(attack)).gainExp(exp);
            this.appendAttack(attack);
        }
        else
        {
            this.appendAttack(attack);
            attacks.get(attacks.indexOf(attack)).gainExp(exp);
            this.appendAttack(attack);
        }    
    }
    
    public void setLevelAttack(Attack attack, int newLevel)
    {
        if(attacks.contains(attack))
        {
            this.appendAttack(attack);
            attacks.get(attacks.indexOf(attack)).setLevel(newLevel);
            this.appendAttack(attack);
        }
        else
        {
            this.appendAttack(attack);
            attacks.get(attacks.indexOf(attack)).setLevel(newLevel);
            this.appendAttack(attack);
        }
    }
    
    
    public void appendAttack(Attack giveAttack)
    {
        int position = 0;
        if(attacks.contains(giveAttack) == false)
        {
            attacks.add(giveAttack); 
        }
        for(Bodypart limb : equipment)
        {
            /*
            System.out.println(limb.getAttack().getName());
            System.out.println(giveAttack.getName());
            System.out.println(limb);
            */
            if(limb.getAttack().getName().equals(giveAttack.getName()))
            {
                this.availableAttacks[position] = giveAttack;
                break;
            }
            position++;
        }
    }
    
    public void appendAttack(Bodypart limb, int slotNum)
    {
       if(limb.getAttack().equals(nothing))
       {
           availableAttacks[slotNum] = limb.getAttack();
       }
       else{
            boolean attackEquipped = false;
            if(attacks.contains(limb.getAttack()) == false)
            {
                attacks.add(limb.getAttack());  
            }

            for(Attack attack : availableAttacks)
            {
                if(limb.getAttack().getName().equals(attack.getName()))
                {
                    attackEquipped = true;
                    break;
                }
            }
            if(attackEquipped == false)
            {
                availableAttacks[slotNum] = limb.getAttack();
            }
       }
    }
    
    //Setters
    
    public void setHead(Bodypart giveHead)
    {
        head = giveHead;
        appendAttack(head,0);
        setBonus();
        updateEquipment();
    }
    
    public void setRightHand(Bodypart giveHand)
    {
        rightHand = giveHand;
        appendAttack(rightHand,1);
        setBonus();
        updateEquipment();
    }
    
    public void setLeftHand(Bodypart giveHand)
    {
        leftHand = giveHand;
        appendAttack(leftHand,2);
        setBonus();
        updateEquipment();
    }
    
    public void setTorso(Bodypart giveTorso)
    {
        torso = giveTorso;
        appendAttack(torso,3);
        setBonus();
        updateEquipment();
    }
    
    public void setRightLeg(Bodypart giveLeg)
    {
        rightLeg = giveLeg;
        appendAttack(rightLeg,4);
        setBonus();
        updateEquipment();
    }
    
    public void setLeftLeg(Bodypart giveLeg)
    {
        leftLeg = giveLeg;
        appendAttack(leftLeg,5);
        setBonus();
        updateEquipment();
    }
    
    public void setTail(Bodypart giveTail)
    {
        tail = giveTail;
        appendAttack(tail,6);
        setBonus();
        updateEquipment();
    }
    
    //Unequippers
    
    public void unequipHead()
    {
        head = nothing;
        appendAttack(head,0);
        setBonus();
        updateEquipment();
    }
    
    public void unequipTorso()
    {
        torso = nothing;
        appendAttack(torso,3);
        setBonus();
        updateEquipment();
    }
    
    public void unequipRightHand()
    {
        rightHand = nothing;
        appendAttack(rightHand,1);
        setBonus();
        updateEquipment();
    }
    
    public void unequipLeftHand()
    {
        leftHand = nothing;
        appendAttack(leftHand,2);
        setBonus();
        updateEquipment();
    }
    
    public void unequipRightLeg()
    {
        rightLeg = nothing;
        appendAttack(rightLeg,4);
        setBonus();
        updateEquipment();
    }
    
    public void unequipLeftLeg()
    {
        leftLeg = nothing;
        appendAttack(leftLeg,5);
        setBonus();
        updateEquipment();
    }
    
    public void unequipTail()
    {
        tail = nothingt;
        appendAttack(tail,6);
        setBonus();
        updateEquipment();
    }
    

//Getters
    
    public Bodypart getHead()
    {
        return head;
    }
    
    public Bodypart getRightHand()
    {
        return rightHand;
    }  
        
    public Bodypart getLeftHand()
    {
        return leftHand;
    }
    
    public Bodypart getTorso()
    {
        return torso;
    }
    
    public Bodypart getRightLeg()
    {
        return rightLeg;
    }
    
    public Bodypart getLeftLeg()
    {
        return leftLeg;
    }
    
    public Bodypart getTail()
    {
        return tail;
    }
         
    public Attack[] getAvailableAttacks()
    {
        /*
        for(Attack attack: availableAttacks)
        {
            System.out.println("first");
            System.out.println(attack.getName());
             System.out.println("second");
        }
        */
        return availableAttacks;
    }
    
    public Bodypart[] getEquipment()
    {
        return equipment;
    }
}

