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
import cz.com.GameFiles.LevyBuild.customClasses.Clerks;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.World;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author czech
 */
public class Save {
    
    /**
     *
     * @param world
     * @throws IOException
     */
    public void saveGame(World world) throws IOException
    {
       this.savePlayer(world.getPlayer());
       this.saveClerks(world.getClerks());
    }
    
    /**
     *
     * @param clerks
     * @throws IOException
     */
    public void saveClerks(Clerks clerks) throws IOException
    {
        BufferedWriter bw = null;

        String path = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Clerks.txt");
        File file = new File(path);
        
        if (!file.exists()) {
	     file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);

        
        String content = (clerks.getFirstClerk().getName() + "\n");
        bw.write(content);
        
        bw.close();
    }
    
    /**
     *
     * @param player
     * @throws IOException
     */
    public void savePlayer(Player player) throws IOException
    {
        this.saveAttack(player);
        this.saveCostumes(player);
        this.saveEquipped(player);
        this.saveInventory(player);
        this.saveName(player);
        this.saveWealth(player);
        this.saveCurrentHealth(player);
    }
    
    /**
     *
     * @param player
     * @throws IOException
     */
    public void saveAttack(Player player) throws IOException
    {
        //System.out.println((System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt"));
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
            String content = (attack.getName() + '@' + attack.getExpTotal()+"\n");
            bw.write(content);

        }
        bw.close();
        
    }
    
    /**
     *
     * @param player
     * @throws IOException
     */
    public void saveCurrentHealth(Player player) throws IOException
    {
        BufferedWriter bw = null;

        String path = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\CurrentHealth.txt");
        File file = new File(path);
        
        if (!file.exists()) {
	     file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        bw = new BufferedWriter(fw);

        bw.write(Integer.toString(player.getCurrentHealth()));
        bw.close();
    }
    
    /**
     *
     * @param player
     * @throws IOException
     */
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
    
    /**
     *
     * @param player
     * @throws IOException
     */
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
    
    /**
     *
     * @param player
     * @throws IOException
     */
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
            bw.write(item.getName()+ '@' + item.getItemCount() + "\n");
        }
        bw.close();
    }
    
    /**
     *
     * @param player
     * @throws IOException
     */
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
        bw.write(player.getEquipment().getHead().getName() + '@' + player.getEquipment().getHead().getLevel() + "\n");
        bw.write(player.getEquipment().getRightHand().getName() + '@' + player.getEquipment().getRightHand().getLevel() + "\n");
        bw.write(player.getEquipment().getLeftHand().getName() + '@' + player.getEquipment().getLeftHand().getLevel() + "\n");
        bw.write(player.getEquipment().getTorso().getName() + '@' + player.getEquipment().getTorso().getLevel() + "\n");
        bw.write(player.getEquipment().getRightLeg().getName() + '@' + player.getEquipment().getRightLeg().getLevel() + "\n");
        bw.write(player.getEquipment().getLeftLeg().getName() + '@' + player.getEquipment().getLeftLeg().getLevel() + "\n");
        bw.write(player.getEquipment().getTail().getName() + '@' + player.getEquipment().getTail().getLevel() + "\n");
        
        bw.close();
    }
    
    /**
     *
     * @param player
     * @throws IOException
     */
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
            bw.write(bodypart.getName() + '@' + bodypart.getLevel()+"\n");   
        }
        
        bw.close();
    }
    
}
