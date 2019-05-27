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
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.*;
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
 *  Class containing the game frame
 * @author czech
 */
public class MainFrame extends JFrame{
    
    private   ArrayList<Attack> attacks;
    private int mod = 50;
    private  JPanel cards;
    private  CardLayout cl;
    private  ArrayList<Item> items;
    private  NameInputPanel nip;
    private  BattlePanel bp;
    private  ShopGUi shop;
    private  ShopOrBattle sob;
    private  DoubleCanvas overworld;
    private  GameContainer gc;
    private  Battle b;
    private  Save s;
    private Specie enemy;

    public void setOverworld(DoubleCanvas overworld) {
        this.overworld = overworld;
    }
    
    
    /**
     *  initializes and sets the class
     * @param windowWidth
     * @param windowHeight
     * @param canvasHeight
     * @param gc
     * @throws IOException
     * @throws MalformedURLException
     * @throws LineUnavailableException
     * @throws UnsupportedAudioFileException
     */
    public MainFrame(int windowWidth, int windowHeight, int canvasHeight, GameContainer gc) throws IOException, MalformedURLException, LineUnavailableException, UnsupportedAudioFileException
    {
        s = new Save();
        this.gc = gc;
        overworld = new DoubleCanvas(gc,windowWidth,windowHeight,canvasHeight);
        cards = new JPanel(new CardLayout());
        String[] panelNames = {"welcome","enter name"};
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 900);
        nip = new NameInputPanel(mod,this);
        bp = new BattlePanel();
        shop = new ShopGUi(this); 
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
    
    /**
     *  shows the card corresponding to the given String
     * @param card
     */
    public void showCard(String card)
    {
        cl.show(cards, card);
//        this.revalidate();
        this.repaint();
        
    }
    
    /**
     *  returns the ShopGUi
     * @return
     */
    public ShopGUi getShop()
    {
        return shop;
    }
    
    /**
     *  listener for many buttons from other classes
     * @param button
     * @throws IOException
     * @throws InterruptedException
     * @throws LineUnavailableException
     * @throws UnsupportedAudioFileException
     */
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
           player.setWealth(100000);
       
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
            s.saveGame(w);
            gc.setWorld(w);
            JButton b = new JButton();
            
            showCard("overworld");
           
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
    
   // private boolean isShopItem(String itemName)
    {
       // for(Item a : gc.getWorld().getClerks().getFirstClerk().getInventory())
        {
            //if(a.getName().equals(itemName))
            {
                
            }
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
    
    /**
     *  returns the overworld menu
     * @return
     */
    
    /**
     *  activates the shop mechanic
     * @throws InterruptedException
     */
    public void shop() throws InterruptedException
    {
        PrintStream printStream = new PrintStream(new CustomOutputStream(shop.getShopTextArea())); 
        //System.setOut(printStream);
        //System.setErr(printStream);
       
        Clerk clerk = gc.getWorld().getClerks().getFirstClerk();
        shop.setShop(clerk,gc.getWorld().getPlayer());
        showCard("shop");
        System.out.println("Here, okoko");
        shop.setPlayerWealthText();
        shop.setText(clerk.getName() + " looks at you with " + clerk.getTrait() + " eyes\n\n" + clerk.getName() + ":   What can I interest you in, traveller?\n");
        
    }
    
    /**
     *  activates the battle mechanic
     * @param enemy
     * @return 
     * @throws InterruptedException
     * @throws LineUnavailableException
     * @throws UnsupportedAudioFileException
     * @throws IOException
     */
    public boolean startBattle(Specie enemy ) throws InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException
    {
        
        //shop();
       //
        
        
      
        return b.result();
    }
    
    /**
     *  loads an old world from save files
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public   World loadWorld() throws IOException, FileNotFoundException, InterruptedException
    {
        Load l = new Load();
        World w = l.loadWorld();
        
        
        return w;
    }
    
    /**
     *  returns the overworld
     * @return
     */
    public DoubleCanvas getOverworld()
    {
        return overworld;
    }
    
    /**
     *  writes text to the battleText JTextArea in the BattlePanel class
     * @param text
     * @throws InterruptedException
     */
    public void writeBattleText(String text) throws InterruptedException
    {
        bp.writeText(text);
    }
    
    /**
     *  writes text to the shopText JTextArea in the ShopGUi class
     * @throws InterruptedException
     */
    public void writeShopText(String text) throws InterruptedException
    {
       
        shop.setText(text);
    }
  
    /**
     *  sets initializes the ShopOrBattle JPanel
     */
    public void battleOrShop(Specie s)
    {
        sob = new ShopOrBattle(this,s);
        cards.add(sob,"shopOrBattle");
        showCard("shopOrBattle");
    }
     /**
     * does the given activity
     * @param battleShopBack
     * @param s
     * @throws InterruptedException
     * @throws javax.sound.sampled.LineUnavailableException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     * @throws java.io.IOException
     */
    public void battleOrShop(String battleShopBack, Specie s) throws InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException
    {
        
        String activity = battleShopBack;
        if(activity.equals("battle"))
        {
            System.out.println(s.getName());
            System.out.println("battle");
            bp.setText("");
            PrintStream printStream = new PrintStream(new CustomOutputStream(bp.getBattleText())); 
            //System.setOut(printStream);
            //System.setErr(printStream);
            b = new Battle(s,gc.getWorld().getPlayer(),this,gc,bp);
            showCard("battle");
            bp.writeText("What would you like to do?\n");
            bp.setBattle(b,gc.getWorld().getPlayer());
            b.doBattle();        
            MusicController.battleMusic();
            //while(b.getTerminated()==false){}
            System.out.println("Here");
        }
        else if(activity.equals("shop"))
        {
            shop();
        }
        else
        {
            setResult(false);
        }
    }
    
     /**
     *  sets the result of the activity to playerSprite
     */
    public void setResult(boolean result)
    {
        this.showCard("overworld");
        gc.getPs().setResult(result);
    }
    
}   

   
