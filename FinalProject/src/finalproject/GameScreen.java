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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aidan
 */
public class GameScreen extends JPanel {

    private BufferedImage test1;
    final long start = System.currentTimeMillis();

//    static BufferedImage GIRAFFE_IMAGE=null;
//    static BufferedImage BOSS_IMAGE = null;
//    static BufferedImage GORILLA_IMAGE = null;
//    static BufferedImage TIGER_IMAGE = null;
//    static BufferedImage MONKEY_IMAGE = null;
//    static BufferedImage ZEBRA_IMAGE = null;

    
    static BufferedImage FIREBALL_IMAGE = null;
    static BufferedImage WATERBALL_IMAGE = null;
    static BufferedImage SNOWBALL_IMAGE = null;
    
    ArrayList <Card> cards = new ArrayList();
    ArrayList <Card> compCards = new ArrayList();
    ArrayList <Card> hand = new ArrayList();
    ArrayList <Card> compHand = new ArrayList();
    
    int totalCards = 33;

    public GameScreen() {

//        GIRAFFE_IMAGE = createBufferedImage("/assets/giraffe.png");
//        BOSS_IMAGE = createBufferedImage("/assets/boss.png");
//        GORILLA_IMAGE = createBufferedImage("/assets/gorilla.png");
//        TIGER_IMAGE = createBufferedImage("/assets/tiger.png");
//        MONKEY_IMAGE = createBufferedImage("/assets/monkey.png");
//        ZEBRA_IMAGE = createBufferedImage("/assets/zebra.png");
//        
//        
//        FIREBALL_IMAGE = createBufferedImage("/assets/fireball.png");
//        WATERBALL_IMAGE = createBufferedImage("/assets/waterball.png");
//        SNOWBALL_IMAGE = createBufferedImage("/assets/snowball.png");
        
        //All water element cards added to arraylist
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(0, i, false));
            compCards.add(new Card(0, i, false));
        }

        //All fire element cards added to arraylist
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(1, i, false));
            compCards.add(new Card(1, i, false));
        }

        //All snow element cards added to arraylist
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(2, i, false));
            compCards.add(new Card(2, i, false));
        }
        
        for (int i = 0; i < 4; i++) {
            drawCard(cards, hand);
        }
        
        for (int i = 0; i < 4; i++) {
            drawCard(compCards, compHand);
        }
        
        Card compPick = compPickCard(compHand);
        drawCard(compCards, compHand);
        int choice = Integer.parseInt(JOptionPane.showInputDialog("Pick a card to draw./n1. " + hand.get(0).toString() + "\n2. " + hand.get(1).toString() + "\n3. " + hand.get(2).toString() + "\n4. " + hand.get(3).toString() + "\n5. " + hand.get(4).toString()));
        Card userPick = hand.get(choice);
        hand.remove(choice);
        drawCard(cards, hand);
        
        checkWin(compPick, userPick);
        

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

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.red);

        
        c++;
        v += (Math.sin(c * 0.001)) / 10;
        x = (int) Math.floor(v);

        g2d.fillRect(0, 0, 1000, 1000);
        g2d.fillRect(100 + x, 100, 50, 50);

        //g2d.drawImage(test1, 100, x, null);
      ///  g2d.drawImage(GIRAFFE_IMAGE, 100, x, null);

        g2d.dispose();
        repaint();

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

    private void drawCard(ArrayList<Card> cards, ArrayList<Card> hand) {
        int rNum = (int) (Math.random() * totalCards + 1);
        Card drawCard = cards.get(rNum);
        drawCard.setFaceUp(true);
        cards.remove(rNum);
        hand.add(drawCard);
        totalCards-= 1;
    }

    private Card compPickCard(ArrayList<Card> compHand) {
        int rNum = (int)(Math.random()*5+1);
        Card cardDraw = compHand.get(rNum);
        return cardDraw;
    }

    private void checkWin(Card compPick, Card userPick) {
        boolean userWin;
        
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
                    userWin = true;
                }
                else{
                    userWin = false;
                }
            }
            
            else if(userElement == 1){
                
            }
        }
    }

    
    
}
