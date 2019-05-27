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

/**
 * This class represents an individual removable object in the overworld.
 * @author Viktor Bobůrka
 */
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
    private int northBound;
    private int southBound;
    private int westBound;
    private int eastBound;
    
    /**
     *
     * @param filename Name of the sprite used for the object.
     * @param coordX This object's initial X coordinate.
     * @param coordY This object's initial Y coordinate.
     * @param objectIdx Object's index in its array.
     * @param gc GameContainer.
     * @param enemyColor Hidden colour of enemies.
     * @param obstacleColor Hidden colour of obstacles.
     * @param canvasHeight Height of the overworld.
     * @param canvasWidth Width of the overworld.
     * @param blockSize The size of tiles on overworld map.
     */
    public GameObject(String filename, int coordX, int coordY, int objectIdx, GameContainer gc, int enemyColor, int obstacleColor, int canvasHeight, int canvasWidth, int blockSize) {
        ENEMY_COLOR = enemyColor;
        OBSTACLE_COLOR = obstacleColor;
        CANVAS_HEIGHT = canvasHeight;
        CANVAS_WIDTH = canvasWidth;
        BLOCK_SIZE = blockSize;
        
        this.northBound = coordY;
        this.southBound = coordY + 50;
        this.eastBound = coordX + 50;
        this.westBound = coordX;
        if (filename == "Enemy.png") {
            
            this.objSpecie = new Species().getWolf();
            this.filePath =  this.objSpecie.getSpriteLocation();
        }
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

    /**
     *
     * @param objectIdx
     */
    public void setObjectIdx(int objectIdx) {
        this.objectIdx = objectIdx;
    }

    /**
     *
     * @return Returns the index of the object's highest pixel.
     */
    public int getNorthBound() {
        return northBound;
    }

    /**
     *
     * @return Returns the index of the object's lowest pixel.
     */
    public int getSouthBound() {
        return southBound;
    }

    /**
     *
     * @return Returns the index of the object's leftmost pixel.
     */
    public int getWestBound() {
        return westBound;
    }

    /**
     *
     * @return Returns the index of the object's rightmost pixel.
     */
    public int getEastBound() {
        return eastBound;
    }

    /**
     * This method paints this object's location the default colour (black).
     */
    public void remove() {
        System.out.println("removed");
        pixels = DoubleCanvas.getPixels();
        visiblePixels = DoubleCanvas.getVisiblePixels();
        for (int i = coordY; i < coordY + BLOCK_SIZE; i++) {
            for (int j = coordX; j < coordX + BLOCK_SIZE; j++) {
                pixels[i * CANVAS_WIDTH + j] = 0x000000;
                visiblePixels[i * CANVAS_WIDTH + j] = 0x000000;
            }
        }
        gc.getDoubleCanvas().setVisiblePixels(visiblePixels);
        gc.getDoubleCanvas().setPixels(pixels);
    }

    /**
     *
     * @return Returns the name of the sprite file.
     */
    public String getFilename() {
        return filename;
    }
    
    /**
     * This method opens the sprite file and draws it on the canvas.
     */
    public void draw(String filename) {
        int color = 0x000000;
        if (filename == "jednorozec.png" || filename == "Enemy.png") {
            color = ENEMY_COLOR;
        }
        if (filename == "Obstacle.png") {
            color = OBSTACLE_COLOR;
        }
        pixels = new int[CANVAS_WIDTH * CANVAS_HEIGHT];
        pixels = gc.getDoubleCanvas().getPixels();
        //System.out.println(coordY);
        //System.out.println(coordX);
        //System.out.println(coordY);
        for (int i = coordY; i < coordY + BLOCK_SIZE && i < CANVAS_HEIGHT; i++) {
            for (int j = coordX; j < coordX + BLOCK_SIZE; j++) {
                pixels[i * CANVAS_WIDTH + j] = color;
            }
        }
        
        visiblePixels = new int[CANVAS_WIDTH * CANVAS_HEIGHT];
        visiblePixels = gc.getDoubleCanvas().getVisiblePixels();
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

    /**
     *
     * @return Returns the X coordinate of the object.
     */
    public int getCoordX() {
        return coordX;
    }

    /**
     *
     * @return Returns the Y coordinate of the object.
     */
    public int getCoordY() {
        return coordY;
    }

    /**
     *
     * @return Returns the index of the object in its array.
     */
    public int getObjectIdx() {
        return objectIdx;
    }
}