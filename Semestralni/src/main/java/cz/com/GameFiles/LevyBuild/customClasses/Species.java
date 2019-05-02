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

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.GameFiles.LevyBuild.customClasses.Attacks;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import java.util.ArrayList;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Randomness;

public class Species {
    
    Specie basicBear;
    Specie basicHuman;
    ArrayList<Specie> allSpecies = new ArrayList<Specie> ();
    
    Randomness rand = new Randomness();
    
    public void basicBear()
    {
        int str = 80;
        int def = 20;
        int hp = 100;
        Double luck = 0.4;
        int speed = 16;
        String focus = "defensive";
        Attacks attacks = new Attacks(hp, def);
        Items items = new Items(hp, def);
        Item[] loot = new Item[]{items.getFish(), items.getBearMeat(), items.getBearBllod(), items.getBearBone(), items.getBearClaw(), items.getBearEye(), items.getBearSkin(), items.getBearTooth(), items.getGold(), items.getNeedle(), items.getThread()};
        loot[8].incrementItemCOunt(rand.getRandomFromRange(20, 60));
        Attack[] attacksUsed = new Attack[]{attacks.getEatUp(), attacks.getSlash(), attacks.getThickSkin(), attacks.getCharge(), attacks.getTailPeacocking()};
        
        for(Attack attack : attacksUsed)
        {
            attack.setLevel(10);
        }
        
        basicBear = new Specie("Bear", str, speed, luck, def, hp, loot, attacksUsed, 5, focus);
        allSpecies.add(basicBear);
    }
    
    public void basicHuman()
    {
        String name = "Basic Human";
        int health  = 50;
        int speed = 5;
        int str = 5;
        Double luck = 0.06;
        int def = 1;
        Attacks allAttacks = new Attacks(health,def);
        Attack[] attacks = new Attack[]{allAttacks.getDoNothing(), allAttacks.getOnePunch()};
        Items items = new Items(health, def);
        Item[] loot = new Item[]{items.getApple()};
        
        for(Attack attack : attacks)
        {
            attack.setLevel(10);
        }
        
        basicHuman = new Specie("Basic Human", str, speed, luck, def, health, loot, attacks,"random");
        allSpecies.add(basicHuman);
    }
    
    public Species()
    {
        basicBear();
        basicHuman();
    }
    
    public int getAllSpeciesIndex(Item item)
    {
        int index = 0;
        for(int x = 0; x<allSpecies.size(); x++)
        {
            if(item.getName().equals(allSpecies.get(x).getName()))
            {
                index = x;
                break;
            }
        }
        return index;
    }
    
    public Specie getBasicBear()
    {
        return basicBear;
    }
    
    public Specie getBasicHuman()
    {
        return basicHuman;
    }
    
    public ArrayList<Specie> getAllSpecies()
    {
        return allSpecies;
    }
}
