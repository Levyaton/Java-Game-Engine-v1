/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.GameFiles.LevyBuild.customClasses.Attacks;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.GameFiles.LevyBuild.customClasses.Items;
import java.io.OutputStream;
import java.io.PrintStream;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Inventory;

/**
 *
 * @author czech
 */
public class Load {
    
    
    /*
    public void saveAttack(Player player) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter (System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt")));
        for(Attack attack : player.getAllAttacks())
        {
            writer.write('#' + attack.getName() + '@' + attack.getExpTotal());
    
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
            writer.write('#' + item.getName()+ '@' + item.getItemCount());
    
        }
        writer.close();
    }
    
    public void saveEquipped(Player player) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter (System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\Equipped.txt")));
        for(Bodypart bodypart  : player.getEquipped())
        {
            writer.write('#' + bodypart.getName() + '@' + bodypart.getLevel());
    
        }
        writer.close();
    }
    */
    
    Attacks attacks = new Attacks(0,0);
    Items items = new Items();
    Bodyparts bodyparts = new Bodyparts(0,0);
    Inventory inv = new Inventory();
    
    
    public Player loadPlayer() throws IOException
    {
        
        PrintStream originalStream = System.out;

        PrintStream dummyStream = new PrintStream(new OutputStream(){
            public void write(int b) {
        // NO-OP
            }
            });
        System.setOut(dummyStream);


        String name;
        Player player;
        ArrayList<Attack> oldAttacks;
        ArrayList<Item> oldItems;
                
         /*       
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }));
        */
        name = loadName();
        
        
        player = new Player(name);
        player.setWealth(loadWealth());
        oldAttacks = loadAttacks();
        
        for(Attack attack : oldAttacks)
        {
           player.getAllAttacks().set(attacks.getAttackIndex(attack), attack);
        }
        
        oldItems = loadInventory();
        
        for(Item item : oldItems)
        {
            player.addItemToInv(item);
        }
        
        ArrayList<Bodypart> oldEquipped = loadEquipment();
        player.setHead(oldEquipped.get(0));
        player.setRightHand(oldEquipped.get(1));
        player.setLeftHand(oldEquipped.get(2));
        player.setTorso(oldEquipped.get(3));
        player.setRightLeg(oldEquipped.get(4));
        player.setLeftLeg(oldEquipped.get(5));
        //System.out.println(oldEquipped.get(6).getName());
        player.setTail(oldEquipped.get(6));
        player.setCurrentHealth(this.loadCurrentHealth());

        
        ArrayList<Bodypart> oldCostumes = loadCostumes();
        
        for(Bodypart item : oldCostumes)
        {
            player.getInv().addCostume(item);
        }
        
        System.setOut(originalStream);
        
        
     return player;
    }
        
    public int loadWealth() throws FileNotFoundException, IOException
    {
        String location = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Wealth.txt");
        File file = new File(location); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
  
        int wealth = Integer.parseInt(br.readLine()); 
        br.close();
        return wealth;
    }
    
    public String loadName() throws FileNotFoundException, IOException
    {
        String location = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Name.txt");
        File file = new File(location); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
  
        String name = br.readLine(); 
        br.close();
        return name;
    }
    
    public int loadCurrentHealth()throws FileNotFoundException, IOException
    {
        String location = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\CurrentHealth.txt");
        File file = new File(location); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
  
        String currentHealthString = br.readLine(); 
        br.close();
        int currentHealth = Integer.parseInt(currentHealthString);
        return currentHealth;
    }
    
    public ArrayList<Attack> loadAttacks() throws FileNotFoundException, IOException
    {
        String location = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt");
        File file = new File(location); 
        String attackName = null;
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        ArrayList<Attack> oldAttacks = new ArrayList<Attack>();
        String line;
        Attack currentAttack;
        String[] split;
        int attackExp;
        while((line = br.readLine()) != null)
        {
            split = line.split("@");
            attackName = split[0];
            attackExp = Integer.parseInt(split[1]);
            for(Attack attack : attacks.getAllAttacks())
            {
                if(attack.getName().equals(attackName))
                {
                    currentAttack = attack;
                    currentAttack.gainExp(attackExp);
                    oldAttacks.add(currentAttack);
                }
            }
        }
        br.close();
        return oldAttacks;
    }   
    
    public ArrayList<Item> loadInventory() throws FileNotFoundException, IOException
    {
        String location = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Inventory.txt");
        File file = new File(location); 
        String itemName = null;
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        ArrayList<Item> oldInv = new ArrayList<Item>();
        String line;
        Item currentItem;
        String[] split;
        int itemCount;
        while((line = br.readLine()) != null)
        {
            split = line.split("@");
            itemName = split[0];
            itemCount = Integer.parseInt(split[1]);
            for(Item item : items.getAllItems())
            {
                if(item.getName().equals(itemName))
                {
                    currentItem = item;
                    currentItem.incrementItemCOunt(itemCount);
                    oldInv.add(currentItem);
                }
            }
        }
        br.close();
        return oldInv;
    }
        
    public ArrayList<Bodypart>  loadEquipment() throws FileNotFoundException, IOException
    {
        String location = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Equipped.txt");
        File file = new File(location); 
        String itemName = null;
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        ArrayList<Bodypart> oldEquipment = new ArrayList<Bodypart>();
        String line;
        Bodypart currentItem;
        String[] split;
        int itemCount;
        while((line = br.readLine()) != null)
        {
            split = line.split("@");
            itemName = split[0];
            itemCount = Integer.parseInt(split[1]);
            for(Bodypart item : bodyparts.getAllBodyparts())
            {
                if(item.getName().equals(itemName))
                {
                    currentItem = item;
                    currentItem.incrementItemCOunt(itemCount);
                    oldEquipment.add(currentItem);
                }
            }
        }
        br.close();
        return oldEquipment;
    }
    
     public ArrayList<Bodypart> loadCostumes() throws FileNotFoundException, IOException
    {
        
        String location = (System.getProperty("user.dir") + "\\src\\main\\java\\cz\\com\\GameFiles\\Save\\Costumes.txt");
        File file = new File(location); 
        String itemName = null;
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        ArrayList<Bodypart> oldCostumes = new ArrayList<Bodypart>();
        String line;
        Bodypart currentItem;
        String[] split;
        int itemCount;
        while((line = br.readLine()) != null)
        {
            split = line.split("@");
            itemName = split[0];
            itemCount = Integer.parseInt(split[1]);
            for(Bodypart item : bodyparts.getAllBodyparts())
            {
                if(item.getName().equals(itemName))
                {
                    currentItem = item;
                    currentItem.incrementItemCOunt(itemCount);
                    oldCostumes.add(currentItem);
                }
            }
        }
        br.close();
        return oldCostumes;

    }
}
