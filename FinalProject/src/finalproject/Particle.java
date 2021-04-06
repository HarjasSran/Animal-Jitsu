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
    
    public Particle(){
        
    }
    
    public Particle(String element, boolean direction){
        particle = createBufferedImage(element);
    }
    
    //setElement(Image element)
    
    //getElement()
    
   
    
    //clone()
    
    //toString()
}
