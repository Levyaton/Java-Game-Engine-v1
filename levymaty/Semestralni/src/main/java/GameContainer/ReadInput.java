package GameContainer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class allows the player to use the keyboard for input.
 * @author Viktor Bobůrka
 */
public class ReadInput implements KeyListener {  //communicates with GC and Player

    private GameContainer gc;
    private final int KEYS_COUNT = 256;
    private boolean keys[] = new boolean [KEYS_COUNT];
    private boolean keysLast[] = new boolean[KEYS_COUNT];
    
    /**
     *
     * @param gc GameContainer is used to gain access to canvas and panel.
     * @see GameContainer
     */
    public ReadInput(GameContainer gc) {
       
        this.gc = gc;
       
        gc.getDoubleCanvas().addKeyListener(this);
    }
         
    /**
     *  keeps track of whih keys were down in last frame and which are down in this frame
     */
    public void update() {
        gc.getDoubleCanvas().grabFocus();
        for (int i = 0; i < KEYS_COUNT; i++) {
            keysLast[i] = keys[i];
        }
    }
    
    /**
     *
     * @param keyId
     * @return returns true if given key is down and false otherwise
     */
    public boolean isKeyDown(int keyId) {
        return keys[keyId];
    }
    
    /**
     *
     * @param keyId
     * @return returns true if key wasn't down in last frame and is down in this frame
     */
    public boolean isKeyPressed(int keyId) {
        return keys[keyId] && !keysLast[keyId];
    }
    
    /**
     *
     * @param keyId
     * @return return true if key was down in last frame and isn't down in this frame
     */
    public boolean isKeyReleased(int keyId) {
        return keysLast[keyId] && !keys[keyId];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        keys[e.getKeyCode()] = false;
    }
    
}
