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
     * 
     * @param element 
     */
    public void setElement(BufferedImage element){
        this.element = element;
    }
    /**
     * 
     * @return 
     */
    public BufferedImage getElement(){
        return element;
    }
    /**
     * 
     * @return 
     */
    public Particle clone(){
        Particle newParticle = new Particle(element, direction);
        return newParticle;
    }
    /**
     * 
     * @return 
     */
    public String toString(){
        return "Element: " + element + "Direction: " + direction;
    }
}
