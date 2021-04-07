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
    
    public Character(){
        
    }
    
    public Character(Color bow, BufferedImage animal, boolean direction, ArrayList cards){
        this.bow = bow;
        this.animal = animal; 
        this.direction = direction;
        this.cards = cards;
    }
    
    public void setBow(Color c){
        bow = c;
    }
    public Color getBow(){
        return bow;
    }
    
    public void setAnimal(BufferedImage animal){
        this.animal = animal;
    }
    
    public BufferedImage getAnimal(){
        return animal;
    }
    
    public ArrayList getCards(){
        return cards;
    }
    
    public Character clone(){
        Character newChar = new Character(bow, animal, direction, cards);
        return newChar;
    }
    
    public String toString(){
        return "Color: " + bow + "\tAnimal: " + animal + "\tCards: " + cards;
    }
}
