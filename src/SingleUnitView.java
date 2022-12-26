import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.io.File;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SingleUnitView implements Initializable{
    //Underlying model
    private Character displayedCharacter;
    private UnitClass displayedClass;
    private ArrayList<UnitClass> displayedAvailableClasses;
    private ArrayList<Skill> displayedAvailableSkills;
    //underlying model

    @FXML private Label charNameLabel;
    @FXML private ImageView portraitView;
    @FXML private ChoiceBox<String> classChoiceBox;
    @FXML private ListView<String> skillsListView;

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
        changeCharacterButton.setOnAction(e -> pickNewCharacter());
        setCharacter(DB.characters.get("Silas"));
        classChoiceBox.setOnAction(e -> changeClass(DB.grabClass(classChoiceBox.getValue())));
    }

    public void setCharacter(Character newCharacter){
        if(displayedCharacter != null){
            Character oldChar = displayedCharacter;
            classChoiceBox.getItems().removeAll(oldChar.classStringArray);
        }
        displayedCharacter = newCharacter;
        charNameLabel.setText(displayedCharacter.name);
        portraitView.setImage(displayedCharacter.getPortrait());
        displayedAvailableClasses = displayedCharacter.availableClasses;

        //TODO it only works without throwing a nullPointer exception when it's done specifically this way
        //I do not yet understand why
        classChoiceBox.getItems().addAll(displayedCharacter.classStringArray);
        //classChoiceBox.getItems().setAll(FXCollections.observableArrayList(displayedCharacter.classStringArray));
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

        //TODO use your "ClassGroup" class to simplify this code
        updateSkillsView();
        UnitClass newClass = DB.grabClass(classChoiceBox.getValue());
        changeClass(newClass);
    }

    public void changeClass(UnitClass newClass){
        if(newClass == null){
            return;
            //TODO hooooo buddy this solution feels extremely sketchy and may come back to bite you later
        }
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
        //update skills
        //update weapons
        classChoiceBox.getSelectionModel().select(newClass.className);
    }

    //TODO: error is thrown when the new character has the same base class as the current one
    //TODO: code says it's a null ptr error and that it can't grab the "null" class from any of the hashes
    //TODO: this does not happen when swapping to a unit with different classes.
    private void pickNewCharacter(){
        TextInputDialog promptUser = new TextInputDialog();
        promptUser.setTitle("FE Tactics Primer");
        promptUser.setHeaderText("Display which character?");
        ImageView iconView = new ImageView();
        iconView.setImage(new Image("Images/Portraits/AnnaTrickster.png"));
        iconView.setFitHeight(100);
        iconView.setPreserveRatio(true);
        promptUser.setGraphic(iconView);

        Optional<String> result = promptUser.showAndWait();
        if(result.isPresent()){
            Character newChar = DB.characters.get(result.get());
            setCharacter(newChar);
        }
    }

    private void updateSkillsView(){
        //TODO "skillNames" will likely be replaced with an arraylist of custom "Skill" controls
        //once you learn how to do that
        displayedAvailableSkills = displayedCharacter.getPossibleSkills();
        System.out.println("Am I even running?");
        ArrayList<String> skillNames = new ArrayList<String>();
        for(Skill thisSkill : displayedAvailableSkills){
            skillNames.add(thisSkill.getName());
            System.out.println("Adding available skill: "+thisSkill.getName());
        }
        skillsListView.getItems().addAll(skillNames);
    }
    

     
}
