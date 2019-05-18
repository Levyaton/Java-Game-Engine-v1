package GameContainer;

import java.awt.Color;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author czech
 */
public class Experimenty {
    /*/
    public static void main(String[] args){
        Window w = new Window();
    }
    /*/
    public Experimenty() {
        String filename = "jednorozec.png";
        String filePath = System.getProperty("user.dir") + "\\Objects\\" + filename;
        File inFile = new File(filePath);
        try {
            BufferedImage in = ImageIO.read(inFile);
            int[] pixels = new int [50*50];
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 50; j++) {
                    pixels[i*50 + j] = in.getRGB(i, j);
                    System.out.printf("%x\n", pixels[i*50 + j]);
                }
            }
            //pixels = in.getRGB();
        } catch (IOException ex) {
            Logger.getLogger(Experimenty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public static void main(String[] args) {
        Experimenty x = new Experimenty();
    }
    
}
