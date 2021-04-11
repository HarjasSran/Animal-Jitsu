//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//
package finalproject;

import java.awt.image.BufferedImage;

/**
 *
 * @author harja
 */
public class Particle extends GameObject {

    BufferedImage element;

    /**
     * initial constructor to set to default values
     */
    public Particle() {
        super();
        element = null;
        direction = true;
    }
    /**
     * Secondary constructor to create particle game object
     * @param xPos
     * @param yPos
     * @param rotation
     * @param width
     * @param height
     * @param scale
     * @param element
     * @param direction 
     */
    public Particle(int xPos, int yPos, int rotation, int width, int height, double scale,  boolean direction, BufferedImage element) {
        super(xPos, yPos, rotation, width, height, scale, direction);
        this.direction = direction;
    }
    /**
     * mutator method to set the element
     * @param element 
     */
    public void setElement(BufferedImage element){
        this.element = element;
    }
    /**
     * accesor method to get the element
     * @return - element of the particle
     */
    public BufferedImage getElement(){
        return element;
    }
    /**
     * clone method to clone the particle
     * @return 
     */
    public Particle clone(){
        Particle newParticle = new Particle(xPos, yPos, rotation, width, height, scale, direction, element);
        return newParticle;
    }
    /**
     * Accessor method to return all particle attributes and values
     * @return 
     */
    public String toString(){
        return super.toString() + "Element: " + element + "Direction: " + direction;
    }
}
