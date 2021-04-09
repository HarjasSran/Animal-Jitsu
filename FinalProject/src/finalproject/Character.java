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
    
    protected long currentFrame=0; 
    final int distortOffset =(int)(Math.random()*10);

int multiplier;
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
    public Character(int x, int y, Color bow, BufferedImage animal, boolean direction, ArrayList<Card> cards) {

        super(x, y, 0, animal.getWidth(), animal.getHeight(), 1, direction);
        this.bow = bow;
        this.animal = animal;
        this.cards = cards;
        if (direction) {
            multiplier = 1;
        }
        else{
            multiplier = -1;
        }
        
        
        
        //gorilla
        //   g2d.drawImage(GameScreen.WHITE_BOW, 425,645+distort/2,GameScreen.WHITE_BOW.getWidth()*3,GameScreen.WHITE_BOW.getHeight()*3-distort/5,null); 

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
    public ArrayList <Card> getCards() {
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
    
// used to distort the heights of characters by a periodic funtion
// making them appear to sort of breathe.     
 double x=0.0;
int distort; 
    public void render(Graphics2D g2d) {
        //System.out.println(this.animal);
        
        
          x += (Math.sin((currentFrame+this.xPos) * 0.001)) / 100;
        distort = (int) Math.floor(x);
        
        
       
        
       currentFrame++; 
        g2d.drawImage(animal, this.getX(), this.getY()+distort, this.getObjectWidth() * multiplier, this.getObjectHeight()-distort, null);
     
        g2d.setFont(CharacterSelectMenu.gameFont);
       // g2d.drawChars(, 0,3,500,500);
       
     
        
       
      
        
//        if(this.getAnimal() != GameScreen.BOSS_IMAGE){
//            
//              g2d.drawImage(GameScreen.WHITE_BOW, 425,645+distort/2,GameScreen.WHITE_BOW.getWidth()*3,GameScreen.WHITE_BOW.getHeight()*3-distort/5,null); 
//          //g2d.drawImage(GameScreen.WHITE_BOW, 390,550+distort/2,GameScreen.WHITE_BOW.getWidth()*2,GameScreen.WHITE_BOW.getHeight()*2-distort/5,null); 
//        }
       


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
        this.height = (this.getAnimal().getHeight()* scale) / 100;

    }
    /**
     * to string method with all attributes of the character
     * @return 
     */
    public String toString() {
        return "Color: " + bow + "\tAnimal: " + animal + "\tCards: " + cards;//return atring with all attributes of the character
    }
}
