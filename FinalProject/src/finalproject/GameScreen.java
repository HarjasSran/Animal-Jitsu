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
    final long start = System.currentTimeMillis();
    
    final BufferedImage GIRAFFE_IMAGE = createBufferedImage("/assets/giraffe.png");
    final BufferedImage BOSS_IMAGE = createBufferedImage("/assests/boss.png");
    final BufferedImage GORILLA_IMAGE = createBufferedImage("/assets/gorilla.png");
    final BufferedImage TIGER_IMAGE = createBufferedImage("/assets/tiger.png");
    final BufferedImage MONKEY_IMAGE = createBufferedImage("/assets/monkey.png");
    final BufferedImage ZEBRA_IMAGE = createBufferedImage("/assets/zebra.png");



    
    final BufferedImage FIREBALL_IMAGE = createBufferedImage("/assets/fireball.png");
    final BufferedImage WATERBALL_IMAGE = createBufferedImage("/assets/waterball.png");
    final BufferedImage SNOWBALL_IMAGE = createBufferedImage("/assests/snowball.png");
    
    
    public GameScreen(){
        System.out.println(GIRAFFE_IMAGE);
        try {     
            test1 = ImageIO.read(getClass().getResourceAsStream("/assets/gorilla.png"));
            System.out.println(test1);
        } catch (IOException  ex) {
            JOptionPane.showMessageDialog(null,"ERROR: "+ex);
            
           
        }
        System.out.println("done");
    }
    
    // test1 = ImageIO.read(getClass().getResourceAsStream("8BitDeckAssetstest1.png"));
  
  
    
    //DELETE THESE_ FOR 
  int x=0; 
  double v=0;
  int c=0; 
  
 public void paint(Graphics g) {
    
   Graphics2D g2d = (Graphics2D) g; 
   
    
   g2d.setColor(Color.red);
   
 
   int elapsed = (int)(System.currentTimeMillis()-start); 
   
   
  
   c++; 
  v += (Math.sin(c*0.001))/10;
   x = (int) Math.floor(v);
   
 
  
 
   
   
     
   
     
     
     g2d.fillRect(0,0,1000,1000); 
   g2d.fillRect(100+x, 100, 50, 50);
   
   
   
   //g2d.drawImage(test1, 100, x, null);
   g2d.drawImage(GIRAFFE_IMAGE, 100, x, null);
   
   
       g2d.dispose(); 
     repaint(); 
     
 }    
    
    
    /**
     * Accessor method which creates a 2d image using the source of the image
     * @param src - source of the image
     * @return - 2d image that can be put on screen for user
     */
    public final BufferedImage createBufferedImage(String src){
        BufferedImage img;
        
        try{
            
        img =  ImageIO.read(getClass().getResourceAsStream(src)); //load image using source and save
       
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "ERROR LOADING " + src + " :\n" + e); //error message
            img=null; //no image if error occurs 
            
            
        } 
         return img; 
        
    }
    
}


