/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    
    public void saveGame(Player player) throws IOException
    {
        this.saveAttack(player);
        this.saveCostumes(player);
        this.saveEquipped(player);
        this.saveInventory(player);
        this.saveName(player);
        
    }
    
    public void saveAttack(Player player) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter (System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt")));
        for(Attack attack : player.getAllAttacks())
        {
            writer.write(attack.getName() + '@' + attack.getExpTotal()+ '\n');
    
        }
        writer.close();
    }
    
    public void saveName(Player player) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter (System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\Name.txt")));
        writer.write(player.getName());
        writer.close();
    }
    
    public void saveInventory(Player player) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter (System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\Inventory.txt")));
        for(Item item : player.getInventory())
        {
            writer.write(item.getName()+ '@' + item.getItemCount() + '\n');
    
        }
        writer.close();
    }
    
    public void saveEquipped(Player player) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter (System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\Equipped.txt")));
        for(Bodypart bodypart  : player.getEquipped())
        {
            writer.write(bodypart.getName() + '@' + bodypart.getLevel() + '\n');
    
        }
        writer.close();
    }
    
     public void saveCostumes(Player player) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter (System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\Costumes.txt")));
        for(Bodypart bodypart : player.getCostumes())
        {
            writer.write(bodypart.getName() + '@' + bodypart.getLevel() + '\n');
    
        }
        writer.close();
    }
    
}
