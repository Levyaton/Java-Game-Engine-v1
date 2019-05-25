/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import GameContainer.GameContainer;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Save;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *  A class responsible for the overworld menu
 * @author czech
 */
public class OverworldMenu extends JPanel implements ActionListener{
    
    JButton save;
    JButton shop;
    JButton back;
    GameContainer gc;
    Save s;
    
    /**
     *  sets up and initializes the class
     * @param gc
     */
    public OverworldMenu(GameContainer gc)
    {
        this.gc = gc;
        this.setName("menu");
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        Dimension panelDim = new Dimension();
        panelDim.setSize(100, 300);
        this.setPreferredSize(panelDim);
        
        this.setVisible(false);
        
    }
    
    /**
     *  sets the class visibility to the given boolean
     * @param visable
     */
    public void setVisable(boolean visable)
    {
        this.setVisable(visable);
        revalidate();
        repaint();
    }
    
    /**
     *  sets the buttons to the menu
     */
    public void setButtons()
    {
        save = new JButton();
        save.setText("Save");
        
        shop = new JButton();
        save.setText("Shop");
        
        back = new JButton();
        back.setText("Back");
        
        this.add(shop);
        this.add(save);
        this.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save)
        {
           s = new Save();
            try {
                s.saveGame(gc.getWorld());
            } catch (IOException ex) {
                Logger.getLogger(OverworldMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == shop)
        {
            try {
                gc.getMainFrame().shop();
            } catch (InterruptedException ex) {
                Logger.getLogger(OverworldMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == back)
        {
            this.setVisable(false);
            revalidate();
            repaint();
        }
    }
    
}

