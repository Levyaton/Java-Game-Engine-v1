/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author czech
 */

public class NameInputPanel extends JPanel{

    private  ArrayList<String> buttonNames;
    private int mod;
    private Dimension thisDim;
    
    private TextFields tf;
    private JTextField t;
    
    public NameInputPanel(int mod) {
        this.mod = mod;
        setLayout(new BorderLayout());     
        thisDim = new Dimension();
        thisDim.setSize(24*mod, 20*mod);
        
        buttonNames = new ArrayList<String>();
        buttonNames.add("Submit");
        Dimension buttonDim = new Dimension();
        buttonDim.setSize(16 * mod, 4 * mod);
        tf = new TextFields();
        t = tf.getNameInputField(mod);
        this.add(t, BorderLayout.NORTH);
        
        this.add(new ButtonPanel(buttonNames,buttonDim,"FlowLayout"));
        this.setBackground(Color.BLACK);
        setVisible(true);
    }
    
    public String getText()
    {
        String pn = t.getText().substring(26);
        return pn;
    }

}
