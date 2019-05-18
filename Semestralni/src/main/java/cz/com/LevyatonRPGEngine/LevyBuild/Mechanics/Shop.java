/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Mechanics;

import cz.com.GameFiles.LevyBuild.customClasses.Items;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.InputCheckers;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import java.util.Scanner;

/**
 *
 * @author czech
 */
public class Shop {
    
    InputCheckers i = new InputCheckers();
    Boolean end = false;
    Clerk shopkeeper;
    Player player;
    Items items = new Items();
    public Shop(Clerk clerk)
    {
        end = false;
        shopkeeper = clerk;
    }
    
    public Clerk getShopkeeper()
    {
        return shopkeeper;
    }
    
    public Player shopping(Player getPlayer)
    {
        player = getPlayer;
        end = false;
        System.out.println(shopkeeper.getDialogue()[0]);
        
        buySellBye();
        
        return player;
    }
    
    private void buySellBye()
    {
        
        while(end == false)
        {
            
            System.out.println("Option 1:   Buy\nOption 2:   Sell\nOption 3:   Bye\n");
            Scanner sc = new Scanner(System.in);
            String choiceStr = sc.nextLine();
            try{
                int choice = Integer.parseInt(choiceStr);
                switch(choice)
                {
                    case 1: 
                            buy();
                            break;
                    case 2: 
                            sell();
                            break;
                    case 3: 
                            end = true;
                            System.out.println("Hope to see you again soon!");
                            if(shopkeeper.getName().equals("Hope"))
                            {
                                System.out.println("Also, could you please fix my Cable?");
                            }
                            break;
                    default:
                            System.out.println("Sorry, I couldn't quite catch that. Please enter the number of your chosen option");
                            break;
                }
            }
            catch(Exception a)
            {
                System.out.println("Sorry, I couldn't quite catch that. Please enter the number of your chosen option. " + a.getMessage());
            }
        }
    }
    
    
    private String playerSell()
    {
        String inv = "";
        int counter = 1;
        for(Item item : player.getInv().getInventory())
        {
            inv += ("Item " + counter + ":   " + item.getName() + "\nCost:   " + item.getValue()+ "\n Owned by " + player.getName()+":  " + item.getItemCount() + "\n\n");
            counter++;
        }
        return inv;
    }
    
    private void sell()
    {
        boolean anotherCheck = true;
        int price = 0;
        int amount = 0;
        Item item = null;
        String choice;
        System.out.println("Oh? What would you like to sell me?\n");
        System.out.println("You currently have " + player.getWealth() + " Gold Coins\n");
        System.out.println(playerSell());
        System.out.println("Enter the number of your chosen item, or 'back' to return:\n");
        while(true)
        {
            
            Scanner s = new Scanner(System.in);
            choice = s.nextLine();
            int number;
            if(choice.toLowerCase().equals("back"))
            {
                break;
            }
            else
            {
                try
                {
                number = Integer.parseInt(choice);
                item = player.getInv().getInventory().get(number-1);
                break;
                }
                catch(Exception o)
                {
                    System.out.println("Sorry, I couldn't quite catch that. Please enter the number of your chosen item\n");
                    System.out.println("You currently have " + player.getWealth() + " Gold Coins\n");
                    System.out.println(playerSell());
                }
            }
            
        }
        if(item == null)
        {
            buySellBye();
        }
        else
        { 
            while(true)
            {
                System.out.println("How many would you like to sell?");
                if(item.isCountable())
                {
                    System.out.println("You currently have " + item.getItemCount() + " " + item.getName()+ "'s and " + player.getWealth() + " Gold Coins\n");
                }
                else
                {
                    System.out.println("You currently have " + item.getItemCount() + " " + item.getName()+ " and " + player.getWealth() + " Gold Coins\n");
                }
                Scanner f = new Scanner(System.in);
                choice = f.nextLine();
                try
                {
                    amount = Integer.parseInt(choice);
                    if(amount>0 && amount<=item.getItemCount())
                    {
                        price = amount*item.getValue();
                        break;
                    }
                    else if(amount<=0)
                    {
                        System.out.println("You must be confused, brave warrior of legend, for you cannot sell me nothing, or less then that :D\n");
                    }
                    else
                    {
                        System.out.println("It would appear you do not own this much of the item\n");
                    }
                }
                catch(Exception o)
                {
                    if(choice.toLowerCase().equals("back"))
                    {
                        anotherCheck = false;
                        break;
                    }
                    else
                    {
                        System.out.println("Sorry, I couldn't quite catch that. Please enter the amount of the item that you are selling\n");
                    }
                }
            }
            while(true)
            {
                if(anotherCheck == false)
                {
                    break;
                }
                else if(item.isCountable())
                {
                    System.out.println("Are you sure you want to sell " + amount + " " + item.getName() + "'s for " + price + " Gold Coins?\n");
                }
                else
                {
                    System.out.println("Are you sure you want to sell " + amount + " " + item.getName() + " for " + price + " Gold Coins?\n");
                }
                System.out.println("Yes/No");
                String[] valid = {"Yes", "No"};
                Scanner s = new Scanner(System.in);
                choice = s.nextLine();
                if(i.validInput(valid, choice))
                {
                    break;
                }
                else
                {
                    System.out.println("Sorry, I couldn't quite catch that. Please enter Yes or No\n");
                }
            }
            if(choice.toLowerCase().equals("yes"))//FOr some reason, after decrementing the item, the program calls buySellBuy and catches an error. Further debbugging will be needed for this fix.
            {
                System.out.println("here");
                player.getInv().decrementItem(item, -amount);
                player.setWealth(player.getWealth()+price);
            }
            this.sell();
        }
    }   
    
    private void buy()
    {
        int totalPrice = 0;
        String choice;
        int amount = 0;
        int chosenItem;
        String choiceStr; 
        Item item = null;
        while(true)
        {
            System.out.println("Theese are our current available items, please, take your pick!\n(Enter the number of your chosen item, or 'Back' to return)\n");
            System.out.println("You currently have " + player.getWealth() + " Gold Coins\n");
            System.out.println(shopkeeper.seeInventory(player));
            Scanner sc = new Scanner(System.in);
            choiceStr = sc.nextLine();
            if(choiceStr.toLowerCase().equals("back"))
            {
                break;
            }
            try
            {
                chosenItem = (Integer.parseInt(choiceStr)-1);
                item = shopkeeper.getInventory().get(chosenItem);
                break;
            }
            catch(Exception a)
            {
                System.out.println("Sorry, I couldn't quite catch that. Please enter the number of your chosen item\n");
            }
        }
        while(item != null)
        {
            System.out.println("How many would you like to buy?\n");
            try
            {
                Scanner a = new Scanner(System.in);
                choice = a.nextLine();
                amount = Integer.parseInt(choice);
                if(amount>=1)
                {
                    totalPrice = (amount-1)*item.getValue();
                    break;
                }
            }
            catch(Exception p){}
            System.out.println("Sorry, I couldn't quite catch that. Please enter a whole number that is larger then zero\n");
        }
        if(item == null)
        {
            buySellBye();
        }
        else
        {
            if(player.getWealth()>=totalPrice)
            {
                int pWealthAfter = player.getWealth() - totalPrice;
                while(true)
                {
                    if(item.isCountable())
                    {
                        System.out.println("Are you sure you wish to buy " + amount + " " + item.getName()+ "'s? You will be left with " + pWealthAfter + " Gold Coins\n");
                    }
                    else
                    {
                        System.out.println("Are you sure you wish to buy " + amount + " " + item.getName()+ "? You will be left with " + pWealthAfter + " Gold Coins\n");
                    }
                    System.out.println("Yes/No");
                    String[] valid = {"Yes", "No"};
                    Scanner s = new Scanner(System.in);
                    choice = s.nextLine();
                    if(i.validInput(valid, choice))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Sorry, I couldn't quite catch that. Please enter Yes or No\n");
                    }
                }
                if(choice.toLowerCase().equals("yes"))
                {
                    for(Item i : items.getAllItems())
                    {
                        if(i.getName().equals(item.getName()))
                        {
                            player.getInv().incrementItem(i, amount);
                            player.setWealth(pWealthAfter);
                            System.out.println("Thank you for your purchase, anything else?");
                            break;
                        }
                    }
                   
                }
                buy();
            }
            else
            {
                System.out.println("You don't seem to have enough Gold Coins to purchase this item\n");
                Scanner s = new Scanner(System.in);
                choice = s.nextLine();
                buy();
            }
        }
    }
    
}
