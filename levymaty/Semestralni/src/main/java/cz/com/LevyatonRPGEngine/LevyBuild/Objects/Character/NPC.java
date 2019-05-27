/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Attack;
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;

/**
 *  A class containing properties for NPC characters
 * @author czech
 */
public class NPC extends Specie{
    
    /**
     *  every NPC must have an array containing a dialogue
     */
    protected String[] dialogue;
    
    /**
     *  initializes and sets the NPC
     * @param givenName
     * @param status
     * @param spriteLocation
     * @param giveStr
     * @param giveSpeed
     * @param giveLuck
     * @param giveDef
     * @param giveHP
     * @param giveLoot
     * @param giveAttacks
     * @param giveFocus
     * @param giveDialogue
     */
    public NPC(String givenName, String status, String spriteLocation,int giveStr, int giveSpeed, Double giveLuck, int giveDef, int giveHP, Item[] giveLoot, Attack[] giveAttacks, String giveFocus, String[] giveDialogue) {
        super(givenName, status,spriteLocation,giveStr, giveSpeed, giveLuck, giveDef, giveHP, giveLoot, giveAttacks, giveFocus);
        dialogue = giveDialogue;
    }
    
    /**
     *  returns a String array containing the NPC dialogue
     * @return
     */
    public String[] getDialogue()
    {
        return dialogue;
    }
    
}
