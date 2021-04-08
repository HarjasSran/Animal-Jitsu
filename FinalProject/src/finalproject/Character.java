/*
cant finish yet, wait for images
 */
package finalproject;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author harja
 */
public class Character extends GameObject {
    //create variables for attributes of the character
    protected Color bow;// the color of the characters bow
    protected BufferedImage animal;// the animal of the character
    protected ArrayList cards;// the characters cards
    
    /**
     * 
     */
    public Character(){
        
    }
    /**
     * 
     * @param bow
     * @param animal
     * @param direction
     * @param cards 
     */
    public Character(Color bow, BufferedImage animal, boolean direction, ArrayList cards){
        this.bow = bow;
        this.animal = animal; 
        this.direction = direction;
        this.cards = cards;
    }
    /**
     * mutator method to set the color of the bow
     * @param c 
     */
    public void setBow(Color c){
        bow = c;
    }
    
    /**
     * accessor method to get the color of the bow
     * @return 
     */
    public Color getBow(){
        return bow;
    }
    /**
     * mutator method to set the animal
     * @param animal 
     */
    public void setAnimal(BufferedImage animal){
        this.animal = animal;
    }
    /**
     * accesor method to get the animal
     * @return 
     */
    public BufferedImage getAnimal(){
        return animal;
    }
    /**
     * accesor method to get the crds
     * @return 
     */
    public ArrayList getCards(){
        return cards;
    }
    /**
     * method to clone the character and its attributes
     * @return 
     */
    public Character clone(){
        Character newChar = new Character(bow, animal, direction, cards);
        return newChar;
    }
    /**
     * accessor method for all the attributes of the player
     * @return 
     */
    public String toString(){
        return "Color: " + bow + "\tAnimal: " + animal + "\tCards: " + cards;
    }
}
