/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.GameFiles.LevyBuild.customClasses;

import cz.com.LevyatonRPGEngine.LevyBuild.Methods.Randomness;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import java.util.ArrayList;

/**
 *
 * @author czech
 */
public class Clerks {
    
    Clerk firstClerk;
    Randomness rand = new Randomness();
    Items items = new Items();
    Attacks a = new Attacks();
    ArrayList<Clerk> allClerks = new ArrayList<Clerk>();
    public void firstClerk()
    {
        String gender;
        String name;
        String[] possibleMaleNames = {"Kurt", "Piotr", "Warren","Bobby", "Scott", "James", "Matt"};
        String[] possibleFemaleNames = {"Hope", "Linda", "Anna", "Steph","Jean", "Ororo", "Illyana" };
        if(rand.success(0.5))
        {
            gender = "Male";
            name = possibleMaleNames[rand.getRandomObjectFromSelection(possibleMaleNames)];
        }
        else
        {
            gender = "Female";
            name = possibleFemaleNames[rand.getRandomObjectFromSelection(possibleFemaleNames)];
        }
        
        int str = 20;
        int speed = 20;
        Double luck = 0.2;
        int def = 20;
        int hp = 200;
        Item[] loot = {items.thread,items.needle,items.apple,items.fish,items.honey};
        Attack[] attacks = {a.slash,a.onePunch};
        String[] dialogue = {"Welcome, traveler! What may I interest you with today?\n", "That would be \n", "Good hevens, mate, what has gotten into you?! \n", "So be it, I shall protect this store with my life!\n"};
        String focus = "aggresive";
        attacks[0].setLevel(20);
        attacks[1].setLevel(20);
        
        firstClerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender);
        
        firstClerk.setItemPrice(100, items.thread);
        firstClerk.setItemPrice(200, items.needle);
        firstClerk.setItemPrice(20, items.fish);
        firstClerk.setItemPrice(10, items.apple);
        firstClerk.setItemPrice(40, items.honey);
        allClerks.add(firstClerk);
    }


    public Clerks()
    {
        firstClerk();
    }
    
    public Clerk getFirstClerk()
    {
        return allClerks.get(allClerks.indexOf(firstClerk));
    }
   
    public ArrayList<Clerk> getAllClerks()
    {
        return allClerks;
    }
}
