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
import cz.com.GameFiles.LevyBuild.customClasses.Species;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import cz.com.GameFiles.LevyBuild.customClasses.Attacks;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;

/**
 *
 * @author czech
 */
public class Equipment {
    
    private Species species = new Species();
    private Specie human = species.getBasicHuman();
    private Bodyparts bodyparts = new Bodyparts(0,0);
    private Bodypart nothing = bodyparts.getEmptySlot();
    private Bodypart nothingt = bodyparts.getEmptyTail();
    private Bodypart head = nothing;
    private Bodypart rightHand = nothing;
    private Bodypart leftHand = nothing;
    private Bodypart torso = nothing;
    private Bodypart rightLeg = nothing;
    private Bodypart leftLeg = nothing;
    private Bodypart tail = nothingt;

    
    private Bodypart[] equipment = {head,rightHand,leftHand,torso,rightLeg,leftLeg,tail};
    
    
    private Attacks attacks;
    
   
    
    private ArrayList<Attack> allAttacks;
    
    
    
    
    private Boolean playerFullSuitBonus = false;
    private Boolean playerHandBonus = false;
    private Boolean playerLegBonus = false;
    
    
   
    
    
    /*/
    [0] = HEAD
    [1] = RIGHT HAND
    [2] = LEFT HAND
    [3] = TORSO
    [4] = RIGHT LEG
    [5] = LEFT LEG
    [6] = TAIL
    /*/

    /**
     *
     */
    
    public Equipment()
    {
        attacks = new Attacks(human.getHP() + 100, human.getDef() + 500);
        this.allAttacks = attacks.getAllAttacks();
        this.setHead(nothing);
        this.setRightHand(nothing);
        this.setLeftHand(nothing);
        this.setTorso(nothing);
        this.setRightLeg(nothing);
        this.setLeftLeg(nothing);
        this.setTail(nothingt);
        setBonus();
        if(playerFullSuitBonus)
        {
            attacks = new Attacks((this.head.getGain()+human.getHP()*2),this.torso.getStatModefier()*2+human.getDef());
        }
        else
        {
            attacks = new Attacks((this.head.getGain() +human.getHP()),this.torso.getStatModefier() + human.getDef());
        }
        
        this.allAttacks = attacks.getAllAttacks();
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
    
    /**
     *
     */
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
    
    /**
     *
     * @param bodypart
     * @return
     */
    public Double bonusMod(String bodypart)
    {
        switch(bodypart)
        {
            case "str": 
                if(playerFullSuitBonus==true)
                {
                    return 4.0;
                }
                else if(playerHandBonus == true)
                {
                    return 5/2.0;
                }
               
                
            case "speed": 
                if(playerFullSuitBonus==true)
                {
                    return 4.0;
                }
                else if(playerLegBonus == true)
                {
                    return 5/2.0;
                }
                break;
                
            case "maxHealth": 
                if(playerFullSuitBonus==true)
                {
                    return 2.0;
                    
                }
               break;
          
            case "def": 
                if(playerFullSuitBonus==true)
                {
                    return 2.0;
                }
                break;
            case  "luck" :
                if(playerFullSuitBonus == true)
                {
                    return 2.0;
                }
        }
        return 1.0;
    
    }

    /**
     *
     */
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
    
    
    
    //Attacks

    /**
     *
     * @param attack
     * @param exp
     * @throws InterruptedException
     */
    
    public void levelAttack(Attack attack, int exp) throws InterruptedException
    {
        allAttacks.get(attacks.getAttackIndex(attack)).gainExp(exp);
    }
    
    /**
     *
     * @param attack
     * @param newLevel
     */
    public void setLevelAttack(Attack attack, int newLevel)
    {
       allAttacks.get(attacks.getAttackIndex(attack)).setLevel(newLevel);
       this.makeAttackAvailable(attack, true);
    }
    
    /**
     *
     * @param bodypart
     * @param trueOrFalse
     */
    public void makeAttackAvailable(Bodypart bodypart, boolean trueOrFalse)
    {
        Attack checkedAttack = bodypart.getAttack();
        Attack attack = allAttacks.get(attacks.getAttackIndex(checkedAttack));
        if(attack.getLevel()>0)
        {
            attack.setAvailability(trueOrFalse);
        }
    }
    
    /**
     *
     * @param giveAttack
     * @param trueOrFalse
     */
    public void makeAttackAvailable(Attack giveAttack, boolean trueOrFalse)
    {
        Attack checkedAttack = giveAttack;
        Attack attack = allAttacks.get(attacks.getAttackIndex(checkedAttack));
        if(attack.getLevel()>0)
        {
            attack.setAvailability(trueOrFalse);
        }
    }
    
   
    //Setters

    /**
     *
     * @param giveHead
     */
    
    public void setHead(Bodypart giveHead)
    {
        makeAttackAvailable(head,false);
        head = giveHead;
        setBonus();
        updateEquipment();
        makeAttackAvailable(head,true);
    }
    
    /**
     *
     * @param giveHand
     */
    public void setRightHand(Bodypart giveHand)
    {
        makeAttackAvailable(rightHand,false);
        rightHand = giveHand;
        setBonus();
        updateEquipment();
        makeAttackAvailable(rightHand,true);
    }
    
    /**
     *
     * @param giveHand
     */
    public void setLeftHand(Bodypart giveHand)
    {
        makeAttackAvailable(leftHand,true);
        leftHand = giveHand;
        setBonus();
        updateEquipment();
        makeAttackAvailable(leftHand,true);
        
    }
    
    /**
     *
     * @param giveTorso
     */
    public void setTorso(Bodypart giveTorso)
    {
        makeAttackAvailable(torso,false);
        torso = giveTorso;
        setBonus();
        updateEquipment();
        makeAttackAvailable(torso,true);
    }
    
    /**
     *
     * @param giveLeg
     */
    public void setRightLeg(Bodypart giveLeg)
    {
        makeAttackAvailable(rightLeg,false);
        rightLeg = giveLeg;
        setBonus();
        updateEquipment();
        makeAttackAvailable(rightLeg,true);
    }
    
    /**
     *
     * @param giveLeg
     */
    public void setLeftLeg(Bodypart giveLeg)
    {
        makeAttackAvailable(leftLeg,false);
        leftLeg = giveLeg;
        setBonus();
        updateEquipment();
        makeAttackAvailable(leftLeg,true);
    }
    
    /**
     *
     * @param giveTail
     */
    public void setTail(Bodypart giveTail)
    {
        makeAttackAvailable(tail,false);
        tail = giveTail;
        setBonus();
        updateEquipment();
        makeAttackAvailable(tail,true);
    }
    
    //Unequippers

    /**
     *
     */
    
    public void unequipHead()
    {
        makeAttackAvailable(head,false);
        head = nothing;
        setBonus();
        updateEquipment();
        makeAttackAvailable(head,true);
    }
    
    /**
     *
     */
    public void unequipTorso()
    {
        makeAttackAvailable(torso,false);
        torso = nothing;
        setBonus();
        updateEquipment();
        makeAttackAvailable(torso,true);
    }
    
    /**
     *
     */
    public void unequipRightHand()
    {
        makeAttackAvailable(rightHand,false);
        rightHand = nothing;
        setBonus();
        updateEquipment();
        makeAttackAvailable(rightHand,true);
    }
    
    /**
     *
     */
    public void unequipLeftHand()
    {
        makeAttackAvailable(leftHand,false);
        leftHand = nothing;
        setBonus();
        updateEquipment();
        makeAttackAvailable(leftHand,true);
    }
    
    /**
     *
     */
    public void unequipRightLeg()
    {
        makeAttackAvailable(rightLeg,false);
        rightLeg = nothing;
        setBonus();
        updateEquipment();
        makeAttackAvailable(rightLeg,true);
    }
    
    /**
     *
     */
    public void unequipLeftLeg()
    {
        makeAttackAvailable(leftLeg,false);
        leftLeg = nothing;
        setBonus();
        updateEquipment();
        makeAttackAvailable(leftLeg,true);
    }
    
    /**
     *
     */
    public void unequipTail()
    {
        makeAttackAvailable(tail,false);
        tail = nothingt;
        setBonus();
        updateEquipment();
        makeAttackAvailable(tail,true);
    }
    

//Getters

    /**
     *
     * @return
     */
    
    public Bodypart getHead()
    {
        return head;
    }
    
    /**
     *
     * @return
     */
    public Bodypart getRightHand()
    {
        return rightHand;
    }  
        
    /**
     *
     * @return
     */
    public Bodypart getLeftHand()
    {
        return leftHand;
    }
    
    /**
     *
     * @return
     */
    public Bodypart getTorso()
    {
        return torso;
    }
    
    /**
     *
     * @return
     */
    public Bodypart getRightLeg()
    {
        return rightLeg;
    }
    
    /**
     *
     * @return
     */
    public Bodypart getLeftLeg()
    {
        return leftLeg;
    }
    
    /**
     *
     * @return
     */
    public Bodypart getTail()
    {
        return tail;
    }
         
    /**
     *
     * @return
     */
    public ArrayList<Attack> getAvailableAttacks()
    {
        ArrayList<Attack> availableAttacks = new ArrayList<Attack>();
        
        for (Attack attack : allAttacks) 
        {
            System.out.println("\n"+attack.getName());
            System.out.println("\n"+attack.getAvailability());
            if(attack.getAvailability() == true)
            {
                if(!availableAttacks.contains(attack))
                {
                    availableAttacks.add(attack);
                }
            }
        }
        
        return availableAttacks;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Attack> getAllAttacks()
    {
        return allAttacks;
    }
    
    /**
     *
     * @return
     */
    public Bodypart[] getEquipment()
    {
        return equipment;
    }
    
   
}

