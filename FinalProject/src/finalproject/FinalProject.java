/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author harja
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        System.out.println("hello");
        
        MainMenuGUI menu = new MainMenuGUI(); 
        menu.setVisible(true);
        
       
        
        
        
      // JOptionPane.showMessageDialog(null,"Github is working correctly!");
        
        
        JFrame game = new JFrame("Game");
        game.setSize(800,800);
       
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameScreen gameScreen =new GameScreen(); 
        game.add(gameScreen); 
        game.setVisible(true);
        
       
       
        
    }
    
}
