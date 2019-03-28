/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.PNGManager;

import cz.com.LevyatonRPGEngine.LevyBuild.Text.WriteFile;
import cz.com.LevyatonRPGEngine.LevyBuild.Text.ArrayMaker;
import java.io.File;




/**
 *
 * @author czech
 */
public class PNGManager {
    
  private void PNGDecoder()
  {
    String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites";
    File[] files = new File(location).listFiles();
    for (File file : files) 
    {
        String extention = "";
        int i = file.getName().lastIndexOf(".");
        if (file.isFile() && (i>0) && (file.getName().substring(i + 1).equals("png")));
        {
            Sprite s = new Sprite(location +"\\" + file.getName());
            String[][] text = ArrayMaker.String2DArray(s.heightGetter(), s.widthGetter());
            WriteFile wf = new WriteFile(location, file.getName().substring(0, i) + ".txt", text);
            wf.write(s.heightGetter(), s.widthGetter());
            
        }
    }
  }
  
  
  
  public static void main(String[] args)
  {
      PNGManager pngm = new PNGManager();
      pngm.PNGDecoder();
  }
}
