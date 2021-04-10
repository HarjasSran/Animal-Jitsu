//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//
package finalproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Aidan
 */
public class GameScreen extends JPanel{

    int index;
    
    
    
     Timer delay = new Timer(1000,null);
    
          ActionListener waitForTurn=  new ActionListener(){
        
           public void actionPerformed(ActionEvent ae) {
               index = comp.playCard();
               compCard = comp.getCard(index);

               delay.stop();
               boolean win = Card.checkWin(compCard,playerCard); 
               System.out.println(win);
             
               removeCard.start(); 
              removeCard.addActionListener(waitForRemoval);
              
               
               
              isPlayerTurn = true; 
             
            }
        
            };
    
    
    
        //start the timer going
    
    
     Timer removeCard = new Timer(4000,null);
    
          ActionListener waitForRemoval=  new ActionListener(){
        
           public void actionPerformed(ActionEvent q) {
              
               playerCard.moveObject(playerCard.getX(), 2000);
                compCard.moveObject(compCard.getX(), 2000);
               
               removeCard.stop();
             
            }
        
            };
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ///BEGINNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN

    final long start = System.currentTimeMillis();

    static BufferedImage GIRAFFE_IMAGE = null;
    static BufferedImage BOSS_IMAGE = null;
    static BufferedImage GORILLA_IMAGE = null;
    static BufferedImage TIGER_IMAGE = null;
    static BufferedImage MONKEY_IMAGE = null;
    static BufferedImage ZEBRA_IMAGE = null;

    static BufferedImage FIREBALL_IMAGE = null;
    static BufferedImage WATERBALL_IMAGE = null;
    static BufferedImage SNOWBALL_IMAGE = null;

    static BufferedImage BACKGROUND_IMAGE = null;
    
    static BufferedImage WHITE_BOW = null; 
    static BufferedImage GREEN_BOW = null;
    static BufferedImage YELLOW_BOW = null;
    static BufferedImage ORANGE_BOW = null;
    static BufferedImage RED_BOW = null;
    static BufferedImage BLACK_BOW = null;
    
    static BufferedImage CARD_SPRITE= null ;
    
    
    //Downscales to 720p 
    static double SCREEN_SCALE = 0.666667;
    
    
    static boolean isPlayerTurn = true; 
    static Card compCard; 
    static Card playerCard; 
    
    ArrayList<Card> cards = new ArrayList();


    static BufferedImage image = null;
    String name;

    Player player;
    Computer comp;

   
    
    public class ClickListener extends MouseAdapter {

    double xPos;
    double yPos;
  
    boolean clicked;


    
   
    
    
  
    
    @Override
    public void mouseClicked(MouseEvent e) {
        xPos = e.getX()/SCREEN_SCALE;
        
        
      
        yPos = e.getY()/SCREEN_SCALE;
        
        
        System.out.println(xPos + ", " + yPos);
        
        for (int i = 0; i < player.getCards().size(); i++) {
            
           
            
            if(player.getCard(i).isClicked(xPos,yPos)){
                
                if (isPlayerTurn) {
                    isPlayerTurn = false;
                    playerCard = player.getCard(i).clone();

                    playerCard.moveObject(800, 500);
                    player.getCards().remove(player.getCard(i));
                    player.getCards().add(i, cards.get(0));
                    player.getCard(i).move(-1000, 0);
                    player.getCard(i).moveObject(i * 140 + 49, 48);
                    player.getCard(i).flip();
                    
//                    player.getCard(i).flip();
                    
                    
                    //System.out.println(player.getCard(i).toString());

                    delay.start();
                    delay.addActionListener(waitForTurn);


              }
                         
               
                
            }
            
            
            
            
       
            
//            //FOR TESTING PURPOSES flip computer cards on click
//            if(comp.getCard(i).isClicked(xPos, yPos)){
//             //   comp.getCard(i).flip();
//            }            
        }
        
        
       

        //save x and y coordinates
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked = true;
        // System.out.println("f" + clicked);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    /**
     * accessor method to get x position
     *
     * @return
     */
    public double getXPos() {
        return xPos;//return x position
    }

    /**
     * accessor method to get the y position
     *
     * @return
     */
    public double getYPos() {
        return yPos;//return y position
    }

    /**
     * accessor method to get wethoer or not the something is pressed
     *
     * @return
     */
    public boolean isPressed() {
        return clicked;//return if it is pressed
    }

}
    
    
    
    
    
    
    
    
    
    
    
    
    
   ///////////////////////////////////////////////////////////////// 

    public GameScreen(JFrame game) {
        
        
        
         ActionListener al = new ActionListener() {
            //when the timer ticks
            public void actionPerformed(ActionEvent ae) {
              
                repaint(); //redraw the panel
            }
        };
         
          Timer timer = new Timer(30,al);
        //start the timer going
        timer.start();

        
        
        
        
        
        
       
        
       
        
        
        
        
        
        
//        listener = new ClickListener();
       game.getContentPane().addMouseListener(new ClickListener());

        GIRAFFE_IMAGE = createBufferedImage("/assets/giraffe.png");
        BOSS_IMAGE = createBufferedImage("/assets/boss.png");
        GORILLA_IMAGE = createBufferedImage("/assets/gorilla.png");
        TIGER_IMAGE = createBufferedImage("/assets/tiger.png");
        MONKEY_IMAGE = createBufferedImage("/assets/monkey.png");
        ZEBRA_IMAGE = createBufferedImage("/assets/zebra.png");

        FIREBALL_IMAGE = createBufferedImage("/assets/fireball.png");
        WATERBALL_IMAGE = createBufferedImage("/assets/waterball.png");
        SNOWBALL_IMAGE = createBufferedImage("/assets/snowball.png");

        BACKGROUND_IMAGE = createBufferedImage("/backgrounds/level1.png");
        
       WHITE_BOW= createBufferedImage("/bows/whiteBow.png"); 
       GREEN_BOW = createBufferedImage("/bows/greenBow.png");
       YELLOW_BOW = createBufferedImage("/bows/yellowBow.png");
       ORANGE_BOW = createBufferedImage("/bows/orangeBow.png");
       RED_BOW = createBufferedImage("/bows/redBow.png");
       BLACK_BOW = createBufferedImage("/bows/blackBow.png");
        
        CARD_SPRITE = createBufferedImage("/assets/cards.png"); 

        //  CARD_SPRITESHEET =  createBufferedImage("/assets/cards.png");
        if (CharacterSelectMenu.getAnimal().equals("giraffe")) {
            image = GIRAFFE_IMAGE;

        } else if (CharacterSelectMenu.getAnimal().equals("gorilla")) {
            image = GORILLA_IMAGE;
        } else if (CharacterSelectMenu.getAnimal().equals("tiger")) {
            image = TIGER_IMAGE;
        } else {
            image = ZEBRA_IMAGE;
        }

        
       
         //All fire element cards added to arraylist
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(0, 0, 0, -10, Card.FIRE_ELEMENT, i, true));
             cards.add(new Card(0,0,0, SCREEN_SCALE,Card.WATER_ELEMENT, i, true));
             cards.add(new Card(0,0,0, SCREEN_SCALE,Card.SNOW_ELEMENT, i, true));
             
               
               
             
           
        }
        Collections.shuffle(cards); 
        name = CharacterSelectMenu.getUsername();

        
       
        player = new Player(name, 550, 400, 1, image, false, splitCards(0, 4, cards));
        
        for (int i = 0; i < player.getCards().size(); i++) {
            player.getCard(i).setX(i*140+40);
             player.getCard(i).setY(40);
             }
        
        
        
        
        comp = new Computer("Sensei Peng",1550, 400, 0, BOSS_IMAGE, true,splitCards(5, 9,cards), 1);
        for (int i = 0; i < comp.getCards().size(); i++) {
            comp.getCard(i).setFaceUp(false);
            comp.getCard(i).setX(i*140+1140);
             comp.getCard(i).setY(40);
        }
     cards = splitCards(10,cards.size()-1, cards); 
       
        
    }

    
   
   
    
    public void paint(Graphics g) {
        
        
        

        Graphics2D g2d = (Graphics2D) g;
       g2d.scale(SCREEN_SCALE, SCREEN_SCALE);
     
        
       

        g2d.drawImage(BACKGROUND_IMAGE, 0, 0, 1920, 1080, null);
        
        if(playerCard!=null){
            
         playerCard.render(g2d);
        }

        player.setScale(80);
        player.render(g2d);

        comp.setScale(80);
        comp.render(g2d);
        
       
     
        
        
        for (int i = 0; i < player.getCards().size(); i++) {
              player.getCard(i).render(g2d);  
              

        }
        for (int i = 0; i < comp.getCards().size(); i++) {
             comp.getCard(i).render(g2d);            
        }
        
      
       
         
        //System.out.println(cardClicked);
      

        // System.out.println(GameScreen.image);
        // g2d.drawImage(image, 100, x, null);
        //g2d.drawImage(image, 500, 100,-image.getWidth()/2, image.getHeight()/2-x/20, null);
        g2d.dispose();
        //repaint();

    }

    /**
     * Accessor method which creates a 2d image using the source of the image
     *
     * @param src - source of the image
     * @return - 2d image that can be put on screen for user
     */
    private BufferedImage createBufferedImage(String src) {
        BufferedImage img;

        try {

            img = ImageIO.read(getClass().getResourceAsStream(src)); //load image using source and save

        } catch (IOException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "ERROR LOADING " + src + " :\n" + e); //error message
            img = null; //no image if error occurs 

        }
        return img;

    }
    
    
    private ArrayList<Card> splitCards(int start, int end, ArrayList<Card> cards){
        
        ArrayList<Card> split = new ArrayList(); 
        for (int i = start; i <= end; i++) {
            split.add(cards.get(i));
            
        }
        
       return split;  
        
        
    }




    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
