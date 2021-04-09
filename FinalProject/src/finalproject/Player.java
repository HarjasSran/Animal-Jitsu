/*

 */
package finalproject;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author harja
 */
public class Player extends Character{
    String name;
    int rank;
    
    public Player(){
        name = "";
        rank = 0;
    }
    
    public Player(int x, int y,String name, Color bow, BufferedImage animal, boolean direction, ArrayList<Card> cards){
        
        super(x,y,bow,animal,direction,cards); 
        
        this.name = name;
       
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
     * @param rank 
     */
    public void setRank(int rank){
        this.rank = rank;
    }
    /**
     * 
     * @return 
     */
    public int getRank(){
        return rank;
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
    
    
    public String toString(){
        return name + "\t" + rank;
    }
}
