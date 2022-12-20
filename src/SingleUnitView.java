import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SingleUnitView implements Initializable{
    //Underlying model
    private Character displayedCharacter;
    private UnitClass displayedClass;
    private ArrayList<UnitClass> displayedAvailableClasses;
    //underlying model

    @FXML private Label charNameLabel;
    @FXML private ImageView portraitView;
    @FXML private ChoiceBox<String> classChoiceBox;

    @FXML private Label charHP;
    @FXML private Label charSTR;
    @FXML private Label charMAG;
    @FXML private Label charSKL;
    @FXML private Label charSPD;
    @FXML private Label charLCK;
    @FXML private Label charDEF;
    @FXML private Label charRES;

    @FXML private Label classHP;
    @FXML private Label classSTR;
    @FXML private Label classMAG;
    @FXML private Label classSKL;
    @FXML private Label classSPD;
    @FXML private Label classLCK;
    @FXML private Label classDEF;
    @FXML private Label classRES;

    @FXML private Label effHP;
    @FXML private Label effSTR;
    @FXML private Label effMAG;
    @FXML private Label effSKL;
    @FXML private Label effSPD;
    @FXML private Label effLCK;
    @FXML private Label effDEF;
    @FXML private Label effRES;

    @FXML private Button changeCharacterButton;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        //changeCharacterButton.setOnAction(null);
        changeCharacter(DB.characters.get("Azura"));
        classChoiceBox.setOnAction(e -> changeClass(DB.grabClass(classChoiceBox.getValue())));
    }

    public void changeCharacter(Character newCharacter){
        displayedCharacter = newCharacter;
        charNameLabel.setText(displayedCharacter.name);
        portraitView.setImage(displayedCharacter.getPortrait());
        displayedAvailableClasses = displayedCharacter.availableClasses;
        classChoiceBox.getItems().addAll(displayedCharacter.classStringArray);
        classChoiceBox.getSelectionModel().select(displayedCharacter.classStringArray.get(0));

        //set charGrowthText
        charHP.setText(""+displayedCharacter.growths.HPGrowth);
        charSTR.setText(""+displayedCharacter.growths.STRGrowth);
        charMAG.setText(""+displayedCharacter.growths.MAGGrowth);
        charSKL.setText(""+displayedCharacter.growths.SKLGrowth);
        charSPD.setText(""+displayedCharacter.growths.SPDGrowth);
        charLCK.setText(""+displayedCharacter.growths.LCKGrowth);
        charDEF.setText(""+displayedCharacter.growths.DEFGrowth);
        charRES.setText(""+displayedCharacter.growths.RESGrowth);
        //end set charGrowthText
        
        UnitClass newClass = DB.grabClass(classChoiceBox.getValue());
        //TODO make a "classList" class that simplifies this bit of code here
        changeClass(newClass);
    }

    public void changeClass(UnitClass newClass){
        displayedClass = newClass;
        //TODO dry code is dry and bad
        classHP.setText(""+newClass.getGrowths().HPGrowth);
        classSTR.setText(""+newClass.getGrowths().STRGrowth);
        classMAG.setText(""+newClass.getGrowths().MAGGrowth);
        classSKL.setText(""+newClass.getGrowths().SKLGrowth);
        classSPD.setText(""+newClass.getGrowths().SPDGrowth);
        classLCK.setText(""+newClass.getGrowths().LCKGrowth);
        classDEF.setText(""+newClass.getGrowths().DEFGrowth);
        classRES.setText(""+newClass.getGrowths().RESGrowth);

        //TODO this needs to be placed into a loop
        effHP.setText(""+(displayedCharacter.growths.HPGrowth + newClass.getGrowths().HPGrowth));
        effSTR.setText(""+(displayedCharacter.growths.STRGrowth + newClass.getGrowths().STRGrowth));
        effMAG.setText(""+(displayedCharacter.growths.MAGGrowth + newClass.getGrowths().MAGGrowth));
        effSKL.setText(""+(displayedCharacter.growths.SKLGrowth + newClass.getGrowths().SKLGrowth));
        effSPD.setText(""+(displayedCharacter.growths.SPDGrowth + newClass.getGrowths().SPDGrowth));
        effLCK.setText(""+(displayedCharacter.growths.LCKGrowth + newClass.getGrowths().LCKGrowth));
        effDEF.setText(""+(displayedCharacter.growths.DEFGrowth + newClass.getGrowths().DEFGrowth));
        effRES.setText(""+(displayedCharacter.growths.RESGrowth + newClass.getGrowths().RESGrowth));
            //TODO: "updating growths" may end up in a method of its own
        //update skills
        //update weapons
        classChoiceBox.getSelectionModel().select(newClass.className);
    }
    

     
}
