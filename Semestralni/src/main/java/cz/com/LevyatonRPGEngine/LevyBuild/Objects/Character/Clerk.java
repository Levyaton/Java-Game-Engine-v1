/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import java.util.ArrayList;

/**
 *
 * @author czech
 */
public class Clerk extends NPC{
    
    
    protected String gender;
    protected ArrayList<Item> inventory = new ArrayList<Item>();
    
    public Clerk(String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot, Attack[] giveAttacks, String giveFocus, String[] giveDialogue, String giveGender) {
        super(givenName, giveStr, giveSpeed, giveLuck, giveDef, giveHP, giveLoot, giveAttacks, giveFocus, giveDialogue);
        setInventory();
        gender = giveGender;
    }
    
    
    public void setInventory()
    {
        for(Item item : loot)
        {
            inventory.add(item);
        }
    }
    
    public void setItemPrice(int price, Item item)
    {
        boolean found = false;
        for(Item inv : inventory)
        {
            if(inv.getName().equals(item.getName()))
            {
                inv.setValue(price);
                found = true;
            }
        }
        if(found==false)
        {
            item.setValue(price);
            inventory.add(item);
        }
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }
    
    public String seeInventory(Player player)
    {
        String inv = "";
        int counter = 1;
        for(Item item : inventory)
        {
        inv += ("Item " + counter + ":   " + item.getName() + "\nCost:   " + item.getValue()+ " Gold Coins\nOwned by " + player.getName()+":  " + this.numberOfItemInPInventory(player, item) + "\n\n");
        counter++;
        }
        return inv;
    }
    
    private int numberOfItemInPInventory(Player player, Item item)
    {
        int number = 0;
        for(Item i : player.getInv().getInventory())
        {
            if(i.getName().equals(item.getName()))
            {
                number = i.getItemCount();
            }
        }
        return number;
    }
    
    public void setClerk(String giveName, String giveGender)
    {
        name = giveName;
        gender = giveGender;
    }
    
    public void setClerk(Clerk clerk)
    {
        name = clerk.getName();
        gender = clerk.getGender();
    }
    
}
