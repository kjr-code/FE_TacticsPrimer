import java.io.File;
import java.net.URL;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
//gross

import javafx.scene.image.Image;

public class Character {
    
    public String name;
    private Image portrait;
    private Image mapSprite;
    public ArrayList<UnitClass> availableClasses = new ArrayList<UnitClass>();
    public ArrayList<String> classStringArray = new ArrayList<String>();

    //TODO: growth rates and stat spreads can be represented as a single "stats" object;
    //TODO: context would determine whether the int[] was a stat Spread, set of growths, or set of bonuses
    //TODO: this would eliminate the need for multiple different classes 
    public int[] bases = new int[8];

    public int[] baseGrowthData = new int[8];
    public Growths growths;

    public Character(String[] charData){
        this.name = charData[0];
        //System.out.println("charData.length = "+charData.length);
        for(int i = 1; i < charData.length; i++){
            baseGrowthData[i-1] = Integer.parseInt(charData[i]);
        }
        growths = new Growths(baseGrowthData);
    }

    public Image getMapSprite(){
        //TODO accessing the file tree every time is probably quite slow; this code can/should live somewhere else
        String temp = "Images/MapSpritesFixed/" + DataGrabber.mapSpritesHash.get(this.name).getName();
        Image cap = new Image(temp);
        return cap;
        //return this.mapSprite;
    }

    //TODO DBMS implementation eliminates need for this method, among others
    public void acquireClass(String whichClass){
        availableClasses.add(DataGrabber.classHash.get(whichClass));
        classStringArray.add(DataGrabber.classHash.get(whichClass).className);
    }

    


    
}
