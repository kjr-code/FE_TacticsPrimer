//import javafx.scene.image.Image;

public class Character {
    
    private String name;
    //private Image portrait;

    //TODO structs?
    public int[] bases;
    public int[] baseGrowths = new int[8];

    public Character(String[] charData){
        this.name = charData[0];
        for(int i = 1; i < charData.length; i++){
            baseGrowths[i-1] = Integer.parseInt(charData[i]);
        }
    }

    


    
}
