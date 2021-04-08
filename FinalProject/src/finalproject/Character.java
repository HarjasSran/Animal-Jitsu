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
    Color bow;
    BufferedImage animal;
    ArrayList cards;
    
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
     * 
     * @param c 
     */
    public void setBow(Color c){
        bow = c;
    }
    
    /**
     * 
     * @return 
     */
    public Color getBow(){
        return bow;
    }
    /**
     * 
     * @param animal 
     */
    public void setAnimal(BufferedImage animal){
        this.animal = animal;
    }
    /**
     * 
     * @return 
     */
    public BufferedImage getAnimal(){
        return animal;
    }
    /**
     * 
     * @return 
     */
    public ArrayList getCards(){
        return cards;
    }
    /**
     * 
     * @return 
     */
    public Character clone(){
        Character newChar = new Character(bow, animal, direction, cards);
        return newChar;
    }
    /**
     * 
     * @return 
     */
    public String toString(){
        return "Color: " + bow + "\tAnimal: " + animal + "\tCards: " + cards;
    }
}
