/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player;

import cz.com.GameFiles.LevyBuild.customClasses.Attacks;
import cz.com.GameFiles.LevyBuild.customClasses.Bodyparts;
import cz.com.GameFiles.LevyBuild.customClasses.Items;
import cz.com.GameFiles.LevyBuild.customClasses.Species;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author czech
 */
public class PlayerTest {
  
    Specie human;
    Bodyparts bodyparts;
    Player instance;
    Attacks attacks;
    Equipment equipment;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        human = new Species().getBasicHuman();
        bodyparts = new Bodyparts(0,0);
        attacks = new Attacks();
        instance = new Player("Bob");
        equipment = new Equipment();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updatePlayerStats method, of class Player.
     */
    @Test
    public void testUpdatePlayerStats() {
        System.out.println("updatePlayerStats");
        
        instance.updatePlayerStats();
        
        int expMaxHealth = 171;
        int expSpeed =  61;
        int expStr = 93;
        Double expLuck = 0.62;
        int expDef = 13;
        
        int resultHp = instance.getMaxHealth();
        int resultSpeed = instance.getSpeed();
        int resultStr = instance.getStr();
        Double resultLuck = instance.getLuck();
        int resultDef = instance.getDef();
        
        
        assertEquals(expMaxHealth, resultHp);
        assertEquals(expSpeed, resultSpeed);
        assertEquals(expStr, resultStr);
        assertEquals(expLuck, resultLuck);
        assertEquals(expDef, resultDef);
        
        
        
        
        
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of getCurrentHealth method, of class Player.
     */
    @Test
    public void testGetCurrentHealth() {
        System.out.println("getCurrentHealth");
      
        int expResult = instance.getMaxHealth();
        int result = instance.getCurrentHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of incrementCurrentHealth method, of class Player.
     */
    @Test
    public void testIncrementCurrentHealth() {
        System.out.println("incrementCurrentHealth");
        int hpChange = 1;
        int expResult = instance.getCurrentHealth() + hpChange;
        instance.incrementCurrentHealth(hpChange);
        int result = instance.getCurrentHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of setCurrentHealth method, of class Player.
     */
    @Test
    public void testSetCurrentHealth() {
        System.out.println("setCurrentHealth");
        
        int hpChange = 50;
        int expResult = hpChange;
        instance.setCurrentHealth(hpChange);
        int result = instance.getCurrentHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of getMaxHealth method, of class Player.
     */
    @Test
    public void testGetMaxHealth() {
        System.out.println("getMaxHealth");
       
        int expResult = human.getHP();
        int result = instance.getMaxHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of getSpeed method, of class Player.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
       
        int expResult = 10;
        int result = instance.getSpeed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getDef method, of class Player.
     */
    @Test
    public void testGetDef() {
        System.out.println("getDef");
      
        int expResult = human.getDef();
        int result = instance.getDef();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of getStr method, of class Player.
     */
    @Test
    public void testGetStr() {
        System.out.println("getStr");
        
        int expResult = 10;
        int result = instance.getStr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getLuck method, of class Player.
     */
    @Test
    public void testGetLuck() {
        System.out.println("getLuck");
       
        Double expResult = human.getLuck();
        Double result = instance.getLuck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getAvailableAttacks method, of class Player.
     */
    @Test
    public void testGetAvailableAttacks() {
        System.out.println("getAvailableAttacks");
        
       
        int expResult = 5;
        int result = instance.getAvailableAttacks().size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getEquipment method, of class Player.
     */
    @Test
    public void testGetEquipment() {
        System.out.println("getEquipment");
        
        String expResult = bodyparts.getHeadBear().getName();
        String result = instance.getEquipment().getHead().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getEquipped method, of class Player.
     */
    @Test
    public void testGetEquipped() {
        System.out.println("getEquipped");
        Bodypart[] equipped = new Bodypart[7];
        for(int x = 0;x<6;x++)
        {
            equipped[x] = bodyparts.getEmptySlot();
        }
        equipped[6] = bodyparts.getEmptyTail();
        
        String expResult = bodyparts.getHeadBear().getName();
        String result = instance.getEquipped()[0].getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of levelAttack method, of class Player.
     */
    @Test
    public void testLevelAttack() throws Exception {
        System.out.println("levelAttack");
 
        Attack attack = instance.getAllAttacks().get(0);
        int expResult = attack.getLevel()+1;
        int exp = instance.getAllAttacks().get(0).getExperienceNeeded();
        instance.levelAttack(attack, exp);
        int result = attack.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setLevelAttack method, of class Player.
     */
    @Test
    public void testSetLevelAttack() {
        System.out.println("setLevelAttack");
        Attack attack = instance.getAllAttacks().get(1);
        int level = 10;
        int expResult = level;
        instance.setLevelAttack(attack, level);
        int result = attack.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of addItemToInv method, of class Player.
     */
    @Test
    public void testAddItemToInv() {
        System.out.println("addItemToInv");
        Item item = new Items().getApple();
        String expResult = item.getName();
        instance.addItemToInv(item);
        String result = instance.getInv().getItem(item.getName()).getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setWealth method, of class Player.
     */
    @Test
    public void testSetWealth() {
        System.out.println("setWealth");
        int number = 0;
        int expResult = number;
        instance.setWealth(number);
        int result = instance.getWealth();
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getWealth method, of class Player.
     */
    @Test
    public void testGetWealth() {
        System.out.println("getWealth");
        int expResult = 0;
        int result = instance.getWealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setHead method, of class Player.
     */
    @Test
    public void testSetHead() {
        System.out.println("setHead");
        Bodypart giveHead = bodyparts.getHeadBear();
        String expResult = giveHead.getName();
        instance.setHead(giveHead);
        String result = instance.getEquipment().getHead().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of setRightHand method, of class Player.
     */
    @Test
    public void testSetRightHand() {
        System.out.println("setRightHand");
        Bodypart giveHand = bodyparts.getHandBear();
        String expResult = giveHand.getName();
        instance.setRightHand(giveHand);
        String result = instance.getEquipment().getRightHand().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setLeftHand method, of class Player.
     */
    @Test
    public void testSetLeftHand() {
        System.out.println("setLeftHand");
        Bodypart giveHand = bodyparts.getHandBear();
        String expResult = giveHand.getName();
        instance.setLeftHand(giveHand);
        String result = instance.getEquipment().getLeftHand().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of setTorso method, of class Player.
     */
    @Test
    public void testSetTorso() {
        System.out.println("setTorso");
        Bodypart giveTorso = bodyparts.getTorsoBear();
        String expResult = giveTorso.getName();
        instance.setTorso(giveTorso);
        String result = instance.getEquipment().getTorso().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setRightLeg method, of class Player.
     */
    @Test
    public void testSetRightLeg() {
        System.out.println("setRightLeg");
        Bodypart giveLeg = bodyparts.getLegBear();
        String expResult = giveLeg.getName();
        instance.setRightLeg(giveLeg);
        String result = instance.getEquipment().getRightLeg().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setLeftLeg method, of class Player.
     */
    @Test
    public void testSetLeftLeg() {
        System.out.println("setLeftLeg");
        Bodypart giveLeg = bodyparts.getLegBear();
        String expResult = giveLeg.getName();
        instance.setLeftLeg(giveLeg);
        String result = instance.getEquipment().getLeftLeg().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of setTail method, of class Player.
     */
    @Test
    public void testSetTail() {
        System.out.println("setTail");
        Bodypart giveTail = bodyparts.getTailBear();
        String expResult = giveTail.getName();
        instance.setTail(giveTail);
        String result = instance.getEquipment().getTail().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getAllAttacks method, of class Player.
     */
    @Test
    public void testGetAllAttacks() {
        System.out.println("getAllAttacks");
        ArrayList<Attack> allAttacks = attacks.getAllAttacks();
        
        String expResult = allAttacks.get(0).getName();
        
        String result = instance.getAllAttacks().get(0).getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of getInventory method, of class Player.
     */
    @Test
    public void testGetInventory() {
        System.out.println("getInventory");
        int expResult = 0;
        int result = instance.getInventory().size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getInv method, of class Player.
     */
    @Test
    public void testGetInv() {
        System.out.println("getInv");
        
        boolean expResult = false;
        boolean result;
        if(instance.getInv() == null)
        {
            result = true;
        }
        else
        {
            result = false;
        }
        
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of getCostumes method, of class Player.
     */
    @Test
    public void testGetCostumes() {
        System.out.println("getCostumes");
        boolean expResult = false;
        boolean result;
        if(instance.getCostumes() == null)
        {
            result = true;
        }
        else
        {
            result = false;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}
