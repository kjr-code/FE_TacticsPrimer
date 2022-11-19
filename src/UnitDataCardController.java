

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UnitDataCardController implements Initializable {

    @FXML private ImageView mapSpriteView;
    @FXML private TableView<Growths> statsTable;
    @FXML private ChoiceBox testUnitChooser;

    //There HAS to be a better way to do this, JavaFX :T
    @FXML private TableColumn<Growths, Integer> hpColumn;
    @FXML private TableColumn<Growths, Integer> strColumn;
    @FXML private TableColumn<Growths, Integer> magColumn;
    @FXML private TableColumn<Growths, Integer> sklColumn;
    @FXML private TableColumn<Growths, Integer> spdColumn;
    @FXML private TableColumn<Growths, Integer> lckColumn;
    @FXML private TableColumn<Growths, Integer> defColumn;
    @FXML private TableColumn<Growths, Integer> resColumn;
    @FXML private TableColumn<Growths, Integer> movColumn;
    //...


    public TableColumn<Growths, Integer>[] statColumns;
    private Character currentChar;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        String css = this.getClass().getResource("flatStyles.css").toExternalForm();
    }

    public void setDefaultCharacter(String charName){
        Character defaultChar = DataGrabber.charHM.get(charName);
        mapSpriteView.setImage(defaultChar.getMapSprite());
        //TODO update available classes in the choicebox next to the sprite 
        updateGrowths(charName);
    }

    public void updateGrowths(String charName){
    currentChar = DataGrabber.charHM.get(charName);
    ObservableList<Growths> singleUnit = FXCollections.observableArrayList(
        currentChar.growths
    );
    statsTable.setItems(singleUnit);
    System.out.println("I just grabbed "+currentChar.name);
        hpColumn.setCellValueFactory(new PropertyValueFactory<Growths, Integer>("HPGrowth"));
        strColumn.setCellValueFactory(new PropertyValueFactory<Growths, Integer>("STRGrowth"));
        magColumn.setCellValueFactory(new PropertyValueFactory<Growths, Integer>("MAGGrowth"));
        sklColumn.setCellValueFactory(new PropertyValueFactory<Growths, Integer>("SKLGrowth"));
        spdColumn.setCellValueFactory(new PropertyValueFactory<Growths, Integer>("SPDGrowth"));
        lckColumn.setCellValueFactory(new PropertyValueFactory<Growths, Integer>("LCKGrowth"));
        defColumn.setCellValueFactory(new PropertyValueFactory<Growths, Integer>("DEFGrowth"));
        resColumn.setCellValueFactory(new PropertyValueFactory<Growths, Integer>("RESGrowth"));
    }
    

    
}
