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
public class Object {
    protected String name; //Every objecct must have a name
    protected String status;//Most objects will have a status, meaning still, movable, playerControlled or indieMovement (Null meaning they are just a concept to be worked with)
    protected String spriteLocation;//Most objects will have a given sprite assighned to them (Null meaning it doesn't have a sprite attached to it)
            
     public Object(String givenName)
    {
        name = givenName;
    }
    
    public Object(String givenName, String givenStatus)
    {
        name = givenName;
        status = givenStatus;
    }
    
    public Object(String givenName, String givenStatus, String givenSpriteLocation)
    {
        name = givenName;
        status = givenStatus;
        spriteLocation = givenSpriteLocation;
    }
    
    public String getName() //Returns the name of the object
    {
        return name;
    }
    
    public String getStatus() //Returns the status of the object
    {
        return status;
    }

    public String getSpriteLocation() //Returns the location of the assighned sprite of the object 
    {
        return spriteLocation;
    }
}


