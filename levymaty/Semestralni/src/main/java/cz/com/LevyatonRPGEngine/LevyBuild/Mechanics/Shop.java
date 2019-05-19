/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Mechanics;

import cz.com.GameFiles.LevyBuild.customClasses.Items;
import cz.com.LevyatonRPGEngine.LevyBuild.Methods.InputCheckers;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Clerk;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
import cz.com.LevyatonRPGEngine.LevyBuild.Window.MainFrame;
import java.util.Scanner;

/**
 *
 * @author czech
 */
public class Shop {
    
    private Clerk clerk;

    private MainFrame mf;
    
    public Shop(Clerk clerk,MainFrame m)
    {
        mf= m;
        this.clerk = clerk;
    }
    
    public void write(String text) throws InterruptedException
    {
        mf.writeShopText(text);
    }
    
    public void greeting() throws InterruptedException
    {
        
        write(clerk.getName() + " looks at you with " + clerk.getTrait() + " eyes\n\n" + clerk.getName() + ":   What can I interest you in, traveller?\n");
    }
    
    public void buy() throws InterruptedException
    {
        write(clerk.getName() + ":   What would you like to buy?\n");
    }

   
}