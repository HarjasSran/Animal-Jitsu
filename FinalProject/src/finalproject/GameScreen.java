/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aidan
 */
public class GameScreen extends JPanel {

//    @Override
//    public Component add(Component comp) {
//        return super.add(comp); //To change body of generated methods, choose Tools | Templates.
//    }
    //GameScreen g = new GameScreen(); 
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
    
    static BufferedImage CARD_SPRITE= null ;

    ArrayList<Card> cards = new ArrayList();
    ArrayList<Card> compCards = new ArrayList();
    ArrayList<Card> hand = new ArrayList();
    ArrayList<Card> compHand = new ArrayList();

    int totalCards = 33;

    static BufferedImage image = null;
    String name;

    Player player;
    Computer comp;

    ClickListener listener;

    public GameScreen(JFrame game) {

        listener = new ClickListener();
        game.getContentPane().addMouseListener(listener);

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

        //All water element cards added to arraylist
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(Card.WATER_ELEMENT, i, false));
            compCards.add(new Card(Card.WATER_ELEMENT, i, false));

            System.out.println("f");
        }

        //All fire element cards added to arraylist
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(Card.FIRE_ELEMENT, i, false));
            compCards.add(new Card(Card.FIRE_ELEMENT, i, false));
        }

        //All snow element cards added to arraylist
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(Card.SNOW_ELEMENT, i, false));
            compCards.add(new Card(Card.SNOW_ELEMENT, i, false));
        }

        name = CharacterSelectMenu.getUsername();

        player = new Player(250, 400, name, Color.white, image, false, cards);

        comp = new Computer(1200, 400, Color.black, BOSS_IMAGE, true, cards, 1);
//        
//        for (int i = 0; i < 4; i++) {
//            drawCard(cards, hand);
//            drawCard(compCards, compHand);
//        }
//        
//        
//        Card compPick = compPickCard(compHand);
//        drawCard(compCards, compHand);
//        int choice = Integer.parseInt(JOptionPane.showInputDialog("Pick a card to draw./n1. " + hand.get(0).toString() + "\n2. " + hand.get(1).toString() + "\n3. " + hand.get(2).toString() + "\n4. " + hand.get(3).toString() + "\n5. " + hand.get(4).toString()));
//        Card userPick = hand.get(choice);
//        hand.remove(choice);
//        drawCard(cards, hand);
//        
//        String userWin = checkWin(compPick, userPick);
//        

//        for (int i = 0; i < 10; i++) {
//            cards.add(new Card(0, i, false));
//            compCards.add(new Card(0, i, false));
//        }
//
//        //All fire element cards added to arraylist
//        for (int i = 0; i < 10; i++) {
//            cards.add(new Card(1, i, false));
//            compCards.add(new Card(1, i, false));
//        }
//
//        //All snow element cards added to arraylist
//        for (int i = 0; i < 10; i++) {
//            cards.add(new Card(2, i, false));
//            compCards.add(new Card(2, i, false));
//        }
//        
//        for (int i = 0; i < 4; i++) {
//            drawCard(cards, hand);
//            drawCard(compCards, compHand);
//        }
//        
//        for (int i = 0; i < 4; i++) {
//            
//        }
//        
//        Card compPick = compPickCard(compHand);
//        drawCard(compCards, compHand);
//        int choice = Integer.parseInt(JOptionPane.showInputDialog("Pick a card to draw./n1. " + hand.get(0).toString() + "\n2. " + hand.get(1).toString() + "\n3. " + hand.get(2).toString() + "\n4. " + hand.get(3).toString() + "\n5. " + hand.get(4).toString()));
//        Card userPick = hand.get(choice);
//        hand.remove(choice);
//        drawCard(cards, hand);
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

        //System.out.println(listener.);
        Graphics2D g2d = (Graphics2D) g;

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
        player.setScale(60);
        player.render(g2d);

        comp.setScale(60);
        comp.render(g2d);
        
        cards.get(0).render(g2d);

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
