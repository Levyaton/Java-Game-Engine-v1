/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import cz.com.GameFiles.LevyBuild.customClasses.Attacks;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import cz.com.GameFiles.LevyBuild.customClasses.Items;
import cz.com.GameFiles.LevyBuild.customClasses.Species;
import cz.com.LevyatonRPGEngine.LevyBuild.Mechanics.Battle;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Save;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.World;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

/**
 *
 * @author czech
 */
public class GameTest {
   
    private static Battle b;
    private static World world;
    private static Player player;
    private Battle battle;
    private static Specie bear;
    private static Species s;
    private static MainFrame m;
    public static void setWorld(World getWorld) throws IOException
    {
    
        world = getWorld;
        player = world.getPlayer();
        
        world.setPlayer(player);
        new Save().saveGame(world);
    }
    

    public static void run() throws InterruptedException
    {
        b.run();
    }
    
    public static void PlayerAttack(Attack attack) throws InterruptedException
    {
        b.pPreformAttack(attack);
    }
    
    
    public static void battle() throws InterruptedException
    {
        s = new Species();
        bear = s.getBasicBear();
        b = new Battle (bear,player);
        b.doBattle();
        
    }
    
    public static void useItem(Item i) throws InterruptedException
    {
        b.useAnItem(i);
    }
    
    public static ArrayList<Item> getItems()
    {
        return b.getHealing();
    }
    
    public static ArrayList<Attack> getAvailableAttacks()
    {
        return b.getAvailableAttacks();
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public World getWorld()
    {
        return world;
    }
    
    public static void main(String[] args){
        
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               m = new MainFrame();
                try {
                    m.setMainFrame();
                } catch (IOException ex) {
                    Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(GameTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}

