/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Species;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Healing.Apple;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;

public class BaseHuman extends Specie{
    final static Apple a = new Apple();
    final static Item[] loot = {a.getApple()};
    
    //Specie parameters are (String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot)

    final static String name = "Basic Human";
    final static int health = 50;
    final static int speed = 5;
    final static int str = 5;
    final static Double luck = 1.1;
    final static int def = 5;
    
    public BaseHuman() {
        super("Basic Human", str, speed, luck, def, health, loot);
    }
}
