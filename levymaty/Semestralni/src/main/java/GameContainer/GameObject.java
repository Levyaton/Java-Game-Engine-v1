package GameContainer;

import cz.com.GameFiles.LevyBuild.customClasses.Species;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



public class GameObject {
    
    private int coordX, coordY;
    private final int BLOCK_SIZE;
    private int[] pixels;
    private int[] visiblePixels;
    private String filePath;
    private String filename;
    private GameContainer gc;
    private final int ENEMY_COLOR;
    private final int OBSTACLE_COLOR;
    private final int CANVAS_HEIGHT;
    private final int CANVAS_WIDTH;
    private int objectIdx;
    private Specie objSpecie;
    
    public GameObject(String filename, int coordX, int coordY, int objectIdx, GameContainer gc, int enemyColor, int obstacleColor, int canvasHeight, int canvasWidth, int blockSize) {
        ENEMY_COLOR = enemyColor;
        OBSTACLE_COLOR = obstacleColor;
        CANVAS_HEIGHT = canvasHeight;
        CANVAS_WIDTH = canvasWidth;
        BLOCK_SIZE = blockSize;
        
        if (filename == "jednorozec.png") {
            
            this.objSpecie = new Species().getBasicBear();
            this.filePath =  this.objSpecie.getSpriteLocation();
        }
        else
        {
            this.filePath = System.getProperty("user.dir") + "\\Objects\\" + filename;
        }
       
        
        this.objectIdx = objectIdx;
        this.gc = gc;
        this.filename = filename;
        this.coordX = coordX;
        this.coordY = coordY;
        //System.out.println(System.getProperty("user.dir"));  GETS PROJECT DIRECTORY
    }
    
    public void remove() {
        System.out.println("removed");
        pixels = DoubleCanvas.getPixels();
        visiblePixels = DoubleCanvas.getVisiblePixels();
        for (int i = 0; i < coordY + BLOCK_SIZE; i++) {
            for (int j = 0; j < coordX + BLOCK_SIZE; j++) {
                pixels[i * CANVAS_WIDTH + j] = 0x000000;
                visiblePixels[i * CANVAS_WIDTH + j] = 0x000000;
            }
        }
        gc.getDoubleCanvas().setVisiblePixels(visiblePixels);
        gc.getDoubleCanvas().setPixels(pixels);
    }
    
    public void draw(String filename) {
        int color = 0x000000;
        if (filename == "jednorozec.png") {
            color = ENEMY_COLOR;
        }
        if (filename == "Obstacle.png") {
            color = OBSTACLE_COLOR;
        }
        pixels = new int[CANVAS_WIDTH * CANVAS_HEIGHT];
        pixels = DoubleCanvas.getPixels();
        //System.out.println(coordY);
        //System.out.println(coordX);
        //System.out.println(coordY);
        for (int i = coordY; i < coordY + BLOCK_SIZE && i < CANVAS_HEIGHT; i++) {
            for (int j = coordX; j < coordX + BLOCK_SIZE; j++) {
                pixels[i * CANVAS_WIDTH + j] = color;
            }
        }
        
        visiblePixels = new int[CANVAS_WIDTH * CANVAS_HEIGHT];
        visiblePixels = DoubleCanvas.getVisiblePixels();
        System.out.println("Prepare for filepath");
        System.out.println(filePath);
        File objFile = new File(filePath);
        BufferedImage objImg;
        try {
            objImg = ImageIO.read(objFile);
            for (int i = coordY; i < coordY + BLOCK_SIZE && i < CANVAS_HEIGHT; i++) {
                for (int j = coordX; j < coordX + BLOCK_SIZE; j++) {
                    visiblePixels[i * CANVAS_WIDTH + j] = objImg.getRGB(j - coordX, i - coordY);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(GameObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*for (int i = coordY; i < coordY + BLOCK_SIZE && i < CANVAS_HEIGHT; i++) {
            for (int j = coordX; j < coordX + BLOCK_SIZE; j++) {
                //visiblePixels[i * CANVAS_WIDTH + j] = 
            }
        }*/
        
        gc.getDoubleCanvas().setPixels(pixels);
        gc.getDoubleCanvas().setVisiblePixels(visiblePixels);
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public int getObjectIdx() {
        return objectIdx;
    }
}