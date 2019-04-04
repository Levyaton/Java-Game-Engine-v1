/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Items.Misc;

/**
 *
 * @author czech
 */
import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Item;
public class Threads extends Item{
    
    final private static int value = 1;//The value of a single gold coin
    final private static String description = "Some thread - good for stiching, but don't forget to get a needle!";
    final private static String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\Thread.png";//Currently doesn't exist
    final private static String name = "Thread";
    final private static String status = "Interactable";
    final private static Double dropRate = 0.000000001;;
    
    public Threads() {
        super(name, status, location, dropRate, description, value);
    }
    
    public Item getThreads()
    {
        return this;
    }
}
