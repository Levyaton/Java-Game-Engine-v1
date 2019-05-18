package GameContainer;

import java.awt.Image;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;

public class DoubleCanvas {
    private final int WINDOW_WIDTH;
    private final int WINDOW_HEIGHT;
    private final int CANVAS_HEIGHT;
    private static int[] pixels;
    private static int[] visiblePixels;
    //private final int BACKGROUND[];
    private int updateCount = 0;
    private int objectCount = 0;
    
    private Frame frame;
    private ModCanvas frontEndCanvas;
    //private ModCanvas backEndCanvas;
    private BufferedImage frontBuffer;
    //private BufferedImage backBuffer;
    private WindowListener WindowListener;
    private BufferStrategy bs;
    private Graphics graphics;
    
    public DoubleCanvas(GameContainer gc, int windowWidth, int windowHeight, int canvasHeight) {
        //this.pixels = new int [WINDOW_HEIGHT * WINDOW_WIDTH];
        WINDOW_WIDTH = windowWidth;
        WINDOW_HEIGHT = windowHeight;
        CANVAS_HEIGHT = canvasHeight;
        //BACKGROUND = new int [WINDOW_WIDTH * CANVAS_HEIGHT];
        pixels = new int [WINDOW_WIDTH * CANVAS_HEIGHT];
        visiblePixels = new int [WINDOW_WIDTH * CANVAS_HEIGHT];
        
        frame = new Frame("Game");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
                System.exit(0);
            }
        });
        
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);
        
        frontEndCanvas = new ModCanvas(WINDOW_WIDTH, CANVAS_HEIGHT);
        frontEndCanvas.setSize(WINDOW_WIDTH, CANVAS_HEIGHT);
        frame.add(frontEndCanvas);
        
        frontEndCanvas.createBufferStrategy(2);
        bs = frontEndCanvas.getBufferStrategy();
        graphics = bs.getDrawGraphics();
        
        frontBuffer = new BufferedImage(WINDOW_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_RGB);
        //backBuffer = new BufferedImage(WINDOW_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_RGB);
        
        /*for (int i = 1500; i < 1550; i++) {
            for (int j = 0; j < 900; j++) {
                frontBuffer.setRGB(i, j, 0xffffff);
            }
        }
        graphics.drawImage(frontBuffer, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, null);
        bs.show();*/
        
    }

    public static int[] getPixels() {
        return pixels;
    }

    public static int[] getVisiblePixels() {
        return visiblePixels;
    }
    
    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    public void setVisiblePixels(int[] visiblePixels) {
        this.visiblePixels = visiblePixels;
    }
    
    public ModCanvas getFrontEndCanvas() {
        return frontEndCanvas;
    }

    
    public void update() {
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
        graphics.drawImage(frontBuffer, 0, 0, WINDOW_WIDTH, CANVAS_HEIGHT, null);
        bs.show();
        
    }
    
/*    public BufferedImage getFrontBuffer() {
        return frontBuffer;
    }

    public BufferedImage getBackBuffer() {
        return backBuffer;
    }

    public void setFrontBuffer(BufferedImage frontBuffer) {
        this.frontBuffer = frontBuffer;
    }

    public void setBackBuffer(BufferedImage backBuffer) {
        this.backBuffer = backBuffer;
    }    */
    
}

class ModCanvas extends Canvas {
    private final int CANVAS_WIDTH;
    private final int CANVAS_HEIGHT;
    
    public ModCanvas(int w, int h) {
        CANVAS_HEIGHT = h;
        CANVAS_WIDTH = w;
        setBackground(Color.BLACK);
        setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    }
}