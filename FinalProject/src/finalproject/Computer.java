/*

 */
package finalproject;

/**
 *
 * @author harja
 */
public class Computer extends Character{
    int skillLevel;
    
    /**
     * Default constructor
     */
    public Computer(){
        skillLevel = 0;
    }
    
    /**
     * Second constructor
     * @param skillLevel 
     */
    public Computer(int skillLevel){
        this.skillLevel = skillLevel;
    }
    
    /**
     * Mutator method to set the skill level of the computer sensei
     * @param skillLevel - skill level of the sensei
     */
    public void setSkillLevel(int skillLevel){
        this.skillLevel = skillLevel;
    }
    /**
     * Accessor method for the skill level
     * @return - skill level of the computer sensei
     */
    public int getSkillLevel(){
        return skillLevel;
    }
    
    /**
     * Cloning method to make a clone of the current computer sensei
     * @return the cloned computer 
     */
    public Computer clone(){
        Computer newComp = new Computer(skillLevel); //new copy of the computer sensei is created 
        return newComp;
    }
    
    /**
     * Accessor method for all attributes and values of the computer sensei
     * @return - all attributes and values of the computer sensei
     */
    public String toString(){
        return String.valueOf(skillLevel);
    }
}
