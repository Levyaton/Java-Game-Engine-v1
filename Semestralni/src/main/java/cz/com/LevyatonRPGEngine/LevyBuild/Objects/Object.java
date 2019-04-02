/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects;

/**
 *
 * @author czech
 */

import cz.com.LevyatonRPGEngine.LevyBuild.PNGManager.Sprite;


public class Object extends Sprite{
    protected boolean isStill;
    protected String name;
    
    public Object(String fileLocation, boolean still, String named) {
        super(fileLocation);
        isStill = still;
        name = named;
    }
    
    public boolean isStillGetter()
    {
        return isStill;
    }
    
    public String nameGetter()
    {
        return name;
    }
    
}
