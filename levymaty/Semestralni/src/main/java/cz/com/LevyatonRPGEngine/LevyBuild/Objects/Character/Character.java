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
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.GameObject;
public class Character extends GameObject{
    
    protected Specie species;
    
    public Character(String givenName, String givenStatus, String givenSpriteLocation, Specie giveSpecies) {
        super(givenName, givenStatus, givenSpriteLocation);
        species = giveSpecies;
    }
    
    public String getSpecies()
    {
        return species.getName();
    }
}
