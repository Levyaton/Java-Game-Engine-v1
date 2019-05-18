/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import cz.com.GameFiles.LevyBuild.customClasses.Items;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Load;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.World;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author czech
 */
public class MainFrame extends JFrame{
    
    private static ArrayList<Attack> attacks;
    private int mod = 50;
    private static JPanel cards;
    private static CardLayout cl;
    private static ArrayList<Item> items;
    private static NameInputPanel nip;
    private static BattlePanel bp;
   
    
    public void setMainFrame() throws IOException, MalformedURLException, LineUnavailableException, UnsupportedAudioFileException
    {
        cards = new JPanel(new CardLayout());

        String[] panelNames = {"welcome","enter name"};
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1199, 1000);
        nip = new NameInputPanel(mod);
        bp = new BattlePanel();
        
        cards.add(new WelcomePanel(mod), "welcome");
        cards.add(nip,"enter name");
        cards.add(bp, "battle");
        cl = (CardLayout)(cards.getLayout());
        this.add(cards);
        
      
        this.setVisible(true);
    }
    
    public static void panelShower(String s)
    {
        cl.show(cards, s);
    }
    
    public static void buttonListener(JButton button) throws IOException, InterruptedException
    {
        //System.out.println(button.getName());
        if(button.getName().equals("Continue"))
        {
            cl.show(cards, "battle");
            GameTest.setWorld(loadWorld());
            startBattle();
            
        }
        else if(button.getName().equals("New Game"))
        {
            cl.show(cards, "enter name");
        }
        else if(button.getName().equals("Submit"))
        {  
           cl.show(cards, "battle");
           Player player = new Player(nip.getText());  
           
           player.setTorso(new Bodyparts(0,0).getTorsoBear());
           player.setHead(new Bodyparts(0,0).getHeadBear());
           player.setRightHand(new Bodyparts(0,0).getHandBear());           
           player.addItemToInv(new Items(0,0).getJerky());
           player.addItemToInv(new Items(0,0).getApple());         
           player.addItemToInv(new Items(0,0).getHoney());
          
       
           for(Attack a : player.getEquipment().getAllAttacks())
           {
               for(Bodypart b : player.getEquipped())
               {
                   if(b.getAttack().getName().equals(a.getName()))
                   {
                       a.setLevel(5);
                       a.setAvailability(true);
                   }
               }
           }  
                   
            World w = new World(player);
            GameTest.setWorld(w);
            startBattle();
            JButton b = new JButton();
            
           
        }
        else if(button.getName().equals("Attack"))
        {
           
            attacks = GameTest.getAvailableAttacks();
            ArrayList<JButton> buttons = new ArrayList<JButton>();
            for(Attack a : attacks)
            {
                
                JButton b = new JButton();
                b.setName(a.getName());
                buttons.add(b);
                
            }
            bp.setSelectedButtons(buttons);
            bp.setSelectedLabel("Attacks");
        }
        else if(button.getName().equals("Bag"))
        {
            
            items = GameTest.getItems();
            ArrayList<JButton> buttons = new ArrayList<JButton>();
            for(Item a : items)
            {
                
                JButton b = new JButton();
                b.setName(a.getName());
                //b.setName(a.getName() + " x " + a.getItemCount());
                buttons.add(b);
                
            }
            bp.setSelectedButtons(buttons);
            bp.setSelectedLabel("Bag");
            
        }
        else if(isAttack(button.getName()))
        {   
            for(Attack a : attacks)
            {
                if(a.getName().equals(button.getName()))
                {
                    GameTest.PlayerAttack(a);
                }
            }    
        }
        else if(isItem(button.getName()))
        {   
           
            for(int i = 0; i<items.size();i++)
            {
               if(items.get(i).getName().equals(button.getName()))
                {
                    GameTest.useItem(items.get(i));
                }
            }
        }
        else if(button.getName().equals("Run"))
        {
            GameTest.run();
        }
        
    }
    
    private static boolean isAttack(String attack)
    {
        if(attacks!= null)
        {
            for(Attack a : attacks)
            {
                if(a.getName().equals(attack))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean isItem(String item)
    {
        if(items!= null)
        {
            for(Item a : items)
            {
                
                if(a.getName().equals(a.getName()))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void startBattle() throws InterruptedException
    {
        cl.show(cards, "battle");//The card doesnt accually switch when starting a new game
        System.out.println("Here");
        GameTest.battle();
    }
    
    public static World loadWorld() throws IOException, FileNotFoundException, InterruptedException
    {
        Load l = new Load();
        World w = l.loadWorld();
        
        
        return w;
    }
    
    public static void writeBattleText(String text) throws InterruptedException
    {
        bp.writeText(text);
    }
}   

   
