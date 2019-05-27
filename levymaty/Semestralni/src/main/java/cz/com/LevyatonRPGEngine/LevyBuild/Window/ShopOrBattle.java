/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import GameContainer.GameContainer;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Save;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *  A class responsible for the overworld menu
 * @author czech
 */
public class ShopOrBattle extends JPanel implements ActionListener{
    
    Specie s;
    JButton battle;
    JButton shop;
    JButton back;
    MainFrame mf;

    
    /**
     *  sets up and initializes the class
     * @param gc
     */
    public ShopOrBattle(MainFrame mf, Specie s)
    {
        this.s = s;
        this.mf = mf;
        this.setName("menu");
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        Dimension panelDim = new Dimension();
        panelDim.setSize(24*50, 20*50);
        this.setPreferredSize(panelDim);
        setButtons();
        this.setVisible(true);
        revalidate();
        repaint();
       
      
    }
    
    
    /**
     *  sets the buttons to the menu
     */
    public void setButtons()
    {
        battle = new JButton();
        battle.setText("Battle");
        battle.addActionListener(this);
        
        shop = new JButton();
        shop.setText("Shop");
        shop.addActionListener(this);
        
        back = new JButton();
        back.setText("Return to overworld");
        back.addActionListener(this);
        
        this.add(shop);
        this.add(battle);
        this.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == shop)
        {
            try {
                mf.battleOrShop("shop", s);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == battle)
        {
            try {
                mf.battleOrShop("battle",s);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == back)
        {
            try {
                mf.battleOrShop("back",s);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ShopOrBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

