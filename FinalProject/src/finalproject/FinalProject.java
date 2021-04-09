/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import static finalproject.CharacterSelectMenu.largePixelFont;
import static finalproject.CharacterSelectMenu.pixelFont;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
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
    
    static Font pixelFont;
    static Font largePixelFont;
    
    
    public FinalProject(){
        
        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fonts/pixelfont.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pixelFont.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fonts/pixelfont.ttf")));
        } catch (IOException | FontFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        largePixelFont = pixelFont.deriveFont(80.0f);

        System.out.println(largePixelFont);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        
        
        
        
       
        MainMenuGUI menu = new MainMenuGUI(); 
        menu.setVisible(true);
        
       
        
        
        
       
        
        
//        JFrame game = new JFrame("Game");
//        game.setSize(800,800);
//       
//        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        GameScreen gameScreen = new GameScreen(); 
//        game.add(gameScreen); 
//        game.setVisible(true);
        
       
       
        
    }
    
}
