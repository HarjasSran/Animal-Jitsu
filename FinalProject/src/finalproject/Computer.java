/*

 */
package finalproject;

/**
 *
 * @author harja
 */
public class Computer {
    int skillLevel;
    
    public Computer(){
        skillLevel = 0;
    }
    
    public Computer(int skillLevel){
        this.skillLevel = skillLevel;
    }
    
    public void setSkillLevel(int skillLevel){
        this.skillLevel = skillLevel;
    }
    public int getSkillLevel(){
        return skillLevel;
    }
    
    public Computer clone(){
        Computer newComp = new Computer(skillLevel);
        return newComp;
    }
    
    public String toString(){
        return String.valueOf(skillLevel);
    }
}
