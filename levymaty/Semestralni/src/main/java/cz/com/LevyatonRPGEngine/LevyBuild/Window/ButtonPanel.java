/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author czech
 */
public class ButtonPanel extends JPanel implements ActionListener{

   
    MainFrame mf;
    ArrayList<JButton> buttons;
    
    ArrayList<String> buttonNames;
    
    String layoutName;
    
    /**
     *
     * @param buttonNames
     * @param panelSize
     * @param layoutName
     * @param m
     */
    public ButtonPanel(ArrayList<String> buttonNames, Dimension panelSize, String layoutName,MainFrame m)
    {
        mf = m;
        buttons = new ArrayList<JButton>();
        this.buttonNames = new ArrayList<String>();
        
        this.layoutName = layoutName;
        this.buttonNames = buttonNames;
        setButtons();
        //assighnLayout();
        for(JButton b : buttons)
        {
            add(b);
            System.out.println(b.getName());
        }
        this.setVisible(true);
    }
    
    
    private void assighnLayout()
    {
        if(layoutName.equals("FlowLayout"))
        {
            this.setLayout(new FlowLayout());
        }
        
        else if(layoutName.equals("BorderLayout"))
        {
            this.setLayout(new BorderLayout());
        }
        
        else if(layoutName.equals("CardLayout"))
        {
            this.setLayout(new CardLayout());
        }
        
        else if(layoutName.equals("GridLayout"))
        {
            this.setLayout(new GridLayout());
        }
        
        else if(layoutName.equals("GridBagLayout"))
        {
            this.setLayout(new GridBagLayout());
        }
        
        else if(layoutName.equals("SpringLayout"))
        {
            this.setLayout(new SpringLayout());
        }
    }
    
    
    private void setButtons()
    {
        for(String name : buttonNames)
        {
            JButton b = new JButton(name);
            b.setName(name);
            b.addActionListener(this);
            buttons.add(b);
           
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
    
        try {
           // System.out.println("Hello");
            //System.out.println(e.getSource());
            mf.buttonListener((JButton) e.getSource());
        } catch (IOException ex) {
            Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ButtonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
    
    
}
