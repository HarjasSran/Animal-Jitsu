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
    
    /**
     * Default User constructor
     */
    public User(){
        name = "";
        rank = 0;
        bow = Color.WHITE;
        date = "Jan 01 2000";
        animal = "DUCK";
    }
    
    /**
     * Second constructor for user 
     * @param name - name of the user
     * @param rank - rank of the user
     * @param bow - color of the user's bow
     * @param date - date user was created
     * @param animal - animal which user used
     */
    public User(String name, int rank, Color bow, String date, String animal){
        this.name = name;
        this.rank = rank;
        this.bow = bow;
        this.date = date;
        this.animal = animal;
    }
    
    /**
     * Mutator method to set the name of the user
     * @param name - name of the user
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Accessor method for name 
     * @return - name of the user
     */
    public String getName(){
        return name;
    }
    
    /**
     * Mutator method to set the rank of the user
     * @param rank - rank of the user
     */
    public void setRank(int rank){
        this.rank = rank;
    }
    /**
     * Accessor method for the user's rank
     * @return - rank of the user
     */
    public int getRank(){
        return rank;
    } 
    
    /**
     * Mutator method to set the color of the user's bow
     * @param bow - color of the user's bow
     */
    public void setBow(Color bow){
        this.bow = bow;
    }
    /**
     * Accessor method for color of bow
     * @return - color of user's bow
     */
    public Color getBow(){
        return bow;
    }
    
    /**
     * Mutator method to set the date the user was created
     * @param date - date the user was created
     */
    public void setDate(String date){
        this.date = date;
    }
    /**
     * Accessor method for date user was created
     * @return - the date user was created
     */
    public String getDate(){
        return date;
    }
    
    /**
     * Mutator method to set the animal which the user is using
     * @param animal - animal that the user is using
     */
    public void setAnimal(String animal){
        this.animal = animal;
    }
    /**
     * Accessor method for animal that user is using
     * @return - animal that the user is using
     */
    public String getAnimal(){
        return animal;
    }
    
    /**
     * Cloning method to clone the User 
     * @return - new cloned user
     */
    public User clone(){
        User newUser = new User(name, rank, bow, date, animal); //Create new user with the exact same attributes and values as the other user
        return newUser;
    }
    
    /**
     * Accessor method for all attributes and values of the User
     * @return - all attributes and values of the user
     */
    public String toString(){
        return "Name: " + name + "\tRank: " + rank + "\tBow Color: " + bow + "\tDate: " + date + "\tAnimal: " + animal;
    }
}
