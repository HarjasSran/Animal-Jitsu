/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    double scale = GameScreen.SCREEN_SCALE;
    boolean clicked;


    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        xPos = e.getX()*scale;
        
        
      
        yPos = e.getY()*scale;
        //System.out.println(xPos + ", " + yPos);

        //save x and y coordinates
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked = true;
        // System.out.println("f" + clicked);
    }

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
