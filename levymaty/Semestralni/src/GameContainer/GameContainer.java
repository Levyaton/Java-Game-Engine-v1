package GameContainer;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;


public class GameContainer implements Runnable {
	private Thread thread;
	private DoubleCanvas gameFrame;
        private ObjectLoader objManager;
        private ReadInput readInput;
        private PlayerSprite player;
        
        public final int ENEMY_COLOR = 0xff3333;
        public final int OBSTACLE_COLOR = 0xcc6666;
        private final int CANVAS_HEIGHT = 900;
        private final int WINDOW_HEIGHT = 900;
        private final int WINDOW_WIDTH = 1600;

        
        private boolean renderNow = false;
	private boolean running = false;
	
        private final double UPDATE_CAP = 1.0/60.0;
        private double currentTime;  //firstTime
	private double lastUpdated;  //lastTime
        private double sinceLastUpdate;  //passedTime
        private double lastRendered = 0;  //unprocessedTime
        
        private int frames;
        private double frameTime;
        private int fps;
        
	public GameContainer() {
            
	}

	public void start() {
            thread = new Thread(this);
            /*
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    gameFrame = new DoubleCanvas(this, WINDOW_WIDTH, WINDOW_HEIGHT, CANVAS_HEIGHT);
                }
            });
            */
            gameFrame = new DoubleCanvas(this, WINDOW_WIDTH, WINDOW_HEIGHT, CANVAS_HEIGHT);
            readInput = new ReadInput(this);
            player = new PlayerSprite("Player", 150, 150, this, readInput, CANVAS_HEIGHT, WINDOW_WIDTH, ENEMY_COLOR, OBSTACLE_COLOR);
            try {
                objManager = new ObjectLoader(this, ENEMY_COLOR, OBSTACLE_COLOR, CANVAS_HEIGHT, WINDOW_WIDTH);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
            //GameObject g = new GameObject("SmallGreen.png");
            //GameObject b = new GameObject("SmallBlue.png");
            running = true;
            thread.run();
            return;
	}

	public void stop() {
            
	}

	public void run() {
            lastUpdated = System.nanoTime() / 1000000000.0;  //10e9
            boolean renderNow = false;
            frames = 0;
            frameTime = 0;
            fps = 0;
            

            while (running) {
                renderNow = false;
                
                currentTime = System.nanoTime() / 1000000000.0;
                sinceLastUpdate  = currentTime - lastUpdated;
                lastUpdated = currentTime;
                lastRendered += sinceLastUpdate;
                frameTime += sinceLastUpdate;
                
                
                while (lastRendered >= UPDATE_CAP) {
                    //System.out.println("update");
                    lastRendered -= UPDATE_CAP;
                    //UPDATE
                    if (frameTime >= 1.0) {
                        frameTime = 0;
                        fps = frames;
                        frames = 0;
                        System.out.println("fps: " + fps);
                    }
                    renderNow = true;
                    
                    try {
                        player.update();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameContainer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(GameContainer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(GameContainer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(GameContainer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    readInput.update();
                }
                
                if (renderNow) {
                    frames++;
                    gameFrame.update();
                    //RENDER   
                }
                else {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
	}

    public void setRunning(boolean running) {
        this.running = running;
    }

    public DoubleCanvas getGameFrame() {
        return gameFrame;
    }

    public int getCANVAS_HEIGHT() {
        return CANVAS_HEIGHT;
    }

    public int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    public int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    public ObjectLoader getObjManager() {
        return objManager;
    }
    
    public static void main(String[] args) {
        GameContainer gc = new GameContainer();
        gc.start();
    }
}