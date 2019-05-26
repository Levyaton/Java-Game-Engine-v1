/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Bodypart;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.World;
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
public class LoadTest {
    
    public LoadTest() {
    }
    
   @BeforeClass
    public static void setUpClass() {
    }
    
   @AfterClass
    public static void tearDownClass() {
    }
    
   @Before
    public void setUp() {
    }
    
 @After
    public void tearDown() {
    }

    /**
     * Test of loadWorld method, of class Load.
     */
    @Test
    public void testLoadWorld() throws Exception {
        System.out.println("loadWorld");
        Load instance = new Load();
        String expResult = "Anna";
        String result = instance.loadWorld().getPlayer().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of loadPlayer method, of class Load.
     */
   @Test
    public void testLoadPlayer() throws Exception {
        System.out.println("loadPlayer");
        Load instance = new Load();
        String expResult = "Anna";
        String result = instance.loadPlayer().getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of loadClerks method, of class Load.
     */
  @Test
    public void testLoadClerks() throws Exception {
        System.out.println("loadClerks");
        Load instance = new Load();
        String expResult = "James";
        String result = instance.loadClerks().get(0).getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of loadWealth method, of class Load.
     */
  @Test
    public void testLoadWealth() throws Exception {
        System.out.println("loadWealth");
        Load instance = new Load();
        int expResult = 3125;
        int result = instance.loadWealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of loadName method, of class Load.
     */
    @Test
    public void testLoadName() throws Exception {
        System.out.println("loadName");
        Load instance = new Load();
        String expResult = "Anna";
        String result = instance.loadName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of loadCurrentHealth method, of class Load.
     */
    @Test
    public void testLoadCurrentHealth() throws Exception {
        System.out.println("loadCurrentHealth");
        Load instance = new Load();
        int expResult = 20;
        int result = instance.loadCurrentHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of loadAttacks method, of class Load.
     */
    @Test
    public void testLoadAttacks() throws Exception {
        System.out.println("loadAttacks");
        Load instance = new Load();
        String expResult = "NullAttack";
        String result = instance.loadAttacks().get(0).getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of loadInventory method, of class Load.
     */
   @Test
    public void testLoadInventory() throws Exception {
        System.out.println("loadInventory");
        Load instance = new Load();
        String expResult = "Jerky";
       String result = instance.loadInventory().get(0).getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of loadEquipment method, of class Load.
     */
   @Test
    public void testLoadEquipment() throws Exception {
        System.out.println("loadEquipment");
        Load instance = new Load();
        String expResult = "Bear Head";
        String result = instance.loadEquipment().get(0).getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of loadCostumes method, of class Load.
     */
    @Test
    public void testLoadCostumes() throws Exception {
        System.out.println("loadCostumes");
        Load instance = new Load();
        String expResult = "Bear Torso";
        String result = instance.loadCostumes().get(0).getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
