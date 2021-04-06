/*

 */
package finalproject;

import java.awt.Color;

/**
 *
 * @author harja
 */
public class User {
    String name;
    int rank;
    Color bow;
    String date;
    String animal;
    
    public User(){
        name = "";
        rank = 0;
        bow = Color.WHITE;
        date = "Jan 01 2000";
        animal = "DUCK";
    }
    
    public User(String name, int rank, Color bow, String date, String animal){
        this.name = name;
        this.rank = rank;
        this.bow = bow;
        this.date = date;
        this.animal = animal;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setRank(int rank){
        this.rank = rank;
    }
    public int getRank(){
        return rank;
    } 
    
    public void setBow(Color bow){
        this.bow = bow;
    }
    public Color getBow(){
        return bow;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
    
    public void setAnimal(String animal){
        this.animal = animal;
    }
    public String getAnimal(){
        return animal;
    }
}
