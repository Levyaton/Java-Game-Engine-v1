/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Methods;

import java.util.Scanner;

/**
 *
 * @author czech
 */
public class InputCheckers {
    
    /**
     *
     * @param valid
     * @param input
     * @return
     */
    public boolean validInput(String[] valid, String input)
    {
        for(String option : valid)
        {
            if(input.toLowerCase().equals(option.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }
    
}
