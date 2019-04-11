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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
import java.io.File;


public class Battle {
    Randomness rand = new Randomness();
    Player player = new Player();
    Specie enemy;
    Object faster;
    Object slower;
    
    
    int turnNumber = 0;
    
    int pHealth = player.getHealth();
    int eHealth = enemy.getHP();
    
    public Battle(Specie getEnemy)
    {
        enemy = getEnemy;
        while(pHealth>0 && eHealth>0)
        {
            speedCheck();
        }
    }
    
    public void speedCheck()
    {
        if(player.getSpeed()>enemy.getSpeed())
        {
            faster = player;
            slower = enemy;
        }
        else if(player.getSpeed()<enemy.getSpeed())
        {
            faster = enemy;
            slower = player;
        }
        else
        {
            int faster = rand.numberFromSequence(2);
            if(faster == 0)
            {
                slower = 1;
            }
            else
            { 
                slower = 0;
            }
        }
            
          
    }
    
    public void playerTurn()
    {
        
    }
    
    public void getAttacks()
    {
    final File folder = new File("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Attacks\\");
        for (final File fileEntry : folder.listFiles()) {
            if(fileEntry.getClass().)
            }
    }
}

    
    
    
    
    
    
    
