package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Catalogue;
import model.Part;

public class CatalogueController extends Controller<Catalogue>{
    @FXML
    private TableView<Part> catalogueTv;
    @FXML
    private TextField typeField;

    @FXML
    private TextField lowPriceField;

    @FXML
    private TextField highPriceField;
    
    @FXML
    private Button addToBuildBtn;

    @FXML
    private Button addToCatalogueBtn;

    @FXML
    private Button removeFromCatalogue;

    @FXML
    private Button closeBtn;
    
    public final Catalogue getCatalogue() { return model; }
    
    @FXML
    private void initialize() {
        int selectedNum = catalogueTv.getSelectionModel().getSelectedItems().size();
        if (selectedNum ==0){
            this.addToBuildBtn.setDisable(true);
            this.removeFromCatalogue.setDisable(true);
        }
        catalogueTv.getSelectionModel().selectedItemProperty().addListener((obs,old,now)->{
            this.addToBuildBtn.setDisable(now==null);
            this.removeFromCatalogue.setDisable(now==null);
        });
        typeField.textProperty ().addListener((o, oldText, newText) ->
                this.model.filterList(newText, lowPriceField.getText(), highPriceField.getText()));
        lowPriceField.textProperty ().addListener((o, oldText, newText) ->
                this.model.filterList(typeField.getText(), newText, highPriceField.getText()));
        highPriceField.textProperty ().addListener((o, oldText, newText) ->
                this.model.filterList(typeField.getText(), lowPriceField.getText() , newText));
    }
    
    
    //private Part getPart() { return catalogueTv.getSelectionModel().getSelectedItem(); }
    @FXML
    void handleAddToBuildAction(ActionEvent event) {
        int selectedNum = catalogueTv.getSelectionModel().getSelectedItems().size();
        if (selectedNum >1){
            this.model.addToBuild(catalogueTv.getSelectionModel().getSelectedItems());
        } else if (selectedNum == 1){
            this.model.addToBuild(catalogueTv.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void handleAddToCatalogueAction(ActionEvent event) throws IOException {
        ViewLoader.showStage(this.model, "/view/addtocatalogue.fxml", "Add Part to Catalogue Window", new Stage());
    }

    @FXML
    void handleCloseAction(ActionEvent event) {
        this.stage.close();
    }

    @FXML
    void handleRemoveCatalogueAction(ActionEvent event) {
        int selectedNum = catalogueTv.getSelectionModel().getSelectedItems().size();
        if (selectedNum >1){
            this.model.remove(catalogueTv.getSelectionModel().getSelectedItems());
        } else if (selectedNum == 1){
            this.model.remove(catalogueTv.getSelectionModel().getSelectedItem());
        }
    }
   
 
}
