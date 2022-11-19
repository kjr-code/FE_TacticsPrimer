

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;

public class GameSelectController implements Initializable {
    
    @FXML
    private ChoiceBox<String> gameBox;

    @FXML
    private Button goButton;

    @FXML
    private ImageView menuLogo; 
    
    private String[] games = {"Fire Emblem: Fates"};
    private Stage mStage;
    private Scene mScene;
    private Parent mRoot;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        gameBox.getItems().addAll(games);
        gameBox.setValue("Fire Emblem: Fates");
        goButton.setOnAction(arg01 -> {
            try {
                makeSelection(arg01);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        
    }

    public void makeSelection(ActionEvent event) throws IOException{
        //String selectedGame = gameBox.getValue();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/unitDataCard.fxml"));
        mRoot = loader.load();
        UnitDataCardController nextSceneController = loader.getController();
        //nextSceneController.setDefaultCharacter();
        DataGrabber.getData();
        nextSceneController.setDefaultCharacter("Silas");
        System.out.println("DATA GRABBER GET DATA MAKE SELECTION GAMESELECTCONTROLLER");
        mStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mScene = new Scene(mRoot);
        mStage.setScene(mScene);
        mStage.show();
        mStage.centerOnScreen();
        //communicate between scenes, set the default char
    }
}
