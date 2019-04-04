/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
public abstract class Bodypart extends Item{
    
    protected int statModefier;
    protected Double luckModefier;
    
    public Bodypart(String giveName, String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, int giveStatModefier) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        statModefier = giveStatModefier;   
    }
    
    public Bodypart(String giveName, String giveStatus, String giveSpriteLocation, Double giveDropRate, String giveDescription, int giveValue, Double giveLuckModefier) {
        super(giveName, giveStatus, giveSpriteLocation,giveDropRate, giveDescription, giveValue);
        luckModefier = giveLuckModefier;   
    }
    
    public int getStatModefier()
    {
        return statModefier;
    }
    
    public Double getLuckModefier()
    {
        return luckModefier;
    }
}
