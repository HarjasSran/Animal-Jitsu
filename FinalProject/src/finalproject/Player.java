//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//
package finalproject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author harja
 */
public class Player extends Character{
    int bow;
    
    public Player(){
        bow = 1;
    }
    
    public Player(String name, int x, int y, int bow, BufferedImage animal, boolean direction, ArrayList<Card> cards){
        
        super(name,x,y,bow,animal,direction,cards); 
        this.bow = bow;
        
       
    }
    
   
        
    /**
     * 
     * @param name 
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * 
     * @return 
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @return 
     */
    public Player clone(){
        Player newPlayer = new Player(); //After adding second constructor, use that
        return newPlayer;
    }
    /**
     * 
     * @return 
     */
    
//    public Card playCard (){
//        
//    }
    
    public void redraw(){
        
    }
    
    
    
    public void render(Graphics2D g2d) {
        super.render(g2d);
        g2d.setFont(CharacterSelectMenu.gameFont);
        g2d.drawChars((this.getBow()+ " " + this.name).toCharArray(), 0, name.length()+2, 120, 1000);

    }

    
    
    public String toString(){
        return name + "\t" + bow;
    }
}
