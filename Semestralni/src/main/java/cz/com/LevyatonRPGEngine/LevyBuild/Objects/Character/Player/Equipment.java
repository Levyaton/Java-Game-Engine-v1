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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Species.BaseHuman;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Other.EmptySlot;

public class Equipment {
    
    private EmptySlot nothing = new EmptySlot(); 
    private Bodypart head;
    private Bodypart rightHand;
    private Bodypart leftHand;
    private Bodypart torso;
    private Bodypart rightLeg;
    private Bodypart leftLeg;
    private Bodypart tail;
    private Bodypart[] equipment = {head,rightHand,leftHand,torso,rightLeg,leftLeg,tail};
    private ArrayList<Attack> attacks = new ArrayList<Attack>();
    private Attack[] availableAttacks = {nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack(),nothing.getAttack()};
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
        
        head = nothing;
        rightHand = nothing;
        leftHand = nothing;
        torso = nothing;
        rightLeg = nothing;
        leftLeg = nothing;
        tail = nothing;
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
    
    public void levlAttack(Attack attack, int exp)
    {
        int slot = getAttackSlot(attack);
        attacks.get(slot).gainExp(exp);
    }
    
    public void setlevlAttack(Attack attack, int newLevel)
    {
        int slot = getAttackSlot(attack);
        attacks.get(slot).setLevel(newLevel);
    }
    
    
    public void appendAttack(Attack giveAttack)
    {
        if(attacks.contains(giveAttack) == false)
        {
            attacks.add(giveAttack); 
        }
    }
    
    public void appendAttack(Bodypart limb, int slotNum)
    {
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
        if(attackEquipped = false)
        {
            availableAttacks[slotNum] = limb.getAttack();
        }
    }
    
    //Setters
    
    public void setHead(Bodypart giveHead)
    {
        head = giveHead;
        appendAttack(head,0);
        setBonus();
    }
    
    public void setRightHand(Bodypart giveHand)
    {
        rightHand = giveHand;
        appendAttack(rightHand,1);
        setBonus();
    }
    
    public void setLeftHand(Bodypart giveHand)
    {
        leftHand = giveHand;
        appendAttack(leftHand,2);
        setBonus();
    }
    
    public void setTorso(Bodypart giveTorso)
    {
        torso = giveTorso;
        appendAttack(torso,3);
        setBonus();
    }
    
    public void setRightLeg(Bodypart giveLeg)
    {
        rightLeg = giveLeg;
        appendAttack(rightLeg,4);
        setBonus();
    }
    
    public void setLeftLeg(Bodypart giveLeg)
    {
        leftLeg = giveLeg;
        appendAttack(leftLeg,5);
        setBonus();
    }
    
    public void setTail(Bodypart giveTail)
    {
        tail = giveTail;
        appendAttack(tail,6);
        setBonus();
    }
    
    //Unequippers
    
    public void unequipHead()
    {
        head = nothing;
        appendAttack(head,0);
        setBonus();
    }
    
    public void unequipTorso()
    {
        torso = nothing;
        appendAttack(torso,3);
        setBonus();
    }
    
    public void unequipRightHand()
    {
        rightHand = nothing;
        appendAttack(rightHand,1);
        setBonus();
    }
    
    public void unequipLeftHand()
    {
        leftHand = nothing;
        appendAttack(leftHand,2);
        setBonus();
    }
    
    public void unequipRightLeg()
    {
        rightLeg = nothing;
        appendAttack(rightLeg,4);
        setBonus();
    }
    
    public void unequipLeftLeg()
    {
        leftLeg = nothing;
        appendAttack(leftLeg,5);
        setBonus();
    }
    
    public void unequipTail()
    {
        tail = nothing;
        appendAttack(tail,6);
        setBonus();
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
        return availableAttacks;
    }
    
    public Bodypart[] getEquipment()
    {
        return equipment;
    }
}

