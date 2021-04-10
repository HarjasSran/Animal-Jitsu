//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//Class for the Sensei playing
package finalproject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author harja
 */
public class Computer extends Character{
    int skillLevel;
    
    /**
     * Default constructor
     */
    public Computer(){
        super(); 
        skillLevel = 0;
    }
    
    /**
     * Second constructor
     * @param name
     * @param x
     * @param y
     * @param bow
     * @param animal
     * @param direction
     * @param skillLevel 
     * @param cards 
     */
    public Computer(String name, int x, int y, int bow, BufferedImage animal, boolean direction, ArrayList<Card> cards, int skillLevel){
        super(name,x,y,bow,animal,direction,cards); 
        this.skillLevel = skillLevel;
        
        
    }
    
    /**
     * Mutator method to set the skill level of the computer sensei
     * @param skillLevel - skill level of the sensei
     */
    public void setSkillLevel(int skillLevel){
        this.skillLevel = skillLevel;
    }
    /**
     * Accessor method for the skill level
     * @return - skill level of the computer sensei
     */
    public int getSkillLevel(){
        return skillLevel;//return the skill level
    }
    
    /**
     * Cloning method to make a clone of the current computer sensei
     * @return the cloned computer 
     */
    public Computer clone(){
        Computer newComp = new Computer(name, xPos, yPos, bow, animal, direction, cards, skillLevel); //new copy of the computer sensei is created 
        return newComp;//return the cloned computer
    }
    /**
     * 
     * @param g2d 
     */
    public void render(Graphics2D g2d) {
        super.render(g2d);
        g2d.setFont(CharacterSelectMenu.gameFont);

        g2d.drawChars(this.name.toCharArray(), 0, name.length(), this.getX() - 175, 1000);
    }
    
    /**
     * Accessor method for all attributes and values of the computer sensei
     * @return - all attributes and values of the computer sensei
     */
    public String toString(){
        return String.valueOf(skillLevel);//retun the skill level
    }
}
