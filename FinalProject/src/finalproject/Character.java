/**
 * Caroline Widdecombe, Aidan Goodyer, Harjas Sran
 * Character Class
 * April 10 2021
 */
package finalproject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author harja
 */
public class Character extends GameObject {

    //create variables for attributes of the character
    protected int bow;// the color of the characters bow
    BufferedImage animal;// the animal of the character
    protected ArrayList cards;// the characters cards

    protected String name;

    protected long currentFrame = 0;
    final int distortOffset = (int) (Math.random() * 10);

   protected int multiplier;

    /**
     * default character constructor
     */
    public Character() {

    }

    /**
     * secondary constructor to create character with user input
     *
     * @param bow
     * @param animal
     * @param direction
     * @param cards
     */
    public Character(String name, int xPos, int yPos, int bow, BufferedImage animal, boolean direction, ArrayList<Card> cards) {

        super(xPos, yPos, 0, animal.getWidth(), animal.getHeight(), 1.0, direction);

        //a width of -1 flips the character's horizontal orientation
        if (direction) {
            multiplier = 1;
        } else {
            multiplier = -1;
        }

        this.bow = bow;
        this.animal = animal;
        this.cards = cards;
        this.name = name;
    }

    /**
     * mutator method to set the color of the bow
     *
     * @param bow
     */
    public void setBow(int bow) {
        this.bow = bow;
    }

    public Card getCard(int i) {
        return (Card) this.cards.get(i);
    }

    /**
     * accessor method to get the color of the bow
     *
     * @return - color of the bow
     */
    public int getBow() {
        return bow; //return the color of the bow
    }

    /**
     * mutator method to set the animal
     *
     * @param animal
     */
    public void setAnimal(BufferedImage animal) {
        this.animal = animal;
    }

    /**
     * accesor method to get the animal
     *
     * @return - image fo the animal
     */
    public BufferedImage getAnimal() {
        return animal;//return the animal
    }

    /**
     * accesor method to get the crds
     *
     * @return
     */
    public ArrayList<Card> getCards() {
        return cards;//return the cards
    }

    
    
// used to distort the heights of characters by a periodic funtion
// making them appear to sort of breathe.     
    double x = 0.0;
    int distort;

    public void render(Graphics2D g2d) {

        
        //move object if there target x positon isnt their current x position
        if (this.getTargetX() > this.getX()) {

            this.setX(Math.round(1.01f * this.getTargetX()));

        } else if (this.getTargetX() < this.getX()) {
            this.setX(this.getX() - Math.round(0.01f * this.getTargetX()));
        }

        //move object if their targer y positons isnt their current y positon
        if (this.getTargetY() > this.getY()) {
            this.setY(this.getY() + Math.round(0.01f * this.getTargetY()));

        } else if (this.getTargetY() < this.getY()) {
            this.setY(this.getY() - Math.round(0.01f * this.getTargetY()));
        }
        
        //breating for the player and computer
        x += (Math.sin((currentFrame + this.xPos) * 0.1)) / 1.5;
        distort = (int) Math.floor(x);

        currentFrame++;
        
        //array holding image of bows
        BufferedImage bows[] = {GameScreen.BLACK_BOW, GameScreen.WHITE_BOW, GameScreen.GREEN_BOW, GameScreen.YELLOW_BOW, GameScreen.ORANGE_BOW, GameScreen.RED_BOW};
        //if the rank of the user is more than 4, their bow color stays the same but rank increases
        if (this.getBow() >= 5) {
            //draw it
            g2d.drawImage(bows[5], this.getX() - this.getObjectWidth(), 965, bows[5].getWidth(), bows[5].getHeight(), null);
        } 
        //if the bow of the image is black, then only draw black belt
        else if(this.getBow() == 0) {
            g2d.drawImage(bows[this.getBow()], this.getX() - this.getObjectWidth(), 965, bows[this.getBow()].getWidth(), bows[this.getBow()].getHeight(), null);
        }
        //otherwise, the bows change colour dependent on the rank
        else {
            g2d.drawImage(bows[this.getBow()], 40, 965, bows[this.getBow()].getWidth(), bows[this.getBow()].getHeight(), null);

        }

        g2d.drawImage(animal, this.getX(), this.getY() + distort, this.getObjectWidth() * multiplier, this.getObjectHeight() - distort, null);

    }

    /**
     * Mutator method to change the scale of the object updates the width and
     * height accordingly
     *
     * @param scale - size scale of the objects
     */
    public void setScale(int scale) {
        this.scale = scale;

        //System.out.println(width*scale);
        this.width = (this.getAnimal().getWidth() * scale) / 100;
        this.height = (this.getAnimal().getHeight() * scale) / 100;

    }
    
        /**
     * method to clone the character and its attributes
     *
     * @return - new character
     */
    public Character clone(){
        Character newChar = new Character(name, xPos, yPos, bow, animal, direction, cards);
        return newChar;
    }

    /**
     * to string method with all attributes of the character
     *
     * @return - all attributes and values of the character
     */
    public String toString() {
        
        return super.toString()+ "Color: " + bow + "\tAnimal: " + animal + "\tCards: " + cards;//return atring with all attributes of the character
    }
}
