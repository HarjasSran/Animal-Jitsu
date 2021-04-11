//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//
package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
    
    
    
    /**
     * method that reads data from the file
     * @param src
     * @return 
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
    
    
    
    /**
     * metod that writes data to the file
     * @param list
     * @param src 
     */
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
    
    
    /**
     * method for descending quicksort
     * @param numbers
     * @param l
     * @param r 
     */
   public static void descendingQuickSort(int[] numbers, int l, int r) {

        // sort is complete when the left bounds of the array are equal or greater than the right bound
        if (l >= r) {

            return;

        }

        int left = l;
        int right = r;

        //pivot at the midpoint between left and right boundary, partitioning two side of array
        int pivot = numbers[(l + r) / 2];

        //repeat until the left and the right touch
        while (left < right) {

            //increment left until it finds a value less than the pivot (flipped operator from ascending) 
            while (numbers[left] > pivot) {
              
                left++;
            }

            //decrement the right until it finds a value greater than pivot (flipped operator from ascending) 
            while (numbers[right] < pivot) {
                
                right--;

            }

            if (left <= right) {
                //swap the number at the left and right iterators
                int temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
                left++;
                right--;

            }

        }

        //quicksort both partitions of the array
        descendingQuickSort(numbers, l, right);
        descendingQuickSort(numbers, left, r);

    }
    
    
 

    
    
    
}
