package GameContainer;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player.Player;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.World;
import cz.com.LevyatonRPGEngine.LevyBuild.Window.MainFrame;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

/**
 * This is the main class of the game engine, it manages the other classes and updates the game.
 * @author Viktor Bobůrka
 */
public class GameContainer implements Runnable {
        
        public final static Logger LOG = Logger.getLogger("Logger");
        private World world;
	private Thread thread;
	private MainFrame mainFrame;
        private ObjectLoader objManager;
        private ReadInput readInput;
        private PlayerSprite ps;
        //private DoubleCanvas overworld;
        
    /**
     * @return Returns the PlayerSprite class.
     */
        
    public PlayerSprite getPs()
    {
        return ps;
    } 
    /**
     * The hidden colour of the enemies.
     */
    public final int ENEMY_COLOR = 0xff3333;

    /**
     * The hidden colour of the obstacles.
     */
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
        
    /**
     * The constructor does nothing, everything is initialized in the start method.
     */
    public GameContainer() {
	}

    /**
     * Sets up all necessary classes, starts the game.
     * @throws IOException
     * @throws MalformedURLException
     * @throws LineUnavailableException
     * @throws UnsupportedAudioFileException
     */
    public void start() throws IOException, MalformedURLException, LineUnavailableException, UnsupportedAudioFileException {
            
            thread = new Thread(this);
            /*
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    gameFrame = new DoubleCanvas(this, WINDOW_WIDTH, WINDOW_HEIGHT, CANVAS_HEIGHT);
                }
            });
            */
            
            //Overworld = new DoubleCanvas(this, WINDOW_WIDTH, WINDOW_HEIGHT, CANVAS_HEIGHT);
            mainFrame = new MainFrame(WINDOW_WIDTH, WINDOW_HEIGHT, CANVAS_HEIGHT,this);
            try {
                objManager = new ObjectLoader(this, ENEMY_COLOR, OBSTACLE_COLOR, CANVAS_HEIGHT, WINDOW_WIDTH);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
            readInput = new ReadInput(this);
            ps = new PlayerSprite("Player", 150, 150, this, readInput, CANVAS_HEIGHT, WINDOW_WIDTH, ENEMY_COLOR, OBSTACLE_COLOR);
            
            //System.out.println("Hellod");
            
            //GameObject g = new GameObject("SmallGreen.png");
            //GameObject b = new GameObject("SmallBlue.png");
            running = true;
            mainFrame.showCard("enterName");
            LOG.info("GameContainer successfully loaded and is running.");
            thread.run();
            return;
	}

    /**
     * This is the main loop of the game, it keeps track of time and updates the game.
     */
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
                    LOG.finest("Updating...");
                    lastRendered -= UPDATE_CAP;
                    //UPDATE
                    if (frameTime >= 1.0) {
                        frameTime = 0;
                        fps = frames;
                        frames = 0;
                        //System.out.println("fps: " + fps);
                    }
                    renderNow = true;
                    
                    try {
                        ps.update();
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
                    LOG.finest("Rendering...");
                    frames++;
                    mainFrame.getOverworld().update();
                    mainFrame.showCard("Overworld");
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

        /**
         * Only used in unit tests.
         * @param mainFrame 
         */
        
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * Sets up the Player, used after battles and in the beginning of the game.
     * @param player
     */
    public void setPlayer(Player player)
    {
        this.world.setPlayer(player);
    }    

    /**
     * Sets the running variable to let the game loop know the game is running.
     * @param running
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     *
     * @return Returns the game world.
     */
    public World getWorld()
   {
       return world;
   }

    /**
     *
     * @return Returns the Main JFrame containing all other panels.
     */
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * Sets up the game world.
     * @param w
     */
    public void setWorld(World w)
   {
       world = w;
   }

    /**
     * 
     * @return Returns the pixel height of the overworld.
     */
    public int getCANVAS_HEIGHT() {
        return CANVAS_HEIGHT;
    }

    /**
     *
     * @return Returns the pixel height of the overworld.
     */
    public int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    /**
     *
     * @return Returns the pixel width of the overworld.
     */
    public int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    /**
     *
     * @return Returns the manager containing all objects of the overworld.
     */
    public ObjectLoader getObjManager() {
        return objManager;
    }
    
    /**
     *
     * @return Returns the overworld.
     */
    public DoubleCanvas getDoubleCanvas()
    {
        return mainFrame.getOverworld();
    }
    
    /**
     * Starts up the Game Container class.
     * @param args
     * @throws IOException
     * @throws MalformedURLException
     * @throws LineUnavailableException
     * @throws UnsupportedAudioFileException
     */
    public static void main(String[] args) throws IOException, MalformedURLException, LineUnavailableException, UnsupportedAudioFileException {
        
        
        GameContainer gc = new GameContainer();
        LOG.setLevel(Level.INFO);
        LOG.info("Starting the GameContainer.");
        gc.start();
    }
}