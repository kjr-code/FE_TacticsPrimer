import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class UnitViewer implements Initializable{
    public Character displayedCharacter;
    public UnitClass displayedClass;

    //public ListView<String> charSelectListView;

    //TODO ascertain whether or not this is the only way to accomplish this
    @FXML private Label HPValue;
    @FXML private Label STRValue;
    @FXML private Label MAGValue;
    
    @FXML private ImageView portraitView;
    @FXML private ImageView mapSpriteView;
    //TODO: update this variable name to something that denotes that it's specifically the choicebox and not the
    //underlying list of UnitClasses
    @FXML private ChoiceBox<String> thisUnitsClasses;
    @FXML private Label nameLabel;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        //System.out.println("Calling initialize!");
        displayedCharacter = DB.characters.get("Xander");
        UnitClass initialClass = displayedCharacter.availableClasses.get(0);
        displayedClass = initialClass;
        setDisplayCharacter(displayedCharacter);
        thisUnitsClasses.setOnAction(e -> changeCurrentClass(DB.grabClass(thisUnitsClasses.getValue())));
    }

    public void setDisplayCharacter(Character whichCharacter){
        //System.out.println("Now viewing: "+whichCharacter.name);
        displayedCharacter = whichCharacter;

        //update character specific elements: name, portraits, class selection
        portraitView.setImage(whichCharacter.getPortrait());
        mapSpriteView.setImage(whichCharacter.getMapSprite());
        nameLabel.setText(whichCharacter.name);



        //TODO: probably turn this into a for each loop, which will eliminate the need for the "classStringArray"
        //TODO: or, potentially even better, write a static method that takes in an arraylist of classes as input
        //TODO: and adds the String returned by "getName" into a seperate observable list
        thisUnitsClasses.getItems().addAll(whichCharacter.classStringArray);
        displayedClass = whichCharacter.availableClasses.get(0);
        //nullpointerexception found here, something to do with current class.classname being null
        thisUnitsClasses.getSelectionModel().select(displayedClass.className);
        changeCurrentClass(displayedClass);
    }

    public void changeCurrentClass(UnitClass newClass){
        //TODO: change displayed skills
        displayedClass = newClass;
        int displayedHP = displayedCharacter.growths.HPGrowth + newClass.getGrowths().HPGrowth;
        int displayedSTR = displayedCharacter.growths.STRGrowth + newClass.getGrowths().STRGrowth;
        int displayedMAG = displayedCharacter.growths.MAGGrowth + newClass.getGrowths().MAGGrowth;

        HPValue.setText(""+displayedHP);
        STRValue.setText(""+displayedSTR);
        MAGValue.setText(""+displayedMAG);
        thisUnitsClasses.getSelectionModel().select(displayedClass.className);
    }

    //TODO: figure out exactly how to merge this method with the above method
    //TODO: will likely involve making "changeCurrentClass" not take in an argument, and instead just
    //take its values from "displayChar/displayClass", which would get updated by the event trigger (?)
    public void updateClass(ActionEvent event){
        //String prevValue = currentClass.className;
        String argClassName = thisUnitsClasses.getValue();
        UnitClass argClass = DB.grabClass(argClassName);
        if(argClass != null){
            changeCurrentClass(argClass);
        }
    }
    
}
