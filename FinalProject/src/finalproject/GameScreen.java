/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Aidan
 */
public class GameScreen extends JPanel{
    
 public void paint(Graphics g) {
   Graphics2D g2d = (Graphics2D) g; 
   
   
   g2d.setColor(Color.red);
   g2d.fillRect(100, 100, 50, 50);
     
     
     
 }    
    
    
    
}
