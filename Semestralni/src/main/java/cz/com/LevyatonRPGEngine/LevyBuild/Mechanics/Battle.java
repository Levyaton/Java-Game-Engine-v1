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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Equipment;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Species.Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Hands.Hand_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Heads.Head_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Legs.Leg_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Tailes.Tail_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Torsos.Torso_Bear;
import java.util.Scanner;


public class Battle {
    private Randomness rand = new Randomness();
    private Player player;
    private Specie enemy;
    private Attack[] enemyAttacks;
    private Object faster;
    private Object slower;
    private Boolean playerCanMove;
    private Boolean enemyCanMove;
    private int pImmobileCounter;
    private int eImmobileCounter;
    private Attack[] availableAttacks;
    private Scanner sc = new Scanner(System.in);
    private Bodypart[] equipment = player.getEquipped();
    
    private int pStr = player.getStr();
    private int pDef = player.getDef();
    private int pSpeed = player.getSpeed();
    private Double pLuck = player.getLuck();
    private int eStr = enemy.getStr();
    private int eDef = enemy.getDef();
    private int eSpeed = enemy.getSpeed();
    private Double eLuck = enemy.getLuck();
    
    private int turnNumber = 1;
    
    private int pHealth = player.getCurrentHealth();
    private int eHealth = enemy.getHP();
    private int enemyBlockedCounter = 0;
    private int playerBlockedCounter = 0;
    private Attack attackResponsableForPlayerBlock;
    private boolean selfImposedPlayerBlock;
    private Attack attackResponsableForEnemyBlock;
    private boolean selfImposedEnemyBlock;
    
    
    public Battle(Specie getEnemy, Player getPlayer)
    {
        enemy = getEnemy;
        player = getPlayer;
        enemyAttacks = enemy.getAttacks();
        availableAttacks = player.getAvailableAttacks();
        while(pHealth>0 && eHealth>0)
        {
            turns(); 
            turnNumber++;
        }
        if(pHealth<=0)
        {
            System.out.println("RIP, you got killed by a " + enemy.getName() + ". Try bragging about that to your friends! See what happens ;-)/n");
        }
        if(eHealth<=0)
        {
            System.out.println("Yay, you have slain the " + enemy.getName()+ "!/n");
            
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
                    if(item.getName().toLowerCase().charAt(0) == 'a' || item.getName().toLowerCase().charAt(0) == 'e' || item.getName().toLowerCase().charAt(0) == 'i' || item.getName().toLowerCase().charAt(0) == 'o' || item.getName().toLowerCase().charAt(0) == 'u')
                    {
                        reward += " an " + item.getName();
                    }
                    else
                    {
                        reward += " a" + item.getName();
                    }
                }
                
            }
        }
        System.out.println(reward + ", great job!/n");
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
            slower = player;
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
                slower = player;
                }
            }
        }
            
          
    }
    
    public boolean attackNameChecker(String givenString)
    {
        boolean AttackIsValid = false;
        for(Attack attack: availableAttacks)
        {
            if(givenString.toLowerCase().equals(attack.getName().toLowerCase()))
            {
                AttackIsValid = true;
            }
        }
        return AttackIsValid;
    }
    
    public int attackAssigner(String givenString)
    {
        int position = 666;
        for(int i = 0;i<availableAttacks.length;i++)
        {
            if(givenString.toLowerCase().equals(availableAttacks[i].getName().toLowerCase()))
            {
               position = i;
            }
        }
        return position;
    }
    
    public Attack chooseAttack()
    {
        Attack attack = availableAttacks[0];
        System.out.println("Enter the name of your chosen Attack: \n");
        for(int x = 0;x < availableAttacks.length;x++)
        {
            if(availableAttacks[x] != null)
            {
                System.out.println("Attack " + x + ":     " + availableAttacks[x].getName() + "\n");
            }
        }

        String chosenAttack = sc.nextLine().toLowerCase();
        if(attackNameChecker(chosenAttack)==false)
        {   
            while(attackNameChecker(chosenAttack)==false)
            {
                System.out.println("Chosen attack does not exist, please reenter the name of your chosen attack: \n");
                chosenAttack = sc.nextLine().toLowerCase();
            }
        }
        try
        {
            attack = availableAttacks[attackAssigner(chosenAttack)];
        }
        catch(Exception attackNameCheckerFailed)
        {
            System.out.println("AttackNameChecker didnt prevent wrong user input, so the returned value of attackAssigner made the array leak");
        }
        return attack;
    }
    
    
    public int pDamageCalculator(Attack attack)
    {
        int baseDamage = attack.getDamage();
        if(equipment[1] == equipment[2])
        {
            baseDamage = attack.getDamage()*2 + attack.getDamage()/2;
            
        }
        int modefiedDamage = baseDamage + player.getStr();
        int trueDamage = modefiedDamage/enemy.getDef();
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
            System.out.println(player.getName()+ " delt " + pDamageCalculator(attack)*1.6 + " points of damage to " + enemy.getName()+ "\n");
            }
            else
            {
            eHealth = eHealth - pDamageCalculator(attack);
            System.out.println(player.getName()+ " delt " + pDamageCalculator(attack) + " points of damage to " + enemy.getName()+ "\n");
            }
        }
        if(attack.getDamage() < 0)
        {
            pHealth = pHealth + attack.getDamage();
            System.out.println(player.getName()+ " delt " + pDamageCalculator(attack) + " points of damage to themselves\n");
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
            pStr += attack.getStrMod();
            printStatChange(attack.getStrMod(), "Strength");
            pDef += attack.getDefMod();
            printStatChange(attack.getDefMod(), "Defense");
            pSpeed += attack.getSpeedMod();
            printStatChange(attack.getSpeedMod(), "Speed");
            pLuck += attack.getLuckMod();
            printStatChange(attack.getLuckMod(), "Luck");
            pHealth += attack.getHpMod();
            printStatChange(attack.getHpMod(), "Health Point's");
        }
        
        if(attack.enemyCanMove()==false && enemyCanMove)
        {
            enemyCanMove = false;
            enemyBlockedCounter = attack.getEBlockLength();
            System.out.println(player.getName() + attack.getBlockedText()[0]);
        }
        else if(attack.enemyCanMove()==false &&  enemyCanMove == false)
        {
            System.out.println(attack.getBlockedText()[2]);
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
            playerCanMove = false;
            attackResponsableForPlayerBlock = attack;
            selfImposedPlayerBlock = true;
            playerBlockedCounter = attack.getTurnLength();
            System.out.println(enemy.getName() + attack.getBlockedText()[0]);
        }
    }
    
    public void playerTurn()
    {
        System.out.println(player.getName()+ "s turn!");
        if(playerCanMove)
        {
           Attack chosenAttack = chooseAttack();
           System.out.println("You used " + chosenAttack.getName()+ "/n");
           pPreformAttack(chosenAttack);
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
                System.out.println(player.getName() + attackResponsableForPlayerBlock.getBlockedText()[1]);
            }
        }
    }
    
    //ENEMY TURN
    
     public int eDamageCalculator(Attack attack)
    {
        int baseDamage = attack.getDamage();
        int modefiedDamage = baseDamage*2 + enemy.getStr();
        int trueDamage = modefiedDamage/player.getDef();
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
            System.out.println("The " + enemy.getName()+ " delt " + eDamageCalculator(attack)*1.6 + " points of damage to " + player.getName()+ ", did it hurt?\n");
            }
            else
            {
            pHealth = pHealth - eDamageCalculator(attack);
            System.out.println("The " + enemy.getName()+ " delt " + eDamageCalculator(attack) + " points of damage to " + player.getName()+ "\n");
            }
        }
        if(attack.getDamage() < 0)
        {
            pHealth = pHealth + attack.getDamage();
            System.out.println(player.getName()+ " delt " + pDamageCalculator(attack) + " points of damage to themselves\n");
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
            eDef += attack.getDefMod();
            eprintStatChange(attack.getDefMod(), "Defense");
            eSpeed += attack.getSpeedMod();
            eprintStatChange(attack.getSpeedMod(), "Speed");
            eLuck += attack.getLuckMod();
            eprintStatChange(attack.getLuckMod(), "Luck");
            eHealth += attack.getHpMod();
            eprintStatChange(attack.getHpMod(), "Health Point's");
        }
        
        if(attack.enemyCanMove()==false && playerCanMove)
        {
            playerCanMove = false;
            playerBlockedCounter = attack.getEBlockLength();
            System.out.println("The " + enemy.getName() + attack.getBlockedText()[0]);
        }
        else if(attack.enemyCanMove()==false &&  playerCanMove == false)
        {
            System.out.println(attack.getBlockedText()[2]);
        }
    }
    
    public void ePreformAttack(Attack attack)
    {
        if(attack.getTurnLength()<2)
        {
            eDealDamage(attack);
            eApplyAttackEffects(attack);
            player.levelAttack(attack, enemy.getExp());
        }
        else
        {
            enemyCanMove = false;
            attackResponsableForEnemyBlock = attack;
            selfImposedEnemyBlock = true;
            enemyBlockedCounter = attack.getTurnLength();
        }
    }
    
    public void enemyTurn()
    {
        System.out.println(enemy.getName()+ "s turn!");
        if(enemyCanMove)
        {
           Attack chosenAttack = enemyAttacks[rand.getRandomObjectFromSelection(enemyAttacks)];
           System.out.println("The " + enemy.getName()+ " used "+ chosenAttack.getName()+ "/n");
           ePreformAttack(chosenAttack);
        }
        else
        {
            
            enemyBlockedCounter--;
            if(enemyBlockedCounter == 0 && selfImposedEnemyBlock == true)
            {
               System.out.println(enemy.getName() + attackResponsableForPlayerBlock.getBlockedText()[2]);
               eDealDamage(attackResponsableForPlayerBlock);
               eApplyAttackEffects(attackResponsableForPlayerBlock);
               enemyCanMove = true;
               player.levelAttack(attackResponsableForPlayerBlock, eStr);    
            }
            else if (playerBlockedCounter == 0 && selfImposedPlayerBlock == false)
            {
                enemyCanMove=true;
                System.out.println(enemy.getName() + attackResponsableForPlayerBlock.getBlockedText()[3]);
            }
            else
            {
                System.out.println("The " + enemy.getName() + attackResponsableForEnemyBlock.getBlockedText()[1]);
            }
        }
    }
    
    public static void main(String[] args)
    {
        Hand_Bear hand = new Hand_Bear();
        Head_Bear head = new Head_Bear();
        Leg_Bear leg = new Leg_Bear();
        Torso_Bear torso = new Torso_Bear();
        Tail_Bear tail = new Tail_Bear();
        
        Player p = new Player();
        
        Bear bear = new Bear();
        Battle b = new Battle(bear,p);
        
    }
    
    
}

    
    
    
    
    
    
    
