/*

 */
package finalproject;

/**
 *
 * @author harja
 */
public class Player extends Character{
    String name;
    int rank;
    
    public Player(){
        name = "";
        rank = 0;
    }
    
    //public Player(String name, Color bow, Image animal, boolean direction, ArrayList cards){
        
    //}
    
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
    
    public Player clone(){
        Player newPlayer = new Player(); //After adding second constructor, use that
        return newPlayer;
    }
    
    public String toString(){
        return name + "\t" + rank;
    }
}
