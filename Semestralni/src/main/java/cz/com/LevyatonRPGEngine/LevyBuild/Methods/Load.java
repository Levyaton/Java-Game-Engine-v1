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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.Attacks;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Items;
import java.io.OutputStream;
import java.io.PrintStream;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Bodyparts;
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
    
    public Player loadPlayer() throws IOException
    {
        String name;
        Player player;
        ArrayList<Attack> oldAttacks;
        ArrayList<Item> oldItems;
                
                
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }));
        
        name = loadName();
        player = new Player(name);
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
        for(int x = 0; x<oldEquipped.size();x++)
        {
           if(x==0)
           {
               player.setHead(oldEquipped.get(x));
           }
           else if(x==1)
           {
               player.setRightHand(oldEquipped.get(x));
           }
           else if(x==2)
           {
               player.setLeftHand(oldEquipped.get(x));
           }
           else if(x==3)
           {
               player.setTorso(oldEquipped.get(x));
           }
           else if(x==4)
           {
               player.setRightLeg(oldEquipped.get(x));
           }
           else if(x==5)
           {
               player.setLeftLeg(oldEquipped.get(x));
           }
           else if(x==6)
           {
               player.setTail(oldEquipped.get(x));
           }
        }
        
        ArrayList<Bodypart> oldCostumes = loadCostumes();
        
        for(Bodypart item : oldCostumes)
        {
            player.getInv().addCostume(item);
        }
        
        
     return player;
    }
    
    
                
        
    
    
    public String loadName() throws FileNotFoundException, IOException
    {
        File file = new File(System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt")); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
  
        String name = br.readLine(); 
        
        return name;
    }
    
    public ArrayList<Attack> loadAttacks() throws FileNotFoundException, IOException
    {
        File file = new File(System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\AllAttacks.txt")); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        ArrayList<Attack> oldAttacks = new ArrayList<Attack>();
        
        while ((br.readLine()) != null) 
        {
            String line = br.readLine();
            int seperatorIndex = line.indexOf('@');
            String attackName = line.substring(0, seperatorIndex);
            String attackLevelString = line.substring(seperatorIndex + 1, line.length());
            int attackExp = Integer.parseUnsignedInt(attackLevelString);
            
            for(Attack attack : attacks.getAllAttacks())
            {
                if(attack.getName().equals(attackName))
                {
                    Attack currentAttack = attack;
                    currentAttack.gainExp(attackExp);
                    oldAttacks.add(currentAttack);
                }
            }
        }
        
        return oldAttacks;
    }
    
    public ArrayList<Item> loadInventory() throws FileNotFoundException, IOException
    {
        File file = new File(System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\Inventory.txt")); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        ArrayList<Item> inv = new ArrayList<Item>();
        
        while ((br.readLine()) != null) 
        {
            String line = br.readLine();
            int seperatorIndex = line.indexOf('@');
            String itemName = line.substring(0, seperatorIndex);
            String itemCountString = line.substring(seperatorIndex + 1, line.length());
            int itemCOunt = Integer.parseUnsignedInt(itemCountString);
            
            for(Item item : items.getAllItems())
            {
                if(item.getName().equals(itemName))
                {
                   Item currentItem = item;
                   currentItem.incrementItemCOunt(itemCOunt);
                   inv.add(currentItem);
                }
            }
        }
        
        return inv;
    }
        
    public ArrayList<Bodypart>  loadEquipment() throws FileNotFoundException, IOException
    {
        File file = new File(System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\Equipped.txt")); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        ArrayList<Bodypart> oldEquipped = new ArrayList<Bodypart>();
        
        while ((br.readLine()) != null) 
        {
            String line = br.readLine();
            int seperatorIndex = line.indexOf('@');
            String bodyPartName = line.substring(0, seperatorIndex);
            String bodyPartLevelString = line.substring(seperatorIndex + 1, line.length());
            int bodyPartLevel = Integer.parseUnsignedInt(bodyPartLevelString);
            
            for(Bodypart bodypart : bodyparts.getAllBodyparts())
            {
                if(bodypart.getName().equals(bodyPartName))
                {
                   Bodypart currentBodyPart = bodypart;
                   currentBodyPart.setLevel(bodyPartLevel);
                   oldEquipped.add(currentBodyPart);
                }
            }
        }
        
        return oldEquipped;
    }
    
     public ArrayList<Bodypart> loadCostumes() throws FileNotFoundException, IOException
    {
        File file = new File(System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\Save\\Costumes.txt")); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        ArrayList<Bodypart> costumes = new ArrayList<Bodypart>();
        
        while ((br.readLine()) != null) 
        {
            String line = br.readLine();
            int seperatorIndex = line.indexOf('@');
            String itemName = line.substring(0, seperatorIndex);
            String itemLevelString = line.substring(seperatorIndex + 1, line.length());
            int itemLevel = Integer.parseUnsignedInt(itemLevelString);
            
            for(Bodypart item : bodyparts.getAllBodyparts())
            {
                if(item.getName().equals(itemName))
                {
                   Bodypart currentItem = item;
                   currentItem.setLevel(itemLevel);
                   costumes.add(currentItem);
                }
            }
        }
        
        return costumes;
    }
}
