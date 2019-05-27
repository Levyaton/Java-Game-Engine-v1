/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *  JPanel containing the Shop GUI
 * @author czech
 */
public class ShopGUi extends javax.swing.JPanel implements ActionListener{
    
    int patience = 5;
    Clerk clerk;
    MainFrame mf;
    Font mainFont;
    Player player;
    
    /**
     *
     * Creates new form ShopGUi
     * @param m
     * @throws IOException
     */
    public ShopGUi(MainFrame m) throws IOException {
        mf = m;
        initComponents();
        custom();
    }
    
    
     /**
     *  returns the player
     */
    public Player getPlayer()
    {
        return player;
    }
    
    /**
     *
     * @throws IOException
     */
    public void custom() throws IOException
    {
      
        buyButton.setName("Buy");
        buyButton.addActionListener(this);
        sellButton.setName("Sell");
        leaveButton.setName("Leave");
        sellButton.addActionListener(this);
        leaveButton.addActionListener(this);
        this.leaveButton.addActionListener(this);
        mainFont = this.shopText.getFont();
        revalidate();
        repaint();
        this.setVisible(true);
    }

    /**
     *  Sets the shop values of Clerk and Player
     * @param clerk
     * @param player
     */
    public void setShop(Clerk clerk, Player player)
    {
        this.clerk = clerk;
        this.player = player;
    }
    
    /**
     *  returns the cool font that I decided to go with, stored in mainFont of this class
     * @return
     */
    public Font getCoolFont()
    {
        return mainFont;
    }
    
    /**
     *  Set's the text of the text area called pWealth, to show the current value of player wealth
     */
    public void setPlayerWealthText()
    {
       this.pWealth.setText(player.getName() + "'s gold:   " + player.getWealth());
        revalidate();
        repaint();
    }
    
    /**
     *  Set's the text into the selectedPanelName
     * @param name
     */
    public void setSelectedLabel(String name)
    {
        this.selectedPanelName.setText(name);
        this.selectedPanelName.setFont(mainFont);
       // revalidate();
        repaint();
    }
    
    /**
     * Gets the shopText textArea
     * @return
     */
    public JTextArea getShopTextArea()
    {
        return this.shopText;
    }
    
    /**
     *
     *  Set's the buttons to the selectedPanel panel
     * 
     * @param buttons
     */
    public void setSelectedButtons(ArrayList<JButton> buttons)
    {
        
        this.selectedPanel.removeAll();
       
        this.selectedPanel.setLayout(new BoxLayout(selectedPanel, BoxLayout.PAGE_AXIS));
        for(JButton b : buttons)
        {
           this.selectedPanel.add(Box.createRigidArea(new Dimension(0,20)));
           b.setText(b.getName());
           b.setFont(mainFont);
           b.setVisible(true);
           b.addActionListener(this);
           this.selectedPanel.add(b);
           

           revalidate();
           repaint();
        }
        
    }
    
    /**
     *  set's text to the shopText textArea
     * @param text
     */
    public void setText(String text)
    {
        this.shopText.setText(text);
        //revalidate();
        repaint();
    }
    
    /**
     *
     * @param text
     * @throws InterruptedException
     */
  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectedPanel = new javax.swing.JPanel();
        clerkPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pWealth = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        buyButton = new javax.swing.JButton();
        sellButton = new javax.swing.JButton();
        leaveButton = new javax.swing.JButton();
        selectedPanelName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        shopText = new javax.swing.JTextArea();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectedPanel.setBackground(new java.awt.Color(60, 0, 0));
        selectedPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout selectedPanelLayout = new javax.swing.GroupLayout(selectedPanel);
        selectedPanel.setLayout(selectedPanelLayout);
        selectedPanelLayout.setHorizontalGroup(
            selectedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        selectedPanelLayout.setVerticalGroup(
            selectedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
        );

        add(selectedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 40, 350, 810));
        selectedPanel.getAccessibleContext().setAccessibleName("selectedPanel");

        clerkPanel.setBackground(new java.awt.Color(57, 57, 57));
        clerkPanel.setToolTipText("");
        clerkPanel.setName("clerkPanel"); // NOI18N
        clerkPanel.setLayout(null);

        pWealth.setBackground(new java.awt.Color(255, 255, 255));
        pWealth.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        pWealth.setForeground(new java.awt.Color(255, 0, 0));
        jScrollPane2.setViewportView(pWealth);
        pWealth.getAccessibleContext().setAccessibleName("pWealth");

        clerkPanel.add(jScrollPane2);
        jScrollPane2.setBounds(0, 465, 420, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JeffTheKillerStretched.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        clerkPanel.add(jLabel1);
        jLabel1.setBounds(0, -20, 1230, 570);

        add(clerkPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 520));
        clerkPanel.getAccessibleContext().setAccessibleName("clerkPanel");

        buttonPanel.setBackground(new java.awt.Color(82, 0, 0));

        buyButton.setBackground(new java.awt.Color(0, 0, 0));
        buyButton.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        buyButton.setForeground(new java.awt.Color(255, 255, 255));
        buyButton.setText("Buy");
        buyButton.setName("sellButton"); // NOI18N
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        sellButton.setBackground(new java.awt.Color(0, 0, 0));
        sellButton.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        sellButton.setForeground(new java.awt.Color(255, 255, 255));
        sellButton.setText("Sell");
        sellButton.setName("sellButton"); // NOI18N
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        leaveButton.setBackground(new java.awt.Color(0, 0, 0));
        leaveButton.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        leaveButton.setForeground(new java.awt.Color(255, 255, 255));
        leaveButton.setText("Leave");
        leaveButton.setName("leaveButton"); // NOI18N
        leaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(391, Short.MAX_VALUE)
                .addComponent(buyButton)
                .addGap(88, 88, 88)
                .addComponent(sellButton)
                .addGap(83, 83, 83)
                .addComponent(leaveButton)
                .addGap(350, 350, 350))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyButton)
                    .addComponent(sellButton)
                    .addComponent(leaveButton))
                .addContainerGap())
        );

        buyButton.getAccessibleContext().setAccessibleName("sellButton");
        sellButton.getAccessibleContext().setAccessibleName("sellButton");

        add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1230, 90));
        buttonPanel.getAccessibleContext().setAccessibleName("buttonPanel");

        selectedPanelName.setBackground(new java.awt.Color(0, 0, 0));
        selectedPanelName.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        selectedPanelName.setForeground(new java.awt.Color(255, 255, 255));
        add(selectedPanelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 350, 40));
        selectedPanelName.getAccessibleContext().setAccessibleName("selectedPanelName");

        shopText.setBackground(new java.awt.Color(102, 102, 102));
        shopText.setColumns(20);
        shopText.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        shopText.setForeground(new java.awt.Color(255, 0, 0));
        shopText.setRows(5);
        shopText.setToolTipText("");
        shopText.setWrapStyleWord(true);
        jScrollPane1.setViewportView(shopText);
        shopText.getAccessibleContext().setAccessibleName("shopText");

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 1230, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyButtonActionPerformed

    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellButtonActionPerformed

    private void leaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leaveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton buyButton;
    private javax.swing.JPanel clerkPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton leaveButton;
    private javax.swing.JTextPane pWealth;
    private javax.swing.JPanel selectedPanel;
    private javax.swing.JTextField selectedPanelName;
    private javax.swing.JButton sellButton;
    private javax.swing.JTextArea shopText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton chosen = (JButton) e.getSource();
        
        if(chosen.getName().equals("Leave"))
        {
            mf.setResult(false);
        }
        else if(chosen.getName().equals("Buy"))
        {
            ArrayList<Item> clerkInv = clerk.getInventory();
            ArrayList<JButton> buttons = new ArrayList<JButton>();
            for(Item a : clerkInv)
            {  
                JButton b = new JButton();
                //b.setName(a.getName());
                b.setName(a.getName() + " x " + a.getItemCount());
                buttons.add(b);       
            }
            setSelectedButtons(buttons);
            setSelectedLabel("Buy");
            this.shopText.setText(clerk.getName() + ":   What would you like to buy?\n");
            
        }
        else if(chosen.getName().equals("Sell"))
        {
            ArrayList<Item> playerInv = player.getInventory();
            ArrayList<JButton> buttons = new ArrayList<JButton>();
            for(Item a : playerInv)
            {  
                JButton b = new JButton();
                //b.setName(a.getName());
                b.setName(a.getName() + " x " + a.getItemCount());
                buttons.add(b);       
            }
            setSelectedButtons(buttons);
            setSelectedLabel("Sell");

            setText(clerk.getName() + ":  Oh? And what, pray tell, have you got that would be of use to me?\n");

        }
        else if(selectedPanelName.getText().equals("Buy"))
        {
            for(Item i : clerk.getInventory())
            {
                if(chosen.getName().contains(i.getName()))
                {
                    if((player.getWealth()-i.getValue())>0)
                    {
                        player.setWealth(player.getWealth()-i.getValue());
                        player.addItemToInv(i);
                      
                        setText("The " + i.getName() + " has been added to your inventory, thank you for your patronage!");
                      
                        this.setPlayerWealthText();
                    }
                    else
                    {                     
                        if(clerk.getName().equals("James"))
                        {
                           setText("You can't afford that, bub!");
                         
                        }
                        else
                        {
                           setText("Im afraid you can't afford that");
                           
                        }
                    }
                }
            }
        }
        else if(selectedPanelName.getText().equals("Sell"))
        {
            Item item = null;
            for(Item i : player.getInventory())
            {
                if(chosen.getName().contains(i.getName()))
                {
                    if((player.getWealth()-i.getValue())>0)
                    {
                        if(i.getItemCount()>0)
                        {
                            item = i;
                            
                            setText("That is a mighty fine " + i.getName() + ", there, friend! Sure, I'll take it of your hands! I'll give ya " + i.getValue() + " gold coins for it!");
                            
                            this.setPlayerWealthText();
                        }
                       
                    }
                   
                }
            }
            try
            {
                player.setWealth(player.getWealth()+item.getValue());
                player.getInv().decrementItem(item);
            }
            catch(Exception outOfItem)
            {
                System.out.println("Out of the Item");
                patience --;
                if(patience==3)
                {
                    this.setText("Stop this foolishness, you have no more of this item!\n");
                }
                else if(patience==2)
                {
                    setText("I grow weary of your foolery, I shall kick you out of my shop if you continue\n");
                }
                else if(patience==1)
                {
                    setText("This is your last warning, persist and you shall be kicked out!\n");
                }
                else if(patience==0)
                {
                    mf.setResult(false);
                }
                
                
            }                 
        }
       
//To change body of generated methods, choose Tools | Templates.
    }
}