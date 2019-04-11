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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Other.EmptySlot;

public class Equipment {
    
    private Bodypart head;
    private Bodypart rightHand;
    private Bodypart leftHand;
    private Bodypart torso;
    private Bodypart rightLeg;
    private Bodypart leftLeg;
    private Bodypart tail;
    private Bodypart[] equipment = {head,torso,rightHand,leftHand,rightLeg,leftLeg,tail};
    private Attack[] attacks = {};
    
    public Equipment()
    {
        EmptySlot nothing = new EmptySlot(); 
        head = nothing;
        rightHand = nothing;
        leftHand = nothing;
        torso = nothing;
        rightLeg = nothing;
        leftLeg = nothing;
        tail = nothing;
    }
    
    
    //Attacks
    
    private void appendAttack(Bodypart limb)
    {
        for (Attack attack : attacks) 
        {
            if(limb.)
        }
    }
    
    //Setters
    
    public void setHead(Bodypart giveHead)
    {
        head = giveHead;
    }
    
    public void setRightHand(Bodypart giveHand)
    {
        rightHand = giveHand;
    }
    
    public void setLeftHand(Bodypart giveHand)
    {
        leftHand = giveHand;
    }
    
    public void setTorso(Bodypart giveTorso)
    {
        torso = giveTorso;
    }
    
    public void setRightLeg(Bodypart giveLeg)
    {
        rightLeg = giveLeg;
    }
    
    public void setLeftLeg(Bodypart giveLeg)
    {
        leftLeg = giveLeg;
    }
    
    public void setTail(Bodypart giveTail)
    {
        tail = giveTail;
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
         
}

