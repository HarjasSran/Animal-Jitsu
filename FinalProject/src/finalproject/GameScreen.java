/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aidan
 */
public class GameScreen extends JPanel{
    
    private BufferedImage test1; 
    
    
    
    public GameScreen(){
        try {     
            test1 = ImageIO.read(getClass().getResourceAsStream("/assets/gorilla.png"));
            System.out.println(test1);
        } catch (IOException  ex) {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex);
            
           
        }
        System.out.println("done");
    }
    
    // test1 = ImageIO.read(getClass().getResourceAsStream("8BitDeckAssetstest1.png"));
  
    
    
 public void paint(Graphics g) {
    
   Graphics2D g2d = (Graphics2D) g; 
   
    
   g2d.setColor(Color.red);
   
   g2d.fillRect(100, 100, 50, 50);
   g2d.drawImage(test1, 100, 100, null);
     
     //repaint(); 
     
 }    
    
    
    
}
