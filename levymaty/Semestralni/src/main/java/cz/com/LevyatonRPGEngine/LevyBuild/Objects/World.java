/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects;

import cz.com.GameFiles.LevyBuild.customClasses.Clerks;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import java.util.ArrayList;

/**
 *  A class containing some in game world properties
 * @author czech
 */
public class World {
    
    Player player;
    Clerks clerks;
  
    /**
     *  initializes the class
     * @param givePlayer
     */
    public World(Player givePlayer)
    {
        player = givePlayer;
        clerks = new Clerks();
      
    }
    
    /**
     *  returns clerks
     * @return
     */
    public Clerks getClerks()
    {
        return clerks;
    }
    
    /**
     *  returns the player
     * @return
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     *  sets the player to the given player
     * @param givePlayer
     */
    public void setPlayer(Player givePlayer)
    {
        player = givePlayer;
    }
    
    /**
     *  sets the clerks to the given Clerks
     * @param getClerks
     */
    public void setClerks(ArrayList<Clerk> getClerks)
    {
        clerks.setFirstClerk(getClerks.get(0).getName());
       
    }
}
