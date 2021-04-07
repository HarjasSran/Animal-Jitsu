/*

 */
package finalproject;

import java.awt.Color;

/**
 *
 * @author harja
 */
public class Card extends Character{
    int element;
    int cardNumber;
    Color color;
    boolean faceUp; //true == facing up
    
    int WATER_ELEMENT = 0;
    int FIRE_ELEMENT = 1;
    int SNOW_ELEMENT = 2;
    
    /**
     * Default constructor
     */
    public Card(){
        element = 0;
        cardNumber = 1;
        color = Color.WHITE;
        faceUp = false;
    }
    
    /**
     * Second constructor to make card with input
     * @param element 
     * @param cardNumber
     * @param color
     * @param faceUp 
     */
    public Card(int element, int cardNumber, Color color, boolean faceUp){
        this.element = element;
        this.cardNumber = cardNumber;
        this.color = color;
        this.faceUp = faceUp;
    }
    
    /**
     * Mutator method to set the element on the card
     * @param element - element on the card 
     */
    public void setElement(int element){
        this.element = element;
    }
    /**
     * Accessor method for the element
     * @return - element on the card
     */
    public int getElement(){
        return element;
    }
    
    /**
     * Mutator method to set the number of the card
     * @param cardNumber - number of the card
     */
    public void setCardNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }
    /**
     * Accessor method for card number
     * @return - number of the card
     */
    public int getCardNumber(){
        return cardNumber;
    }
    
    /**
     * Mutator method to set the color of the card
     * @param c 
     */
    public void setColor (Color c){
        color = c;
    }
    /**
     * Accessor method for the color
     * @return - color of the card
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Mutator method to set the direction card is facing
     * @param faceUp - true (up) or false (down)
     */
    public void setFaceUp(boolean faceUp){
        this.faceUp = faceUp;
    }
    /**
     * Accessor method for the direction of the card
     * @return - direction that the card is facing
     */
    public boolean getFaceUp(){
        return faceUp;
    }
    
    /**
     * Clone method to make a copy of the card
     * @return - the clone of the card
     */
    public Card clone(){
        Card newCard = new Card(element, cardNumber, color, faceUp); //create new card with the exact same attributes and value
        return newCard;
    }
    
    /**
     * Accessor method for all attributes and values of the card
     * @return - all  attributes and values of the card
     */
    public String toString(){
        return "Element: " +  String.valueOf(element) + "\tCard Number: " + String.valueOf(cardNumber) + "\tColour: " + color + "\tFacing: " + faceUp;
    }
}
