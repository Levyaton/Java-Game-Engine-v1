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
import java.io.File;
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
        this.saveWealth(player);
        
    }
    
    public void saveAttack(Player player) throws IOException
    {
        System.out.println((System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt"));
        BufferedWriter bw = null;

        String path = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt");
        File file = new File(path);
        
        if (!file.exists()) {
	     file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);

        for(Attack attack : player.getAllAttacks())
        {
            String content = ('$'+attack.getName() + '@' + attack.getExpTotal());
            bw.write(content);

        }
        bw.close();
        
    }
    
    public void saveName(Player player) throws IOException
    {
        //System.out.println((System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Name.txt"));
        
        //System.out.println((System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt"));
        BufferedWriter bw = null;

        String path = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Name.txt");
        File file = new File(path);
        
        if (!file.exists()) {
	     file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);

        bw.write(player.getName());
        bw.close();
    }
    
    public void saveWealth(Player player) throws IOException
    {
        //System.out.println((System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Name.txt"));
        
        //System.out.println((System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt"));
        BufferedWriter bw = null;

        String path = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Wealth.txt");
        File file = new File(path);
        
        if (!file.exists()) {
	     file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);

        bw.write(Integer.toString(player.getWealth()));
        bw.close();
    }
    
    public void saveInventory(Player player) throws IOException
    {
        BufferedWriter bw = null;

        String path = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Inventory.txt");
        File file = new File(path);
        
        if (!file.exists()) {
	     file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
        for(Item item : player.getInventory())
        {
            bw.write('$'+item.getName()+ '@' + item.getItemCount());
        }
        bw.close();
    }
    
    public void saveEquipped(Player player) throws IOException
    {
        
        BufferedWriter bw = null;

        String path = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Equipped.txt");
        File file = new File(path);
        
        if (!file.exists()) 
        {
	    file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
       for(Bodypart bodypart  : player.getEquipped())
        {
            bw.write('$'+bodypart.getName() + '@' + bodypart.getLevel());
        }
       bw.close();
    }
    
     public void saveCostumes(Player player) throws IOException
    {
       
        BufferedWriter bw = null;

        String path = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Costumes.txt");
        File file = new File(path);
        
        if (!file.exists()) 
        {
	    file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);


       for(Bodypart bodypart : player.getCostumes())
        {
            bw.write('$'+bodypart.getName() + '@' + bodypart.getLevel() + '$');   
        }
        
        bw.close();
    }
    
}
