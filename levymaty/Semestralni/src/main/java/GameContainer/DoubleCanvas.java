package GameContainer;

import java.awt.Image;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Shape;
import java.text.AttributedCharacterIterator;
import javax.swing.*;

/**
 * This class creates and manages the graphics on the overworld panel.
 * @author Viktor Bobůrka
 */
public class DoubleCanvas extends JPanel {
    private final int WINDOW_WIDTH;
    private final int WINDOW_HEIGHT;
    private final int CANVAS_HEIGHT;
    private static int[] pixels;
    private static int[] visiblePixels;
    //private final int BACKGROUND[];
    private int updateCount = 0;
    private int objectCount = 0;
    
    private GameContainer gc;
    private ModCanvas frontEndCanvas;
    private BufferedImage frontBuffer;
    private WindowListener WindowListener;
    private BufferStrategy bs;
    private Graphics graphics;
   
        
    /**
     *
     * @param gc GameContainer.
     * @param windowWidth Pixel width of the overworld.
     * @param windowHeight Pixel height of the overworld.
     * @param canvasHeight Pixel height of the overworld.
     */
    public DoubleCanvas(GameContainer gc, int windowWidth, int windowHeight, int canvasHeight) {
        //this.pixels = new int [WINDOW_HEIGHT * WINDOW_WIDTH];
        this.gc = gc;
        WINDOW_WIDTH = windowWidth;
        WINDOW_HEIGHT = windowHeight;
        CANVAS_HEIGHT = canvasHeight;
        //BACKGROUND = new int [WINDOW_WIDTH * CANVAS_HEIGHT];
        pixels = new int [WINDOW_WIDTH * CANVAS_HEIGHT];
        visiblePixels = new int [WINDOW_WIDTH * CANVAS_HEIGHT];
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);
        this.requestFocus();
        this.grabFocus();
                
        this.setVisible(true);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        frontEndCanvas = new ModCanvas(WINDOW_WIDTH, CANVAS_HEIGHT);
        frontEndCanvas.setSize(WINDOW_WIDTH, CANVAS_HEIGHT);
        //overworldPanel.add(frontEndCanvas);
        /*frontEndCanvas.createBufferStrategy(1);
        bs = frontEndCanvas.getBufferStrategy();
        graphics = bs.getDrawGraphics();*/
        frontBuffer = new BufferedImage(WINDOW_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }
    
    /**
     * 
     * @return Returns BufferedImage object that is drawn on the canvas.
     */
    public BufferedImage getFrontBuffer() {
        return frontBuffer;
    }

    /**
     * 
     * @return Returns the hidden pixels array.
     */
    public static int[] getPixels() {
        return pixels;
    }

    /**
     * 
     * @return Returns the pixels array visible to the player.
     */
    public static int[] getVisiblePixels() {
        return visiblePixels;
    }

    /**
     * Sets up the hidden pixels array.
     * 
     */
    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }


    /**
     * Sets up the pixels array visible to the player.
     * 
     */
    public void setVisiblePixels(int[] visiblePixels) {
        this.visiblePixels = visiblePixels;
    }
    
    /**
     * @return Returns the canvas.
     * 
     */
    public ModCanvas getFrontEndCanvas() {
        return frontEndCanvas;
    }

    //int x = 0;

    /**
     * This method displays any changes made to the visiblePixels array.
     */
    public void update() {
        
        //if(x%50 == 0)
        {
           // System.out.println(x);
        }
        this.add(new PanelGraphics(gc));
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);
        this.requestFocus();
        this.grabFocus();
      
        
        /*updateCount++;
        if (updateCount < 50) return;*/
        /*for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                frontBuffer.setRGB(i, j, 0x0000ff);
            }
        }*/
        
        for (int i = 0; i < CANVAS_HEIGHT - 1; i++) {
            for (int j = 0; j < WINDOW_WIDTH; j++) {
                //System.out.println(pixels[i * WINDOW_WIDTH + j]);
                frontBuffer.setRGB(j, i, visiblePixels[i*WINDOW_WIDTH + j]);
            }
        }
        
        
       this.add(new PanelGraphics(gc));
        
        //Graphics g = frontBuffer.getGraphics();
        //g.drawImage(frontBuffer, 0, 0, WINDOW_WIDTH, CANVAS_HEIGHT, null);
        
        
        /*graphics.drawImage(frontBuffer, 0, 0, WINDOW_WIDTH, CANVAS_HEIGHT, null);
        bs.show();*/
       //x++;
    }
}

class PanelGraphics extends JComponent {
    GameContainer gc;
    
    PanelGraphics (GameContainer gc) {
        setPreferredSize(new Dimension(1600, 900));
        this.gc = gc;
    }
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawImage(gc.getDoubleCanvas().getFrontBuffer(), 0, 0, gc.getWINDOW_WIDTH(), gc.getCANVAS_HEIGHT(), null);
    }
}


class ModCanvas extends Canvas {
    private final int CANVAS_WIDTH;
    private final int CANVAS_HEIGHT;
    
    public ModCanvas(int w, int h) {
        CANVAS_HEIGHT = h;
        CANVAS_WIDTH = w;
        setBackground(Color.RED);
        setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    }
}
