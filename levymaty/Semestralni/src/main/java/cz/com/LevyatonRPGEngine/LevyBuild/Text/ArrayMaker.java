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
public class ArrayMaker {
     
     public   String[] [] String2DArray(int height, int width)
  {
      String[][] arr = new String[height] [width];
      
      for(int y = 0; y<height;y++)
      {
          for(int x = 0; x<width;x++)
          {
              arr[y][x] = "0";
          }
      }
      return arr;
  }

}
