/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.com.LevyatonRPGEngine.LevyBuild.Objects.Character.Player;

import cz.com.LevyatonRPGEngine.LevyBuild.Objects.Object;
import java.util.Scanner;

/**
 *
 * @author czech
 */
public class Player extends Object {
    
    
    
    public Player(String fileLocation, boolean still, String named) {
        super(fileLocation, still, named);
    }
    
    
    
    public String nameSetter()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the protagonist's name?\n");
        String name = sc.nextLine();
        return name;
    }
    
    public void PlayerInitilazer()
    {
        String location = "C:\\Users\\czech\\Documents\\NetBeansProjects\\levymaty\\Semestralni\\src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Character\\Player\\player.png";
        Player p = new Player(location, false, nameSetter());
    }
    
    
    
}
