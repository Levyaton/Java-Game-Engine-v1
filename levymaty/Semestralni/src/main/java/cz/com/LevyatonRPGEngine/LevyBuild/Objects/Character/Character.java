/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.basicGameObject;

/**
 *
 * @author czech
 */
public class Character extends basicGameObject{
    
    /**
     *
     */
    protected Specie species;
    
    /**
     *
     * @param givenName
     * @param givenStatus
     * @param givenSpriteLocation
     * @param giveSpecies
     */
    public Character(String givenName, String givenStatus, String givenSpriteLocation, Specie giveSpecies) {
        super(givenName, givenStatus, givenSpriteLocation);
        species = giveSpecies;
    }
    
    /**
     *
     * @return
     */
    public String getSpecies()
    {
        return species.getName();
    }
}
