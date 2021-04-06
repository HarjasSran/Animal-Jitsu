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
    
    public Card(){
        element = 0;
        cardNumber = 1;
        color = Color.WHITE;
        faceUp = false;
    }
    
    public Card(int element, int cardNumber, Color color, boolean faceUp){
        this.element = element;
        this.cardNumber = cardNumber;
        this.color = color;
        this.faceUp = faceUp;
    }
    
    public void setElement(int element){
        this.element = element;
    }
    public int getElement(){
        return element;
    }
    
    public void setCardNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }
    public int getCardNumber(){
        return cardNumber;
    }
    
    public void setColor (Color c){
        color = c;
    }
    public Color getColor(){
        return color;
    }
    
    public void setFaceUp(boolean faceUp){
        this.faceUp = faceUp;
    }
    public boolean getFaceUp(){
        return faceUp;
    }
    
    public Card clone(){
        Card newCard = new Card(element, cardNumber, color, faceUp);
        return newCard;
    }
    
    //public String toString(){
        //return element "\t" + cardNumber + "\t" + color + "\t" + faceUp;
    //}
}
