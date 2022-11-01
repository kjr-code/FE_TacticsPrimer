package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;

public class GameSelectController implements Initializable {
    
    @FXML
    private ChoiceBox<String> gameBox;

    @FXML
    private Button goButton;

    @FXML
    private ImageView menuLogo; 
    
    private String[] games = {"Fire Emblem: Fates", "Fire Emblem: Awakening", "Fire Emblem: Three Houses"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        gameBox.getItems().addAll(games);
        gameBox.setValue("Fire Emblem: Fates");
    }

    private void makeSelection(String selectedGame){
        //TODO passing in a String feels suboptimal here
        
    }
}
