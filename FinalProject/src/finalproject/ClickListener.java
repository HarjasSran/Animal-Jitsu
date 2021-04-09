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

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());
    }
    
}
