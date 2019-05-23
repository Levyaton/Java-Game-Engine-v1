/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author czech
 */
public class TextFields 
{
    JTextField welcomeText;
    
    JTextField nameInputField;
    
    JTextField battleText;
    
    /**
     *
     * @param mod
     * @return
     */
    public JTextField getWelcomeTextField(int mod){
        
        welcomeText = new JTextField(50);
        welcomeText.setHorizontalAlignment(JTextField.CENTER);
        Dimension textDim = new Dimension();
        textDim.setSize(16*mod, 4*mod);
        welcomeText.setPreferredSize(textDim);
        welcomeText.setEditable(false);
        welcomeText.setBackground(Color.BLACK);
        welcomeText.setForeground(Color.RED);
        welcomeText.setFont(new Font("Serif", Font.ITALIC, 20));
        welcomeText.setText("Welcome, Warrior of Legend! Have you come to continue your adventure, or start anew?\n");
        return welcomeText;
    }
    
    /**
     *
     * @param mod
     * @return
     */
    public JTextField getNameInputField(int mod){
        
        nameInputField = new JTextField(50);
        nameInputField.setHorizontalAlignment(JTextField.CENTER);
        Dimension textDim = new Dimension();
        textDim.setSize(16*mod, 4*mod);
        nameInputField.setPreferredSize(textDim);
        nameInputField.setEditable(true);
        nameInputField.setBackground(Color.BLACK);
        nameInputField.setForeground(Color.RED);
        nameInputField.setFont(new Font("Serif", Font.ITALIC, 20));
        nameInputField.setText("Please enter player name:\n");
        return  nameInputField;
    }
    
    /**
     *
     * @param mod
     * @return
     */
    public JTextField getBattleText(int mod){
        
        battleText = new JTextField(50);
        battleText.setHorizontalAlignment(JTextField.CENTER);
        Dimension textDim = new Dimension();
        battleText.setSize(16*mod, 4*mod);
        battleText.setPreferredSize(textDim);
        battleText.setEditable(true);
        battleText.setBackground(Color.BLACK);
        battleText.setForeground(Color.RED);
        battleText.setFont(new Font("Serif", Font.ITALIC, 20));
       
        return battleText;
    }
    
   
}
