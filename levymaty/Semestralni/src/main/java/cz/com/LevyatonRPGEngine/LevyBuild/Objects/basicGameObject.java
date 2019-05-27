/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects;

/**
 *  A class responsible for the properties of a general game objects
 * @author czech
 */
public abstract class basicGameObject {

    /**
     *  Every object must have a name
     */
    protected String name; 

    /**
     *  Most objects will have a status, meaning still, movable, playerControlled or indieMovement (Null meaning they are just a concept to be worked with)
     */
    protected String status;

    /**
     *  Most objects will have a given sprite assigned to them (Null meaning it doesn't have a sprite attached to it)
     */
    protected String spriteLocation;
            
    /**
     *  initializes and sets the class
     * @param giveName
     */
    public basicGameObject(String giveName)
    {
        name = giveName;
    }
    
    /**
     *  initializes and sets the class
     * @param giveName
     * @param giveStatus
     */
    public basicGameObject(String giveName, String giveStatus)
    {
        name = giveName;
        status = giveStatus;
    }
    
    /**
     *  initializes and sets the class
     * @param giveName
     * @param giveStatus
     * @param giveSpriteLocation
     */
    public basicGameObject(String giveName, String giveStatus, String giveSpriteLocation)
    {
        name = giveName;
        status = giveStatus;
        spriteLocation = giveSpriteLocation;
    }
    
    /**
     *Returns the name of the object
     * @return
     */
    public String getName()
    {
        return name;
    }
    
    /**
     *  Returns the status of the object
     * @return
     */
    public String getStatus()
    {
        return status;
    }

    /**
     *  Returns the location of the assigned sprite of the object 
     * @return
     */
    public String getSpriteLocation()
    {
        return spriteLocation;
    }
}


