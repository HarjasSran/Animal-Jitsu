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
    
    int xPos;
    int yPos;
    boolean clicked;
    @Override
    public void mouseClicked(MouseEvent e) {
        xPos = e.getX();
        yPos = e.getY();
        System.out.println(xPos + ", " + yPos);
        
        //save x and y coordinates
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        clicked = true;
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        clicked = false;
    }
    
    public int getXPos(){
        return xPos;
    }
    
    public int getYPos(){
        return yPos;
    }
    
    public boolean isPressed(){
        return clicked;
    }
    
}
