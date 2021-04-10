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

    ArrayList<Card> cards = new ArrayList<Card>();
    
   // ArrayList<Card> compCards = new ArrayList();
  //  ArrayList<Card> hand = new ArrayList();
  //  ArrayList<Card> compHand = new ArrayList();

    int totalCards = 33;

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
        
        for (int i = 0; i < 5; i++) {
            
           
            
            if(player.getCard(i).isClicked(xPos,yPos)){
                
              if(isPlayerTurn){  
              player.getCard(i).moveObject(800, 500);
              
              isPlayerTurn = false; 
              comp.playCard(System.currentTimeMillis()); 
              }
                         
               
                
            }
            
            
            
            
       
            
            //FOR TESTING PURPOSES flip computer cards on click
            if(comp.getCard(i).isClicked(xPos, yPos)){
                comp.getCard(i).flip();
            }            
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
            cards.add(new Card(0, 0, 0, -10, Card.FIRE_ELEMENT, i, false));
             cards.add(new Card(0,0,0, SCREEN_SCALE,Card.WATER_ELEMENT, i, false));
             cards.add(new Card(0,0,0, SCREEN_SCALE,Card.SNOW_ELEMENT, i, false));
             
               
               
             
           
        }
        Collections.shuffle(cards); 
        
        
        
        
       
        
      // cards.s

        name = CharacterSelectMenu.getUsername();

        
        //ArrayList playerCards = (ArrayList)cards.subList(0, cards.size()/2-1); 
        player = new Player(name, 550, 400, 1, image, false, splitCards(0, cards.size()/2-1, cards));
        
        for (int i = 0; i < 5; i++) {
            player.getCard(i).setFaceUp(true);
            player.getCard(i).setX(i*140+40);
             player.getCard(i).setY(40);
             }
        
        
        
        
        comp = new Computer("Sensei Peng",1550, 400, 0, BOSS_IMAGE, true,splitCards(cards.size()/2, cards.size()-1,cards), 1);
        for (int i = 0; i < 5; i++) {
           // comp.getCards().get(i).setFaceUp(true); 
          /// comp.getCard(i).setFaceUp(true);
            comp.getCard(i).setX(i*140+1140);
             comp.getCard(i).setY(40);
        }
        cards.clear();
       
        
       

//        
//        String userWin = checkWin(compPick, userPick);
        //give element win to the user or sensei based on win or loss
        //make cards array. use card class to create cards and array list of the random cards that got drawed into users hand
        //computer has same array list of cards but not a "hand" arraylist
        //let user pick a card from their array list and have computer draw random card
        //compare the cards and declare a winner. give winner the element that they have won
        //make sure that once a card is played, it can not be drawn again from either user or computer
        //keep the game running until someone has won with all of their elements or their are no more cards left
    }

    // test1 = ImageIO.read(getClass().getResourceAsStream("8BitDeckAssetstest1.png"));
    //DELETE THESE_ FOR 
    int x = 0;
    double v = 0;
    int c = 0;

    /**
     *
     * @param g
     */

    //static Character character = new Character(Color.BLACK,image, true, cards);
    
   
   
    
    public void paint(Graphics g) {

        
        
        //System.out.println(listener.isPressed());
        //System.out.println(listener.);
        Graphics2D g2d = (Graphics2D) g;
       g2d.scale(SCREEN_SCALE, SCREEN_SCALE);
     
        

        //g2d.setColor(Color.red);
        c++;
        v += (Math.sin(c * 0.001)) / 10;
        x = (int) Math.floor(v);

        //g2d.fillRect(0, 0, 1000, 1000);
        //g2d.fillRect(100 + x, 100, 50, 50);
        g2d.drawImage(BACKGROUND_IMAGE, 0, 0, 1920, 1080, null);
        
       
//        player.setX(200);
//        player.setY(500);
//        player.setWidth(player.getAnimal().getWidth()/4);
//        player.setHeight(player.getAnimal().getHeight()/4);

        //System.out.println(listener.xPos);
        player.setScale(80);
        player.render(g2d);

        comp.setScale(80);
        comp.render(g2d);
        
       
     
        
        
        for (int i = 0; i < 5; i++) {
//            player.getCard(i).setFaceUp(true);
//            player.getCard(i).setX(i*140+40);
//             player.getCard(i).setY(40);
              player.getCard(i).render(g2d);  
              
              
            //  System.out.println(i + ": " + player.getCard(i).getElement());
              
              //System.out.println(player.getCard(i).getX());
              
             // System.out.println(player.getCard(i).isClicked(listener));
        }
        for (int i = 0; i < 5; i++) {
           // comp.getCards().get(i).setFaceUp(true); 
          /// comp.getCard(i).setFaceUp(true);
//            comp.getCard(i).setX(i*140+1140);
//             comp.getCard(i).setY(40);
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

    /**
     * method that draws a new card
     *
     * @param cards
     * @param hand
     */
    private void drawCard(ArrayList<Card> cards, ArrayList<Card> hand) {
        int rNum = (int) (Math.random() * totalCards + 1);
        Card drawCard = cards.get(rNum);
        drawCard.setFaceUp(true);
        cards.remove(rNum);
        hand.add(drawCard);
        totalCards -= 1;
    }

    /**
     * method that picks a card for the sensei penguin
     *
     * @param compHand
     * @return
     */
    private Card compPickCard(ArrayList<Card> compHand) {
        int rNum = (int) (Math.random() * 5 + 1);
        Card cardDraw = compHand.get(rNum);
        return cardDraw;
    }

    /**
     * method to check if someone has won
     *
     * @param compPick
     * @param userPick
     * @return
     */
    private String checkWin(Card compPick, Card userPick) {
        String userWin = "";

        //snow(2) beats water(0)
        //water(0) beats fire(1)
        //fire(1) beats snow(2)
        int compElement = compPick.getElement();
        int userElement = userPick.getElement();

        int compNumber = compPick.getCardNumber();
        int userNumber = compPick.getCardNumber();

        if (userElement != compElement) {
            if (userElement == 0) {
                if (compElement == 1) {
                    userWin = "win";
                }
            } else if (userElement == 1) {
                if (compElement == 2) {
                    userWin = "win";
                }
            } else if (userElement == 2) {
                if (compElement == 0) {
                    userWin = "win";
                }
            }
        } else if (userElement == compElement) {
            if (userNumber > compNumber) {
                userWin = "win";
            } else if (userElement == compNumber) {
                userWin = "tie";
            }
        }

        return userWin;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
