import java.util.ArrayList;

public class UnitClass {
    public String className;
    private String classDesc;
    private int[] growthRates = new int[8];
    public Growths classGrowths;
    //this code represents the same data unnecessarily

    public ArrayList<Skill> classSkills = new ArrayList<Skill>();

    public ArrayList<UnitClass> promotedClasses = new ArrayList<UnitClass>();
    //PromotedClasses can go into a "baseUnitClass" class whih extends UnitClass and has extra fields

    public UnitClass(String className, String classDesc){
        this.className = className;
        this.classDesc = classDesc;
    }

    public void addSkill(Skill skillName){
        classSkills.add(skillName);
    }

    //TODO potentially unnecessary method here
    public Growths getGrowths(){
        //return new Growths(growthRates);
        return classGrowths;
        //TODO boiiiiii
    }

    public void setGrowths(Growths growthsArg){
        classGrowths = growthsArg;
    }
}
