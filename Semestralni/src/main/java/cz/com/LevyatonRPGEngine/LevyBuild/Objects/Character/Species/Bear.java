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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Healing.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Hands.Hand_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Heads.Head_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Legs.Leg_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Tailes.Tail_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodyparts.Torsos.Torso_Bear;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Misc.*;


public class Bear extends Specie {
    //Specie parameters are (String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot)
    final private static Fish fish = new Fish();
   final private static  BearMeat meat = new BearMeat();
    final private static BearBlood blood = new BearBlood();
    final private static BearBone bone = new BearBone();
    final private static BearClaw claw = new BearClaw();
    final private static BearEye eye = new BearEye();
    final private static BearSkin skin = new BearSkin();
    final private static BearTooth tooth = new BearTooth();
    final private static Gold gold = new Gold();
    final private static Needle needle = new Needle();
    final private static Threads thread = new Threads();
    final private static Hand_Bear hand = new Hand_Bear();
    final private static Head_Bear head = new Head_Bear();
    final private static Leg_Bear leg = new Leg_Bear();
    final private static Tail_Bear tail = new Tail_Bear();
    final private static Torso_Bear torso = new Torso_Bear();
    final private static Item[] bearSuit = {head.getHead(), hand.getHand(),leg.getLeg(),tail.getTail(), torso.getTorso()};
    final private static Item[] loot = {fish.getThis(),meat.getThis(), blood.getThis(), bone.getThis(), claw.getThis(), eye.getThis(),skin.getThis(),tooth.getThis(),gold.getThis(),needle.getThis(),thread.getThis()};
  

    public Bear() {
        super("Bear", 32, 16, 0.8, 28, 60, loot);
    }
}
