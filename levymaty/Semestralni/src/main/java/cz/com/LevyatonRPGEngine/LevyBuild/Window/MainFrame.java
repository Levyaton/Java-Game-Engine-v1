/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import GameContainer.DoubleCanvas;
import GameContainer.GameContainer;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import cz.com.GameFiles.LevyBuild.customClasses.Items;
import cz.com.LevyatonRPGEngine.LevyBuild.Mechanics.Battle;
import cz.com.LevyatonRPGEngine.LevyBuild.Mechanics.Shop;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.CustomOutputStream;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Load;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.World;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
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
    
    private   ArrayList<Attack> attacks;
    private int mod = 50;
    private   JPanel cards;
    private   CardLayout cl;
    private   ArrayList<Item> items;
    private   NameInputPanel nip;
    private   BattlePanel bp;
    private   ShopGUi shop;
    private   World w;
    private   DoubleCanvas overworld;
    private GameContainer gc;
    private Battle b;
    
    public MainFrame(GameContainer gc, int windowWidth, int windowHeight, int canvasHeight) throws IOException, MalformedURLException, LineUnavailableException, UnsupportedAudioFileException
    {
        this.gc = gc;
        cards = new JPanel(new CardLayout());
        String[] panelNames = {"welcome","enter name"};
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 900);
        nip = new NameInputPanel(mod,this);
        bp = new BattlePanel(this);
        shop = new ShopGUi(this);
        overworld = new DoubleCanvas(gc,windowWidth,windowHeight,canvasHeight);
        cards.add(new WelcomePanel(mod,this), "welcome");
        cards.add(overworld, "overworld");
        cards.add(nip,"enter name");
        cards.add(shop, "shop");
        cards.add(bp, "battle");
        cl = (CardLayout)(cards.getLayout());
        this.setResizable(true);
        this.add(cards);
        
      
        this.setVisible(true);
    }
    
    
    public void showCard(String card)
    {
        cl.show(cards, card);
        this.revalidate();
        this.repaint();
        
    }
    
    
    public ShopGUi getShop()
    {
        return shop;
    }
    
    public  void buttonListener(JButton button) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException
    {
        //System.out.println(button.getName());
        if(button.getName().equals("Continue"))
        {
            //cl.show(cards, "battle");
            gc.setWorld(loadWorld());
            //startBattle();
            showCard("overworld");
           //shop();
        }
        else if(button.getName().equals("New Game"))
        {
            showCard("enter name");
        }
        else if(button.getName().equals("Submit"))
        {  
           
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
                   
            w = new World(player);
            gc.setWorld(w);
            JButton b = new JButton();
            
            showCard("overworld");
           
        }
        else if(button.getName().equals("Attack"))
        {
           
            attacks = gc.getWorld().getPlayer().getAvailableAttacks();
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
            
            items = gc.getWorld().getPlayer().getInv().getInventory();
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
                    b.pPreformAttack(a);
                }
            }    
        }
        else if(isItem(button.getName()))
        {   
           
            for(int i = 0; i<items.size();i++)
            {
               if(items.get(i).getName().equals(button.getName()))
                {
                    b.useAnItem(items.get(i));
                   // if(items.get(i).getItemCount()<1)
                    {
                       // bp.updateSelectedPane(items.get(i).getName());
                       
                    }
                }
            }
        }
        else if(button.getName().equals("Run"))
        {
            b.run();
        }
        else if(button.getName().equals("Buy"))
        {  
           
            Clerk c = gc.getWorld().getClerks().getFirstClerk();
            ArrayList<Item> clerkInv = c.getInventory();
            ArrayList<JButton> buttons = new ArrayList<JButton>();
            for(Item a : clerkInv)
            {  
                JButton b = new JButton();
                //b.setName(a.getName());
                b.setName(a.getName() + " x " + a.getItemCount());
                buttons.add(b);       
            }
            shop.setSelectedButtons(buttons);
            shop.setSelectedLabel("Buy");
            
            
        }
        
    }
    
    private   boolean isAttack(String attack)
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
    
    private   boolean isItem(String item)
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
    
    
    public   void shop() throws InterruptedException
    {
        PrintStream printStream = new PrintStream(new CustomOutputStream(shop.getShopTextArea())); 
        System.setOut(printStream);
        System.setErr(printStream);
        Clerk clerk = gc.getWorld().getClerks().getFirstClerk();
        showCard("shop");
        System.out.println("Here, okoko");
        shop.setPlayerWealthText(gc.getWorld().getPlayer().getName() + "'s gold:   " + gc.getWorld().getPlayer().getWealth()+"\n");
        shop.setText(clerk.getName() + " looks at you with " + clerk.getTrait() + " eyes\n\n" + clerk.getName() + ":   What can I interest you in, traveller?\n");
    }
    
    public  void startBattle(Specie enemy) throws InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException
    {
        PrintStream printStream = new PrintStream(new CustomOutputStream(bp.getBattleText())); 
        System.setOut(printStream);
        System.setErr(printStream);
        b = new Battle(enemy,gc.getWorld().getPlayer(),this,gc);
        System.out.println("What would you like to do?\n");
        b.doBattle();
        showCard("battle");//The card doesnt accually switch when starting a new game
        //System.out.println("Here");
        MusicController.battleMusic();
       // cl.show(cards, "shop");
    }
    
    public   World loadWorld() throws IOException, FileNotFoundException, InterruptedException
    {
        Load l = new Load();
        World w = l.loadWorld();
        
        
        return w;
    }
    
    public   DoubleCanvas getOverworld()
    {
        return overworld;
    }
    
    
    public void writeBattleText(String text) throws InterruptedException
    {
        bp.writeText(text);
    }
    
    
   
    public   void writeShopText(String text) throws InterruptedException
    {
       
        shop.setText(text);
    }
}   

   
