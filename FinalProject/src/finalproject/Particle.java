/*
Cant do yet, need to wait for images
 */
package finalproject;

import java.awt.image.BufferedImage;

/**
 *
 * @author harja
 */
public class Particle extends GameObject {

    BufferedImage element;

    /**
     * 
     */
    public Particle() {
        element = null;
        direction = true;
    }
    /**
     * 
     * @param element
     * @param direction 
     */
    public Particle(BufferedImage element, boolean direction) {
        this.element = element;
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
     * @return 
     */
    public BufferedImage getElement(){
        return element;
    }
    /**
     * clone method to clone the particle
     * @return 
     */
    public Particle clone(){
        Particle newParticle = new Particle(element, direction);
        return newParticle;
    }
    /**
     * Accessor method to return all particle attributes and values
     * @return 
     */
    public String toString(){
        return "Element: " + element + "Direction: " + direction;
    }
}
