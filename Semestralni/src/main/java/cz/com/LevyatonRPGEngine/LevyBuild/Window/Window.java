/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author czech
 */
public class Window {
    /*/
    public static void main(String[] args){
        Window w = new Window();
    }
    /*/
    public Window() {
        JFrame frame = new JFrame();
        frame.setSize(1200,1200);//Change windows size to change the game window
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   
}
