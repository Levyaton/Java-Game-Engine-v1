package GameContainer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ReadInput implements KeyListener {  //communicates with GC and Player

    private GameContainer gc;
    private final int KEYS_COUNT = 256;
    private boolean keys[] = new boolean [KEYS_COUNT];
    private boolean keysLast[] = new boolean[KEYS_COUNT];
    
    
    
    public ReadInput(GameContainer gc) {
       
        this.gc = gc;
       
        gc.getDoubleCanvas().addKeyListener(this);
    }
     
    public void update() {
        gc.getDoubleCanvas().grabFocus();
        for (int i = 0; i < KEYS_COUNT; i++) {
            keysLast[i] = keys[i];
        }
    }
    
    public boolean isKeyDown(int keyId) {
        return keys[keyId];
    }
    
    public boolean isKeyPressed(int keyId) {
        return keys[keyId] && !keysLast[keyId];
    }
    
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
