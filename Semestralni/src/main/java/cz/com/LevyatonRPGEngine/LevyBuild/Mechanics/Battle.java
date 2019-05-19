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
import cz.com.LevyatonRPGEngine.LevyBuild.Window.MainFrame;


public class Battle{
    
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
    
    
    public void testString() throws InterruptedException
    {
       write("This is a test");
    }
    
    
    public void write(String text) throws InterruptedException
    {
        MainFrame.writeBattleText(text);
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
    
    public Battle(Specie getEnemy, Player getPlayer) throws InterruptedException
    {
       
        enemy = getEnemy;
        player = getPlayer;
        enemyProperties();
        playerProperties();
        welcomeMessage(getEnemy.getName());
       
    }
    
    
    public boolean battleEnded() throws InterruptedException
    {
        if(pHealth<1)
        {
            write("RIP, you got killed by a " + enemy.getName() + ". Try bragging about that to your friends! See what happens ;-)\n");
            terminated = true;
            return true;
        }
        else if(eHealth<1)
        {  
            write("Yay, you have slain the " + enemy.getName()+ "!\n");
            getLoot();
            terminated = true;
            return true;
        }
        
        return false;
    }
    
    public void doBattle() throws InterruptedException
    {
       turns();
    }
    
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
        //write(eStrat);
    }
    
    
    public Player updatePlayer()
    {
        return this.player;
    }
    
    public void welcomeMessage(String enemyName) throws InterruptedException
    {
        
        
        
        
        write(player.getName() + " is attacked by" + AorAn(enemyName) + enemyName + "!\nThe battle has begun!");
        
        //Scanner sc = new Scanner(System.in);
        //String chosenAttack = sc.nextLine();
    }
    
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
        
        write(reward + ", great job!\n");
    }
    
    public void turns() throws InterruptedException
    {
        if(pSpeed>eSpeed)
        {
            playerTurn();
            if(eHealth>0 && playerRan==false)
            {
            enemyTurn();
            }
        }
        else if(pSpeed<eSpeed)
        {
            enemyTurn();
            if(pHealth>0)
            {
            playerTurn();
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
            }
            else
            { 
                enemyTurn();
                if(pHealth>0)
                {
                playerTurn();
                }
            }
        }
            
          
    }
    
    public void chooseAttack() throws InterruptedException
    {
        ArrayList<Attack> usableAttacks = player.getAvailableAttacks();
        write("Please enter the number of you're chosen attack, or type 'back' to return to the action selection\n");
        while(true)
        {   
            attackWriter();
            Scanner sc = new Scanner(System.in);
            String chosenAttack = sc.nextLine();
            try
            {
                Attack chosen = usableAttacks.get(Integer.parseInt(chosenAttack)-1);
                String testName = chosen.getName();
                
                write("You used " + chosen.getName()+ "\n");
                pPreformAttack(chosen);
                player.levelAttack(chosen,  chosen.getExpTotal()/1000 + enemy.getStr() + enemy.getDef() + enemy.getSpeed() + enemy.getHP());
                break;
            }
            catch(Exception p)
            {
                if(chosenAttack.toLowerCase().equals("back"))
                {
                    attackRunHeal();
                    break;
                }
                else
                {
                write("\nChosen attack does not exist, please reenter the number of your chosen attack: \n");
                }
            }
        }
    }
    
    
    
    public ArrayList<Attack> getAvailableAttacks()
    {
        ArrayList<Attack> usableAttacks = player.getAvailableAttacks();
        
     
        return usableAttacks;
    }
    
    public void attackWriter() throws InterruptedException
    {
        ArrayList<Attack> usableAttacks = player.getAvailableAttacks();
        write("Your attacks are: \n");
        for(int x = 0; x<usableAttacks.size();x++)
        {
            if(!usableAttacks.get(x).equals(attacks.getEmptyAttack()))
            {
                write("Attack " + (x+1) + ":   " + usableAttacks.get(x).getName() + "\n");
            }
        }
        write("Back\n");
    }
    
    public Double pDamageCalculator(Attack attack)
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
    
    public void pDealDamage(Attack attack) throws InterruptedException
    {
        if(attack.getDamage() > 0)
        {
            if(rand.success(pLuck))
            {
            eHealth = (int) Math.round(eHealth - pDamageCalculator(attack)*1.6 + 0.5);
            write("By the messy beard of Odin, you landed a critical hit!\n");
            write(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)*1.6+0.5) + " points of damage to " + enemy.getName()+ "\n");
            }
            else
            {
            eHealth = (int) Math.round(eHealth - pDamageCalculator(attack));
            write(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)+0.5) + " points of damage to " + enemy.getName()+ "\n");
            }
        }
        if(attack.getDamage() < 0)
        {
            pHealth = pHealth + attack.getDamage();
            write(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)+0.5) + " points of damage to themselves\n");
        }
    }
    
    public void printStatChange(int modefier, String statName) throws InterruptedException
    {
        if(modefier > 0)
        {
            write(player.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
            write(player.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }
    
    public void printStatChange(Double modefier, String statName) throws InterruptedException
    {
        if(modefier > 0)
        {
            write(player.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
           write(player.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
        
       
    }
    
    public void pApplyAttackEffects(Attack attack) throws InterruptedException
    {     
        if(attack.hasEffect())
        {
            
            //write(attack.getName() + "\n" + attack.hasEffect());
            pStr += attack.getStrMod();
            printStatChange(attack.getStrMod(), "Strength");
            if(pStr>player.getStr() + 20)
            {
                pStr = player.getStr() + 20;
                write(player.getName() + "'s strength can't get any higher, it's maxed out!"+ "!\n");
            }
       
            pDef += attack.getDefMod();
            printStatChange(attack.getDefMod(), "Defense");
            if(pDef>player.getDef() + 20)
            {  
                pDef = player.getDef() + 20;
                write(player.getName() + "'s defense can't get any higher, it's maxed out!"+ "!\n");
            }
            
            pSpeed += attack.getSpeedMod();
            printStatChange(attack.getSpeedMod(), "Speed");
            if(pSpeed > player.getSpeed() + 20)
            {
                pSpeed = player.getSpeed() + 20;
                write(player.getName() + "'s speed can't get any higher, it's maxed out!"+ "!\n");
            }
            
            pLuck += attack.getLuckMod();
            printStatChange(attack.getLuckMod(), "Luck");
            if(pLuck > 0.9)
            {
                pLuck = 0.9;
                write(player.getName() + "'s luck can't get any higher, it's maxed out!"+ "!\n");
            }
            pHealth += attack.getHpMod();
            printStatChange(attack.getHpMod(), "Health Point's");
            if(pHealth>player.getMaxHealth())
            {
                pHealth = player.getMaxHealth();
                write(player.getName() + "'s health can't go any higher, it's maxed out!"+ "!\n");
            }
           
        }
        
        if(attack.enemyCanMove()==false && enemyCanMove)
        {
            
            enemyCanMove = false;
            enemyBlockedCounter = attack.getEBlockLength();
            //write(enemyBlockedCounter);
            this.attackResponsableForEnemyBlock = attack;
            write(player.getName() + attack.getBlockedText()[0]+ "!\n");
        }
        else if(attack.enemyCanMove()==false &&  enemyCanMove == false)
        {
            
            write(player.getName() + attack.getBlockedText()[2]+ "!\n");
        }
        
    }
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
                //write("Here, yo");
                playerCanMove = false;
                attackResponsableForPlayerBlock = attack;
                selfImposedPlayerBlock = true;
                playerBlockedCounter = attack.getTurnLength();
                write(player.getName() + attack.getBlockedText()[0]+ "!\n");

            }
            if(!battleEnded())
            {
                enemyTurn();
            }
        }
        
    }
    
    
    
    public int playerDecision() throws InterruptedException
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
            write("Sorry, I couldn't quite catch that. Please enter the number of your chosen option" + "!\n");
            }
        }
    }
    
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
            write("You successfully escabed the " + enemy.getName() + "!\n");
            terminated = true;
        }
        else
        {
            write("In a valiant effort to escape the " + enemy.getName()+ ", you have been caught off guard by you persuer! You couldn't escape.\n");
            this.turnNumber++;
            enemyTurn();
        }
        }
        
    }
    
    public ArrayList<Item> getHealing()
    {
        
        return player.getInv().getHealingItems();
    }
    
    public void useAnItem(Item chosenItem) throws InterruptedException//Does not work
    {
        
        for(Item item : items.getHealingItems())
        {
            if(item.getName().equals(chosenItem.getName()))
            {
               System.out.println("Used " + chosenItem.getName());
               this.pHealth += item.getGain();
               System.out.println(chosenItem.getItemCount());
               player.getInv().decrementItem(item);
               printStatChange(item.getGain(), "Health Points");
               if(pHealth > player.getMaxHealth())
               {
                   write(player.getName() + "'s health can't go any higher, it's maxed out!"+ "\n");
                   pHealth = player.getMaxHealth();
               }
               write(player.getName() + " used a " + chosenItem.getName() + " \n");
               this.turnNumber++;
               enemyTurn();
               break;
            }
        }
    }
    
    public void attackRunHeal() throws InterruptedException
    {
        write("What would you like to do?\n");
        MainFrame.panelShower("battle");
    }
    
    public void playerTurn() throws InterruptedException
    {
        if(terminated = false)
        {
            write(player.getName()+ "'s turn!\n");

            write("Turn number " + turnNumber + "\n");
            write(player.getName()+ "'s health is at:  " + this.pHealth + " out of " + player.getMaxHealth()+ "\n");
            write(enemy.getName()+ "'s health is at:  " + this.eHealth + " out of " + enemy.getHP()+ "\n");
            /*write(player.getName() + "'s block counter is at " + this.playerBlockedCounter);
            if(playerBlockedCounter>0)
            {
                write(this.attackResponsableForPlayerBlock.getName());
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
                  write(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[2]+ "\n");
                   pDealDamage(attackResponsableForPlayerBlock);
                   pApplyAttackEffects(attackResponsableForPlayerBlock);
                   playerCanMove = true; 

                }
                else if (playerBlockedCounter == 0 && selfImposedPlayerBlock == false)
                {
                    playerCanMove=true;
                    write(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[3]+ "\n");
                }
                else
                {
                    //write(this.attackResponsableForPlayerBlock.getName());
                    write(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[1]+ "\n");
                }

            }
            turnNumber++;
            if(!battleEnded())
            {
                enemyTurn();
            }
        }
        
        //Scanner sc = new Scanner(System.in);
        //String chosenAttack = sc.nextLine();
    }
    
    //ENEMY TURN
    
     public Double eDamageCalculator(Attack attack)
    {
        int baseDamage = attack.getDamage();
        int modefiedDamage = baseDamage*2 + enemy.getStr();
        int randDamage = rand.getRandomFromRange(modefiedDamage/10, modefiedDamage/10 + 5);
        Double defense = (pDef + 10)/5.0;
        Double trueDamage = (modefiedDamage+randDamage)/defense;
        return trueDamage;
    
    }
    
    public void eDealDamage(Attack attack) throws InterruptedException
    {
        if(attack.getDamage() > 0)
        {
            if(rand.success(eLuck))
            {
            pHealth = (int) Math.round(pHealth - eDamageCalculator(attack)*1.6 + 0.5);
            write("Awww snap, the " + enemy.getName() + " landed a critical hit!\n");
            write("The " + enemy.getName()+ " delt " + (int) Math.round(eDamageCalculator(attack)*1.6+0.5) + " points of damage to " + player.getName()+ ", did it hurt?\n");
            }
            else
            {
            pHealth = (int) Math.round(pHealth - eDamageCalculator(attack));
            write("The " + enemy.getName()+ " delt " + (int) Math.round(eDamageCalculator(attack)+0.5) + " points of damage to " + player.getName()+ "\n");
            }
        }
        if(attack.getDamage() < 0)
        {
            pHealth = pHealth + attack.getDamage();
            write(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)+0.5) + " points of damage to themselves\n");
        }
    }
    
    public void eprintStatChange(int modefier, String statName) throws InterruptedException
    {
        if(modefier > 0)
        {
            write("The " + enemy.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
            write("The " + enemy.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }
    
    public void eprintStatChange(Double modefier, String statName) throws InterruptedException
    {
        if(modefier > 0)
        {
            write(player.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
            write(player.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }
    
    
    public void eApplyAttackEffects(Attack attack) throws InterruptedException
    {     
        if(attack.hasEffect())
        {
            eStr += attack.getStrMod();
            eprintStatChange(attack.getStrMod(), "Strength");
            if(eStr>enemy.getStr() + 20)
            {
                eStr = enemy.getStr() + 20;
                write(enemy.getName() + "'s strength can't go any higher, it's maxed out!"+ "\n");
            }
            eDef += attack.getDefMod();
            eprintStatChange(attack.getDefMod(), "Defense");
            if(eDef>enemy.getDef() + 20)
            {
                eDef = enemy.getDef() + 20;
                write(enemy.getName() + "'s defense can't go any higher, it's maxed out!"+ "\n");
            }
            eSpeed += attack.getSpeedMod();
            eprintStatChange(attack.getSpeedMod(), "Speed");
            if(eSpeed>enemy.getSpeed() + 20)
            {
                eSpeed = enemy.getSpeed() + 20;
                write(enemy.getName() + "'s speed can't go any higher, it's maxed out!"+ "\n");
            }
            eLuck += attack.getLuckMod();
            eprintStatChange(attack.getLuckMod(), "Luck");
            if(eLuck>0.9)
            {
                eLuck = 0.9;
                write(enemy.getName() + "'s luck can't go any higher, it's maxed out!"+ "\n");
            }
            eHealth += attack.getHpMod();
            eprintStatChange(attack.getHpMod(), "Health Point's");
            if(eHealth>enemy.getHP())
            {
                eHealth = enemy.getHP();
                write(enemy.getName() + "'s health can't go any higher, it's maxed out!"+ "\n");
            }
        }
        
        if(attack.enemyCanMove()==false && playerCanMove)
        {
            playerCanMove = false;
 
            playerBlockedCounter = attack.getEBlockLength();
            attackResponsableForPlayerBlock = attack;
            write("The " + enemy.getName() + attack.getBlockedText()[0]+ "\n");
        }
        else if(attack.enemyCanMove()==false &&  playerCanMove == false)
        {
            write(("The " + enemy.getName() + attack.getBlockedText()[2])+ "\n");
            
        }
    }
    
    public void ePreformAttack(Attack attack) throws InterruptedException
    {
        if(attack.getTurnLength()<2)
        {
            eDealDamage(attack);
            eApplyAttackEffects(attack);
            player.levelAttack(attack, attack.getExpTotal()/100 + 2*enemy.getStr() + 2*enemy.getDef() + 2*enemy.getSpeed() + 2*enemy.getHP());
           
        }
        else
        {
            enemyCanMove = false;
            attackResponsableForEnemyBlock = attack;
            selfImposedEnemyBlock = true;
            enemyBlockedCounter = attack.getTurnLength();
            write("The "+ enemy.getName() + attack.getBlockedText()[0]+ "\n"+ "\n");
        }
         if(!battleEnded())
         {
            playerTurn();
         }
    }
   
    public boolean maxed(Attack attack)
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
    
    public Attack enemyChoosenAttack()
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
    
    
    
    public void enemyTurn() throws InterruptedException
    {
        if(terminated==false)
        {
            write(enemy.getName()+ "'s turn!\n");
            if(enemyCanMove)
            {
               Attack chosenAttack = this.enemyChoosenAttack();
               write("The " + enemy.getName()+ " used "+ chosenAttack.getName()+ "\n");
               ePreformAttack(chosenAttack);
               player.levelAttack(chosenAttack, chosenAttack.getExpTotal()/100 + 2*enemy.getStr() + 2*enemy.getDef() + 2*enemy.getSpeed() + 2*enemy.getHP());
            }
            else
            {   
                enemyBlockedCounter--;
                if(enemyBlockedCounter == 0 && selfImposedEnemyBlock == true)
                {
                    //write("I got here");
                    //write( attackResponsableForPlayerBlock.getBlockedText()[2]);
                   write("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[2]+ "\n");
                   eDealDamage(attackResponsableForEnemyBlock);
                   eApplyAttackEffects(attackResponsableForEnemyBlock);
                   enemyCanMove = true;
                   player.levelAttack(attackResponsableForEnemyBlock,attackResponsableForEnemyBlock.getExpTotal()/100 + 2*enemy.getStr() + 2*enemy.getDef() + 2*enemy.getSpeed() + 2*enemy.getHP());
                }
                else if (enemyBlockedCounter == 0 && selfImposedEnemyBlock == false)
                {
                    //write("playerBlockedCounter == 0 && selfImposedPlayerBlock == false");
                    //write(attackResponsableForEnemyBlock.getName());
                    //write("Here");
                    enemyCanMove=true;
                    write("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[3]+ "\n");
                }
                else
                {
                   write("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[1]+ "\n");
                }
                if(battleEnded()==false)
                {
                    playerTurn();
                }
            }
        }
        
    }
    
    
    
    
}

    
    
    
    
    
    
    
