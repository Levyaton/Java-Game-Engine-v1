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

public class BaseHuman {
    Apple a = new Apple();
    Item[] loot = {a.getApple()};
    //Specie parameters are (String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot)
    Specie s = new Specie("Basic Human", 5, 5, 1.1, 5, 50, loot);
}
