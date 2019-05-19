package GameContainer;

import java.awt.event.KeyEvent;

public class Player {
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
    
    
    public Player (String filename, int coordX, int coordY, GameContainer gc, ReadInput readInput, int canvasHeight, int windowWidth, int enemyColor, int obstacleColor) {
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
    
    public void update() {
        this.drawBlack();
        this.updatePosition();
        this.checkFacedSquare();
        this.draw(filePath);
        //System.out.println("x:" + coordX + "y:" + coordY);
        if (facingEnemy && readInput.isKeyReleased(KeyEvent.VK_SPACE)) {
            System.out.println("FIGHT");
            for (int i = 0; i < gc.getObjManager().getBcount(); i++) {
                if (facingDirection == 'A') {
                    
                }
                if (facingDirection == 'D') {
                    
                }
                if (facingDirection == 'W') {
                    
                }
                if (facingDirection == 'S') {
                    
                }
                
                
                if (gc.getObjManager().getClassB()[i].getCoordX() == coordX - (coordX%50) + 50 || gc.getObjManager().getClassB()[i].getCoordY() == coordY - (coordY%50) + 50) {
                    gc.getObjManager().getClassB()[i].remove();
                }
            }
            //starts fight 
        }
    }
    
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
        
        gc.getGameFrame().setVisiblePixels(visiblePixels);
        gc.getGameFrame().setPixels(pixels);
    }
    
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
        gc.getGameFrame().setPixels(visiblePixels);
        gc.getGameFrame().setPixels(pixels);
    }
    
    
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
    
    public void goRight() {
        if (pixels[coordY * 1600 + coordX + 51/**/] == 0x000000 && pixels[(coordY + 49/**/) * 1600 + coordX + 51/**/] == 0x000000) {
            coordX += PLAYER_SPEED;
        }
    }
    
    public void goLeft() {
        if (pixels[coordY * 1600 + coordX - 1] == 0x000000 && pixels[(coordY + 49/**/) * 1600 + coordX - 1] == 0x000000) {
            coordX -= PLAYER_SPEED;
        }
    }
    
    public void goUp() {
        if (pixels[(coordY - 1) * 1600 + coordX] == 0x000000 && pixels[(coordY - 1) * 1600 + coordX + 49] == 0x000000) {
            coordY -= PLAYER_SPEED;
        }
    }
    
    public void goDown() {
        if (pixels[(coordY + 50/**/) * 1600 + coordX] == 0x000000 && pixels[(coordY + 50/**/) * 1600 + coordX + 49] == 0x000000) {
            coordY += PLAYER_SPEED;
        }
    }
}