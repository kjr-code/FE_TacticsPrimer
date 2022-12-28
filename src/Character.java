import java.io.File;
import java.net.URL;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Character {
    
    public File portraitFile;
    public File mapSpriteFile;
    public String name;
    private Image portrait;
    private Image mapSprite;
    public ArrayList<UnitClass> availableClasses = new ArrayList<UnitClass>();
    public ArrayList<String> classStringArray = new ArrayList<String>();

    //refactor fields//
    public ArrayList<UnitClass> unitClasses = new ArrayList<UnitClass>();
    public char[] usableWeapons = {0,0,0,0,0,0,0,0};
    public Character[] partners;
    public Character[] buddies;
    //SWORDS,LANCES,AXES,DAGGERS,BOWS, TOMES, STAVES, STONES

    public Growths growths;
    public ClassGroup classes;

    public Character(String[] charData){
        this.name = charData[0];
        int[] growthData = new int[8];
        for(int i = 1; i < charData.length; i++){
            growthData[i-1] = Integer.parseInt(charData[i]);
        }
        growths = new Growths(growthData);
        classes = new ClassGroup(); 
    }

    public Image getMapSprite(){
        String temp = "Images/MapSpritesFixed/"+this.name+".png";
        Image cap = new Image(temp);
        return cap;
    }

    //TODO DBMS implementation eliminates need for this method, among others
    public void acquireClass(String whichClass){
        availableClasses.add(DataGrabber.classHash.get(whichClass));
        classStringArray.add(DataGrabber.classHash.get(whichClass).className);
    }

    public void obtainClass(String whichClass){
        availableClasses.add(DB.grabClass(whichClass));
        classStringArray.add(DB.grabClass(whichClass).className);
    }

    public void obtainPromotedClass(String whichClass){
        availableClasses.add(DB.promotedClasses.get(whichClass));
        classStringArray.add(DB.promotedClasses.get(whichClass).className);
    }

    //Takes in a base class (or a string naming one) as an arg and checks "classTrees" for the remaining classes
    public void addClassLine(String whichClass){
        availableClasses.add(DB.baseClasses.get(whichClass));
        if(DB.baseClasses.get(whichClass).promotedClasses.size() != 0){
            for(UnitClass promotedClass : DB.baseClasses.get(whichClass).promotedClasses){
                availableClasses.add(promotedClass);
            }
        }
    }

    public Image getPortrait(){
        String temp = "Images/Portraits/"+this.name+".png";
        Image cap = new Image(temp);
        return cap;
    }

    public ArrayList<Skill> getPossibleSkills(){
        ArrayList<Skill> possibleSkills = new ArrayList<Skill>();
        for(UnitClass thisClass : classes.getList()){
            for(Skill thisSkill : thisClass.classSkills){
                possibleSkills.add(thisSkill);
            }
        }
        return possibleSkills;
        //TODO: you're going to need a skillsgroup class as well, that populates the list based on the params
        //in the displayed character. 

        //will need to add friendship/partner support pairings first before implementing this (to prevent more work later)
    }

    public ArrayList<Skill> getPossibleSkills(boolean test){
        if(test == false){
            System.out.println("Not running the test method I see?");
            return null;
        } else {
            ArrayList<Skill> possibleSkills = new ArrayList<Skill>();
            for(UnitClass thisClass : availableClasses){
                for(Skill thisSkill : thisClass.classSkills){
                    possibleSkills.add(thisSkill);
                }
            }
            return possibleSkills;
        }
    }

    public void setMapSpriteFile(File aFile){
        //TODO: figure out why the program breaks without the existence of this literally empty method
    }
      
}
