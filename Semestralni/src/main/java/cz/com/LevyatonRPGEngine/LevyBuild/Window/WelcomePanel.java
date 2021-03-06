/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author czech
 */
public class WelcomePanel extends JPanel{
    
    
    ArrayList<String> buttonNames;
    
    int mod;
    Dimension thisDim;
    Dimension textDim;
    Dimension buttonDim;
    
    public WelcomePanel(int mod){

        this.mod = mod;
        setLayout(new BorderLayout());     
        thisDim = new Dimension();
        thisDim.setSize(24*mod, 20*mod);
        
        buttonNames = new ArrayList<String>();
        buttonNames.add("Continue");
        buttonNames.add("New Game");
        buttonDim = new Dimension();
        buttonDim.setSize(16 * mod, 4 * mod);
        
        
        this.add(new TextFields().getWelcomeTextField(mod), BorderLayout.NORTH);
        
        this.add(new ButtonPanel(buttonNames,buttonDim,"FlowLayout"));
        this.setBackground(Color.BLACK);
        setVisible(true);
    }

    
    
    
}
