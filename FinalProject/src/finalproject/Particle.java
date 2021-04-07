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


    public Particle() {
        element = null;
        direction = true;
    }

    public Particle(BufferedImage element, boolean direction) {
        this.element = element;
        this.direction = direction;
    }

    public void setElement(BufferedImage element){
        this.element = element;
    }
    public BufferedImage getElement(){
        return element;
    }
    public Particle clone(){
        Particle newParticle = new Particle(element, direction);
        return newParticle;
    }
    public String toString(){
        return "Element: " + element + "Direction: " + direction;
    }
}
