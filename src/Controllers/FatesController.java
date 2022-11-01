package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FatesController implements Initializable {

    @FXML
    private Button addUnitButton;

    @FXML
    private Label noneSelectedLabel;

    @FXML
    private VBox unitDataDisplay;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        //set all of the "unit slots" to disabled on initialize
        //re-init when they're enabled by the "add a unit" button
    }

    private void addUnit(){
        //bring up "add unit" menu in a seperate "box"
    }
    
}
