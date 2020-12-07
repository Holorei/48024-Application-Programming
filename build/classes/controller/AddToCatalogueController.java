package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Catalogue;

public class AddToCatalogueController extends Controller<Catalogue>{
    @FXML
    private TextField typeField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private Button addToCatalogueBtn;
    

    @FXML
    void handleAddtoCatalogueAction(ActionEvent event) throws IOException {
        if (typeField.getText().isEmpty()){
            //ViewLoader.showStage(this.model, "/view/addtocatalogue.fxml", "Add Part to Catalogue Window", new Stage());
            ViewLoader.showStage(new String("Empty type entered"), "/view/error.fxml", "Incorrect Input", new Stage());
        } else if (nameField.getText().isEmpty()){
            ViewLoader.showStage(new String("Empty name entered"), "/view/error.fxml", "Incorrect Input", new Stage());
        } else if (priceField.getText().isEmpty()){
            ViewLoader.showStage(new String("Empty price entered"), "/view/error.fxml", "Incorrect Input", new Stage());
        }else{
            try {
                this.model.addPart(nameField.getText(), typeField.getText(), Double.parseDouble(priceField.getText()));
                this.stage.close();
            } catch (Exception e) {
                ViewLoader.showStage(new String("Invalid price entered"), "/view/error.fxml", "Incorrect Input", new Stage());
            }
            
        }
    }

}
