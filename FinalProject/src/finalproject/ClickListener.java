//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//class to register the mouse actions preformed by the user
package finalproject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author harja
 */
public class ClickListener extends MouseAdapter {

    double xPos;
    double yPos;
    static double scale = GameScreen.SCREEN_SCALE;
    boolean clicked;


    
    /**
     * accessor method to get the x and y pos of whenre the user clicked
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        xPos = e.getX()/scale;
        
        
      
        yPos = e.getY()/scale;
        
        
        System.out.println(xPos + ", " + yPos);

        //save x and y coordinates
    }
    /**
     * method for wwhen mouse is pressed 
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        clicked = true;
        // System.out.println("f" + clicked);
    }
    /**
     * method for when moouse is released
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    /**
     * accessor method to get x position
     *
     * @return
     */
    public double getXPos() {
        return xPos;//return x position
    }

    /**
     * accessor method to get the y position
     *
     * @return
     */
    public double getYPos() {
        return yPos;//return y position
    }

    /**
     * accessor method to get wethoer or not the something is pressed
     *
     * @return
     */
    public boolean isPressed() {
        return clicked;//return if it is pressed
    }

}
