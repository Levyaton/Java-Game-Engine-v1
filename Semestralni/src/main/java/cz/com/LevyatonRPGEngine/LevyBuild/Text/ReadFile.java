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
import java.io.*;
import java.util.Scanner;
import java.io.File;
import cz.com.LevyatonRPGEngine.LevyBuild.PNGManager.Sprite;

public class ReadFile {
    public char[][] pixelGetter(String filePath, int height, int width) //reads a file containing the pixel information of a png image
    {
        char[][] pixels = new char [height][width];
        try{
        String lines = "";
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        lines = scanner.nextLine();
        while (scanner.hasNextLine()) {
               lines = lines + scanner.nextLine();
        }

        int linesPosition = 0;
        for(int y = 0; y<height; y++)
        {
            for(int x = 0; x<width; x++)
            {
                Character currentChar = lines.charAt(linesPosition);
                if(currentChar != ' ')
                {
                    pixels[y][x] = currentChar;
                }
                linesPosition++;
            }
        }
        
        }
        catch(FileNotFoundException filelocation)
        {
            System.out.println("File not found at given location: " + filePath);
        }
        return pixels;
    }

    /*/
    public static void main(String[] args)
    {
        String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites";
        String name = "A_bird_creature_33x33";
        Sprite s = new Sprite(location +"\\" +  name + ".png");
        ReadFile rf = new ReadFile();
        char[][] pixels = rf.pixelGetter(location +"\\" +  name + ".txt", s.heightGetter(), s.widthGetter());
        for(int y = 0; y<s.heightGetter(); y++)
        {
            for(int x = 0; x<s.widthGetter(); x++)
            {
                System.out.println(pixels[y][x]);
                System.out.println(" Value Y is " + y);
                System.out.println(" Value X is " + x);
                
            }
            
        }
        
    }
    /*/
}
