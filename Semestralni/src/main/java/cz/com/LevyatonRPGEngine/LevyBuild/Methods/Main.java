/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;

import cz.com.LevyatonRPGEngine.LevyBuild.Mechanics.Battle;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Species.Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Hands.Hand_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Heads.Head_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Legs.Leg_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Other.EmptySlot;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Tailes.Tail_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Torsos.Torso_Bear;

/**
 *
 * @author czech
 */



public class Main {
    
 
    
    
    public static void main(String[] args)
    {
        Hand_Bear hand = new Hand_Bear();
        Head_Bear head = new Head_Bear();
        Leg_Bear leg = new Leg_Bear();
        Torso_Bear torso = new Torso_Bear();
        Tail_Bear tail = new Tail_Bear();
        EmptySlot nothing = new EmptySlot();
        
        //head, hand, hand, torso, leg, nothing, tail
        Player player = new Player();
        player.setHead(head);
        player.setLeftHand(hand);
        player.setRightHand(nothing);
        player.setTorso(torso);
        player.setRightLeg(leg);
        player.setLeftLeg(leg);
        player.setTail(tail);
        player.setLevelAttack(head.getAttack(), 5);
        player.setLevelAttack(hand.getAttack(), 5);
        player.setLevelAttack(leg.getAttack(), 5);
        player.setLevelAttack(torso.getAttack(), 5);
        player.setLevelAttack(tail.getAttack(), 5);
        //System.out.println(player.getEquipment().getHead().getAttack().getLevel());
        //System.out.println(player.getAvailableAttacks()[0].getName());
        
        Bear bear = new Bear();
        Battle b = new Battle(bear, player);
        player = b.updatePlayer();
        
    }
}
