//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//
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
    protected int bow;// the color of the characters bow
    BufferedImage animal;// the animal of the character
    protected ArrayList cards;// the characters cards

    protected String name;

    protected long currentFrame = 0;
    final int distortOffset = (int) (Math.random() * 10);

    int multiplier;

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
    public Character(String name, int x, int y, int bow, BufferedImage animal, boolean direction, ArrayList<Card> cards) {

        super(x, y, 0, animal.getWidth(), animal.getHeight(), 1.0, direction);

        if (direction) {
            multiplier = 1;
        } else {
            multiplier = -1;
        }

        this.bow = bow;
        this.animal = animal;
        this.cards = cards;
        this.name = name;

        //gorilla
        //   g2d.drawImage(GameScreen.WHITE_BOW, 425,645+distort/2,GameScreen.WHITE_BOW.getWidth()*3,GameScreen.WHITE_BOW.getHeight()*3-distort/5,null); 
    }

    /**
     * mutator method to set the color of the bow
     *
     * @param c
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
     * @return
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
    public ArrayList<Card> getCards() {
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
    double x = 0.0;
    int distort;

    public void render(Graphics2D g2d) {

        
        
        if (this.getTargetX() > this.getX()) {

            // this.setX(xPos+1);
            this.setX(Math.round(1.01f * this.getTargetX()));

        } else if (this.getTargetX() < this.getX()) {
            this.setX(this.getX() - Math.round(0.01f * this.getTargetX()));
        }

        if (this.getTargetY() > this.getY()) {

            // this.setX(xPos+1);
            this.setY(this.getY() + Math.round(0.01f * this.getTargetY()));

        } else if (this.getTargetY() < this.getY()) {
            this.setY(this.getY() - Math.round(0.01f * this.getTargetY()));
        }

        //System.out.println(this.animal);
        x += (Math.sin((currentFrame + this.xPos) * 0.1)) / 1.5;
        distort = (int) Math.floor(x);

        currentFrame++;
        BufferedImage bows[] = {GameScreen.BLACK_BOW, GameScreen.WHITE_BOW, GameScreen.GREEN_BOW, GameScreen.YELLOW_BOW, GameScreen.ORANGE_BOW, GameScreen.RED_BOW};
        g2d.drawImage(bows[this.getBow()], this.getX() - this.getObjectWidth(), 965, bows[this.getBow()].getWidth(), bows[this.getBow()].getHeight(), null);
        g2d.drawImage(animal, this.getX(), this.getY() + distort, this.getObjectWidth() * multiplier, this.getObjectHeight() - distort, null);

//        g2d.setFont(CharacterSelectMenu.gameFont);
//        if(this instanceof Player){
//            g2d.drawChars(this.name.toCharArray(), 0,name.length(),50, 1000);
//            
//        }
//        else if(this instanceof Computer){
//             g2d.drawChars(this.name.toCharArray(), 0,name.length(),this.getX()-175, 1000);
//        }
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
        this.height = (this.getAnimal().getHeight() * scale) / 100;

    }

    /**
     * to string method with all attributes of the character
     *
     * @return
     */
    public String toString() {
        return "Color: " + bow + "\tAnimal: " + animal + "\tCards: " + cards;//return atring with all attributes of the character
    }
}
