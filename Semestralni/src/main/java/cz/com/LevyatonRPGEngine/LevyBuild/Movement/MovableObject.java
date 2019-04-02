/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Movement;

/**
 *
 * @author czech
 */
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import cz.com.LevyatonRPGEngine.LevyBuild.PNGManager.Sprite;
import java.awt.event.KeyEvent;


public class MovableObject {
    
    protected boolean playerControlled;
    protected String movementType;
    protected int[][] position = ;
    
    
    public MovableObject(boolean controlledByPlayer, boolean isStill, String movement, String imagelocation)
   {
       playerControlled = controlledByPlayer;
       movementType = movement;
       Sprite s = new Sprite(imagelocation);
   }
   
    public boolean playerControlledGetter()
    {
        return playerControlled;
    }
    
    public String movementTypeGetter()
    {
        return movementType;
    }
    
    public int[] move(int currentX, int currentY)
    {
    
        if(movementTypeGetter().equals("Keyboard"))
        {
            int array[]= keyboardMovement.keyPressed(KeyEvent e, currentX, currentY);
        }
    }
}
