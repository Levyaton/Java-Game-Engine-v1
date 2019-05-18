/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.GameFiles.LevyBuild.customClasses;

import cz.com.LevyatonRPGEngine.LevyBuild.Mechanics.Shop;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import java.util.ArrayList;

/**
 *
 * @author czech
 */
public class Shops {
   
    Clerks clerks;
    Shop firstShop;
    ArrayList<Shop> allShops = new ArrayList<Shop>(); 
    
    public Shops(Clerks giveClerks)
    {
        clerks = giveClerks;
        firstShop();
    }
    
    public void firstShop()
    {
        firstShop = new Shop(clerks.getFirstClerk());
        allShops.add(firstShop);
    }
    
    public void setFistShop(Clerk clerk)
    {
        firstShop = new Shop(clerk);
    }
    
    public ArrayList<Shop> getAllShops()
    {
        return allShops;
    }
}
