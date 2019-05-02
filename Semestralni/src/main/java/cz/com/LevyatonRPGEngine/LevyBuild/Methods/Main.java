/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;

import cz.com.LevyatonRPGEngine.LevyBuild.Mechanics.Battle;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.GameFiles.LevyBuild.customClasses.Items;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.GameFiles.LevyBuild.customClasses.Species;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author czech
 */



public class Main {
        
        
    
    private static Player setters(Player player)
    {
        Items items = new Items();
        Bodyparts bodyparts = new Bodyparts(player.getMaxHealth(),player.getDef());
        Bodypart head = bodyparts.getHeadBear();
        Bodypart hand = bodyparts.getHandBear();
        Bodypart nothing = bodyparts.getEmptySlot();
        Bodypart torso = bodyparts.getTorsoBear();
        Bodypart leg = bodyparts.getLegBear();
        Bodypart tail = bodyparts.getEmptyTail();
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
        return player;
    }
    
    public static boolean playAgain() {
        boolean validInput = false;
        boolean playAgain = false;
        
        while(validInput == false)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Yes/No");
            String yesOrNo = sc.nextLine();
            if(yesOrNo.toLowerCase().equals("yes"))
            {
                validInput=true;
                playAgain = true;
            }
            else if(yesOrNo.toLowerCase().equals("no"))
            {
                validInput=true;
                playAgain = false;
            }
            else
            {
                System.out.println("Sorry, didn't quite catch that, please answer with a simple Yes or No");
            }
        }
        return playAgain;
    }
    
    public static Player newGameOrContinue() throws IOException
    {
            System.out.println("Welcome, warrior! Would you like to continue your adventure, or shall you start fresh?\n");
            System.out.println("\nEnter Continue or New Game");
            Player player = null;
            while(true)
            {
                Scanner sc = new Scanner(System.in);
                String continueOrNewGame = sc.nextLine();
                if(continueOrNewGame.toLowerCase().equals("continue"))
                {
                   Load l = new Load();
                   player = l.loadPlayer();
                   break;
                }
                else if(continueOrNewGame.toLowerCase().equals("new game"))
                {
                    player = new Player();

                    player = setters(player);
                    break;
                }
                else
                {
                    System.out.println("Sorry, didn't quite catch that, please answer with a simple Continue or New Game");
                }
            }
            return player;
    }
    
    public static void main(String[] args) throws IOException
    {
        Player player;
        player = newGameOrContinue();
        Species species = new Species();
        
        Specie bear = species.getBasicBear();
        
        
        Save s = new Save();
        s.saveGame(player);
        Load l = new Load();
        player = l.loadPlayer();
        //System.out.println(player.getAllAttacks().get(2).getExp());
        Battle b = new Battle(bear, player);
        player = b.updatePlayer();
        if(player.getCurrentHealth()<=0)
        {
            System.out.println("You have been killed in battle, oh noble warrior. Valhala awaits!\nWait, what's this?!\nIt seems the gods have taken pitty on you, and given you a new life!\nThey have taken some of your riches, but you are, at least, alive once more.\nGo forth, nobe hero, and make your gods proud!\n");
            player.setCurrentHealth(15);
            player.setWealth(player.getWealth()/2);
        }
        s.saveGame(player);
        System.out.println(player.getCurrentHealth());
        while(true)
        {
            System.out.println("You currently have " + player.getWealth() + " Gold Coins, do you yarn for more bloodshed, warrior?");
            if(playAgain())
            {
                b = new Battle(bear, player);
                player = b.updatePlayer();
                s.saveGame(player);  
            }
            else
            {
                System.out.println("Ok, your progress is saved, please, come play again soon, ok :D?");
                break;
            }
        }
    }
}
