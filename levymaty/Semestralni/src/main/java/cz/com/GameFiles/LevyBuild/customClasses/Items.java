/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.GameFiles.LevyBuild.customClasses;



import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Randomness;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import java.util.ArrayList;

/**
 *  a class containing all in-game items
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
     *  initializes the class and sets the variables
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
     * initializes the class and sets the variables
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
     *  returns the index of a given Item from the ArrayList called misc
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
     * returns the index of a given Item from the ArrayList called allItems
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
     *  returns true if the item heals
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
     *  returns the index of a given Item from the ArrayList called healingItems
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
    
   
    private void apple()
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

  
    private void basketOfFood()
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

  
    private void bearMeat()
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

   
   private void bloodDrink()
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

   
    private void fish()
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

   
    private void healingPotion(int playerHealth)
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

    private void honey()
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

  
    private void jerky()
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

   
   private void sandWitch(int getDef, int getMaxHealth)
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

    private void bearBlood()
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

   
    private void bearBone()
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

  
    private void bearClaw()
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

   
    private void bearEye()
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

   
    private void bearSkin()
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

  
    private void bearTooth()
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

   
    private void gold()
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

  
    private void needle()
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

  
    private void thread()
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
     *  returns the ArrayList called allItems
     * @return
     */
    
    public ArrayList<Item> getAllItems()
    {
        return allItems;
    }
    
    /**
     * returns the ArrayList called  healingItems
     * @return
     */
    public ArrayList<Item> getHealingItems()
    {
        return healingItems;
    }
    
    /**
     * returns the ArrayList called misc
     * @return
     */
    public ArrayList<Item> getMisc()
    {
        return misc;
    }
    
    /**
     * returns the item called apple
     * @return
     */
    public Item getApple()
    {
        return apple;
    }
    
    /**
     * returns the item called basketOfFood
     * @return
     */
    public Item GetBasketOfFood()
    {
        return basketOfFood;
    }
    
    /**
     *  returns the item called bearBlood
     * @return
     */
    public Item getBearBllod()
    {
        return bearBlood;
    }
    
    /**
     *  returns the item called bearMeat
     * @return
     */
    public Item getBearMeat()
    {
        return bearMeat;
    }
    
    /** 
     *  returns the item called bloodDrink
     * @return
     */
    public Item getBloodDrink()
    {
        return bloodDrink;
    }
    
    /**
     *  returns the item called fish
     * @return
     */
    public Item getFish()
    {
        return fish;
    }
    
    /**
     *  returns the item called  healingPotion
     * @return
     */
    public Item getHealingPotion()
    {
        return healingPotion;
    }
    
    /**
     *  returns the item called honey
     * @return
     */
    public Item getHoney()
    {
        return honey;
    }
    
    /**
     *  returns the item called jerky
     * @return
     */
    public Item getJerky()
    {
        return jerky;
    }
    
    /**
     *  returns the item called sandWitch
     * @return
     */
    public Item getSandWitch()
    {
        return sandWitch;
    }
 
    /**
     *  returns the item called bearBlood
     * @return
     */
    public Item getBearBlood()
    {
        return bearBlood;
    }
    
    /**
     *  returns the item called bearBone
     * @return
     */
    public Item getBearBone()
    {
        return bearBone;
    }
    
    /**
     *  returns the item called bearClaw
     * @return
     */
    public Item getBearClaw()
    {
        return bearClaw;
    }
    
    /**
     *  returns the item called bearEye
     * @return
     */
    public Item getBearEye()
    {
        return bearEye;
    }
    
    /**
     *  returns the item called bearSkin
     * @return
     */
    public Item getBearSkin()
    {
        return bearSkin;
    }
    
    /**
     *  returns the item called bearTooth
     * @return
     */
    public Item getBearTooth()
    {
        return bearTooth;
    }
    
    /**
     *  returns the item called gold
     * @return
     */
    public Item getGold()
    {
        return gold;
    }
    
    /**
     *  returns the item called needle
     * @return
     */
    public Item getNeedle()
    {
        return needle;
    }
    
    /**
     *  returns the item called thread
     * @return
     */
    public Item getThread()
    {
        return thread;
    } 
}
