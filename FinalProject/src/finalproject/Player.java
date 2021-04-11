/**
 * Caroline Widdecombe, Aidan Goodyer, Harjas Sran
 * Player class
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
public class Player extends Character{
    int bow;
    
    /**
     * Primary constructor 
     */
    public Player(){
        super();
        bow = 1;
    }
    
    /**
     * Secondary constructor 
     * @param name
     * @param x
     * @param y
     * @param bow
     * @param animal
     * @param direction
     * @param cards 
     */
    public Player(String name, int x, int y, int bow, BufferedImage animal, boolean direction, ArrayList<Card> cards){
        super(name,x,y,bow,animal,direction,cards); 
        this.bow = bow;
    }
    
   
        
    /**
     * Mutator method to set the name of the player
     * @param name 
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Accessor method to get the name of the player
     * @return - name of the character
     */
    public String getName(){
        return name;
    }
    
    
    
    /**
     * Render method which draws the players and rank as well as calling on the
     * super render method
     */
    public void render(Graphics2D g2d) {
        super.render(g2d);
        g2d.setFont(CharacterSelectMenu.gameFont);
        g2d.drawChars((this.getBow()+ " " + this.name).toCharArray(), 0, (this.getBow()+ " " + this.name).toCharArray().length, 120, 1000);

    }

    /**
     * Clone method to make an identical new player
     *
     * @return - the identical new player
     */
    public Player clone() {
        Player newPlayer = new Player(name, xPos, yPos, bow, animal, direction, cards); //After adding second constructor, use that
        return newPlayer;
    }
    /**
     * method to return the name and bow of the character to the user
     * @return 
     */
    public String toString(){
        return super.toString() + name + "\t" +  bow;
    }
}
