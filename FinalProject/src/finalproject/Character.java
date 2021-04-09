/*
cant finish yet, wait for images
 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author harja
 */
public class Character extends GameObject {

    //create variables for attributes of the character
    protected Color bow;// the color of the characters bow
    BufferedImage animal;// the animal of the character
    protected ArrayList cards;// the characters cards

    /**
     *default character constructor
     */
    public Character() {

    }

    /**
     *secondary constructor to create character with user input
     * @param bow
     * @param animal
     * @param direction
     * @param cards
     */
    public Character(int x, int y, Color bow, BufferedImage animal, boolean direction, ArrayList cards) {
        super(x, y, 0, animal.getWidth(), animal.getHeight(), 1, direction);
        this.bow = bow;
        this.animal = animal;
        this.cards = cards;

    }

    /**
     * mutator method to set the color of the bow
     *
     * @param c
     */
    public void setBow(Color c) {
        bow = c;
    }

    /**
     * accessor method to get the color of the bow
     *
     * @return
     */
    public Color getBow() {
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
     * @return
     */
    public BufferedImage getAnimal() {
        return animal;//return the animal
    }

    /**
     * accesor method to get the crds
     *
     * @return
     */
    public ArrayList getCards() {
        return cards;//return the cards
    }

    /**
     * method to clone the character and its attributes
     *
     * @return
     */
//    public Character clone(){
//        //Character newChar = new Character(bow, animal, direction, cards);
//      //  return newChar;
//    }
    /**
     * accessor method for all the attributes of the player
     *
     * @return
     */

    public void render(Graphics2D g2d) {
        //System.out.println(this.animal);
        g2d.drawImage(animal, this.getX(), this.getY(), this.getObjectWidth(), this.getObjectHeight(), null);

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
        this.width = (this.getObjectWidth() * scale) / 100;
        this.height = (this.getObjectHeight() * scale) / 100;

    }
    /**
     * to string method with all attributes of the character
     * @return 
     */
    public String toString() {
        return "Color: " + bow + "\tAnimal: " + animal + "\tCards: " + cards;//return atring with all attributes of the character
    }
}
