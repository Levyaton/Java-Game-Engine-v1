/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Window;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author czech
 */
public class JTextAreaOutputStream extends OutputStream
{
    private final JTextArea destination;
    private JTextArea ta;

    /**
     *
     * @param destination
     */
    public JTextAreaOutputStream (JTextArea destination)
    {
        if (destination == null)
            throw new IllegalArgumentException ("Destination is null");

        this.destination = destination;
    }

    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException
    {
        final String text = new String (buffer, offset, length);
        SwingUtilities.invokeLater(new Runnable ()
            {
                @Override
                public void run() 
                {
                    destination.append (text);
                }
            });
    }

    @Override
    public void write(int b) throws IOException
    {
        write (new byte [] {(byte)b}, 0, 1);
    }

    /**
     *
     * @param mod
     * @return
     * @throws Exception
     */
    public JTextArea main(int mod) throws Exception
    {
        setTextArea(mod);
        JTextAreaOutputStream out = new JTextAreaOutputStream (ta);
        System.setOut (new PrintStream (out));
        return ta;
    }
    
    /**
     *
     * @param mod
     */
    public void setTextArea(int mod)
    {
        
        ta = new JTextArea();
        ta.setForeground(Color.RED);
        ta.setBackground(Color.BLACK);
        ta.setFont(new Font("Serif", Font.ITALIC, 16));
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setEditable (false);
        ta.setBounds(0,14*mod,16*mod,4*mod); 
   
        ta.setVisible(true);
    }
}