/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player;

/**
 *
 * @author czech
 */

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import java.util.ArrayList;
import java.util.Arrays;
import cz.com.GameFiles.LevyBuild.customClasses.Items;






public class Inventory {
    ArrayList<Item> inventory;
    ArrayList<Bodypart> costumes;
    Items items = new Items(0,0);
   
    public Inventory()
    {
        inventory = new ArrayList<Item>();
        costumes = new ArrayList<Bodypart>();
    }
    
    public  ArrayList<Bodypart> getCostumes()
    {
        return costumes;
    }
            
            
    public ArrayList<Item> getHealingItems()
    {
        ArrayList<Item> healingItems = new ArrayList<Item>();
        for(Item item : inventory)
        {
            for(Item healing : items.getHealingItems())
            {
                if(item.getName().equals(healing.getName()))
                {
                    healingItems.add(item);
                }
            }
        }
        return healingItems;
    }
    
    public String seeInventory()
     {
         String inv = "";
         int position = 0;
         for(Item i : inventory)
         {
            inv = inv + i.getName() + "\n";
         }
         return inv;
     }
    
    public void decrementItem(Item item)
    {
        int counter = -1;
         for (Item inventorySlot : inventory)
         {
             counter++;
             if(inventorySlot.getName().equals(item.getName()))
             {
                 inventorySlot.incrementItemCOunt(-1);
                 if(inventorySlot.getItemCount() == 0)
                 {
                    inventory.remove(item);
                 }
             }
         }
    }
    
    public void decrementItem(Bodypart item)
    {
        int counter = -1;
         for (Bodypart inventorySlot : costumes)
         {
             counter++;
             if(inventorySlot.getName().equals(item.getName()))
             {
                 inventorySlot.incrementItemCOunt(-1);
                 if(inventorySlot.getItemCount() == 0)
                 {
                    costumes.remove(item);
                 }
             }
         }
    }
    
    public void decrementItem(Item item, int amount)
    {
        int counter = -1;
         for (Item inventorySlot : inventory)
         {
             counter++;
             if(inventorySlot.getName().equals(item.getName()))
             {
                 inventorySlot.incrementItemCOunt(amount);
                 if(inventorySlot.getItemCount() == 0)
                 {
                    inventory.remove(item);
                 }
             }
         }
    }
    
    public void decrementItem(Bodypart item, int amount)
    {
        int counter = -1;
         for (Bodypart inventorySlot : costumes)
         {
             counter++;
             if(inventorySlot.getName().equals(item.getName()))
             {
                 inventorySlot.incrementItemCOunt(amount);
                 if(inventorySlot.getItemCount() == 0)
                 {
                    costumes.remove(item);
                 }
             }
         }
    }
    
    public void incrementItem(Item item)
    {
        boolean exists = false;
         int counter = -1;
         for (Item inventorySlot : inventory)
         {
             counter++;
             if(inventorySlot.getName().equals(item.getName()))
             {
                 inventorySlot.incrementItemCOunt(1);
                 exists = true;
             }
         }
         if(exists == false)
         {
             inventory.add(item);
         }
    }
    
    public void incrementItem(Bodypart item)
    {
        boolean exists = false;
         int counter = -1;
         for (Bodypart inventorySlot : costumes)
         {
             counter++;
             if(inventorySlot.getName().equals(item.getName()))
             {
                 inventorySlot.incrementItemCOunt(1);
                 exists = true;
             }
         }
         if(exists == false)
         {
             costumes.add(item);
         }
    }
    
    public void incrementItem(Item item, int amount)
    {
        boolean exists = false;
         int counter = -1;
         for (Item inventorySlot : inventory)
         {
             counter++;
             if(inventorySlot.getName().equals(item.getName()))
             {
                 inventorySlot.incrementItemCOunt(amount);
                 exists = true;
             }
         }
         if(exists == false)
         {
            inventory.add(item);
         }
         
         
    }

    public void incrementItem(Bodypart item, int amount)
    {
        boolean exists = false;
         int counter = -1;
         for (Bodypart inventorySlot : costumes)
         {
             counter++;
             if(inventorySlot.getName().equals(item.getName()))
             {
                 inventorySlot.incrementItemCOunt(amount);
                 exists = true;
             }
         }
         if(exists == false)
         {
            costumes.add(item);
         }
    }
    public void removeItem(Item item)
    {
        inventory.remove(item);
    }
    
    public void removeItem(Bodypart item)
    {
        costumes.remove(item);
    }
    

    
    public String getHealing()
    {
        String healingItem = "";
        for (Item inventorySlot : inventory)
        {
            if(inventorySlot.getGain()> 0)
            {
                healingItem = healingItem + inventorySlot.getName() + "\n";
            }
        }
        return healingItem;
    }

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
   

    public Item getItem(String name)
    {
        for (Item inventorySlot : inventory)
        {
            if(inventorySlot.getName().equals(name))
            {
                return inventorySlot;
            }
        }
        return null;
    }
    
    public Bodypart getCostume(String name)
    {
        for (Bodypart inventorySlot : costumes)
        {
            if(inventorySlot.getName().equals(name))
            {
                return inventorySlot;
            }
        }
        return null;
    }

    public void addItem(Item item)
    {
        inventory.add(item);
    }
    
    public void addCostume(Bodypart item)
    {
        costumes.add(item);
    }
    
    public void upgradeCostume(Bodypart givenItem)
    {
        for(Bodypart item : costumes)
        {
            if(item.getName().equals(givenItem.getName()))
            {
                item.setLevel(item.getLevel()+1);
            }
        }
    }
    
    public void upgradeCostume(Bodypart givenItem, int level)
    {
        for(Bodypart item : costumes)
        {
            if(item.getName().equals(givenItem.getName()))
            {
                item.setLevel(level);
            }
        }
    }
 }

