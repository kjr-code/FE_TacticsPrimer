import java.util.jar.Attributes.Name;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("Controllers/GameSelect.fxml"));
        Scene badTut = new Scene(root);
        primaryStage.setScene(badTut);
        primaryStage.setTitle("FE Tactics Primer v 0.01");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
