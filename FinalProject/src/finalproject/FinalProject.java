/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

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
    public static void main(String[] args) {
        System.out.println("hello");
        
        
      // JOptionPane.showMessageDialog(null,"Github is working correctly!");
        
        
        JFrame game = new JFrame("Game");
        game.setSize(800,800);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameScreen gameScreen =new GameScreen(); 
        game.add(gameScreen); 
       
       
        
    }
    
}
