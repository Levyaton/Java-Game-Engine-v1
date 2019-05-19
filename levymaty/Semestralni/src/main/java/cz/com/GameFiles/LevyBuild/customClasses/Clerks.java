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
    String[] traits = {"friendly", "stern", "jovial", "grumpy", "serious", "sad"};
         
    
    public Clerk getIllyana(int mod)       
    {
        Clerk clerk;
        String gender = "female";
        String name = "Illyana";
        String trait = traits[5];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getBetsy(int mod)       
    {
        Clerk clerk;
        String gender = "female";
        String name = "Betsy";
        String trait = traits[2];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getOroro(int mod)       
    {
        
        Clerk clerk;
        String gender = "female";
        String name = "Ororo";
        String trait = traits[1];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getJean(int mod)       
    {
        
        Clerk clerk;
        String gender = "female";
        String name = "Jean";
        String trait = traits[4];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getSteph(int mod)       
    {
        
        Clerk clerk;
        String gender = "female";
        String name = "Steph";
        String trait = traits[0];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getAnna(int mod)       
    {
        
        Clerk clerk;
        String gender = "female";
        String name = "Anna";
        String trait = traits[1];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getLinda(int mod)       
    {
        
        Clerk clerk;
        String gender = "female";
        String name = "Linda";
        String trait = traits[2];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getHope(int mod)       
    {
        
        Clerk clerk;
        String gender = "female";
        String name = "Hope";
        String trait = traits[1];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getMatt(int mod)       
    {
        
        Clerk clerk;
        String gender = "male";
        String name = "Matt";
        String trait = traits[0];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getJames(int mod)       
    {
        
        Clerk clerk;
        String gender = "male";
        String name = "James";
        String trait = traits[3];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getScott(int mod)       
    {
        
        Clerk clerk;
        String gender = "male";
        String name = "Scott";
        String trait = traits[1];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getBobby(int mod)       
    {
        
        Clerk clerk;
        String gender = "male";
        String name = "Bobby";
        String trait = traits[4];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    
    public Clerk getWarren(int mod)       
    {
        Clerk clerk;
        String gender = "male";
        String name = "Warren";
        String trait = traits[4];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getKurt(int mod)       
    {
        
        Clerk clerk;
        String gender = "male";
        String name = "Kurt";
        String trait = traits[0];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    public Clerk getPiotr(int mod)       
    {
        
        Clerk clerk;
        String gender = "male";
        String name = "Piotr";
        String trait = traits[2];
        
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
        
        clerk = new Clerk(name, str,speed, luck,def, hp, loot, attacks, focus, dialogue, gender,trait);
        
        clerk.setItemPrice(100, items.thread);
        clerk.setItemPrice(200, items.needle);
        clerk.setItemPrice(20, items.fish);
        clerk.setItemPrice(10, items.apple);
        clerk.setItemPrice(40, items.honey);
        allClerks.add(clerk);
        return clerk;
    }
    
    
            
    public  void setFirstClerk()
    {
        String gender;
        String name;
        String trait;
       
        Clerk[] possibleClerks = {this.getAnna(10),this.getBobby(10),this.getHope(10),this.getIllyana(10),this.getJames(10),this.getJean(10),this.getKurt(10),this.getLinda(10),this.getMatt(10),this.getOroro(10),this.getPiotr(10),this.getScott(10),this.getSteph(10),this.getWarren(10),this.getBetsy(10)};
        firstClerk = possibleClerks[rand.getRandomObjectFromSelection(possibleClerks)];
    }

    public void setFirstClerk(String name)
    {
        for(Clerk c : getAllClerks())
        {
            if(c.getName().equals(name))
            {
                firstClerk = c;
            }
        }
    }
   
    public Clerk loadClerk(String name)
    {
        for(Clerk c : getAllClerks())
        {
            if(c.getName().equals(name))
            {
                return c;
            }
        }
        return getFirstClerk();
    }

    public Clerks()
    {
        setFirstClerk();
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
