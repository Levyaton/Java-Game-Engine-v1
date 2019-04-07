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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie.*;


public class Battle {
    Player player = new Player();
    Object specie;
    
    int turnNumber = 0;
    
    int playerHealth = player.getHealth;
    
    public Battle(Object enemy)
    {
        specie = enemy;
    }
    
    
    
}
