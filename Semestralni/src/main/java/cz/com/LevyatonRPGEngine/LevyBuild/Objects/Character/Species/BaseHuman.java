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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Healing.Apple;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;

public class BaseHuman extends Specie {

    private Apple a;
    private static Item[] loot;

    //Specie parameters are (String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot)
    private static String name;
    private static int health;
    private static int speed;
    private static int str;
    private static Double luck;
    private static int def;
    private static DoNothing nothing = new DoNothing();
    private static Attack[] attacks = new Attack[]{nothing};

    public BaseHuman() {
        super("Basic Human", str, speed, luck, def, health, loot, attacks,"random");
        properties();
    }

    private void properties() {
        this.a = new Apple();
        this.loot = new Item[]{a.getThis()};

        //Specie parameters are (String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot)
        this.name = "Basic Human";
        this.health = 50;
        this.speed = 5;
        this.str = 5;
        this.luck = 0.06;
        this.def = 1;
       
    }
}
