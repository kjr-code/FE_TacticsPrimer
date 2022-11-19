import java.io.File;
import java.net.URL;

import javafx.scene.image.Image;

public class Character {
    
    public String name;
    private Image portrait;
    private Image mapSprite;

    //TODO structs?
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
        //sheeeeeesh
        String temp = "Images/MapSprites/" + DataGrabber.mapSpritesHash.get(this.name).getName();
        Image cap = new Image(temp);
        return cap;
        //return this.mapSprite;
    }

    


    
}
