/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author carolinewiddecombe
 */
public class Highscores {

    /**
     * @param args the command line arguments
     */
    
//       static ArrayList<String> list = new ArrayList();
//       
//    public static void readData(String src){
//        
//       
//        
//         File f = new File(src); 
//     
//        try {
//            Scanner s = new Scanner(f); //if file is not found
//            
//            while (s.hasNextLine()){
//                String newData[] = new String[2];
//                newData[0] = (s.nextLine());
//                newData[1] = (s.nextLine());
//                
//                
//            }
//
//            //descendingQuickSort(level, 5, 4);
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        list.add(data[0]);
////        list.add(data[1]);
//        
//    }
//    
//    
//    public static void writeData(String src, String[] data){
//        
//        
//       
//        
//         try {
//            FileWriter myWriter = new FileWriter(src);
//            for (int i = 0; i < data.length; i++) {
//                myWriter.write(data[i]+"\n");
//            }
//            myWriter.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Error:" + e);
//        } catch (IOException ex) {
//            Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    
    
    
    /**
     * caroline
7
caroline
7
sam
6
sam
5
john
2
john
2
john
2
john
2
     * @param args 
     */
    
    
    
    
    public static ArrayList readData(String src){
        
        File f = new File(src);
        ArrayList <String> list =new ArrayList(); 
         try {
            Scanner s = new Scanner(f); //if file is not found
            
            while (s.hasNextLine()){
                String newData[] = new String[2];
                newData[0] = (s.nextLine());
                newData[1] = (s.nextLine());
                list.add(newData[0]);
                list.add(newData[1]);
                
            }

            //descendingQuickSort(level, 5, 4);

        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "The following error occured:\n"  + ex); 
        }
//        list.add(data[0]);
//        list.add(data[1]);
        return list; 
    }
    
    
    
    
    public static void writeData(ArrayList<String> list, String src){
         try {
            FileWriter myWriter = new FileWriter(src);
            for (int i = 0; i < list.size(); i++) {
                myWriter.write(list.get(i)+"\n");
            }
            myWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error:" + e);
        } catch (IOException ex) {
           // Logger.getLogger(Highscores.class.getName()).log(Level.SEVERE, null, ex);
            
            
            JOptionPane.showMessageDialog(null, "The following error occured:\n"  + ex); 
        }
        
    }
    
    
 

    
    
    
}
