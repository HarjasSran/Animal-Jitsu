/*

 */
package finalproject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author harja
 */
public class Card extends GameObject {

    int element;
    int cardNumber;
    Color color;
    boolean faceUp; //true == facing up

    final static int PIXEL_WIDTH = 35;
    final static int PIXEL_HEIGHT = 47;

    final static int FIRE_ELEMENT = 0;
    final static int WATER_ELEMENT = 1;
    final static int SNOW_ELEMENT = 2;
    
     static int DEFAULT_SCALE = 4;

    /**
     * Default constructor
     */
    public Card() {
        super();
        element = 0;
        cardNumber = 1;
        color = Color.WHITE;
        faceUp = false;
    }

    /**
     * Second constructor to make card with input
     *
     * @param element
     * @param cardNumber
     * @param faceUp
     */
    public Card(int xPos, int yPos, int rotation, double scale, int element, int cardNumber, boolean faceUp) {
        super(xPos, yPos, rotation, PIXEL_WIDTH * DEFAULT_SCALE, PIXEL_HEIGHT * DEFAULT_SCALE, scale, true);
        this.element = element;
        this.cardNumber = cardNumber;
        this.faceUp = faceUp;
        
        
       

    }

    /**
     * Mutator method to set the element on the card
     *
     * @param element - element on the card
     */
    public void setElement(int element) {
        this.element = element;
    }

    /**
     * Accessor method for the element
     *
     * @return - element on the card
     */
    public int getElement() {
        return element;//return the element of the card
    }

    /**
     * Mutator method to set the number of the card
     *
     * @param cardNumber - number of the card
     */
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Accessor method for card number
     *
     * @return - number of the card
     */
    public int getCardNumber() {
        return cardNumber;//return the number of the card
    }

    /**
     * Mutator method to set the color of the card
     *
     * @param c
     */
    public void setColor(Color c) {
        color = c;
    }

    /**
     * Accessor method for the color
     *
     * @return - color of the card
     */
    public Color getColor() {
        return color;//return the color of the card
    }

    /**
     * Mutator method to set the direction card is facing
     *
     * @param faceUp - true (up) or false (down)
     */
    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    /**
     * Accessor method for the direction of the card
     *
     * @return - direction that the card is facing
     */
    public boolean getFaceUp() {
        return faceUp;//return weather or not the card is face up
    }

   
    int horizontalIndex;
    int verticalIndex; 

    int cardXOffset; 
    int cardYOffset; 

    public void render(Graphics2D g2d) {
        
        
        if(faceUp){
          horizontalIndex = this.cardNumber+1;
         verticalIndex = this.element;
         
        }else{
            horizontalIndex=0; 
            verticalIndex=0; 
        }
         cardXOffset = horizontalIndex * PIXEL_WIDTH;
          cardYOffset = verticalIndex * PIXEL_HEIGHT;   
        
        /**
         *
         */
        
       
        g2d.drawImage(GameScreen.CARD_SPRITE, xPos, yPos, PIXEL_WIDTH * DEFAULT_SCALE+xPos, PIXEL_HEIGHT * DEFAULT_SCALE+yPos, cardXOffset, cardYOffset, PIXEL_WIDTH + cardXOffset, PIXEL_HEIGHT + cardYOffset, null);

    }

    /**
     * Clone method to make a copy of the card
     *
     * @return - the clone of the card
     */
    public Card clone() {
        Card newCard = new Card(xPos, yPos, rotation, scale, element, cardNumber, faceUp); //create new card with the exact same attributes and value
        return newCard;//return the clone of the card
    }

    /**
     * Accessor method for all attributes and values of the card
     *
     * @return - all attributes and values of the card
     */
    public String toString() {
        return "Element: " + String.valueOf(element) + "\tCard Number: " + String.valueOf(cardNumber) + "\tColour: " + color + "\tFacing: " + faceUp;//return tring of all attributes of the card
    }
    
    
    public boolean isClicked(ClickListener listener) {
        
        
        double clickXPos = listener.getXPos();
        double clickYPos = listener.getYPos();
        boolean isClicked = false;
      //  System.out.println(this.xPos);
     
        
        if (this.getX()<clickXPos && clickXPos<this.getX()+this.getObjectWidth()) {
            
            if(this.getY()<clickYPos && clickYPos<this.getY()+this.getObjectHeight()){
          System.out.println("Element"+this.element +  "Value" + this.getCardNumber());
            isClicked = true;

            }
            

        } else {
            //System.out.println(false);
        }
        
       
        return isClicked;
    }
}
