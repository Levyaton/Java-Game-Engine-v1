/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects;

import cz.com.GameFiles.LevyBuild.customClasses.Clerks;
import cz.com.GameFiles.LevyBuild.customClasses.Shops;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import java.util.ArrayList;

/**
 *
 * @author czech
 */
public class World {
    
    Player player;
    Clerks clerks;
    Shops shops;
    
    public World()
    {
        player = new Player();
        clerks = new Clerks();
        shops = new Shops(clerks);
    }
    
    public World(Player givePlayer)
    {
        player = givePlayer;
        clerks = new Clerks();
        shops = new Shops(clerks);
    }
    
    public Clerks getClerks()
    {
        return clerks;
    }
    
    public Player getPlayer()
    {
        return player;
    }
    public void setPlayer(Player givePlayer)
    {
        player = givePlayer;
    }
    
    public Shops getShops()
    {
        return shops;
    }
    
    public void setClerks(ArrayList<Clerk> getClerks)
    {
        clerks.setFirstClerk(getClerks.get(0).getName());
        shops = new Shops(clerks);
    }
}
