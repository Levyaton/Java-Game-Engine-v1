/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 * the class makes changing the system output destination to a JTextArea a cinch
 * @author czech
 */
public class CustomOutputStream extends OutputStream {
    private JTextArea textArea;
     
    /**
     *  sets the textArea to the given JTextArea
     * @param textArea
     */
    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
