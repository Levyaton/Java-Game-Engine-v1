/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.PNGManager;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author czech
 */
public class Sprite {
    
    private int width;
    private int height;
    
    public Sprite(String fileLocation)
    {
        System.out.println(fileLocation);
         try {
            File f = new File(fileLocation);
            BufferedImage image = ImageIO.read(f);
            height = image.getHeight();
            width = image.getWidth();
        }
        catch (IOException ioe) {
            System.out.println("Here");
            ioe.printStackTrace();
        }
    }
    
    public int widthGetter()
    {
        return width;
    }
    
    public int heightGetter()
    {
        return height;
    }
}
