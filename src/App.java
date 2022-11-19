import java.util.jar.Attributes.Name;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("Controllers/GameSelect.fxml"));
        Scene scene = new Scene(root);
        //TODO :T
        //badTut.getStylesheets().add(getClass().getResource("flatStyles.css").toExternalForm());
        String css = this.getClass().getResource("flatStyles.css").toExternalForm();
        primaryStage.setScene(scene);
        scene.getStylesheets().add(css);
        primaryStage.setTitle("FE Tactics Primer v 0.01");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
