import java.util.ArrayList;

public class UnitClass {
    public String className;
    private String classDesc;
    public Growths classGrowths;

    public ArrayList<Skill> classSkills = new ArrayList<Skill>();
    public ArrayList<UnitClass> promotedClasses = new ArrayList<UnitClass>();

    public UnitClass(String className, String classDesc){
        this.className = className;
        this.classDesc = classDesc;
    }

    public void addSkill(Skill skillName){
        classSkills.add(skillName);
    }

    //TODO potentially unnecessary method here
    public Growths getGrowths(){
        return classGrowths;
    }

    public void setGrowths(Growths growthsArg){
        classGrowths = growthsArg;
    }
}
