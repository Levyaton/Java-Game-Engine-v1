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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attacks.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Misc.*;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;

public class Bear extends Specie {

    //Specie parameters are (String givenName, int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot)
    private static Fish fish = new Fish();
    private static BearMeat meat = new BearMeat();
    private static BearBlood blood = new BearBlood();
    private static BearBone bone = new BearBone();
    private static BearClaw claw = new BearClaw();
    private static BearEye eye = new BearEye();
    private static BearSkin skin = new BearSkin();
    private static BearTooth tooth = new BearTooth();
    private static Gold gold = new Gold(100);
    private static Needle needle = new Needle();
    private static Threads thread = new Threads();
    private static Slash slash = new Slash();
    private static Charge charge = new Charge();
    private static TailPeacocking tailPeacocking = new TailPeacocking();
    private static EatUp eatUp = new EatUp();
    private static ThickSkin thickSkin = new ThickSkin();
    private static Item[] loot = new Item[]{fish.getThis(), meat.getThis(), blood.getThis(), bone.getThis(), claw.getThis(), eye.getThis(), skin.getThis(), tooth.getThis(), gold.getThis(), needle.getThis(), thread.getThis()};
    private static Attack[] attacks = new Attack[]{eatUp, slash, thickSkin, charge, tailPeacocking };
    private static int str = 60;
    private static int def = 4;
    private static int hp = 100;
    private static Double luck = 0.4;
    private static int speed = 16;
    private static String focus = "defensive";
    //Snažil jsem se tu udělat totéž, co jsi udělal v playeru, protože dostávám zase ten samej error a měl jsem stejně debilně udělaný parametry. Ale teď nevym, jak obejdu tenhle červenej problém
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
        super("Bear", str, speed, luck, def, hp, loot, attacks, 5, focus);
       
    }

      
}
