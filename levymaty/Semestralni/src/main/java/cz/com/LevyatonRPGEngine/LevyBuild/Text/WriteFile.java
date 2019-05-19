/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Text;

/**
 *
 * @author czech
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class WriteFile 
{
    private String path;
    private String text;
    private String name;
    private String[][] XYText;
    
    public WriteFile(String filePath, String fileName, String textToBeWritten)
    {
        path = filePath;
        name = fileName;
        text = textToBeWritten;
    }
    
    public WriteFile(String filePath, String fileName, String[][] textToBeWritten)
    {
        path = filePath;
        name = fileName;
        XYText = textToBeWritten;
    }
    
    public void write()
    {
            try{
                FileWriter fw = new FileWriter(path+name);
                PrintWriter pw = new PrintWriter(fw);
                pw.print(text);
                pw.close();
            }
            catch (IOException writingFailure)
            {
                System.out.println("The file path was: " + path + "\nThe file name was: " + name + "\nThe file text was: " + text + "\n");
            }
    }
    public void write(int height, int width){
        {
            try{
           
                
                FileWriter fw = new FileWriter(path+name);
                PrintWriter pw = new PrintWriter(fw);
                 pw.println();
                for(int y = 0; y<height; y++)
                {
                    for(int x = 0; x<width; x++)
                    {
                        pw.print(XYText[y][x]);
                    }
                    pw.println();
                }
                pw.println();
                pw.close();
            }
            catch (IOException writingFailure)
            {
                System.out.println("The file path was: " + path + "\nThe file name was: " + name + "\nThe file text was: a 2D String Array\n");
            }
        }
    }
    
   
}
