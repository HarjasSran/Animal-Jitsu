//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//
package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Aidan
 */
public class GameScreen extends JPanel {

    
    Color highlight = Color.BLACK;
    int compIndex = -1;
    boolean win;
    int playerElement;
    int compElement;

    int playerFireWin = 0;
    int playerWaterWin = 0;
    int playerSnowWin = 0;

    int compFireWin = 0;
    int compWaterWin = 0;
    int compSnowWin = 0;

    //timer that delays 1000 ms
    Timer delay = new Timer(1000, null);

    //waits 1000 ms until the computer plays
    ActionListener waitForTurn = new ActionListener() {
        //when mouse is clicked on a card
        public void actionPerformed(ActionEvent ae) {
           //remove the mouse listener so that this all runs once only
            delay.removeActionListener(waitForTurn);
            delay.stop();
            //generate and save a random card that the computer will play using the playCard method from the Computer class
            compIndex = comp.playCard();
                //clone the card that is gettng player and delete it from the computers hand 
            compCard = comp.getCard(compIndex).clone();
            comp.getCards().remove(comp.getCard(compIndex));
            //move the computer selected card to the screen to display
            compCard.moveObject(1000, 500);
            //flip the card being displayed
            compCard.flip();

            //check which card wins using the checkWin method from the Card method by comparing the elements and values of the 2 cards
            win = Card.checkWin(compCard, playerCard);
            //if it is not the players turn
            if (isPlayerTurn == false) {
                //save the card that is going to be added back to the computers hand from the shuffled deck and set it face down
                Card deckCard = cards.get(0);
                deckCard.setFaceUp(false);
                //add the card to the computers hand of cards 
                comp.getCards().add(compIndex, deckCard);
                //remove the new added card from the deck
                cards.remove(cards.get(0));
                //move it off the screen so that is can be moving with animation
                comp.getCard(compIndex).move(3000, 0);
                //x and y postions of where the computers card should move dependent on its postion and index
                int compMoveX = compIndex * 140 + 1135;
                int compMoveY = 49;
                //move the card into position
                comp.getCard(compIndex).moveObject(compMoveX, compMoveY);
            }
            //removal of the played cards so that they go off the screen
            removeCard.start();
            removeCard.addActionListener(waitForRemoval); 
            
            //check for who won and which element they won with and display method
            checkElementWins();
            
            //check if someone has won the round and display message
            checkRoundWin();

        }/**
         * reset all element wins to default
         */
        private void reset() {
            playerFireWin = 0;
            playerWaterWin = 0;
            playerSnowWin = 0;

            compFireWin = 0;
            compWaterWin = 0;
            compSnowWin = 0;
        }

        /**
         * check for who has won and which element they won with. Display message accordingly
         */
        private void checkElementWins() {
           //if the user has won
            if (win) {
                //save the element that the user has won win
                playerElement = playerCard.getElement();
                //if the user won with fire element, add a fire element win
                if (playerElement == Card.FIRE_ELEMENT) {
                    playerFireWin += 1;
                    
                }
                //if the user won with the water element, add a water element win
                else if (playerElement == Card.WATER_ELEMENT) {
                    playerWaterWin += 1;
                } 
                //if the user won with the snow element, add a snow element win
                else if (playerElement == Card.SNOW_ELEMENT) {
                    playerSnowWin +=1;
                }
                //show the user that they have won
                JOptionPane.showMessageDialog(null, "You have won!");
            } 
            //if the user has not won and the computer has won instead
            else {
                //save the element that the computer has won win
                compElement = compCard.getElement();
                //if the computer has won with the fire element, add a fire element win
                if (compElement == Card.FIRE_ELEMENT) {
                    compFireWin += 1;
                }
                //if the computer has won with the water element, add a water element win
                else if (playerElement == Card.WATER_ELEMENT) {
                    compWaterWin += 1;
                }
                //if the computer has won with the snow element, add a snow element win
                else if (playerElement == Card.SNOW_ELEMENT) {
                    compSnowWin +=1;
                }
                //show the user that the sensei has won
                JOptionPane.showMessageDialog(null, "You lost to Sensei Peng");
            }
        }

        /**
         * check if someone has won the round and display message according. start new round if someone has won
         */
        private void checkRoundWin() {
           
            //if the player has atleast 1 win with each element or 3 in total with 1 certain element
            if ((playerFireWin >= 1 && playerWaterWin >= 1 && playerSnowWin >= 1) || playerFireWin >= 3 || playerWaterWin >= 3 || playerSnowWin >= 3 ) {
                //show the user that they have won this round and that they will be promoted
                JOptionPane.showMessageDialog(null, "You have won this round against Sensei Peng! You will get Promoted!");
                //increase the players rank and this will also change their bow colour
                player.setBow(player.getBow() + 1);
                //reset all the element wins back to default for the new round
                reset();
            } 
            //if the computer has atleast 1 win with each element or 3 in total with 1 certain element
            else if (compFireWin >=1 && compWaterWin >= 1 && compSnowWin >= 1 || compFireWin >= 3 || compWaterWin >= 3 || playerSnowWin >= 3) {
                JOptionPane.showMessageDialog(null, "You have lost this round to Sensei Peng. Better luck next time!");
                //reset all the element wins back to default for the new round
                reset();
            } 
        }

    };

    //start the timer going
    Timer removeCard = new Timer(2000, null);

    ActionListener waitForRemoval = new ActionListener() {

        public void actionPerformed(ActionEvent q) {
            removeCard.removeActionListener(waitForRemoval);
            playerCard.moveObject(playerCard.getX(), 2000);
            compCard.moveObject(compCard.getX(), 2000);
            compCard.setFaceUp(false);
            playerCard.setFaceUp(false);
            cards.add(compCard);
            cards.add(playerCard);


            Collections.shuffle(cards);


            removeCard.stop();
            isPlayerTurn = true;


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

    static BufferedImage CARD_SPRITE = null;

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

    int playerIndex = -1;

    public class ClickListener extends MouseAdapter {

        double xPos;
        double yPos;

        boolean clicked;

       
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
           
            xPos = e.getX() / SCREEN_SCALE;
            yPos = e.getY() / SCREEN_SCALE;
             System.out.println(xPos + ", " + yPos);
            for (int i = 0; i < player.getCards().size(); i++) {
                playerIndex = i;

                if (player.getCard(i).isClicked(xPos, yPos)) {

                    if (isPlayerTurn) {
                        isPlayerTurn = false;

                        playerCard = player.getCard(playerIndex).clone();

                        playerCard.moveObject(800, 500);

                        player.getCards().remove(player.getCard(playerIndex));

                        Card deckCard = cards.get(0);
                        deckCard.setFaceUp(true);
                        player.getCards().add(playerIndex, deckCard);
                        cards.remove(cards.get(0));
                        player.getCard(playerIndex).move(-1000, 0);
                        int moveX = playerIndex * 140 + 49;
                        int moveY = 48;
                        player.getCard(playerIndex).moveObject(moveX, moveY);

//
//                   
                        delay.start();
                        delay.addActionListener(waitForTurn);

                    }

                }

            }
            
            //g2d.fillRect(750, 950, 270, 60);
           if(xPos>750 && xPos<1020 && yPos<1000 && yPos>950){
               
             User user = new User(player.getName(), player.getBow()); 
             
             LeaderboardGUI.writeData(user);
               
            System.exit(0);
           }
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

        Timer timer = new Timer(30, al);
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

        WHITE_BOW = createBufferedImage("/bows/whiteBow.png");
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
            cards.add(new Card(0, 0, 0, SCREEN_SCALE, Card.FIRE_ELEMENT, i, true));
            cards.add(new Card(0, 0, 0, SCREEN_SCALE, Card.WATER_ELEMENT, i, true));
            cards.add(new Card(0, 0, 0, SCREEN_SCALE, Card.SNOW_ELEMENT, i, true));

        }
        Collections.shuffle(cards);
        name = CharacterSelectMenu.getUsername();

        player = new Player(name, 550, 400, 1, image, false, splitCards(0, 4, cards));

        for (int i = 0; i < player.getCards().size(); i++) {
            player.getCard(i).setX(i * 140 + 40);
            player.getCard(i).setY(40);
        }

        comp = new Computer("Sensei Peng", 1550, 400, 0, BOSS_IMAGE, true, splitCards(5, 9, cards), 1);

        for (int i = 0; i < comp.getCards().size(); i++) {
            comp.getCard(i).setFaceUp(false);
            comp.getCard(i).setX(i * 140 + 1140);
            comp.getCard(i).setY(40);
        }

        cards = splitCards(10, cards.size() - 1, cards);

    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(SCREEN_SCALE, SCREEN_SCALE);

        g2d.drawImage(BACKGROUND_IMAGE, 0, 0, 1920, 1080, null);

        player.setScale(80);
        player.render(g2d);

        comp.setScale(80);
        comp.render(g2d);

//
//        if(playerElement == Card.FIRE_ELEMENT){
//            g2d.drawImage(FIREBALL_IMAGE, 500, 500, FIREBALL_IMAGE.getWidth(), FIREBALL_IMAGE.getHeight(), null);
//        }
//        else if(compElement == Card.FIRE_ELEMENT){
//            g2d.drawImage(FIREBALL_IMAGE, 500, 500, FIREBALL_IMAGE.getWidth(), FIREBALL_IMAGE.getHeight(), null);
//        }
        for (int i = 0; i < player.getCards().size(); i++) {
            player.getCard(i).render(g2d);

        }
        for (int i = 0; i < comp.getCards().size(); i++) {
            comp.getCard(i).render(g2d);
        }

        if (playerCard != null) {

            playerCard.render(g2d);
        }

        if (compCard != null) {
            compCard.render(g2d);
        }

        
        
        
        
        
        //g2d.fillRect(750, 950, 270, 60);
        
        g2d.scale(0.5, 0.5);
        
        
        g2d.drawChars(("END BATTLE").toCharArray(), 0,("END BATTLE").toCharArray().length , 1540,1980);
        //g2d.scale(SCREEN_SCALE, SCREEN_SCALE);
        
        
        
        
        g2d.dispose();

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

    private ArrayList<Card> splitCards(int start, int end, ArrayList<Card> cards) {

        ArrayList<Card> split = new ArrayList();
        for (int i = start; i <= end; i++) {
            split.add(cards.get(i));
        }

        return split;

    }

}
