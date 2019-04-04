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


public class Bear {
    //Specie parameters are (String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot)
    Fish fish = new Fish();
    BearMeat meat = new BearMeat();
    BearBlood blood = new BearBlood();
    BearBone bone = new BearBone();
    BearClaw claw = new BearClaw();
    BearEye eye = new BearEye();
    BearSkin skin = new BearSkin();
    BearTooth tooth = new BearTooth();
    Gold gold = new Gold();
    Needle needle = new Needle();
    Threads thread = new Threads();
    Hand_Bear hand = new Hand_Bear();
    Head_Bear head = new Head_Bear();
    Leg_Bear leg = new Leg_Bear();
    Tail_Bear tail = new Tail_Bear();
    Torso_Bear torso = new Torso_Bear();
    Item[] bearSuit = {head.getHead(), hand.getHand(),leg.getLeg(),tail.getTail(), torso.getTorso()};
    Item[] loot = {fish.getFish(),meat.getBearMeat(), blood.getBearBlood(), bone.getBearBonde(), claw.getBearClaw(), eye.getBearEye(),skin.getBearSkin(),tooth.getBearTooth(),gold.getGold(),needle.getNeedle(),thread.getThreads()};
    Specie s = new Specie("Bear", 32, 16, 0.8, 28, 60, loot);
}
