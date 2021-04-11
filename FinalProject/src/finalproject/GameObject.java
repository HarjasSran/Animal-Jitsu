//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//
package finalproject;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author harja
 */
abstract public class GameObject {

    protected int xPos;
    protected int yPos;
    protected int rotation;
    protected int width;
    protected int height;
    protected double scale;
    protected boolean direction; //true == left

    int targetX;
    int targetY;


    /**
     * Default constructor
     */
    public GameObject() {

        xPos = 0;
        yPos = 0;
        rotation = 0;
        width = 0;
        height = 0;
        scale = 0;
        direction = true; //Facing left
    }

    /**
     * Second constructor used for making GameObjects
     *
     * @param xPos - x position of object
     * @param yPos - y position of object
     * @param rotation - rotation of the object
     * @param width - width of the object
     * @param height - height of the object
     * @param scale - scale of the object
     * @param direction - the direction the object is facing. true == left
     */
    public GameObject(int xPos, int yPos, int rotation, int width, int height, double scale, boolean direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rotation = rotation;
        this.width = width;

        this.height = height;
        this.scale = scale;
        this.direction = direction;

        targetX = this.xPos;
        targetY = this.yPos;

    }

    /**
     * Mutator method which changes x and y position of game objects
     *
     * @param xPos - x position of the object
     * @param yPos - y position of the object
     */
    public void move(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Mutator method which changes the x position of the game objects
     *
     * @param xPos - x position of the object
     */
    public void setX(int xPos) {
        this.targetX = xPos;
        this.xPos = xPos;
    }

    /**
     * Mutator method which changes the y position of the game objects
     *
     * @param yPos - y position of the object
     */
    public void setY(int yPos) {
        this.targetY = yPos;
        this.yPos = yPos;
    }

    /**
     * mutator method which sets the x and y position of the game objects
     *
     * @param xPos
     * @param yPos
     */
    public void setPositon(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Accessor method for x position
     *
     * @return - x position of the object
     */
    public int getX() {

        return xPos;//return th x position
    }

    /**
     * Accessor method for y position
     *
     * @return - y position of the object
     */
    public int getY() {
        return yPos;//return the y position
    }

    /**
     * Mutator method to change the rotation of the object
     *
     * @param rotation - rotation of the object
     */
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    /**
     * Accessor method for rotation
     *
     * @return - rotation of the object
     */
    public int getRotation() {
        return rotation;//return the rotation
    }

    /**
     * Accessor method for scale
     *
     * @return - scale of the object
     */
    public double getScale() {
        return scale;//return the scale
    }

    /**
     * Mutator method to set the width of the object
     *
     * @param width - width of the object
     */
    public void setWidth(int width) {

        this.width = width;

    }

    /**
     * Accessor method for width
     *
     * @return - width of the object
     */
    public int getObjectWidth() {

        return width;//return the width
    }

    /**
     * Mutator method to set the height of the object
     *
     * @param height - height of the object
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Accessor method for height
     *
     * @return - height of the object
     */
    public int getObjectHeight() {
        return height;
    }

    /**
     * Mutator method to set the direction that the object is facing
     *
     * @param direction - direction that the object is facing
     */
    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    /**
     * Accessor method for directon
     *
     * @return - direction that the object is facing
     */
    public boolean getDirection() {
        return direction;//return the direction
    }

    /**
     * Accessor method to return all GameObject attributes and values
     *
     * @return - all GameObject attributes and values
     */
    public String toString() {
        return "X Position: " + xPos + "\tY Position: " + yPos + "\tRotation: " + rotation + "\tWidth: " + width + "\tHeight: " + height + "\tScale: " + scale + "\tDirection: " + direction;//to string of attributes of the object
    }

    /**
     * Static method to interpolate between 2 values
     * @param a start value
     * @param b end value
     * @param fac factor controlling speed (0.5 means it moves halfway to end point each time) 
     * @return the interpolated value
     */
    public static int lerp(int a, int b, double fac) {
        return a + (int) (fac * (b - a));
    }

    public int getTargetX() {
        return this.targetX;
    }

    public int getTargetY() {
        return this.targetY;
    }

    public void moveObject(int x, int y) {

        targetX = x;
        targetY = y;

    }

    /**
     * method to create buffered image
     *
     * @param src
     * @return
     */
    protected BufferedImage createBufferedImage(String src) {
        BufferedImage img;

        try {

            img = ImageIO.read(getClass().getResourceAsStream(src)); //load image using source and save

        } catch (IOException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "ERROR LOADING " + src + " :\n" + e); //error message
            img = null; //no image if error occurs 

        }
        return img;//return the image

    }

}
