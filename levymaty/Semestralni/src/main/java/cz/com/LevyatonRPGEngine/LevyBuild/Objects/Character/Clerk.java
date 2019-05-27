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
 *  A class containing the information about a clerk
 * @author czech
 */
public class Clerk extends NPC{
    
    /**
     *  every clerk must have a trait, those being Aggressive, defensive or random
     */
    protected String trait;

    /**
     *  every clerk must have a gender
     */
    protected String gender;

    /**
     *  every clerk must have an inventory
     */
    protected ArrayList<Item> inventory = new ArrayList<Item>();
    
    /**
     *  Sets up the Clerk
     * @param givenName
     * @param giveStr
     * @param giveSpeed
     * @param giveLuck
     * @param giveDef
     * @param giveHP
     * @param giveLoot
     * @param giveAttacks
     * @param giveFocus
     * @param giveDialogue
     * @param giveGender
     * @param giveTrait
     */
    public Clerk(String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot, Attack[] giveAttacks, String giveFocus, String[] giveDialogue, String giveGender, String giveTrait) {
        super(givenName, "static","addSpriteLocationLater",giveStr, giveSpeed, giveLuck, giveDef, giveHP, giveLoot, giveAttacks, giveFocus, giveDialogue);
        setInventory();
        gender = giveGender;
        trait = giveTrait;
    }
    
    /**
     *  sets the clerks inventory
     */
    public void setInventory()
    {
        for(Item item : loot)
        {
            inventory.add(item);
        }
    }
    
    /**
     *  sets the price of an Item in the Clerk's inventory
     * @param price
     * @param item
     */
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
    
    /**
     *  returns the clerks trait
     * @return
     */
    public String getTrait()
    {
        return trait;
    }
    
    /**
     *  returns the Clerk's gender
     * @return
     */
    public String getGender()
    {
        return gender;
    }
    
    /**
     *  returns an ArrayList containing the clerks inventory
     * @return
     */
    public ArrayList<Item> getInventory()
    {
        return inventory;
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
    
    /**
     *  sets the up the Clerk with a given name and gender
     * @param giveName
     * @param giveGender
     */
    public void setClerk(String giveName, String giveGender)
    {
        name = giveName;
        gender = giveGender;
    }
    
    /**
     *  sets the clerk to the given Clerk
     * @param clerk
     */
    public void setClerk(Clerk clerk)
    {
        name = clerk.getName();
        gender = clerk.getGender();
    }
    
}
