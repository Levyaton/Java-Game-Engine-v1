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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Healing.Fish;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Hands.Hand_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Heads.Head_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Legs.Leg_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Tailes.Tail_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Torsos.Torso_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;


public class Bear {
    //Specie parameters are (String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot)
    Fish fish = new Fish();
    Hand_Bear hand = new Hand_Bear();
    Head_Bear head = new Head_Bear();
    Leg_Bear leg = new Leg_Bear();
    Tail_Bear tail = new Tail_Bear();
    Torso_Bear torso = new Torso_Bear();
    Item[] bearSuit = {head.getHead(), hand.getHand(),leg.getLeg(),tail.getTail(), torso.getTorso()};
    Item[] loot = {bearSuit[0], bearSuit[1], bearSuit[2], bearSuit[3], bearSuit[4],fish.getFish()};
    Specie s = new Specie("Bear", 32, 16, 0.8, 28, 60, loot);
}
