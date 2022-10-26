import java.util.jar.Attributes.Name;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;


public class App extends Application{

    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("Resources/GameSelect.fxml"));
        Scene badTut = new Scene(root);
        primaryStage.setScene(badTut);
        primaryStage.setTitle("FE Tactics Primer v 0.01");
        //MainMenu.display(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
