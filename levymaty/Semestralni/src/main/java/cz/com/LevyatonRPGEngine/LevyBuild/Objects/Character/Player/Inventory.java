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

/**
 *  A class responsible for the players inventory
 * @author czech
 */
public class Inventory {
    ArrayList<Item> inventory;
    ArrayList<Bodypart> costumes;
    Items items = new Items(0,0);
    ArrayList<Item> healingItems;

    /**
     *  initializes and sets the class
     */
    public Inventory()
    {
        inventory = new ArrayList<Item>();
        costumes = new ArrayList<Bodypart>();
        healingItems = new ArrayList<Item>();
    }
    
    /** 
     *  returns an ArrayList containing all of the players costumes
     * @return
     */
    public  ArrayList<Bodypart> getCostumes()
    {
        return costumes;
    }
            
    /**
     *  returns an ArrayList containing all of the players healing items
     * @return
     */
    public ArrayList<Item> getHealingItems()
    {
        return healingItems;
    }
    
    /**
     *  returns a String containing the names of every inventory item
     * @return
     */
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
    
    /**
     *  updates the ArrayList called healingItems
     */
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
    
    /**
     *  decrements the number of an item in the players inventory and removes it if it reaches 0
     * @param item
     */
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
    
    /**
     *decrements the number of a Bodypart in the players inventory and removes it if it reaches 0
     * @param item
     */
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
    
    /**
     *  decrements the number of an item in the players inventory by a given amount and removes it if it reaches 0
     * @param item
     * @param amount
     */
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
    
    /** 
     *  decrements the number of a Bodypart by a given amount in the players inventory and removes it if it reaches 0
     * @param item
     * @param amount
     */
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
    
    /**
     *  increments the number of an item in the players inventory
     * @param item
     */
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
    
    /**
     *  increments the number of a Bodypart in the players inventory
     * @param item
     */
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
    
    /**
     *    increments the number of an item in the players inventory by a given amount 
     * @param item
     * @param amount
     */
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

    /**
     *    increments the number of a Bodypart in the players inventory by a given amount
     * @param item
     * @param amount
     */
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

    /**
     *  removes the given item from the players inventory
     * @param item
     */
    public void removeItem(Item item)
    {
        inventory.remove(item);
    }
    
    /**
     * removes the given Bodypart from the players inventory
     * @param item
     */
    public void removeItem(Bodypart item)
    {
        costumes.remove(item);
    }
    
    /**
     *  returns an ArrayList containing all of the healing Items in the players inventory
     * @return
     */
    public ArrayList<Item> getHealing()
    {
        return this.healingItems;
    }

    /** returns a string containing all of the healing Items in the players inventory with their Item count
     *
     * @return
     */
    public String getHealingString()
    {
        String healingItem = "";
        for (Item heal : healingItems)
        {
            healingItem = healingItem + heal.getName() + "     Item amount: " + heal.getItemCount()+"\n";
            
        }
        return healingItem;
    }

    /**
     *  returns an ArayList containing the players inventory
     * @return
     */
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
   
    /** 
     *  returns an Item corresponding to the given name
     * @param name
     * @return
     */
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
    
    /**
     *  returns a Bodypart corresponding to the given name
     * @param name
     * @return
     */
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

    /**
     *  adds the given Item to tbe players inventory
     * @param item
     */
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
    
    /**
     *  sets the inventory to the given ArrayList of Items
     * @param giveInv
     */
    public void setInv(ArrayList<Item> giveInv)
    {
        inventory = giveInv;
    }
    
    /**
     *  sets the ArrayList of healing Items to the given ArrayList
     * @param giveInv
     */
    public void setHealing(ArrayList<Item> giveInv)
    {
        healingItems = giveInv;
    }
    
    /**
     *  sets the ArrayList of costumes to the given ArrayList
     * @param giveInv
     */
    public void setCostumes(ArrayList<Bodypart> giveInv)
    {
        costumes = giveInv;
    }
    
    /**
     *  adds the given Bodypart to costumes
     * @param item
     */
    public void addCostume(Bodypart item)
    {
        costumes.add(item);
        costumes.get(costumes.indexOf(item)).addItem();
    }
    
    /**
     *  increments the given Bodyparts level
     * @param givenItem
     */
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
    
    /**
     *  sets the given Bodyparts level to the given number
     * @param givenItem
     * @param level
     */
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

