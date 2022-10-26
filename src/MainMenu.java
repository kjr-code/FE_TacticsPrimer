import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainMenu {
    //Menu items
    static VBox mainBox;

    static ChoiceBox<String> gameSelection;
    static Image logo;
    static ImageView logoView;
    static Button goButton;

    //menu variables
    static final int buttonSpacing = 20;

    public static void display(Stage theStage){
        //Layout
        mainBox = new VBox(buttonSpacing);

        logo = new Image("/brandOfExalt.png");
        logoView = new ImageView(logo); 
        logoView.setFitWidth(300);
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);
        logoView.setCache(true);
        //taken from the oracle docs but this honestly seems a bit excessive

        gameSelection = new ChoiceBox<String>();
        gameSelection.setMinWidth(150);
        gameSelection.getItems().addAll("Fates", "Awakening", "Three Houses");
        gameSelection.setValue("Select your game...");

        goButton = new Button("Go");
        goButton.setMinWidth(150);
        //TODO gotta be a better way to make the widths of these menu items uniform
        
        mainBox.getChildren().addAll(logoView, gameSelection, goButton);
        mainBox.setAlignment(Pos.CENTER);
        
        Scene menuScene = new Scene(mainBox, 800, 600);
        theStage.setScene(menuScene);


        
    }
}
