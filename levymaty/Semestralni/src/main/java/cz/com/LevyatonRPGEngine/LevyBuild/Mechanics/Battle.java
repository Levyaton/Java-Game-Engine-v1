/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Mechanics;

/**
 *
 * @author czech
 */
import GameContainer.GameContainer;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Randomness;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import java.util.Scanner;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import cz.com.GameFiles.LevyBuild.customClasses.Items;
import java.util.ArrayList;
import cz.com.GameFiles.LevyBuild.customClasses.Attacks;
import cz.com.LevyatonRPGEngine.LevyBuild.Window.BattlePanel;

import cz.com.LevyatonRPGEngine.LevyBuild.Window.MainFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

/**
 *  a class containing the battle mechanic
 * 
 * @author czech
 */
 public class Battle{
    
    private boolean input = false;
    MainFrame mf;
    private Items items = new Items();
    private Randomness rand = new Randomness();
    private Specie enemy;
    private Player player;
    private Attack[] enemyAttacks;
    private ArrayList<Item> playerItems;
    private Object faster;
    private Object slower;
    private Boolean playerCanMove = true;
    private Boolean enemyCanMove = true;
    private int pImmobileCounter;
    private int eImmobileCounter;
    private boolean playerRan = false;
    private Bodypart[] equipment;
    private BattlePanel bp;
    private int pStr;
    private int pDef;
    private int pSpeed;
    private Double pLuck;
    private int eStr;
    private int eDef;
    private int eSpeed;
    private Double eLuck;
    private String eStrat;
    private boolean terminated = false;
   
    
    private int turnNumber = 1;
    
    private int pHealth;
    private int eHealth;
    private int enemyBlockedCounter = 0;
    private int playerBlockedCounter = 0;
    private Attack attackResponsableForPlayerBlock;
    private boolean selfImposedPlayerBlock;
    private Attack attackResponsableForEnemyBlock;
    private boolean selfImposedEnemyBlock;
    
    private Attacks attacks;
    
    private GameContainer gc;
   
    /**
     *  initializes and sets the battle parameters and values
     * @param getEnemy
     * @param getPlayer
     * @param m
     * @param gc
     * @throws InterruptedException
     * @throws IOException
     */
    public Battle(Specie getEnemy, Player getPlayer, MainFrame m, GameContainer gc, BattlePanel bp) throws InterruptedException, IOException
    {
        this.bp = bp;
        this.gc = gc;
        mf = m;
        enemy = getEnemy;
        player = getPlayer;
        enemyProperties();
        playerProperties();
        welcomeMessage(getEnemy.getName()); 
    }
   
   
    private void enemyProperties()
    {
        eStr = enemy.getStr();
        eDef = enemy.getDef();
        eSpeed = enemy.getSpeed();
        eLuck = enemy.getLuck();
        eHealth = enemy.getHP();
        enemyAttacks = enemy.getAttacks();
        this.enemyStrat();
        
    }
    
    private void playerProperties()
    {
        pStr = player.getStr();
        pDef = player.getDef();
        pSpeed = player.getSpeed();
        pLuck = player.getLuck();
        pHealth = player.getCurrentHealth();
        
        equipment = player.getEquipped();
        attacks = new Attacks(player.getMaxHealth(), pDef);
        playerItems = player.getInv().getHealingItems();
    }
    
    /**
     *  checks to see if the battle has ended by checking the player and enemy health. If ether is lower then 1, the battle ends and the the appropriate actions take place and it returns true. Otherwise, it returns false
     * @return
     * @throws InterruptedException
     */
    public boolean battleEnded() throws InterruptedException
    {
        if(pHealth<1)
        {
            bp.writeText("RIP, you got killed by a " + enemy.getName() + ". Try bragging about that to your friends! See what happens ;-)\n");
            terminated = true;
            player.setCurrentHealth(20);
            player.setWealth(player.getWealth()/2);
            /*
            for(int x = 0; x<5;x++)
            {
                player.getInv().removeItem(player.getInv().getInventory().get(rand.getRandomFromRange(0, player.getInv().getInventory().size()-1)));
            }   
            */
            mf.setResult(this.result());
            gc.setPlayer(player);
           
            return true;
            
        }
        else if(eHealth<1)
        {  
            bp.writeText("Yay, you have slain the " + enemy.getName()+ "!\n");
            getLoot();
            terminated = true;
            mf.setResult(this.result());
            gc.setPlayer(player);
           
            
            return true;
        }
        else if(terminated==true)
        {
            mf.setResult(this.result());
            gc.setPlayer(player);
            return true;
        }
        
        return false;
    }
    
    /**
     * returns true if the enemy has been defeated, otherwise it returns false
     * @return
     */
    public boolean result()
    {
        mf.showCard("overworld");
        if(eHealth<1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     *  starts the battle
     * @throws InterruptedException
     */
    public void doBattle() throws InterruptedException
    {
       turns();
    }
    
    /**
     *  decides on what moves the enemy will use
     */
    public void enemyStrat()
    {
        if(rand.success(0.01))
        {
            if(enemy.getFocus().toLowerCase().equals("aggresive"))
            {
                eStrat = "defensive";
            }
            else if(enemy.getFocus().toLowerCase().equals("defensive"))
            {
                eStrat = "aggressive";
            }         
        }
        else
        {
            eStrat = enemy.getFocus();
        }
        //writeText(eStrat);
    }
    
    /**
     *  returns the version of the player that was modified during the battle, allowing for an update outside of the battle
     * @return
     */
    public Player updatePlayer()
    {
        return this.player;
    }
    
    /**
     *  writes a welcome message
     * @param enemyName
     * @throws InterruptedException
     */
    public void welcomeMessage(String enemyName) throws InterruptedException
    {
        
        
        
        
        bp.writeText(player.getName() + " is attacked by" + AorAn(enemyName) + enemyName + "!\nThe battle has begun!");
        
        //Scanner sc = new Scanner(System.in);
        //String chosenAttack = sc.nextLine();
    }
    
    /**
     *  decides on weather or not a word is a vowel or consonant, then returns 'a' or 'an' correspondingly
     * @param getWord
     * @return
     */
    public String AorAn(String getWord)
    {
        String word = getWord.toLowerCase();
        char l = word.charAt(0);
        if(l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u' || l == 'y')
        {
            return " an ";
        }
        else
        {
            return " a ";
        }
    }
    
    /**
     *  gives the player the loot they won in the battle
     * @throws InterruptedException
     */
    public void getLoot() throws InterruptedException
    {
        String reward = "You got";
        Item[] possibleLoot = enemy.getLoot();
        ArrayList<Item> acctualLoot = new ArrayList<Item>();
        
        for(int x = 0;x<possibleLoot.length;x++)
        {
            if(rand.success(possibleLoot[x].getDropRate()))
            {
                acctualLoot.add(possibleLoot[x]);
                if(possibleLoot[x].getName().equals("Gold Coin"))
                {
                    player.setWealth(player.getWealth()+possibleLoot[x].getItemCount());
                }
                else
                {
                    player.addItemToInv(possibleLoot[x]);
                }
                
            }
        }
        for(Item item : acctualLoot)
        {
        
            if(acctualLoot.size()>1)
            {   
                if(acctualLoot.get(0).getName().equals(item.getName()))
                {
                    if(item.getName().equals("Gold Coin"))
                    {
                        if(item.getItemCount()>1)
                        {
                            reward += " " + item.getItemCount() + " Gold Coins";
                        }
                        else
                        {
                            reward += " a Gold Coin";
                        }
                    }
                    else
                    {
                       if(item.isCountable())
                       {
                        reward += AorAn(item.getName()) + item.getName();
                       }
                       else
                       {
                        reward += " some " + item.getName();
                       }
                    }
                }
                else if(acctualLoot.get(acctualLoot.size()-1).getName().equals(item.getName()))
                {
                    if(item.getName().equals("Gold Coin"))
                    {
                        if(item.getItemCount()>1)
                        {
                            reward += ", and " + item.getItemCount() + " Gold Coins";
                        }
                        else
                        {
                            reward += ", and a Gold Coin";
                        }
                    }
                    else
                    {
                       if(item.isCountable())
                       {
                        reward += ", and " + AorAn(item.getName()) + item.getName();
                       }
                       else
                       {
                        reward += ", and some " + item.getName();
                       }

                    }
                }
                else
                {
                    if(item.getName().equals("Gold Coin"))
                    {
                        if(item.getItemCount()>1)
                        {
                            reward += ", " + item.getItemCount() + " Gold Coins";
                        }
                        else
                        {
                            reward += ", a Gold Coin";
                        }
                    }
                    else
                    {
                       if(item.isCountable())
                       {
                        reward += "," + AorAn(item.getName()) + item.getName();
                       }
                       else
                       {
                        reward += ", some " + item.getName();
                       }
                    }
                }    

                }
            }
        
        bp.writeText(reward + ", great job!\n");
    }
    
     /**
     *  returns the terminated variable
     * @return
     */
    
    public boolean getTerminated()
    {
        return terminated;
    }
    
    /**
     *  decides on the order of the turns
     * @throws InterruptedException
     */
    public void turns() throws InterruptedException
    {
        if(pSpeed>eSpeed)
        {
            playerTurn();
            if(eHealth>0 && playerRan==false)
            {
                enemyTurn();
            }
            else
            {
                terminated = true;
            }
            
        }
        else if(pSpeed<eSpeed)
        {
            enemyTurn();
            if(pHealth>0)
            {
            playerTurn();
            }
            else
            {
                terminated = true;
            }
        }
        else
        {
            int f = rand.numberFromSequence(2);
            if(f == 0)
            {
                playerTurn();
                
                if(eHealth>0 && playerRan==false)
                {
                enemyTurn();
                }
                else
                {
                    terminated = true;
                }
            }
            else
            { 
                enemyTurn();
                if(pHealth>0)
                {
                    playerTurn();
                }
                else
                {
                    terminated = true;
                }
            }
        }   
    }
    
    /**
     *  returns an ArrayList of the currently available attacks the player has
     * @return
     */
    public ArrayList<Attack> getAvailableAttacks()
    {
        ArrayList<Attack> usableAttacks = player.getAvailableAttacks();
        
     
        return usableAttacks;
    }
  
    
    private Double pDamageCalculator(Attack attack)
    {
        int baseDamage = attack.getDamage();
        if(equipment[1] == equipment[2])
        {
            baseDamage = attack.getDamage()*2 + attack.getDamage()/2;
            
        }
        int modefiedDamage = baseDamage + pStr;
        int randDamage = rand.getRandomFromRange(modefiedDamage/10, modefiedDamage/10 + 5);
        Double defense = (eDef+10)/5.0;
        Double trueDamage = (int) (modefiedDamage+randDamage)/defense;
        return trueDamage;
    
    }
    
  
   private void pDealDamage(Attack attack) throws InterruptedException
    {
        if(attack.getDamage() > 0)
        {
            if(rand.success(pLuck))
            {
            eHealth = (int) Math.round(eHealth - pDamageCalculator(attack)*1.6 + 0.5);
            bp.writeText("By the messy beard of Odin, you landed a critical hit!\n");
            bp.writeText(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)*1.6+0.5) + " points of damage to " + enemy.getName()+ "\n");
            }
            else
            {
            eHealth = (int) Math.round(eHealth - pDamageCalculator(attack));
            bp.writeText(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)+0.5) + " points of damage to " + enemy.getName()+ "\n");
            }
        }
        if(attack.getDamage() < 0)
        {
            pHealth = pHealth + attack.getDamage();
            bp.writeText(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)+0.5) + " points of damage to themselves\n");
        }
    }
    
   
    private void printStatChange(int modefier, String statName) throws InterruptedException
    {
        if(modefier > 0)
        {
            bp.writeText(player.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
            bp.writeText(player.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }

    private void printStatChange(Double modefier, String statName) throws InterruptedException
    {
        if(modefier > 0)
        {
            bp.writeText(player.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
           bp.writeText(player.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
        
       
    }
    
   
    private void pApplyAttackEffects(Attack attack) throws InterruptedException
    {     
        if(attack.hasEffect())
        {
            
            //writeText(attack.getName() + "\n" + attack.hasEffect());
            pStr += attack.getStrMod();
            printStatChange(attack.getStrMod(), "Strength");
            if(pStr>player.getStr() + 20)
            {
                pStr = player.getStr() + 20;
                bp.writeText(player.getName() + "'s strength can't get any higher, it's maxed out!"+ "!\n");
            }
       
            pDef += attack.getDefMod();
            printStatChange(attack.getDefMod(), "Defense");
            if(pDef>player.getDef() + 20)
            {  
                pDef = player.getDef() + 20;
                bp.writeText(player.getName() + "'s defense can't get any higher, it's maxed out!"+ "!\n");
            }
            
            pSpeed += attack.getSpeedMod();
            printStatChange(attack.getSpeedMod(), "Speed");
            if(pSpeed > player.getSpeed() + 20)
            {
                pSpeed = player.getSpeed() + 20;
                bp.writeText(player.getName() + "'s speed can't get any higher, it's maxed out!"+ "!\n");
            }
            
            pLuck += attack.getLuckMod();
            printStatChange(attack.getLuckMod(), "Luck");
            if(pLuck > 0.9)
            {
                pLuck = 0.9;
                bp.writeText(player.getName() + "'s luck can't get any higher, it's maxed out!"+ "!\n");
            }
            pHealth += attack.getHpMod();
            printStatChange(attack.getHpMod(), "Health Point's");
            if(pHealth>player.getMaxHealth())
            {
                pHealth = player.getMaxHealth();
                bp.writeText(player.getName() + "'s health can't go any higher, it's maxed out!"+ "!\n");
            }
           
        }
        
        if(attack.enemyCanMove()==false && enemyCanMove)
        {
            
            enemyCanMove = false;
            enemyBlockedCounter = attack.getEBlockLength();
            //writeText(enemyBlockedCounter);
            this.attackResponsableForEnemyBlock = attack;
            bp.writeText(player.getName() + attack.getBlockedText()[0]+ "!\n");
        }
        else if(attack.enemyCanMove()==false &&  enemyCanMove == false)
        {
            
            bp.writeText(player.getName() + attack.getBlockedText()[2]+ "!\n");
        }
        
    }

    /**
     *  makes the user use the their chosen attack
     * @param attack
     * @throws InterruptedException
     */
    public void pPreformAttack(Attack attack) throws InterruptedException
    {
        if(terminated==false)
        {
           
            if(attack.getTurnLength()<2)
            {
            pDealDamage(attack);
            pApplyAttackEffects(attack);
            }
            else
            {
                //writeText("Here, yo");
                playerCanMove = false;
                attackResponsableForPlayerBlock = attack;
                selfImposedPlayerBlock = true;
                playerBlockedCounter = attack.getTurnLength();
                bp.writeText(player.getName() + attack.getBlockedText()[0]+ "!\n");

            }
            if(!battleEnded())
            {
                enemyTurn();
            }
        }
        
    }
    
    
    
   /* public int playerDecision() throws InterruptedException
    {
        
        int option;
        while(true)
        {  
            try
            {
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if(option==1 || option==2 || option==3)
                {
                    return option;
                }
            }
            catch(Exception p)
            {
            writeText("Sorry, I couldn't quite catch that. Please enter the number of your chosen option" + "!\n");
            }
        }
    }
    */

    /**
     *  checks to see if the player successfully escaped the enemy
     * @throws InterruptedException
     */

    public void run() throws InterruptedException
    {
        if(terminated == false)
        {
            Double chance;
            if(pSpeed>(3/2)*eSpeed)
            {
                chance = 0.9;
            }
            else
            {
                chance = (2*pSpeed/(eSpeed*1.0));
            }
            if(rand.success(chance))
            {
                bp.writeText("You successfully escabed the " + enemy.getName() + "!\n");
                terminated = true;
                mf.setResult(result());
              
            }
            else
            {
                bp.writeText("In a valiant effort to escape the " + enemy.getName()+ ", you have been caught off guard by you persuer! You couldn't escape.\n");
                this.turnNumber++;
                enemyTurn();
            }
        }
        
    }
    
    /**
     *  returns an ArrayList of the players current healing items
     * @return
     */
    public ArrayList<Item> getHealing()
    {
        
        return player.getInv().getHealingItems();
    }
    
    /**
     *  causes the player to use their chosen item
     * @param chosenItem
     * @throws InterruptedException
     */
    public void useAnItem(Item chosenItem) throws InterruptedException//Does not work
    {
        
        for(Item item : items.getHealingItems())
        {
            if(item.getName().equals(chosenItem.getName()))
            {
               bp.writeText("Used " + chosenItem.getName());
               this.pHealth += item.getGain();
               bp.writeText(Integer.toString(chosenItem.getItemCount()));
               player.getInv().decrementItem(item);
               printStatChange(item.getGain(), "Health Points");
               if(pHealth > player.getMaxHealth())
               {
                   bp.writeText(player.getName() + "'s health can't go any higher, it's maxed out!"+ "\n");
                   pHealth = player.getMaxHealth();
               }
               bp.writeText(player.getName() + " used a " + chosenItem.getName() + " \n");
               this.turnNumber++;
               enemyTurn();
               break;
            }
        }
    }
    
    /**
     *  writes "What would you like to do?\n"
     * @throws InterruptedException
     */
    public void attackRunHeal() throws InterruptedException
    {
        bp.writeText("What would you like to do?\n");
    }
    
   
    
    /**
     *  decides on weather or not the player gets to have any input on their turn
     * @throws InterruptedException
     */
    public void playerTurn() throws InterruptedException
    {
        
        if(terminated == false)
        {
             bp.writeText(player.getName()+ "'s turn!\n");

             bp.writeText("Turn number " + turnNumber + "\n");
             bp.writeText(player.getName()+ "'s health is at:  " + this.pHealth + " out of " + player.getMaxHealth()+ "\n");
             bp.writeText(enemy.getName()+ "'s health is at:  " + this.eHealth + " out of " + enemy.getHP()+ "\n");
            /*writeText(player.getName() + "'s block counter is at " + this.playerBlockedCounter);
            if(playerBlockedCounter>0)
            {
                writeText(this.attackResponsableForPlayerBlock.getName());
            }
            */
            if(playerCanMove)
            {
               attackRunHeal();
            }
            else
            {
                playerBlockedCounter--;
                if(playerBlockedCounter == 0 && selfImposedPlayerBlock == true)
                {
                   bp.writeText(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[2]+ "\n");
                   pDealDamage(attackResponsableForPlayerBlock);
                   pApplyAttackEffects(attackResponsableForPlayerBlock);
                   playerCanMove = true; 

                }
                else if (playerBlockedCounter == 0 && selfImposedPlayerBlock == false)
                {
                    playerCanMove=true;
                     bp.writeText(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[3]+ "\n");
                }
                else
                {
                     //writeText(this.attackResponsableForPlayerBlock.getName());
                     bp.writeText(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[1]+ "\n");
                }    
                turnNumber++;
                if(!battleEnded())
                {
                    enemyTurn();
                }
            }
        }
        
        //Scanner sc = new Scanner(System.in);
        //String chosenAttack = sc.nextLine();
    }
    
    //ENEMY TURN

    private Double eDamageCalculator(Attack attack)
    {
        int baseDamage = attack.getDamage();
        int modefiedDamage = baseDamage*2 + enemy.getStr();
        int randDamage = rand.getRandomFromRange(modefiedDamage/10, modefiedDamage/10 + 5);
        Double defense = (pDef + 10)/5.0;
        Double trueDamage = (modefiedDamage+randDamage)/defense;
        return trueDamage;
    
    }
    
   
    private void eDealDamage(Attack attack) throws InterruptedException
    {
        if(attack.getDamage() > 0)
        {
            if(rand.success(eLuck))
            {
            pHealth = (int) Math.round(pHealth - eDamageCalculator(attack)*1.6 + 0.5);
             bp.writeText("Awww snap, the " + enemy.getName() + " landed a critical hit!\n");
             bp.writeText("The " + enemy.getName()+ " delt " + (int) Math.round(eDamageCalculator(attack)*1.6+0.5) + " points of damage to " + player.getName()+ ", did it hurt?\n");
            }
            else
            {
            pHealth = (int) Math.round(pHealth - eDamageCalculator(attack));
             bp.writeText("The " + enemy.getName()+ " delt " + (int) Math.round(eDamageCalculator(attack)+0.5) + " points of damage to " + player.getName()+ "\n");
            }
        }
        if(attack.getDamage() < 0)
        {
            pHealth = pHealth + attack.getDamage();
            bp. writeText(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)+0.5) + " points of damage to themselves\n");
        }
    }
    
    
    private void eprintStatChange(int modefier, String statName) throws InterruptedException
    {
        if(modefier > 0)
        {
             bp.writeText("The " + enemy.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
             bp.writeText("The " + enemy.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }
    
   
    private void eprintStatChange(Double modefier, String statName) throws InterruptedException
    {
        if(modefier > 0)
        {
             bp.writeText(player.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
             bp.writeText(player.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }
    
   
    private void eApplyAttackEffects(Attack attack) throws InterruptedException
    {     
        if(attack.hasEffect())
        {
            eStr += attack.getStrMod();
            eprintStatChange(attack.getStrMod(), "Strength");
            if(eStr>enemy.getStr() + 20)
            {
                eStr = enemy.getStr() + 20;
                 bp.writeText(enemy.getName() + "'s strength can't go any higher, it's maxed out!"+ "\n");
            }
            eDef += attack.getDefMod();
            eprintStatChange(attack.getDefMod(), "Defense");
            if(eDef>enemy.getDef() + 20)
            {
                eDef = enemy.getDef() + 20;
                 bp.writeText(enemy.getName() + "'s defense can't go any higher, it's maxed out!"+ "\n");
            }
            eSpeed += attack.getSpeedMod();
            eprintStatChange(attack.getSpeedMod(), "Speed");
            if(eSpeed>enemy.getSpeed() + 20)
            {
                eSpeed = enemy.getSpeed() + 20;
                 bp.writeText(enemy.getName() + "'s speed can't go any higher, it's maxed out!"+ "\n");
            }
            eLuck += attack.getLuckMod();
            eprintStatChange(attack.getLuckMod(), "Luck");
            if(eLuck>0.9)
            {
                eLuck = 0.9;
                 bp.writeText(enemy.getName() + "'s luck can't go any higher, it's maxed out!"+ "\n");
            }
            eHealth += attack.getHpMod();
            eprintStatChange(attack.getHpMod(), "Health Point's");
            if(eHealth>enemy.getHP())
            {
                eHealth = enemy.getHP();
                 bp.writeText(enemy.getName() + "'s health can't go any higher, it's maxed out!"+ "\n");
            }
        }
        
        if(attack.enemyCanMove()==false && playerCanMove)
        {
            playerCanMove = false;
 
            playerBlockedCounter = attack.getEBlockLength();
            attackResponsableForPlayerBlock = attack;
             bp.writeText("The " + enemy.getName() + attack.getBlockedText()[0]+ "\n");
        }
        else if(attack.enemyCanMove()==false &&  playerCanMove == false)
        {
             bp.writeText(("The " + enemy.getName() + attack.getBlockedText()[2])+ "\n");
            
        }
    }
    
  
    private void ePreformAttack(Attack attack) throws InterruptedException
    {
        if(attack.getTurnLength()<2)
        {
            eDealDamage(attack);
            eApplyAttackEffects(attack);
            
            levelAttack(attack);
           
        }
        else
        {
            enemyCanMove = false;
            attackResponsableForEnemyBlock = attack;
            selfImposedEnemyBlock = true;
            enemyBlockedCounter = attack.getTurnLength();
             bp.writeText("The "+ enemy.getName() + attack.getBlockedText()[0]+ "\n"+ "\n");
        }
         if(!battleEnded())
         {
            playerTurn();
         }
    }
   
   
    private boolean maxed(Attack attack)
    {
        if(attack.hasEffect()==false)
        {
            return false;
        }
        if(attack.getStrMod()>0)
        {
            if(this.eStr >= enemy.getStr() + 20)
            {
                return true;
            }
        }
        if(attack.getDefMod()>0)
        {
            if(this.eDef >= enemy.getDef() + 20)
            {
                return true;
            }
        }
        if(attack.getHpMod()>0)
        {
            if(this.eHealth >= enemy.getHP())
            {
                return true;
            }
        }
        if(attack.getSpeedMod()>0)
        {
            if(this.eSpeed >= enemy.getSpeed() + 20)
            {
                return true;
            }
        }
        if(attack.getLuckMod()>0)
        {
            if(this.eLuck >= 0.9)
            {
                return true;
            }
        }
        return false;
        
    }
    
   
    private Attack enemyChoosenAttack()
    {
            ArrayList<Attack> mostUsed = new ArrayList<Attack>();
            ArrayList<Attack> lessUsed = new ArrayList<Attack>();
            ArrayList<Attack> rare = new ArrayList<Attack>();
            
            Double bestOdds = 0.6;
            Double lesserOdds = 0.9;
            
            
            if(eStrat.toLowerCase().equals("defensive"))
            {
                for(Attack attack : enemyAttacks)
                {
                    if(attack.hasEffect()==true)
                    {
                        if(this.maxed(attack) == false)
                        {
                            mostUsed.add(attack);
                        }
                    }
                    else
                    {
                        if(attack.enemyCanMove() == false)
                        {
                            if(this.maxed(attack) == false)
                            {
                                lessUsed.add(attack);
                            }
                        }
                        else
                        {
                            if(this.maxed(attack) == false)
                            {
                                rare.add(attack);
                            }
                        }
                    }
                }   
            }
            else if(eStrat.toLowerCase().equals("aggresive"))
            {
                for(Attack attack : enemyAttacks)
                {
                    if(attack.getDamage()>0 && attack.characterCanMove()==true)
                    {
                        if(this.maxed(attack) == false)
                        {
                            mostUsed.add(attack);
                        }
                    }
                    else
                    {
                        if(attack.getDamage()>0 || attack.getStrMod()>0)
                        {
                            if(this.maxed(attack) == false)
                            {
                                lessUsed.add(attack);
                            }
                        }
                        else
                        {
                            if(this.maxed(attack) == false)
                            {
                            rare.add(attack);
                            }
                        }
                    }
                }   
            }
            else
            {
               return enemyAttacks[rand.getRandomObjectFromSelection(enemyAttacks)];
            }
            
            if(mostUsed.size()<1 && lessUsed.size()<1 && rare.size()<1)
            {
                return enemyAttacks[rand.getRandomObjectFromSelection(enemyAttacks)];
            }
            
            ArrayList<ArrayList<Attack>> attacks = new ArrayList<ArrayList<Attack>>();
            attacks.add(mostUsed);
            attacks.add(lessUsed);
            attacks.add(rare);
            
            ArrayList<Attack> chosenTier = new ArrayList<Attack>();
            while(chosenTier.size()<1)
            {
               chosenTier = attacks.get(rand.choiceOfThree(bestOdds, lesserOdds));
            }
            Attack chosen = chosenTier.get(rand.getRandomFromRange(0, chosenTier.size()-1));
            return chosen;
    }
   
    
    
    private void levelAttack(Attack attack) throws InterruptedException
    {
        int level = attack.getLevel();
        player.levelAttack(attack, attack.getExpTotal()/100 + 2*enemy.getStr() + 2*enemy.getDef() + 2*enemy.getSpeed() + 2*enemy.getHP());
        if(level<attack.getLevel())
        {
            if(level == 1)
            {
                bp.writeText("Congratulations! You just learned how to use the move " + attack.getName() + "! You can use it while wearing the right equipment\n");
            }
 
            else if (attack.getName().equals("Do nothing"))
            {
               bp.writeText("All of you observationand hard work has paid of! By using and watching your enemies do nothing, you have improved your own performance! " + attack.getName() + " has leveled up\n");
            }
            else
            {
               bp.writeText("All of you observation and hard work has paid of! By using and watching your enemies use the move " + attack.getName() + ", you have improved your own performance! " + attack.getName() + " has leveled up\n");
            }
        }
    }
    private void enemyTurn() throws InterruptedException
    {
        if(terminated==false)
        {
            bp. writeText(enemy.getName()+ "'s turn!\n");
            if(enemyCanMove)
            {
               Attack chosenAttack = this.enemyChoosenAttack();
                bp.writeText("The " + enemy.getName()+ " used "+ chosenAttack.getName()+ "\n");
                ePreformAttack(chosenAttack);
                levelAttack(chosenAttack);
               
               
            }
            else
            {   
                enemyBlockedCounter--;
                if(enemyBlockedCounter == 0 && selfImposedEnemyBlock == true)
                {
                    //writeText("I got here");
                    //writeText( attackResponsableForPlayerBlock.getBlockedText()[2]);
                    bp.writeText("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[2]+ "\n");
                   eDealDamage(attackResponsableForEnemyBlock);
                   eApplyAttackEffects(attackResponsableForEnemyBlock);
                   enemyCanMove = true;
                   levelAttack(attackResponsableForEnemyBlock);
                }
                else if (enemyBlockedCounter == 0 && selfImposedEnemyBlock == false)
                {
                    //writeText("playerBlockedCounter == 0 && selfImposedPlayerBlock == false");
                    //writeText(attackResponsableForEnemyBlock.getName());
                    //writeText("Here");
                    enemyCanMove=true;
                    bp.writeText("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[3]+ "\n");
                }
                else
                {
                    bp.writeText("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[1]+ "\n");
                }
            }
            if(battleEnded()==false)
            {
                playerTurn();
            }
        }
    }
        
}
    
    
    
    


    
    
    
    
    
    
    
