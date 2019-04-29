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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
import java.util.Scanner;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Bodyparts;
import java.util.ArrayList;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.Attacks;


public class Battle{
    private Randomness rand = new Randomness();
    private Specie enemy;
    private Player player;
    private Attack[] enemyAttacks;
    private Object faster;
    private Object slower;
    private Boolean playerCanMove = true;
    private Boolean enemyCanMove = true;
    private int pImmobileCounter;
    private int eImmobileCounter;
    
    
    private Scanner sc = new Scanner(System.in);
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
    }
    
    public Battle(Specie getEnemy, Player getPlayer)
    {
        enemy = getEnemy;
        player = getPlayer;
        enemyProperties();
        playerProperties();
        welcomeMessage(getEnemy.getName());
        while(pHealth>0 && eHealth>0)
        {
            turns(); 
            turnNumber++;
        }
        if(pHealth<=0)
        {
            System.out.println("RIP, you got killed by a " + enemy.getName() + ". Try bragging about that to your friends! See what happens ;-)\n");
        }
        if(eHealth<=0)
        {
            System.out.println("Yay, you have slain the " + enemy.getName()+ "!\n");
            
        }
    
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
        System.out.println(eStrat);
    }
    
    public Player updatePlayer()
    {
        return this.player;
    }
    
    public void welcomeMessage(String enemyName)
    {
        System.out.println(player.getName() + " is attacked by" + AorAn(enemyName) + enemyName + "!\n\nThe battle has begun!\n");
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
    
    public void getLoot()
    {
        String reward = "You got ";
        Item[] possibleLoot = enemy.getLoot();
        for(Item item : possibleLoot)
        {
            if(rand.success(item.getDropRate()))
            {
                player.addItemToInv(item);
                if(item.getName().equals("Gold Coin"))
                {
                    reward += item.getValue() + " Gold Coins";
                }
                else
                {
                   reward += AorAn(item.getName()) + item.getName();
                }
                
            }
        }
        System.out.println(reward + ", great job!\n");
    }
    
    public void turns()
    {
        if(pSpeed>eSpeed)
        {
            playerTurn();
            if(eHealth>0)
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
                if(eHealth>0)
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
    
    public Attack chooseAttack()
    {
        ArrayList<Attack> usableAttacks = player.getAvailableAttacks();
        System.out.println("Please enter the number of you're chosen attack\n");
        while(true)
        {  
            
            this.attackWriter();
            try{
                int chosenAttack = sc.nextInt();
                Attack chosen = usableAttacks.get(chosenAttack-1);
                String testName = chosen.getName();
                return chosen;
            }
            catch(Exception p)
            {
            System.out.println("\nChosen attack does not exist, please reenter the number of your chosen attack: \n");
            }
        }
    }
    
    
    
    public void attackWriter()
    {
        ArrayList<Attack> usableAttacks = player.getAvailableAttacks();
        System.out.println("Your attacks are: \n");
        for(int x = 0; x<usableAttacks.size();x++)
        {
            if(!usableAttacks.get(x).equals(attacks.getEmptyAttack()))
            {
                System.out.println("Attack " + (x+1) + ":   " + usableAttacks.get(x).getName() + "\n");
            }
        }
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
    
    public void pDealDamage(Attack attack)
    {
        if(attack.getDamage() > 0)
        {
            if(rand.success(pLuck))
            {
            eHealth = (int) Math.round(eHealth - pDamageCalculator(attack)*1.6 + 0.5);
            System.out.println("By the messy beard of Odin, you landed a critical hit!\n");
            System.out.println(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)*1.6+0.5) + " points of damage to " + enemy.getName()+ "\n");
            }
            else
            {
            eHealth = (int) Math.round(eHealth - pDamageCalculator(attack));
            System.out.println(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)+0.5) + " points of damage to " + enemy.getName()+ "\n");
            }
        }
        if(attack.getDamage() < 0)
        {
            pHealth = pHealth + attack.getDamage();
            System.out.println(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)+0.5) + " points of damage to themselves\n");
        }
    }
    
    public void printStatChange(int modefier, String statName)
    {
        if(modefier > 0)
        {
            System.out.println(player.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
            System.out.println(player.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }
    
    public void printStatChange(Double modefier, String statName)
    {
        if(modefier > 0)
        {
            System.out.println(player.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
            System.out.println(player.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }
    
    public void pApplyAttackEffects(Attack attack)
    {     
        if(attack.hasEffect())
        {
            
            //System.out.println(attack.getName() + "\n" + attack.hasEffect());
            pStr += attack.getStrMod();
            printStatChange(attack.getStrMod(), "Strength");
            if(pStr>player.getStr() + 20)
            {
                pStr = player.getStr() + 20;
                System.out.println(player.getName() + "'s strength can't get any higher, it's maxed out!");
            }
       
            pDef += attack.getDefMod();
            printStatChange(attack.getDefMod(), "Defense");
            if(pDef>player.getDef() + 20)
            {  
                pDef = player.getDef() + 20;
                System.out.println(player.getName() + "'s defense can't get any higher, it's maxed out!");
            }
            
            pSpeed += attack.getSpeedMod();
            printStatChange(attack.getSpeedMod(), "Speed");
            if(pSpeed > player.getSpeed() + 20)
            {
                pSpeed = player.getSpeed() + 20;
                System.out.println(player.getName() + "'s speed can't get any higher, it's maxed out!");
            }
            
            pLuck += attack.getLuckMod();
            printStatChange(attack.getLuckMod(), "Luck");
            if(pLuck > 0.9)
            {
                pLuck = 0.9;
                System.out.println(player.getName() + "'s luck can't get any higher, it's maxed out!");
            }
            pHealth += attack.getHpMod();
            printStatChange(attack.getHpMod(), "Health Point's");
            if(pHealth>player.getMaxHealth())
            {
                pHealth = player.getMaxHealth();
                System.out.println(player.getName() + "'s health can't go any higher, it's maxed out!");
            }
        }
        
        if(attack.enemyCanMove()==false && enemyCanMove)
        {
            
            enemyCanMove = false;
            enemyBlockedCounter = attack.getEBlockLength();
            //System.out.println(enemyBlockedCounter);
            this.attackResponsableForEnemyBlock = attack;
            System.out.println(player.getName() + attack.getBlockedText()[0]);
        }
        else if(attack.enemyCanMove()==false &&  enemyCanMove == false)
        {
            
            System.out.println(player.getName() + attack.getBlockedText()[2]);
        }
    }
    public void pPreformAttack(Attack attack)
    {
        if(attack.getTurnLength()<2)
        {
            pDealDamage(attack);
            pApplyAttackEffects(attack);
        }
        else
        {
            //System.out.println("Here, yo");
            playerCanMove = false;
            attackResponsableForPlayerBlock = attack;
            selfImposedPlayerBlock = true;
            playerBlockedCounter = attack.getTurnLength();
            System.out.println(player.getName() + attack.getBlockedText()[0]);
        }
    }
    
    public void playerTurn()
    {
        
        System.out.println(player.getName()+ "'s turn!\n");
        
        System.out.println("Turn number " + turnNumber);
        System.out.println(player.getName()+ "'s health is at:  " + this.pHealth + " out of " + player.getMaxHealth());
        System.out.println(enemy.getName()+ "'s health is at:  " + this.eHealth + " out of " + enemy.getHP()+ "\n");
        /*System.out.println(player.getName() + "'s block counter is at " + this.playerBlockedCounter);
        if(playerBlockedCounter>0)
        {
            System.out.println(this.attackResponsableForPlayerBlock.getName());
        }
        */
        if(playerCanMove)
        {
           Attack chosenAttack = chooseAttack();
           System.out.println("You used " + chosenAttack.getName()+ "\n");
           pPreformAttack(chosenAttack);
           player.levelAttack(chosenAttack,  chosenAttack.getExpTotal()/1000 + enemy.getStr() + enemy.getDef() + enemy.getSpeed() + enemy.getHP());
        }
        else
        {
            playerBlockedCounter--;
            if(playerBlockedCounter == 0 && selfImposedPlayerBlock == true)
            {
               System.out.println(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[2]);
               pDealDamage(attackResponsableForPlayerBlock);
               pApplyAttackEffects(attackResponsableForPlayerBlock);
               playerCanMove = true; 
            }
            else if (playerBlockedCounter == 0 && selfImposedPlayerBlock == false)
            {
                playerCanMove=true;
                System.out.println(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[3]);
            }
            else
            {
                //System.out.println(this.attackResponsableForPlayerBlock.getName());
                System.out.println(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[1]);
            }
        }
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
    
    public void eDealDamage(Attack attack)
    {
        if(attack.getDamage() > 0)
        {
            if(rand.success(eLuck))
            {
            pHealth = (int) Math.round(pHealth - eDamageCalculator(attack)*1.6 + 0.5);
            System.out.println("Awww snap, the " + enemy.getName() + " landed a critical hit!\n");
            System.out.println("The " + enemy.getName()+ " delt " + (int) Math.round(eDamageCalculator(attack)*1.6+0.5) + " points of damage to " + player.getName()+ ", did it hurt?\n");
            }
            else
            {
            pHealth = (int) Math.round(pHealth - eDamageCalculator(attack));
            System.out.println("The " + enemy.getName()+ " delt " + (int) Math.round(eDamageCalculator(attack)+0.5) + " points of damage to " + player.getName()+ "\n");
            }
        }
        if(attack.getDamage() < 0)
        {
            pHealth = pHealth + attack.getDamage();
            System.out.println(player.getName()+ " delt " + (int) Math.round(pDamageCalculator(attack)+0.5) + " points of damage to themselves\n");
        }
    }
    
    public void eprintStatChange(int modefier, String statName)
    {
        if(modefier > 0)
        {
            System.out.println("The " + enemy.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
            System.out.println("The " + enemy.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }
    
    public void eprintStatChange(Double modefier, String statName)
    {
        if(modefier > 0)
        {
            System.out.println(player.getName() + "'s " + statName + " grew by " + modefier + " points!\n");
        }
        else if(modefier<0)
        {
            System.out.println(player.getName() + "'s " + statName + " dropped by " + modefier + " points!\n");
        }
    }
    
    
    public void eApplyAttackEffects(Attack attack)
    {     
        if(attack.hasEffect())
        {
            eStr += attack.getStrMod();
            eprintStatChange(attack.getStrMod(), "Strength");
            if(eStr>enemy.getStr() + 20)
            {
                eStr = enemy.getStr() + 20;
                System.out.println(enemy.getName() + "'s strength can't go any higher, it's maxed out!");
            }
            eDef += attack.getDefMod();
            eprintStatChange(attack.getDefMod(), "Defense");
            if(eDef>enemy.getDef() + 20)
            {
                eDef = enemy.getDef() + 20;
                System.out.println(enemy.getName() + "'s defense can't go any higher, it's maxed out!");
            }
            eSpeed += attack.getSpeedMod();
            eprintStatChange(attack.getSpeedMod(), "Speed");
            if(eSpeed>enemy.getSpeed() + 20)
            {
                eSpeed = enemy.getSpeed() + 20;
                System.out.println(enemy.getName() + "'s speed can't go any higher, it's maxed out!");
            }
            eLuck += attack.getLuckMod();
            eprintStatChange(attack.getLuckMod(), "Luck");
            if(eLuck>0.9)
            {
                eLuck = 0.9;
                System.out.println(enemy.getName() + "'s luck can't go any higher, it's maxed out!");
            }
            eHealth += attack.getHpMod();
            eprintStatChange(attack.getHpMod(), "Health Point's");
            if(eHealth>enemy.getHP())
            {
                eHealth = enemy.getHP();
                System.out.println(enemy.getName() + "'s health can't go any higher, it's maxed out!");
            }
        }
        
        if(attack.enemyCanMove()==false && playerCanMove)
        {
            playerCanMove = false;
 
            playerBlockedCounter = attack.getEBlockLength();
            attackResponsableForPlayerBlock = attack;
            System.out.println("The " + enemy.getName() + attack.getBlockedText()[0]);
        }
        else if(attack.enemyCanMove()==false &&  playerCanMove == false)
        {
            System.out.println(("The " + enemy.getName() + attack.getBlockedText()[2]));
            
        }
    }
    
    public void ePreformAttack(Attack attack)
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
            System.out.println("The "+ enemy.getName() + attack.getBlockedText()[0]+ "\n");
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
    
    
    
    public void enemyTurn()
    {
        System.out.println(enemy.getName()+ "'s turn!\n");
        if(enemyCanMove)
        {
           Attack chosenAttack = this.enemyChoosenAttack();
           System.out.println("The " + enemy.getName()+ " used "+ chosenAttack.getName()+ "\n");
           ePreformAttack(chosenAttack);
           player.levelAttack(chosenAttack, chosenAttack.getExpTotal()/100 + 2*enemy.getStr() + 2*enemy.getDef() + 2*enemy.getSpeed() + 2*enemy.getHP());
        }
        else
        {   
            enemyBlockedCounter--;
            if(enemyBlockedCounter == 0 && selfImposedEnemyBlock == true)
            {
                //System.out.println("I got here");
                //System.out.println( attackResponsableForPlayerBlock.getBlockedText()[2]);
               System.out.println("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[2]);
               eDealDamage(attackResponsableForEnemyBlock);
               eApplyAttackEffects(attackResponsableForEnemyBlock);
               enemyCanMove = true;
               player.levelAttack(attackResponsableForEnemyBlock,attackResponsableForEnemyBlock.getExpTotal()/100 + 2*enemy.getStr() + 2*enemy.getDef() + 2*enemy.getSpeed() + 2*enemy.getHP());
            }
            else if (enemyBlockedCounter == 0 && selfImposedEnemyBlock == false)
            {
                //System.out.println("playerBlockedCounter == 0 && selfImposedPlayerBlock == false");
                //System.out.println(attackResponsableForEnemyBlock.getName());
                //System.out.println("Here");
                enemyCanMove=true;
                System.out.println("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[3]);
            }
            else
            {
                System.out.println("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[1]);
            }
        }
    }
    
    
    
    
}

    
    
    
    
    
    
    
