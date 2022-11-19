import javafx.scene.image.Image;
import java.util.ArrayList;

public class UnitClass {
    private String className;
    private String classDesc;
    private Image genericPortrait;
    private int[] growthRates = new int[8];

    //public Skill[] classSkills = new Skill[2];
    public ArrayList<Skill> classSkills = new ArrayList<Skill>();
    //wouldn't need to import arrayList if you coded this better 4head

    public Growths classGrowths;

    public UnitClass(){
        //comment
    }

    //TODO this shouldn't live here long, code is very WET and needs refactoring
    //also variable naming conventions are inconsistent with rest of project
    public UnitClass(String className, String classDesc){
        this.className = className;
        this.classDesc = classDesc;
    }

    public void addSkill(Skill skillName){
        classSkills.add(skillName);
    }

    public Growths getGrowths(){
        return new Growths(growthRates);
    }
}
