//Caroline Widdecombe, Aidan Goodyr, Harjas Sran
//April 10 2021
//
package finalproject;



/**
 *
 * @author harja
 */
public class User {
    String name;
    int rank;
    
    /**
     * Default User constructor
     */
    public User(){
        name = "";
        rank = 0;

    }
    
    /**
     * Second constructor for user 
     * @param name - name of the user
     * @param rank - rank of the user
     * @param bow - color of the user's bow
     * @param date - date user was created
     * @param animal - animal which user used
     */
    public User(String name, int rank){
        this.name = name;
        this.rank = rank;

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
     * Cloning method to clone the User 
     * @return - new cloned user
     */
    public User clone(){
        User newUser = new User(name, rank); //Create new user with the exact same attributes and values as the other user
        return newUser;
    }
    
    /**
     * Accessor method for all attributes and values of the User
     * @return - all attributes and values of the user
     */
    public String toString(){
        return "Name: " + name + "\tRank: " + rank;
    }
}
