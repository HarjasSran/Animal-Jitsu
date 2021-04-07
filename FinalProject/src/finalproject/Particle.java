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

    String element;
    BufferedImage particle;

    final static int SNOW_ELEMENT = 0;
    final static int FIRE_ELEMENT = 1;
    final static int WATER_ELEMENT = 2;

    public Particle() {

    }

    public Particle(String element, boolean direction) {
        particle = createBufferedImage(element);
    }

    //setElement(Image element)
    //getElement()
    //clone()
    //toString()
}
