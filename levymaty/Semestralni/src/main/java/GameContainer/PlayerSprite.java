package GameContainer;

import cz.com.GameFiles.LevyBuild.customClasses.Species;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Specie;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author czech
 */
public class PlayerSprite {
    private final int PLAYER_SPEED;
    private GameContainer gc;
    private int coordX, coordY;
    private String filename;
    private String filePath;
    private int WIDTH = 50;
    private int HEIGHT = 50;
    private final int CANVAS_HEIGHT;
    private final int WINDOW_WIDTH;
    private final int ENEMY_COLOR;
    private final int OBSTACLE_COLOR;
    private int[] pixels;
    private int[] visiblePixels;
    private ReadInput readInput;
    private char facingDirection;
    private boolean facingEnemy;
    private int numberOfEnemiesFaced = 0;
    
    /**
     *
     * @param filename
     * @param coordX
     * @param coordY
     * @param gc
     * @param readInput
     * @param canvasHeight
     * @param windowWidth
     * @param enemyColor
     * @param obstacleColor
     */
    public PlayerSprite (String filename, int coordX, int coordY, GameContainer gc, ReadInput readInput, int canvasHeight, int windowWidth, int enemyColor, int obstacleColor) {
        
        ENEMY_COLOR = enemyColor;
        OBSTACLE_COLOR = obstacleColor;
        CANVAS_HEIGHT = canvasHeight;
        WINDOW_WIDTH = windowWidth;
        facingDirection = 'D';
        this.readInput = readInput;
        this.gc = gc;
        this.filename = filename;
        this.coordX = coordX;
        this.coordY = coordY;
        filePath = System.getProperty("user.dir") + "\\Objects\\" + filename;
        PLAYER_SPEED = 2;  //must divide 50 because im lazy
    }
    
    /**
     *
     * @return
     */
    
    public GameObject getFacingEnemy() {
        System.out.println(gc.getObjManager().getBcount());

        if (facingDirection == 'A') {
            for (int i = 0; i < gc.getObjManager().getBcount(); i++ ) {
                //System.out.println(gc.getObjManager().getClassB()[i].getCoordX()   "   "   gc.getObjManager().getClassB()[i].getCoordY());
                if (coordX - 50 >= gc.getObjManager().getClassB()[i].getWestBound()
                        && coordX - 50 < gc.getObjManager().getClassB()[i].getEastBound()
                        && coordY >= gc.getObjManager().getClassB()[i].getNorthBound()
                        && coordY < gc.getObjManager().getClassB()[i].getSouthBound()) {
                    System.out.println("asd");
                return gc.getObjManager().getClassB()[i];
                }
                System.out.println("A");
            }
        }

        else if (facingDirection == 'D') {
            System.out.println("D");
            for (int i = 0; i < gc.getObjManager().getBcount(); i++ ) {
                if (coordX + 50 >= gc.getObjManager().getClassB()[i].getWestBound()
                        && coordX + 50 < gc.getObjManager().getClassB()[i].getEastBound()
                        && coordY >= gc.getObjManager().getClassB()[i].getNorthBound()
                        && coordY < gc.getObjManager().getClassB()[i].getSouthBound()) {
                    System.out.println("asd");
                return gc.getObjManager().getClassB()[i];
                }
            }
        }
        else if (facingDirection == 'S') {
            System.out.println("S");
            for (int i = 0; i < gc.getObjManager().getBcount(); i++ ) {
                if (coordX >= gc.getObjManager().getClassB()[i].getWestBound()
                            && coordX < gc.getObjManager().getClassB()[i].getEastBound()
                            && coordY + 50 >= gc.getObjManager().getClassB()[i].getNorthBound()
                            && coordY + 50 < gc.getObjManager().getClassB()[i].getSouthBound()) {
                        System.out.println("asd");
                return gc.getObjManager().getClassB()[i];
                    }
            }
        }
        else if (facingDirection == 'W') {
            System.out.println("W");
            for (int i = 0; i < gc.getObjManager().getBcount(); i++ ) {
                if (coordX >= gc.getObjManager().getClassB()[i].getWestBound()
                            && coordX < gc.getObjManager().getClassB()[i].getEastBound()
                            && coordY - 50 >= gc.getObjManager().getClassB()[i].getNorthBound()
                            && coordY - 50 < gc.getObjManager().getClassB()[i].getSouthBound()) {
                        System.out.println("asd");
                return gc.getObjManager().getClassB()[i];
                    }
            }
        }
        else {
            System.out.println("!@#!@#!@");
            return null;
        }
        System.out.println("!@#!@#!@");
        return null;
    }
    
    /**
     *
     * @throws InterruptedException
     * @throws LineUnavailableException
     * @throws UnsupportedAudioFileException
     * @throws IOException
     */
    public void update() throws InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException{
        boolean battleWon = false;
        if (readInput.isKeyReleased(KeyEvent.VK_ESCAPE)) {
           gc.getMainFrame().getOverworldMenu().setVisable(true);
        }
        this.drawBlack();
        this.updatePosition();
        this.checkFacedSquare();
        this.draw(filePath);
        //System.out.println("x:" + coordX + "y:" + coordY);
        if (facingEnemy && readInput.isKeyReleased(KeyEvent.VK_SPACE)) {
            //System.out.println("FIGHT");
            GameObject enemy = this.getFacingEnemy();
            if (enemy.getFilename() == "jednorozec.png") {
                battleWon = gc.getMainFrame().startBattle(new Species().getBasicBear());
            }
            if (enemy.getFilename() == "Enemy.png") {
                battleWon = gc.getMainFrame().startBattle(new Species().getWolf());
            }
            if (battleWon) gc.getObjManager().removeEnemy(enemy);
            }
            //starts fight 
        }
    
    /**
     *
     */
    public void drawBlack() {
        int color = 0x000000;
        pixels = new int[WINDOW_WIDTH * CANVAS_HEIGHT];
        pixels = DoubleCanvas.getPixels();
        visiblePixels = new int[WINDOW_WIDTH * CANVAS_HEIGHT];
        visiblePixels = DoubleCanvas.getVisiblePixels();
        //System.out.println(coordY);
        //System.out.println(coordX);
        //System.out.println(coordY);
        for (int i = coordY; i < coordY + HEIGHT && i < CANVAS_HEIGHT; i++) {
            for (int j = coordX; j < coordX + WIDTH; j++) {
                pixels[i * WINDOW_WIDTH + j] = color;
            }
        }
        
        for (int i = coordY; i < coordY + HEIGHT && i < CANVAS_HEIGHT; i++) {
            for (int j = coordX; j < coordX + WIDTH; j++) {
                visiblePixels[i * WINDOW_WIDTH + j] = color;
            }
        }
        
        gc.getDoubleCanvas().setVisiblePixels(visiblePixels);
        gc.getDoubleCanvas().setPixels(pixels);
    }
    
    /**
     *
     * @param filename
     */
    public void draw(String filename) {
        int color = 0xffffff;
        pixels = new int[WINDOW_WIDTH * CANVAS_HEIGHT];
        pixels = DoubleCanvas.getPixels();
        visiblePixels = new int [WINDOW_WIDTH * CANVAS_HEIGHT];
        visiblePixels = DoubleCanvas.getVisiblePixels();
        //System.out.println(coordY);
        //System.out.println(coordX);
        //System.out.println(coordY);
        for (int i = coordY; i < coordY + HEIGHT && i < CANVAS_HEIGHT; i++) {
            for (int j = coordX; j < coordX + WIDTH; j++) {
                pixels[i * WINDOW_WIDTH + j] = color;
            }
        }
        for (int i = coordY; i < coordY + HEIGHT && i < CANVAS_HEIGHT; i++) {
            for (int j = coordX; j < coordX + WIDTH; j++) {
                visiblePixels[i * WINDOW_WIDTH + j] = color;
            }
        }
        gc.getDoubleCanvas().setPixels(visiblePixels);
        gc.getDoubleCanvas().setPixels(pixels);
    }
    
    /**
     *
     */
    public void updatePosition() {
        if (readInput.isKeyDown(KeyEvent.VK_W)) {
            this.goUp();
            facingDirection = 'W';
        }
        if (readInput.isKeyDown(KeyEvent.VK_S)) {
            this.goDown();
            facingDirection = 'S';
        }
        if (readInput.isKeyDown(KeyEvent.VK_A)) {
            this.goLeft();
            facingDirection = 'A';
        }
        if (readInput.isKeyDown(KeyEvent.VK_D)) {
            this.goRight();
            facingDirection = 'D';
        }
        /*if (readInput.isKeyPressed(KeyEvent.VK_SPACE) && facingEnemy == true) {
            System.out.println("\n\n\nFIGHT\n\n\n");
        }*/
    }
    
    /**
     *
     */
    public void checkFacedSquare() {
        if (facingDirection == 'W') {
            if (pixels[(coordY - 1) * WINDOW_WIDTH + coordX] == ENEMY_COLOR /*|| pixels[(coordY - 1) * WINDOW_WIDTH + coordX + 49] == ENEMY_COLOR*/) {
                facingEnemy = true;
                //System.out.println("facing enemy W");
            } else {
                facingEnemy = false;
            }
        }   
        if (facingDirection == 'S') {
            if (pixels[(coordY + 50/**/) * WINDOW_WIDTH + coordX] == ENEMY_COLOR /*|| pixels[(coordY + 50) * WINDOW_WIDTH + coordX + 49] == ENEMY_COLOR*/) {
                facingEnemy = true;
                //System.out.println("facing enemy S");
            } else {
                facingEnemy = false;
            }
        }   
        if (facingDirection == 'A') {
            if (pixels[coordY * WINDOW_WIDTH + coordX - 1] == ENEMY_COLOR /*|| pixels[(coordY + 49) * WINDOW_WIDTH + coordX - 1] == ENEMY_COLOR*/) {
                facingEnemy = true;
                //System.out.println("facing enemy A");
            } else {
                facingEnemy = false;
            }
        }   
        if (facingDirection == 'D') {
            if (pixels[coordY * WINDOW_WIDTH + coordX + 50/**/] == ENEMY_COLOR /*|| pixels[(coordY + 49) * WINDOW_WIDTH + coordX + 50] == ENEMY_COLOR*/) {
                facingEnemy = true;
                //System.out.println("facing enemy D");
            } else {
                facingEnemy = false;
            }
        }
    }
    
    /**
     *
     */
    public void goRight() {
        if (pixels[coordY * 1600 + coordX + 51/**/] == 0x000000 && pixels[(coordY + 49/**/) * 1600 + coordX + 51/**/] == 0x000000) {
            coordX += PLAYER_SPEED;
        }
    }
    
    /**
     *
     */
    public void goLeft() {
        if (pixels[coordY * 1600 + coordX - 1] == 0x000000 && pixels[(coordY + 49/**/) * 1600 + coordX - 1] == 0x000000) {
            coordX -= PLAYER_SPEED;
        }
    }
    
    /**
     *
     */
    public void goUp() {
        if (pixels[(coordY - 1) * 1600 + coordX] == 0x000000 && pixels[(coordY - 1) * 1600 + coordX + 49] == 0x000000) {
            coordY -= PLAYER_SPEED;
        }
    }
    
    /**
     *
     */
    public void goDown() {
        if (pixels[(coordY + 50/**/) * 1600 + coordX] == 0x000000 && pixels[(coordY + 50/**/) * 1600 + coordX + 49] == 0x000000) {
            coordY += PLAYER_SPEED;
        }
    }
}