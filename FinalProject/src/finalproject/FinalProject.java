/**
 * Caroline Widdecombe, Aidan Goodyer, Harjas Sran
 * Final Project Main Method
 * April 10 2021
 */
package finalproject;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
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
    public static void main(String[] args) {
        
       
        MainMenuGUI menu = new MainMenuGUI(); 
        menu.setVisible(true);       
       
       
        menu.setVisible(true);
   
        
    }
    
}
