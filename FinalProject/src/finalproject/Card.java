//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//
package finalproject;

import java.awt.Color;
import java.awt.Graphics2D;

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

    
    // controls the scaling of the card e.g. 4 is 4 times larger than source image
    static int DEFAULT_SCALE = 4;

    int targetWidth;

    /**
     * Default constructor
     * create a generic card that is face down
     */
    public Card() {
        super();
        this.element = 0;
        this.cardNumber = 1;
        this.color = Color.WHITE;
        this.faceUp = false;
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
        targetWidth = PIXEL_WIDTH * DEFAULT_SCALE;
        
        
        
         

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
     * In practice, this method should typically not be called
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

    //makes the card width approach 0 as to appear to flip (using linear interpolation)
    public void flip() {
        this.targetWidth = 0;
    }
    
    //
    /**
     * once the card with reaches its minimum value, 
     * this method will be called by the render fucntion 
     * in order to change the card to face up, and then reset 
     * the width to default via linear interpolation
     */
    public void flip2(){
        this.targetWidth = PIXEL_WIDTH*DEFAULT_SCALE; 
        this.setFaceUp(!faceUp);
    }

    // controls which card is drawn based off a portion of the card spritesheet x Position
    int horizontalIndex;
    // controls which card is drawn based off a portion of the card spritesheet y Position
    int verticalIndex;

    // the width of the selection area for the spritesheet
    int cardXOffset;
     // the height of the selection area for the spritesheet
    int cardYOffset;

    public void render(Graphics2D g2d) {
        
     //g2d.fillRect(xPos, yPos, 50, 500);
  
        
 //the card always strives to approach the target width
 // if the target width is not currently reached, it will move 50% of the way there
 // easing its way to the correct width smoothly
if(this.targetWidth != this.width && this.width!=1){
   this.width = lerp(width,targetWidth,0.5);
   
}

// the minimum possible width of the card
// occurs after flip is called
if(this.width==1){
    // second half of the flipping animation  - flip2 changes the faceUp attribute of the card
    flip2(); 
    this.width = lerp(width,targetWidth,0.5);
  
}
        
 //card always tries to approach its targetX   
 //via smooth easing function
 if(this.getTargetX()!=this.getX()){
     xPos =  GameObject.lerp(xPos, targetX, 0.1); 
 }
 
 
 //card always tries to approach its targetY   
 //via smooth easing function
 if(this.getTargetY()>=this.getY()){
     yPos =  GameObject.lerp(yPos, targetY, 0.1); 
 }
        
        //if it is face up, it translates the selected portion of the spritesheet to the correct location
        if(faceUp){
          horizontalIndex = this.cardNumber+1;
         verticalIndex = this.element;
         
        }else{
            // if face down, the selected portion of the spritesheet is the first card which is facedown
            horizontalIndex=0; 
            verticalIndex=0; 
        }

        // minimum width reached by the flip() lerp function, once this is reached, flip it to the other side and expand width with flip2()
        if (this.width == 1) {
            flip2();
            this.width = lerp(width, targetWidth, 0.5);

        }

        if (this.getTargetX() != this.getX()) {
            xPos = GameObject.lerp(xPos, targetX, 0.1);
        }

        if (this.getTargetY() >= this.getY()) {
            yPos = GameObject.lerp(yPos, targetY, 0.1);
        }

        if (faceUp) {
            horizontalIndex = this.cardNumber + 1;
            verticalIndex = this.element;

        } else {
            horizontalIndex = 0;
            verticalIndex = 0;
        }
        cardXOffset = horizontalIndex * PIXEL_WIDTH;
        cardYOffset = verticalIndex * PIXEL_HEIGHT;

        /**
         *Cards are drawn by selecting a start & end x and y value from the spritesheet, and drawing that rectangular portion of the spritesheet
         */
        g2d.drawImage(GameScreen.CARD_SPRITE, xPos, yPos, this.width + xPos, this.height + yPos, cardXOffset, cardYOffset, PIXEL_WIDTH + cardXOffset, PIXEL_HEIGHT + cardYOffset, null);

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
    
    
    
    
    public static boolean checkWin(Card compPick, Card userPick) {
      boolean userWin= false; 

        //snow(2) beats water(0)
        //water(0) beats fire(1)
        //fire(1) beats snow(2)
        int compElement = compPick.getElement();
        int userElement = userPick.getElement();

        int compNumber = compPick.getCardNumber();
        int userNumber = userPick.getCardNumber();

        if (userElement != compElement) {//if the user and sensei pick differant elements
            if (userElement == FIRE_ELEMENT) {//if user picks fire
                if (compElement == SNOW_ELEMENT) {//if sensei picks snow
                 userWin = true; //user wins
                }
            } else if (userElement == WATER_ELEMENT) {//if user picks water
                if (compElement == FIRE_ELEMENT) {//if sensei picks fire
                   userWin = true; //user wins
                }
            } else if (userElement ==SNOW_ELEMENT) {//if user picks snow
                if (compElement == WATER_ELEMENT) {//if sensi picks water
                    userWin = true;//user wins
                }
            }


        } else if (userElement == compElement) {//if user and sensei pick the sme element
            if (userNumber > compNumber) {//if the users number is greater than senseis number
                userWin = true;//user wins
            }
        }

        return userWin;//return weather or not the user won
    }
    
    
    
    
    
    
    

    /**
     * Accessor method for all attributes and values of the card
     *
     * @return - all attributes and values of the card
     */
    public String toString() {
       
        return  super.toString() + "Element: " + String.valueOf(element) + "\tCard Number: " + String.valueOf(cardNumber) + "\tColour: " + color + "\tFacing: " + faceUp;//return tring of all attributes of the card
    }

    /**
     * Checks whether or not the card is getting clicked by the user
     * @param x - x pos of mouse when clicking
     * @param y - y pos of mouse when clicking
     * @return - if the card was clicked (boolean)
     */
    public boolean isClicked(double x, double y) {

        boolean isClicked = false;

        //if the user has clikced between the x positions of the card
        if (this.getX() < x && x < this.getX() + this.getObjectWidth()) {
            //if the user has also clicked between the ypostions of the card
            if (this.getY() < y && y < this.getY() + this.getObjectHeight()) {
                //then the user has clicked the card
                isClicked = true;

            }

        }
        //card was not clicked otherwise
        else {
            isClicked = false;

        }

        return isClicked;
    }
}
