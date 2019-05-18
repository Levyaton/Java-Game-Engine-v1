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
import cz.com.GameFiles.LevyBuild.customClasses.Clerks;
import cz.com.LevyatonRPGEngine.LevyBuild.Mechanics.Shop;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.World;

import cz.com.Testing.JTextAreaOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author czech
 */

public class Main {

    static World world;
    static Player player;
    static Clerks c;


    static InputCheckers i;
    static Species species;
    static Load l;
    static Specie bear;
    static Shop sh;

    static Save s;
    static Battle b;

    private static Player setters(Player player) {

        Items items = new Items();
        Bodyparts bodyparts = new Bodyparts(player.getMaxHealth(), player.getDef());
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
        System.out.println(player.getInv().getHealing().get(player.getInv().getHealing().indexOf(items.getApple())).getItemCount());
        player.setWealth(666);
        return player;
    }

    public static boolean goShopping() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Yes/No");
            String[] valid = {"Yes", "No"};
            String input = sc.nextLine();
            if (i.validInput(valid, input)) {
                if (input.toLowerCase().equals("yes")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("Sorry, didn't quite catch that, please answer with a simple Yes or No");
            }
        }
    }

    public static boolean playAgain() {
        boolean validInput = false;
        boolean playAgain = false;

        while (validInput == false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Yes/No");
            String yesOrNo = sc.nextLine();
            if (yesOrNo.toLowerCase().equals("yes")) {
                validInput = true;
                playAgain = true;
            } else if (yesOrNo.toLowerCase().equals("no")) {
                validInput = true;
                playAgain = false;
            } else {
                System.out.println("Sorry, didn't quite catch that, please answer with a simple Yes or No");
            }
        }
        return playAgain;
    }

    public static void newGameOrContinue(String nOrC) throws IOException {

        System.out.println("Hello");
        
        if (nOrC.equals("c")) {
            Load l = new Load();
            
//            try{
            world = l.loadWorld();
            //startBattle();
//            }
//            catch(IOException a)
//            {
//                System.out.println("WTF");
//            }
        } else {
            System.out.println("Please enter player name: ");
           // bf.showPanel("textInputPanel");
            
            
        }

    }

    public static void startBattle() throws InterruptedException
    {
       // bf.showPanel("battlePanel");
       // bf.activateBattle(bear, world.getPlayer());
        //b = new Battle(bear,world.getPlayer());
        //b.doBattle();
    }

    public void perform(JButton e) throws IOException 
    {
        System.out.println("Greeting, warrior of legend! Would you like to continue your adventure, or start a new one?");
        String button = e.getName();
        if(button.equals("continue"))
        {  
            newGameOrContinue("c");
        }
        else if(button.equals("new game"))
        {
            newGameOrContinue("n");
        }
    }
    
    public Battle getBattle()
    {
        return b;
    }
    
    public void playerName (String name) throws IOException, InterruptedException 
    {
            Player p = new Player(name);
            world = new World(p);
            s = new Save();
            s.saveGame(world);
            startBattle();
            
    }
    

    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException, InterruptedException {

        c = new Clerks();

        species = new Species();

        bear = species.getBasicBear();
        sh = new Shop(c.getFirstClerk());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //bf = new BattleFrame();
                //JTextAreaOutputStream out = new JTextAreaOutputStream(bf.textOut);
                //System.setOut(new PrintStream(out));
                //bf.setVisible(true);

            }
        });

        /*
        
        if(world.getPlayer().getCurrentHealth()<=0)
        {
            System.out.println("You have been killed in battle, oh noble warrior. Valhala awaits!\nWait, what's this?!\nIt seems the gods have taken pitty on you, and given you a new life!\nThey have taken some of your riches, but you are, at least, alive once more.\nGo forth, nobe hero, and make your gods proud!\n");
            world.getPlayer().setCurrentHealth(15);
            world.getPlayer().setWealth(world.getPlayer().getWealth()/2);
        }
        s.saveGame(world);
        System.out.println(world.getPlayer().getCurrentHealth());
        while(true)
        {
            System.out.println("You currently have " + world.getPlayer().getWealth() + " Gold Coins, do you yarn for more bloodshed, warrior?");
            if(playAgain())
            {
                b = new Battle(bear, world.getPlayer());
                world.setPlayer(b.updatePlayer());
                s.saveGame(world);  
            }
            else
            {
                System.out.println("Ah, I see. Are you perhpas interested in some shopping, then?");
                if(goShopping())
                {
                    world.setPlayer(sh.shopping(world.getPlayer()));
                }
                else
                {
                    System.out.println("Ok, your progress is saved, please, come play again soon, ok :D?");
                    break;
                }
            }
        }
         */
    }
}
