/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.GameFiles.LevyBuild.customClasses;

/**
 *
 * @author czech
 */

import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Randomness;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import java.util.ArrayList;

/**
 *
 * @author czech
 */
public class Items {
    
    ArrayList<Item> allItems = new  ArrayList<Item>();
    Randomness rand = new Randomness();
    
    //Healing
    ArrayList<Item> healingItems = new  ArrayList<Item>();
    
    Item apple;
    Item basketOfFood;
    Item bearMeat;
    Item bloodDrink;
    Item fish;
    Item healingPotion;
    Item honey;
    Item jerky;
    Item sandWitch;
    
    
    
    //Misc.
    ArrayList<Item> misc = new  ArrayList<Item>();
    
    Item bearBlood;
    Item bearBone;
    Item bearClaw;
    Item bearEye;
    Item bearSkin;
    Item bearTooth;
    Item gold;
    Item needle;
    Item thread;
    
    /**
     *
     */
    public Items()
    {
        this.apple();
        this.basketOfFood();
        this.bearBlood();
        this.bearMeat();
        this.bloodDrink();
        this.fish();
        this.honey();
        this.jerky();
        this.bearBlood();
        this.bearBone();
        this.bearClaw();
        this.bearEye();
        this.bearSkin();
        this.bearTooth();
        this.gold();
        this.needle();
        this.thread();
    }
    
    /**
     *
     * @param giveHealth
     * @param giveDef
     */
    public Items(int giveHealth, int giveDef)
    {
        this.apple();
        this.basketOfFood();
        this.bearBlood();
        this.bearMeat();
        this.bloodDrink();
        this.fish();
        this.healingPotion(giveHealth);
        this.honey();
        this.jerky();
        this.sandWitch(giveDef, giveHealth);
        this.bearBlood();
        this.bearBone();
        this.bearClaw();
        this.bearEye();
        this.bearSkin();
        this.bearTooth();
        this.gold();
        this.needle();
        this.thread();
    }
    
    /**
     *
     * @param item
     * @return
     */
    public int getMiscItemIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<misc.size(); x++)
        {
            if(item.getName().equals(misc.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    /**
     *
     * @param item
     * @return
     */
    public int getAllItemIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<allItems.size(); x++)
        {
            if(item.getName().equals(allItems.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    /**
     *
     * @param checkedItem
     * @return
     */
    public boolean heals(Item checkedItem)
    {
        for(Item item : healingItems)
        {
            if(item.getName().equals(checkedItem.getName()))
            {
                return true;
            }
        }
       return false;
    }
    
    /**
     *
     * @param item
     * @return
     */
    public int halingItemIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<healingItems.size(); x++)
        {
            if(item.getName().equals(healingItems.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    //Healing
    
    private int healthGiver(int getPlayerDef, int getPlayerMaxHealth)
    {
        int witchAttack = rand.getRandomFromRange(30, 200);
        if(getPlayerDef>witchAttack)
        {
            return getPlayerMaxHealth;
        }
        return -((int) Math.round(getPlayerMaxHealth*0.75));
    }
    
    /**
     *
     */
    public void apple()
    {
        int healthGain = 5;//How much health will the Apple restore
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
        String description = "A juicy looking apple";
        int value = 3;
        Double dropRate = 0.8;
        
        apple = new Item("Apple", "Movable", spriteLocation, dropRate,description,value,healthGain);
        this.allItems.add(apple);
        this.healingItems.add(apple);
    }

    /**
     *
     */
    public void basketOfFood()
    {
        String name = "Basket of Food";
        String state = "Movable";
        int healthGain = 5;//How much health will the Apple restore
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
        String description = "A basket left by an unknown individual with varying content";
        int value = 3;
        Double dropRate = 0.8;
        
        basketOfFood = new Item(name, state, spriteLocation, dropRate, description, value);
        this.allItems.add(basketOfFood);
        this.healingItems.add(basketOfFood);
    }

    /**
     *
     */
    public void bearMeat()
    {
        int healthGain = 10;//How much health will the Apple restore
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\HealingItems\\BearMeat.png";//Currently doesn't exist
        String description = "The meat of a bear";
        String name = "Bear Meat";
        int value = 10;
        Double dropRate = 0.7;
        String status = "Movable";
        
        bearMeat = new Item(name, status, spriteLocation, dropRate, description, value, healthGain);
        bearMeat.countable(false);
        this.allItems.add(bearMeat);
        this.healingItems.add(bearMeat);
    }

    /**
     *
     */
    public void bloodDrink()
    {
        String name = "Blood Drink";
        String state = "Movable";
        int healthGain = 5;//How much health will the Apple restore
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
        String description = "\n  ...or is it Clamato Juice?";
        int value = 13;
        Double dropRate = 0.1;
        
        bloodDrink = new Item(name, state, spriteLocation, dropRate, description, value, healthGain);
        this.allItems.add(bloodDrink);
        this.healingItems.add(bloodDrink);
    }

    /**
     *
     */
    public void fish()
    {
        int healthGain = 10;//How much health will the Fish restore
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Fish.png";//Currently doesn't exist
        String description = "A raw fish";
        int value = 7;
        Double dropRate = 0.8;
        
        fish = new Item("Fish", "Movable", spriteLocation, dropRate,description,value,healthGain);
        this.allItems.add(fish);
        this.healingItems.add(fish);
    }

    /**
     *
     * @param playerHealth
     */
    public void healingPotion(int playerHealth)
    {
        Randomness rand = new Randomness();
        String name = "Health Potion";
        String state = "Movable";
        Double chanceOfNegativeEffect = 0.08;
        Double goodHealing = 0.75;
        Double badHealing = -0.5;
        Double healthGain = rand.getChanceOfEffect(chanceOfNegativeEffect, badHealing, goodHealing);//How much health will the Apple restore
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
        String description = "Will heal you...probably";
        int value = 50;
        Double dropRate = 0.1;
        
        healingPotion = new Item(name, state, spriteLocation, dropRate, description, ((int) Math.round(playerHealth*healthGain)));
        this.allItems.add(healingPotion);
        this.healingItems.add(healingPotion);
    }

    /**
     *
     */
    public void honey()
    {
        String name = "Honey";
        String state = "Movable";
        int healthGain = 20;//How much health will the Apple restore
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
        String description = "\n  ...it's just honey, what more is there to say about it?";
        int value = 15;
        Double dropRate = 0.35;
        
        honey = new Item(name, state, spriteLocation, dropRate, description, value, healthGain);
        honey.countable(false);
        this.allItems.add(honey);
        this.healingItems.add(honey);
    }

    /**
     *
     */
    public void jerky()
    {
        String name = "Jerky";
        String state = "Movable";
        int healthGain = 10;//How much health will the Apple restore
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
        String description = "Overprised, and oversalted dried meat, yet still delitious ";
        int value = 70;
        Double dropRate = 0.05;
        
        jerky = new Item(name, state, spriteLocation, dropRate, description, value, healthGain);
        this.allItems.add(jerky);
        this.healingItems.add(jerky);
    }

    /**
     *
     * @param getDef
     * @param getMaxHealth
     */
    public void sandWitch(int getDef, int getMaxHealth)
    {
        String name = "SandWitch";
        String state = "Movable";
        String spriteLocation = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Apple.png";//Currently doesn't exist
        String description = "It seems to yell curses at you, as if to indicate it's sentience. The sandwich also seems to contain a lot of sand. Still, there is now way the sandwich is a person...right?";
        int value = 0;
        Double dropRate = 0.2;
        
        sandWitch = new Item(name, state, spriteLocation, dropRate, description, value, rand.healthGiver(getDef, getMaxHealth, 30, 200, 0.75));
        this.allItems.add(sandWitch);
        this.healingItems.add(sandWitch);
    }
    
    
    //Misc.

    /**
     *
     */
    public void bearBlood()
    {
    int value = 1;//The value of a single gold coin
    String description = "The blood of a bear";
    String location = System.getProperty("user.dir" + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");//Currently doesn't exist
    String name = "Bear Blood";
    String status = "Interactable";
    Double dropRate = 0.6;
    bearBlood = new Item(name, status, location, dropRate, description, value);
    bearBlood.countable(false);
    allItems.add(bearBlood);
    misc.add(bearBlood);
    }

    /**
     *
     */
    public void bearBone()
    {
    int value = 7;//The value of a single gold coin
    String description = "The bone of a bear";
    String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearBone.png";//Currently doesn't exist
    String name = "Bear Bone";
    String status = "Interactable";
    Double dropRate = 0.3;
    bearBone = new Item(name, status, location, dropRate, description, value);
    allItems.add(bearBone);
    misc.add(bearBone);
    }

    /**
     *
     */
    public void bearClaw()
    {
    int value = 5;//The value of a single gold coin
    String description = "Claws of a bear";
    String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png";//Currently doesn't exist
    String name = "Bear Claw";
    String status = "Interactable";
    Double dropRate = 0.25;
    bearClaw = new Item(name, status, location, dropRate, description, value);
    allItems.add(bearClaw);
    misc.add(bearClaw);
    }

    /**
     *
     */
    public void bearEye()
    {
    int value = 15;//The value of a single gold coin
    String description = "The eye of a bear";
    String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearEye.png";//Currently doesn't exist
    String name = "Bear Eye";
    String status = "Interactable";
    Double dropRate = 0.1;
    bearEye = new Item(name, status, location, dropRate, description, value);
    allItems.add(bearEye);
    misc.add(bearEye);
    }

    /**
     *
     */
    public void bearSkin()
    {
    int value = 10;//The value of a single gold coin
    String description = "The skin of a bear - Fur included! Will suit all you furry needs :-b";
    String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearSkin.png";//Currently doesn't exist
    String name = "Bear Skin";
    String status = "Interactable";
    Double dropRate = 0.15;
    bearSkin = new Item(name, status, location, dropRate, description, value);
    allItems.add(bearSkin);
    misc.add(bearSkin);
    }

    /**
     *
     */
    public void bearTooth()
    {
    int value = 5;//The value of a single gold coin
    String description = "A single tooth of a bear";
    String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearTooth.png";//Currently doesn't exist
    String name = "Bear tooth";
    String status = "Interactable";
    Double dropRate = 0.3;
    bearTooth = new Item(name, status, location, dropRate, description, value);
    allItems.add(bearTooth);
    misc.add(bearTooth);
    }

    /**
     *
     */
    public void gold()
    {
    int value = 1;//The value of a single gold coin
    String description = "A single gold coin";
    String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\Gold_Coin.png";//Currently doesn't exist
    String name = "Gold Coin";
    String status = "Interactable";
    Double dropRate = 1.0;
    gold = new Item(name, status, location, dropRate, description, value);
    allItems.add(gold);
    misc.add(gold);
    }

    /**
     *
     */
    public void needle()
    {
    int value = 1;//The value of a single gold coin
    String description = "A silver needle - Be sure to purchise a thread as well!";
    String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\Needle.png";//Currently doesn't exist
    String name = "Silver Needle";
    String status = "Interactable";
    Double dropRate = 0.000000001;
    needle = new Item(name, status, location, dropRate, description, value);
    allItems.add(needle);
    misc.add(needle);
    }

    /**
     *
     */
    public void thread()
    {
    int value = 1;//The value of a single gold coin
    String description = "Some thread - good for stiching, but don't forget to get a needle!";
    String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\Thread.png";//Currently doesn't exist
    String name = "Thread";
    String status = "Interactable";
    Double dropRate = 0.000000001;;
    thread = new Item(name, status, location, dropRate, description, value);
    thread.countable(false);
    allItems.add(thread);
    misc.add(thread);
    }
    
    //Getters

    /**
     *
     * @return
     */
    
    public ArrayList<Item> getAllItems()
    {
        return allItems;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Item> getHealingItems()
    {
        return healingItems;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Item> getMisc()
    {
        return misc;
    }
    
    /**
     *
     * @return
     */
    public Item getApple()
    {
        return apple;
    }
    
    /**
     *
     * @return
     */
    public Item GetBasketOfFood()
    {
        return basketOfFood;
    }
    
    /**
     *
     * @return
     */
    public Item getBearBllod()
    {
        return bearBlood;
    }
    
    /**
     *
     * @return
     */
    public Item getBearMeat()
    {
        return bearMeat;
    }
    
    /**
     *
     * @return
     */
    public Item getBloodDrink()
    {
        return bloodDrink;
    }
    
    /**
     *
     * @return
     */
    public Item getFish()
    {
        return fish;
    }
    
    /**
     *
     * @return
     */
    public Item getHealingPotion()
    {
        return healingPotion;
    }
    
    /**
     *
     * @return
     */
    public Item getHoney()
    {
        return honey;
    }
    
    /**
     *
     * @return
     */
    public Item getJerky()
    {
        return jerky;
    }
    
    /**
     *
     * @return
     */
    public Item getSandWitch()
    {
        return sandWitch;
    }
 
    /**
     *
     * @return
     */
    public Item getBearBlood()
    {
        return bearBlood;
    }
    
    /**
     *
     * @return
     */
    public Item getBearBone()
    {
        return bearBone;
    }
    
    /**
     *
     * @return
     */
    public Item getBearClaw()
    {
        return bearClaw;
    }
    
    /**
     *
     * @return
     */
    public Item getBearEye()
    {
        return bearEye;
    }
    
    /**
     *
     * @return
     */
    public Item getBearSkin()
    {
        return bearSkin;
    }
    
    /**
     *
     * @return
     */
    public Item getBearTooth()
    {
        return bearTooth;
    }
    
    /**
     *
     * @return
     */
    public Item getGold()
    {
        return gold;
    }
    
    /**
     *
     * @return
     */
    public Item getNeedle()
    {
        return needle;
    }
    
    /**
     *
     * @return
     */
    public Item getThread()
    {
        return thread;
    } 
}
