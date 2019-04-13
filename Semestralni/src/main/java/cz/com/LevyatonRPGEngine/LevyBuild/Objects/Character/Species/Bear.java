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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Misc.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;


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
    final private static Gold gold = new Gold(100);
    final private static Needle needle = new Needle();
    final private static Threads thread = new Threads();
    final private static Slash slash = new Slash();
    final private static Charge charge = new Charge();
    final private static TailPeacocking tailPeacocking = new TailPeacocking();
    final private static EatUp eatUp = new EatUp();
    final private static ThickSkin thickSkin = new ThickSkin();
    final private static Item[] loot = {fish.getThis(),meat.getThis(), blood.getThis(), bone.getThis(), claw.getThis(), eye.getThis(),skin.getThis(),tooth.getThis(),gold.getThis(),needle.getThis(),thread.getThis()};
    final private static Attack[] attacks = {eatUp,slash,thickSkin,charge,tailPeacocking};
    
            
    /*      
    [0] = HEAD
    [1] = RIGHT HAND
    [2] = LEFT HAND
    [3] = TORSO
    [4] = RIGHT LEG
    [5] = LEFT LEG
    [6] = TAIL
    */
            
    public Bear() {
        super("Bear", 32, 16, 0.8, 28, 60, loot,attacks);
    }
}
