/**
 * Caroline Widdecombe, Aidan Goodyer, Harjas Sran
 * Game Screen menu with main whole game
 * April 10 2021
 */
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Aidan
 */
public class GameScreen extends JPanel {


    
 
    
  
  

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

    //Downscales to 720p from native 1080
    static double SCREEN_SCALE = 0.666667;

    static boolean isPlayerTurn = true; //starts as the players turn
    static Card compCard;
    static Card playerCard;

    ArrayList<Card> cards = new ArrayList();

    static BufferedImage image = null;
    static int imageX = 0;
    static int imageY = 0;
    
    
    String name = CharacterSelectMenu.getUsername();;

    Player player;
    Computer comp;

    int playerIndex = -1;
    
    
    // save a global reference to the gamescreen so we can manipulate its properties while running the game
    GameScreen g = this; 
    
    //label that stores text that is printed after each turn
    String label = ""; 
    
   

    int compIndex = -1;
    boolean win;
    int playerElement;
    int compElement;

    
    //win trackers for computer and player
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
           //remove the mouse listener so that this all runs once only every time
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
                label = name + " wins"; 
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
                
                label = "Sensei wins"; 
            }
        }

        /**
         * check if someone has won the round and display message according. start new round if someone has won
         */
        private void checkRoundWin() {
           
            //if the player has atleast 1 win with each element or 3 in total with 1 certain element
            if ((playerFireWin >= 1 && playerWaterWin >= 1 && playerSnowWin >= 1) || playerFireWin >= 3 || playerWaterWin >= 3 || playerSnowWin >= 3 ) {
                //show the user that they have won this round and that they will be promoted
                
                label  = "new bow achieved"; 
                //increase the players rank and this will also change their bow colour
                player.setBow(player.getBow() + 1);
                //reset all the element wins back to default for the new round
                reset();
            } 
            //if the computer has atleast 1 win with each element or 3 in total with 1 certain element
            else if (compFireWin >=1 && compWaterWin >= 1 && compSnowWin >= 1 || compFireWin >= 3 || compWaterWin >= 3 || playerSnowWin >= 3) {
                
                player.setBow(player.getBow()-1);
                label = "defeated by sensei peng"; 
                
                //reset all the element wins back to default for the new round
                reset();
            } 
        }

    };

    //start the timer going
    Timer removeCard = new Timer(2000, null);
    //once the cards have been removed after playing
    ActionListener waitForRemoval = new ActionListener() {
        
        public void actionPerformed(ActionEvent q) {
            removeCard.removeActionListener(waitForRemoval);
            
            //move the player user and computer cards off the screen
            playerCard.moveObject(playerCard.getX(), 2000);
            compCard.moveObject(compCard.getX(), 2000);
            //flip the cards when they are moving off the screen
            compCard.setFaceUp(false);
            playerCard.setFaceUp(false);
            //add the cards back into the deck
            cards.add(compCard);
            cards.add(playerCard);

            //shuffle the deck of cards to randomize the order
            Collections.shuffle(cards);

            //stop removing the cards off the screen
            removeCard.stop();
            //it is now the players turn to play
            isPlayerTurn = true;
            label = ""; 

        }

    };
    //class which listens for card clicks
    public class ClickListener extends MouseAdapter {

        double xPos;
        double yPos;

        boolean clicked;


        /**
         * If the mouse is clicked
         * @param e 
         */

        @Override
        public void mouseClicked(MouseEvent e) {

            //get the x and y positions of the users click and scale the values according to the screen
            xPos = e.getX() / SCREEN_SCALE;
            yPos = e.getY() / SCREEN_SCALE;

            //for all the cards that the user has

            for (int i = 0; i < player.getCards().size(); i++) {
                //index of the specific card 
                playerIndex = i;
                //if any player card is clicked by the mouse x and y pos. Card class has isClicked method
                if (player.getCard(i).isClicked(xPos, yPos)) {
                    //if it is the players tuen
                    if (isPlayerTurn) {
                        //no longer players turn
                        isPlayerTurn = false;
                        
                        //clone the card which the user clicked
                        playerCard = player.getCard(playerIndex).clone();

                        //move the clicked card to the middle of the screen
                        playerCard.moveObject(800, 500);

                        //remove the card that was clicked from the players hand 
                        player.getCards().remove(player.getCard(playerIndex));

                        //temporary card that holds the new card getting added to the players hand7
                        Card deckCard = cards.get(0);
                        deckCard.setFaceUp(true);
                        
                        //add new card to the players hand from the deck
                        player.getCards().add(playerIndex, deckCard);
                        //remove the card from the overall deck
                        cards.remove(cards.get(0));
                        //move the new card off the screen so that it can fly in
                        player.getCard(playerIndex).move(-1000, 0);
                        //the x and y positions that the card needs to move to depending on the index of the clicked card
                        int moveX = playerIndex * 140 + 49;
                        int moveY = 48;
                        //move the card into the correct position
                        player.getCard(playerIndex).moveObject(moveX, moveY);
            
                        delay.start();
                        delay.addActionListener(waitForTurn);

                    }

                }

            }
            
            
            //sorta hardcoded because last minute fix
            // if the bottom middle is clicked (exit game text) 
            if (xPos > 750 && xPos < 1020 && yPos < 1000 && yPos > 950) {
                //hide the game
                gameFrame.setVisible(false);
                //create a new user object to store name & score
                User user = new User(player.getName(), player.getBow());
                main.setVisible(true);
                
                
                LeaderboardGUI.writeData(user);
                
                
                
                
                

           }
        }
        


    }

    
    //store the GUIs that may be accessed from within the screen so that they can be returned to 
    JFrame gameFrame;
    MainMenuGUI main;

  
    public GameScreen(JFrame game, MainMenuGUI m) {

        main = m;
        gameFrame = game;
        

        /**
         * Game animation loop - repaints every 30ms
         */
        ActionListener al = new ActionListener() {
            //when the timer ticks
            public void actionPerformed(ActionEvent ae) {

                repaint(); //redraw the panel
            }
        };
        // timer triggers actionlistener every 30ms
        Timer timer = new Timer(30, al);
        //start the timer going
        timer.start();

        //listeners for mouse on jFrame game
        game.getContentPane().addMouseListener(new ClickListener());

        //all images saves to buffered image using createBufferedImage method located in gamescreen class
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

        //if the user choses to be a giraffe 
        if (CharacterSelectMenu.getAnimal().equals("giraffe")) {
            //save image as giraffe
            image = GIRAFFE_IMAGE;
            imageX = 550;
            imageY = 250;

        } 
        //if the user choses to be a gorilla
        else if (CharacterSelectMenu.getAnimal().equals("gorilla")) {
            //save image as gorrila
            image = GORILLA_IMAGE;
            imageX = 550;
            imageY = 400;
        }
        //if the user choses to be a tiger
        else if (CharacterSelectMenu.getAnimal().equals("tiger")) {
            //save image as tiger
            image = TIGER_IMAGE;
            imageX = 680;
            imageY = 560;
        }
        //if the user choses to be a zebra
        else {
            //save image as zebra
            image = ZEBRA_IMAGE;
            imageX = 600;
            imageY = 0;
        }

        //All cards get generated and added into deck
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(0, 0, 0, SCREEN_SCALE, Card.FIRE_ELEMENT, i, true));
            cards.add(new Card(0, 0, 0, SCREEN_SCALE, Card.WATER_ELEMENT, i, true));
            cards.add(new Card(0, 0, 0, SCREEN_SCALE, Card.SNOW_ELEMENT, i, true));

        }
        //shuffle the cards
        Collections.shuffle(cards);
        
        //create player using secondary constructor from the Player class. Use split card method to assign the first 5 cards in the shuffled deck to the user
        player = new Player(name, imageX, imageY, 1, image, false, splitCards(0, 4, cards));

        //draw all the cards from the player deck in the correct locations dependent on its index
        for (int i = 0; i < player.getCards().size(); i++) {
            player.getCard(i).setX(i * 140 + 40);
            player.getCard(i).setY(40);
        }

        //create computer using secondary constructor from the Computer class. Use split card method to assign the second 5 cards in the shuffled deck to the computer
        comp = new Computer("Sensei Peng", 1550, 400, 0, BOSS_IMAGE, true, splitCards(5, 9, cards), 1);

        //draw all the cards from the computers deck in the correct locations dependen on its index
        for (int i = 0; i < comp.getCards().size(); i++) {
            //make sure the cards are face down so that the user cannot see the computers cards
            comp.getCard(i).setFaceUp(false);
            comp.getCard(i).setX(i * 140 + 1140);
            comp.getCard(i).setY(40);
        }

        //cards array looses cards and becomes smaller from the transfer of the deck cards to the users and computers hand
        cards = splitCards(10, cards.size() - 1, cards);

    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        //scale the screen to correct screen size
        g2d.scale(SCREEN_SCALE, SCREEN_SCALE);

        //draw an image to fill the background fully
        g2d.drawImage(BACKGROUND_IMAGE, 0, 0, 1920, 1080, null);

        //increase the size and draw the player on the screen with the name, rank and bow colour
        player.setScale(80);
        player.render(g2d);

        //increase the size and draw the computer on the screen with the name, rank and bow colour
        comp.setScale(80);
        comp.render(g2d);


        //render all of the cards in the player deck
        for (int i = 0; i < player.getCards().size(); i++) {
            player.getCard(i).render(g2d);

        }
        //render all of the cards in the computer deck
        for (int i = 0; i < comp.getCards().size(); i++) {
            comp.getCard(i).render(g2d);
        }

        //if the player selected card is now not null
        if (playerCard != null) {
            //render the player card onto the screen
            playerCard.render(g2d);
        }
        //if the computer selected card is now not null
        if (compCard != null) {
            //render the player card onto the screen
            compCard.render(g2d);
        }
        
        
        // renders whatever label text appears above the cards after each turn
        g2d.setColor(Color.WHITE);
        g2d.drawChars(label.toCharArray(), 0, label.length(), 700, 400);
        
        
        // bad fix to downscale text, last minute fix
        g2d.scale(0.5, 0.5);
        // print end battle text on middle bottom of screen
         g2d.setColor(Color.BLACK);
        g2d.drawChars(("END BATTLE").toCharArray(), 0,("END BATTLE").toCharArray().length , 1700,1980);

        
        
        
        //dispose of the current render frame. hopefully this is good for memory usage 
        g2d.dispose();

    }

    /**
     * creates a 2d image using the source of the image
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
     * Split method to split an array of cards into smaller groups using start and end indexes
     * @param start - start index of the card arraylist
     * @param end - end index of the card arraylist
     * @param cards - arraylist which holds the deck of cards
     * @return - the split array 
     */
    private ArrayList<Card> splitCards(int start, int end, ArrayList<Card> cards) {

        ArrayList<Card> split = new ArrayList();
        //save all the cards from the start to end index into new array list which will be returned
        for (int i = start; i <= end; i++) {
            split.add(cards.get(i));
        }

        return split;

    }

}
