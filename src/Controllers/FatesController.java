package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FatesController implements Initializable {

    @FXML
    private Button addUnitButton;

    @FXML
    private Label noneSelectedLabel;

    @FXML
    private VBox unitDataDisplay;

    @FXML
    private HBox[] singleUnitDisplays;

    private int numActive = 0;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        //TODO will need to put "database" files in different package/directory.
        for(int i = 0; i < singleUnitDisplays.length; i++){
            singleUnitDisplays[i].setVisible(false);
            singleUnitDisplays[i].setManaged(false);
        }
    }

    private void addUnit(){
        //bring up "add unit" menu in a seperate "box"
        noneSelectedLabel.setText("Add another! :D");
        if(numActive <= singleUnitDisplays.length){
            singleUnitDisplays[numActive].setManaged(true);
            singleUnitDisplays[numActive].setVisible(true);
            numActive++;
        } else {
            noneSelectedLabel.setText("Bro stop adding units! >:(");
        }
    }
    
}
