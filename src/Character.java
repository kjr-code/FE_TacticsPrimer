import java.io.File;
import java.net.URL;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
//gross
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

    //TODO: growth rates and stat spreads can be represented as a single "stats" object;
    //TODO: context would determine whether the int[] was a stat Spread, set of growths, or set of bonuses
    //TODO: this would eliminate the need for multiple different classes 
    
    public Growths growths;

    //Char name and growths passed in as args, values retrieved from a String[]
    //TODO: add format checking here, i.e. make sure the array passed in is the right size and type
    //TODO: throw an exception if invalid type, for example
    public Character(String[] charData){
        this.name = charData[0];
        int[] growthData = new int[8];
        for(int i = 1; i < charData.length; i++){
            growthData[i-1] = Integer.parseInt(charData[i]);
        }
        growths = new Growths(growthData);
    }

    public Image getMapSprite(){
        //TODO accessing the file tree every time is probably quite slow; this code can/should live somewhere else
        //String temp = "Images/MapSpritesFixed/" + DataGrabber.mapSpritesHash.get(this.name).getName();
        String temp = "Images/MapSpritesFixed/"+this.name+".png";
        Image cap = new Image(temp);
        return cap;
    }

    //TODO DBMS implementation eliminates need for this method, among others
    public void acquireClass(String whichClass){
        availableClasses.add(DataGrabber.classHash.get(whichClass));
        classStringArray.add(DataGrabber.classHash.get(whichClass).className);
    }

    //TODO: following 2 methods are extremely wet and need revision
    public void obtainClass(String whichClass){
        availableClasses.add(DB.baseClasses.get(whichClass));
        classStringArray.add(DB.baseClasses.get(whichClass).className);
    }

    public void obtainPromotedClass(String whichClass){
        availableClasses.add(DB.promotedClasses.get(whichClass));
        classStringArray.add(DB.promotedClasses.get(whichClass).className);
    }

    //Takes in a base class (or a string naming one) as an arg and checks "classTrees" for the remaining classes
    public void addClassLine(String whichClass){
        availableClasses.add(DB.baseClasses.get(whichClass));
        //TODO: just cache these values, you don't have to keep hurting yourself :(
        if(DB.baseClasses.get(whichClass).promotedClasses.size() != 0){
            for(UnitClass promotedClass : DB.baseClasses.get(whichClass).promotedClasses){
                availableClasses.add(promotedClass);
            }
        }
    }

    public Image getPortrait(){
        //String temp = "Images/Portraits/" + DataGrabber..get(this.name).getName();
        String temp = "Images/Portraits/"+this.name+".png";
        Image cap = new Image(temp);
        return cap;
        //return portrait;
    }

    public void setMapSpriteFile(File aFile){

    }
      
}
