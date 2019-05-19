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
    ArrayList<Item> healingItems;
    public Inventory()
    {
        inventory = new ArrayList<Item>();
        costumes = new ArrayList<Bodypart>();
        healingItems = new ArrayList<Item>();
    }
    
    public  ArrayList<Bodypart> getCostumes()
    {
        return costumes;
    }
            
            
    public ArrayList<Item> getHealingItems()
    {
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
    
    public void updateHealingItems()
    {
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
    }
    
    public void decrementItem(Item item)
    {
        
         for (Item inventorySlot : inventory)
         {
             if(inventorySlot.getName().equals(item.getName()))
             {
                 inventorySlot.incrementItemCOunt(-1);
                 if(inventorySlot.getItemCount() <= 0)
                 {
                    inventory.remove(item);
                    
                    
                    for(int i = 0; i<healingItems.size();i++)
                    {
                        if(healingItems.get(i).getName().equals(item.getName())){
                            healingItems.remove(healingItems.get(i));
                        }   
                    }
             
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
                 if(inventorySlot.getItemCount() <= 0)
                 {
                    inventory.remove(item);
                    if(healingItems.contains(item))
                    {
                        healingItems.remove(item);
                    }
                    return;
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
                 inventorySlot.addItem();
                 exists = true;
             }
         }
         if(exists == false)
         {
             inventory.add(item);
             inventory.get(inventory.indexOf(item)).addItem();
             if(items.heals(item))
             {
                 healingItems.add(item);
             }
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
                 inventorySlot.addItem();
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
            item.incrementItemCOunt(amount);
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
    

    public ArrayList<Item> getHealing()
    {
        return this.healingItems;
    }
    public String getHealingString()
    {
        String healingItem = "";
        for (Item heal : healingItems)
        {
            healingItem = healingItem + heal.getName() + "     Item amount: " + heal.getItemCount()+"\n";
            
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
        boolean heals = false;
        inventory.add(item);
        for(Item currentItem : healingItems)
        {
            if(currentItem.getName().equals(item.getName()))
            {
                heals = true;
            }
        }
        if(heals = true)
        {
            this.healingItems.add(item);
            healingItems.get(healingItems.indexOf(item)).addItem();
            //System.out.println(healingItems.get(healingItems.indexOf(item)).getItemCount());
        }
    }
    
    public void setInv(ArrayList<Item> giveInv)
    {
        inventory = giveInv;
    }
    
    public void setHealing(ArrayList<Item> giveInv)
    {
        healingItems = giveInv;
    }
    
    public void setCostumes(ArrayList<Bodypart> giveInv)
    {
        costumes = giveInv;
    }
    
    public void addCostume(Bodypart item)
    {
        costumes.add(item);
        costumes.get(costumes.indexOf(item)).addItem();
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

