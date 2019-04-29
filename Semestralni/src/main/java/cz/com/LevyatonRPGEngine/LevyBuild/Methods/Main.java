/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;

import cz.com.LevyatonRPGEngine.LevyBuild.Mechanics.Battle;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Items;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Species.Species;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Bodyparts;
import java.io.IOException;
/**
 *
 * @author czech
 */



public class Main {
        
        static Player player = new Player();
        static Bodyparts bodyparts = new Bodyparts(player.getMaxHealth(),player.getDef());
        static Bodypart head = bodyparts.getHeadBear();
        static Bodypart hand = bodyparts.getHandBear();
        static Bodypart nothing = bodyparts.getEmptySlot();
        static Bodypart torso = bodyparts.getTorsoBear();
        static Bodypart leg = bodyparts.getLegBear();
        static Bodypart tail = bodyparts.getEmptyTail();
        static Items items = new Items();
    
    private static void setters()
    {
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
        player.addItemToInv(items.getApple());
        player.setWealth(666);
    }
    
    public static void main(String[] args) throws IOException
    {
        Species species = new Species();
        setters();
        bodyparts = new Bodyparts(player.getMaxHealth(),player.getDef());
        setters();
        /*Specie bear = species.getBasicBear();
        Battle b = new Battle(bear, player);
        player = b.updatePlayer();
        */
        Save s = new Save();
        s.saveGame(player);
        Load l = new Load();
        player = l.loadPlayer();
       
    }
}
