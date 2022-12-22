import java.util.ArrayList;

public class ClassGroup {
    
    private ArrayList<UnitClass> classesInternal = new ArrayList<UnitClass>();

    public ClassGroup(){

    }

    public ArrayList<String> classNames(){
        ArrayList<String> returnVal = new ArrayList<String>();
        for(int i = 0; i < classesInternal.size(); i++){
            returnVal.add(classesInternal.get(i).className);
        }
        return returnVal;
    }

    public void addClass(UnitClass whichClass){
        classesInternal.add(whichClass);
    }

    public void addClass(String whichClass){
        classesInternal.add(DB.grabClass(whichClass));
    }
}
