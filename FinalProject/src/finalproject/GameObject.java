/*
add update methods
update the mouseOver method
 */
package finalproject;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author harja
 */
public class GameObject {
    int xPos;
    int yPos;
    int rotation;
    int width;
    int height;
    double scale;
    boolean direction; //true == right
    
    public GameObject(){
        xPos = 0;
        yPos = 0;
        rotation = 0;
        width = 0;
        height = 0;
        scale = 0.0;
        direction = true; //Facing right
    }
    
    public GameObject(int xPos, int yPos, int rotation, int width, int height, double scale, boolean direction){
        this.xPos = xPos;
        this.yPos = yPos;
        this.rotation = rotation;
        this.width = width;
        this.height = height;
        this.scale = scale;
        this.direction = direction;
    }
    
    public void move(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public void setX(int xPos){
        this.xPos = xPos;
    }
    public void setY(int yPos){
        this.yPos = yPos;
    }
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
    
    public void setRotation(int rotation){
        this.rotation = rotation;
    }
    public int getRotation(){
        return rotation;
    }
    
    public void setScale(double scale){
        this.scale = scale;
    }
    public double getScale(){
        return scale;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    public int getWidth(){
        return width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return height;
    }
    
    public void setDirection(boolean direction){
        this.direction = direction;
    }
    public boolean getDirection(){
        return direction;
    }
    
    public void mouseOver(){ //check if the mouse is over a object
        
    }
    
    public GameObject clone(){
        GameObject newGameObject = new GameObject(xPos, yPos, rotation, width, height, scale, direction);
        return newGameObject;
    }
    
    public String toString(){
        return "X Position: " + xPos + "\tY Position: " + yPos + "\tRotation: " + rotation + "\tWidth: " + width + "\tHeight: " + height + "\tScale: " + scale + "\tDirection: " + direction;
    }
    
    public BufferedImage createBufferedImage(String src){
        BufferedImage img;
        
        try{
            
        img =  ImageIO.read(getClass().getResourceAsStream(src));
       
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "ERROR LOADING " + src + " :\n" + e);
            img=null;
            
            
        } 
         return img; 
        
    }
    
    
}
