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
import java.util.Arrays;






public class Inventory {
    Item[] inventory;
   
    public Inventory()
    {
        inventory = new Item[100];
    }
    
    public void addItem(Item addedItem)
    {
       int position = -1;
       boolean findSpace = true;
        int firstEmptySlot = 0;
        for (Item inventorySlot : inventory) {
            position++;
            if(inventory[position]==null && findSpace)
            {
                firstEmptySlot = position;
                findSpace = false;
            }
            if (inventorySlot.getName().equals(addedItem.getName())) 
            {
                inventorySlot.incrementItemCOunt(1);
                break;
            }
        }
        inventory[firstEmptySlot] = addedItem; 
    }
     
    public String seeInventory()
     {
         String inv = "";
         int position = 0;
         while(inventory[position] != null)
         {
            inv = inv + inventory[position].getName() + "\n";
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
                    removeItem(counter);
                 }
             }
         }
    }

    public void removeItem(int counter)
    {
        Item[] merged = new Item[100];
        if(counter>0 && counter<inventory.length-1)
        {
            Item[] newInv1 = Arrays.copyOfRange(inventory,0,counter);
            Item[] newInv2 = Arrays.copyOfRange(inventory,counter+1,inventory.length);


            System.arraycopy(newInv1, 0, merged, 0, newInv1.length);
            System.arraycopy(newInv2, newInv1.length, merged, newInv1.length, newInv2.length - newInv1.length);
            inventory = merged;
        }
        else if(counter == 0)
        {
            Item[] newInv1 = Arrays.copyOfRange(inventory,1,inventory.length);
            System.arraycopy(newInv1, 0, merged, 0, newInv1.length);
            inventory = merged;
             
        }
        else
        {
            Item[] newInv1 = Arrays.copyOfRange(inventory,0,inventory.length-1);
            System.arraycopy(newInv1, 0, merged, 0, newInv1.length);
            inventory = merged;
             
        }
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
    }

