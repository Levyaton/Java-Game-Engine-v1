/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;


import GameContainer.GameContainer;
import cz.com.LevyatonRPGEngine.LevyBuild.Mechanics.Battle;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import java.awt.Component;
import java.net.URL;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *  A panel that is responsible for battles
 * @author czech
 */
public class BattlePanel extends javax.swing.JPanel implements ActionListener{

    ArrayList<Attack> attacks;
    ArrayList<Item> items;
    Player player;
    Font mainFont;
    Battle battle;
    
    /**
     * Creates new form BattlePanel2
     * @throws java.io.IOException
     * @throws java.net.MalformedURLException
     * @throws javax.sound.sampled.LineUnavailableException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     */
    public BattlePanel() throws IOException, MalformedURLException, LineUnavailableException, UnsupportedAudioFileException {
       
      
        initComponents();
        custom();
        //battleMusic();
        
    }

    /**
     *  sets up the battle
     * @param battle
     * @param player
     */
    public void setBattle(Battle battle, Player player)
    {
        this.battle = battle;
        this.player = player;
    }
    
    /**
     *  returns the battleText JTextArea
     * @return
     */
    public JTextArea getBattleText()
    {
        return this.battleText;
    }
    
    /**
     *  customizes the generated JPanel
     * @throws LineUnavailableException
     * @throws UnsupportedAudioFileException
     * @throws IOException
     */
    public void custom() throws LineUnavailableException, UnsupportedAudioFileException, IOException
    {
        JPanel panel = new JPanel();

      
       
        //battleText.add(scrollPane1);

        
        
        //selectedPanel.add(scrollPane2);
        
        Attack.addActionListener(this);
        Bag.addActionListener(this);
        Run.addActionListener(this);
        mainFont = battleText.getFont();
        this.setVisible(true);
       
    }
    
    /**
     *  sets the text of the selectedName JTextFielsd to the given String
     * @param name
     */
    public void setSelectedName(String name)
    {
        this.selectedName.setText(name);
        this.selectedName.setFont(mainFont);
       // revalidate();
        repaint();
    }
    
    /**
     *  updates the buttons in the selectedPanel JPanel
     * @param buttonName
     */
    public void updateSelectedPane(String buttonName)
   {
       Component[] components = this.selectedPanel.getComponents();
       ArrayList<JButton> buttons = new ArrayList<JButton>();
       for(Component c : components)
       {
           if(c instanceof JButton)
           {
               if(!c.getName().equals(buttonName))
               {
                    buttons.add((JButton) c);
               }     
           }
       }
        this.selectedPanel.removeAll();
        for(JButton b : buttons)
        {
           this.selectedPanel.add(Box.createRigidArea(new Dimension(0,20)));
           b.setText(b.getName());
           b.setFont(mainFont);
           b.setVisible(true);
           b.addActionListener(this);
           this.selectedPanel.add(b);


          //revalidate();
           repaint();
        }
   }
    
    /**
     *  sets the buttons to the selectedPane JPanel
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
     *  appends the given String to the battleTExt JTextArea
     * @param text
     * @throws InterruptedException
     */
    
   
    public void writeText(String text) throws InterruptedException
    {
     
        this.battleText.append(text);
    }
    
    
    
    /**
     *  sets the given String to the battleText JTextArea
     * @param text
     * @throws InterruptedException
     */
    public void setText(String text) throws InterruptedException
    {
        this.battleText.setText(text);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        animationPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        battleText = new javax.swing.JTextArea();
        buttonPanel = new javax.swing.JPanel();
        Attack = new javax.swing.JButton();
        Bag = new javax.swing.JButton();
        Run = new javax.swing.JButton();
        selectedName = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        animationPanel.setBackground(new java.awt.Color(102, 102, 102));
        animationPanel.setName("animationPanel"); // NOI18N
        animationPanel.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poo.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        animationPanel.add(jLabel2);
        jLabel2.setBounds(0, -10, 1310, 510);

        add(animationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 490));
        animationPanel.getAccessibleContext().setAccessibleName("animationPanel");

        selectedPanel.setBackground(new java.awt.Color(51, 51, 51));
        selectedPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selectedPanel.setForeground(new java.awt.Color(102, 0, 0));
        selectedPanel.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        selectedPanel.setName("selectedPanel"); // NOI18N
        selectedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane2.setViewportView(selectedPanel);
        selectedPanel.getAccessibleContext().setAccessibleName("selectedPanel");

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 50, 270, 800));

        battleText.setEditable(false);
        battleText.setBackground(new java.awt.Color(0, 0, 0));
        battleText.setColumns(20);
        battleText.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        battleText.setForeground(new java.awt.Color(255, 0, 0));
        battleText.setLineWrap(true);
        battleText.setRows(5);
        battleText.setWrapStyleWord(true);
        battleText.setName("battleText"); // NOI18N
        jScrollPane3.setViewportView(battleText);
        battleText.getAccessibleContext().setAccessibleName("battleText");

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 1310, 260));

        buttonPanel.setBackground(new java.awt.Color(102, 0, 0));
        buttonPanel.setName("buttonPanel"); // NOI18N

        Attack.setBackground(new java.awt.Color(0, 0, 0));
        Attack.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        Attack.setForeground(new java.awt.Color(255, 255, 255));
        Attack.setActionCommand("Attack");
        Attack.setLabel("Attack");
        Attack.setName("Attack"); // NOI18N

        Bag.setBackground(new java.awt.Color(0, 0, 0));
        Bag.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        Bag.setForeground(new java.awt.Color(255, 255, 255));
        Bag.setText("Bag");
        Bag.setName("Bag"); // NOI18N
        Bag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BagActionPerformed(evt);
            }
        });

        Run.setBackground(new java.awt.Color(0, 0, 0));
        Run.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        Run.setForeground(new java.awt.Color(255, 255, 255));
        Run.setText("Run");
        Run.setName("Run"); // NOI18N

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(Attack, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(Bag, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(Run, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(Bag, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(Attack, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(Run, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1310, 110));
        buttonPanel.getAccessibleContext().setAccessibleName("buttonPanel");

        selectedName.setEditable(false);
        selectedName.setBackground(new java.awt.Color(0, 0, 0));
        selectedName.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        selectedName.setForeground(new java.awt.Color(255, 0, 0));
        selectedName.setAutoscrolls(false);
        selectedName.setName("selectedName"); // NOI18N
        selectedName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedNameActionPerformed(evt);
            }
        });
        add(selectedName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 270, 50));
        selectedName.getAccessibleContext().setAccessibleName("selectedName");
    }// </editor-fold>//GEN-END:initComponents

    private void BagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BagActionPerformed

    private void selectedNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Attack;
    private javax.swing.JButton Bag;
    private javax.swing.JButton Run;
    private javax.swing.JPanel animationPanel;
    private javax.swing.JTextArea battleText;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField selectedName;
    private javax.swing.JPanel selectedPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
       
        JButton chosenButton = (JButton) e.getSource();
        //System.out.println(selectedName.getText());
        
        try {
           if(e.getSource().equals(Attack))
           {
               attacks = player.getAvailableAttacks();
            ArrayList<JButton> buttons = new ArrayList<JButton>();
            for(Attack a : attacks)
            {
                
                JButton b = new JButton();
                b.setName(a.getName());
                buttons.add(b);
                
            }
            setSelectedButtons(buttons);
            setSelectedName("Attacks");
           }
           else  if(e.getSource().equals(Bag))
           {
            this.selectedPanel.removeAll();
            items = player.getInventory();
            ArrayList<JButton> buttons = new ArrayList<JButton>();
            for(Item a : items)
            {
                
                JButton b = new JButton();
                //b.setName(a.getName());
                b.setName(a.getName() + " x " + a.getItemCount());
                buttons.add(b);
                
            }
            setSelectedButtons(buttons);
            setSelectedName("Bag");
           }
           
           else  if(e.getSource().equals(Run))
           {
               battle.run();
           }
           
           else  if(this.selectedName.getText().equals("Attacks"))
           {
               System.out.println("Attacks pressed");
               for(Attack a : battle.getAvailableAttacks())
               {
                   if(a.getName().equals(chosenButton.getName()))
                   {
                       
                       battle.pPreformAttack(a);
                   }
               }
           }
           
           else  if(this.selectedName.getText().equals("Bag"))
           {
               System.out.println(chosenButton.getText());
               for(Item i : battle.getHealing())
               {
                   if(chosenButton.getName().contains(i.getName()))
                   {
                      
                       battle.useAnItem(i);
                   }
               }
           }
           
           
           
//To change body of generated methods, choose Tools | Templates.
        } catch (InterruptedException ex) {
            Logger.getLogger(BattlePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
