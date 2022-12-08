import java.util.ArrayList;

public class BaseClass extends UnitClass {

    public ArrayList<UnitClass> promotedClasses = new ArrayList<UnitClass>();
    //TODO you'll prolly want to come back to this later
    public BaseClass(String className, String classDesc){
        super(className, classDesc);
    }

    public void addPromotedClass(String whatClass){
        promotedClasses.add(DB.promotedClasses.get(whatClass));
    }
    
}
