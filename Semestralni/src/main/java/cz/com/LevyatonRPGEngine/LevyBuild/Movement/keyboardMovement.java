/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Movement;

import java.awt.event.KeyEvent;

/**
 *
 * @author czech
 */
public class keyboardMovement {
    public static int[][] keyPressed(KeyEvent e, int currentX, int currentY) {
        int position[][] = {{currentY},{currentX}};
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
        {
            //move right
            array = {{},{}}
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT|| e.getKeyCode() == KeyEvent.VK_A)
        {
            //move left 
            array[0][1] = currentX--;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
        {
            //move up
            array[0][0] = currentX++;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
        {
            //move down
            array[0]--;
        }
        return array;
    }

}
