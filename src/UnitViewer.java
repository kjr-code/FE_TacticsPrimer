import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class UnitViewer implements Initializable{
    public Character displayedCharacter;
    public ListView<String> charSelectListView;

    //TODO ascertain whether or not this is the only way to accomplish this
    @FXML private Label HPValue;
    @FXML private Label STRValue;
    @FXML private Label MAGValue;
    //@FXML private Label SKLValue;
    //@FXML private Label SPDValue;
    //@FXML private Label LCKValue;
    //@FXML private Label DEFValue;
    //@FXML private Label RESValue;
    
    @FXML private ImageView portraitView;
    @FXML private ImageView mapSpriteView;
    @FXML private ChoiceBox<String> thisUnitsClasses;
    @FXML private Label nameLabel;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        //TODO: setOnAction for dropdown list 
    }

    //TODO: cache whichCharacter.growths into a local variable since you access it so much
    public void setDisplayCharacter(Character whichCharacter){
        System.out.println(whichCharacter.name);
        //Extremely lazy (efficient?) casting from int to String
        HPValue.setText(""+whichCharacter.growths.HPGrowth);
        STRValue.setText(""+whichCharacter.growths.STRGrowth);
        MAGValue.setText(""+whichCharacter.growths.MAGGrowth);
        //SKLValue.setText(""+whichCharacter.growths.SKLGrowth);
        //SPDValue.setText(""+whichCharacter.growths.SPDGrowth);
        //LCKValue.setText(""+whichCharacter.growths.LCKGrowth);
        //DEFValue.setText(""+whichCharacter.growths.DEFGrowth);
        //RESValue.setText(""+whichCharacter.growths.RESGrowth);
        //TODO this can almost certainly be put in a loop

        portraitView.setImage(whichCharacter.getPortrait());
        mapSpriteView.setImage(whichCharacter.getMapSprite());

        //TODO address the type safety warning you generate here
        //thisUnitsClasses.setItems(FXCollections.observableArrayList(whichCharacter.availableClasses));
        thisUnitsClasses.setItems(FXCollections.observableArrayList(whichCharacter.classStringArray));
        //TODO set the selected option to, say, the first unitclass in this new list
        //thisUnitsClasses.getSelectionModel().select(FXCollections.observableArrayList(whichCharacter.availableClasses.get(0)));
        thisUnitsClasses.getSelectionModel().select(whichCharacter.classStringArray.get(0));

        //update weapon usage display ( may be included in the previous step )
        //update skills display
    }
    
}
