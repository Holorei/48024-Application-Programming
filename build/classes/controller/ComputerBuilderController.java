package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Build;
import model.Catalogue;
import model.ComputerBuilder;

public class ComputerBuilderController extends Controller<ComputerBuilder> {
    @FXML
    private Button viewCatalogueBtn;
    @FXML
    private Button viewBuildBtn;
    @FXML
    private Button quitBtn;

    private Catalogue getCatalogue(){
        return this.model.getCatalogue();
    }
    private Build getBuild(){
        return this.model.getBuild();
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        ViewLoader.showStage(getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }
    
    @FXML
    void handleViewBuildAction(ActionEvent event) throws IOException{
        ViewLoader.showStage(getBuild(), "/view/build.fxml", "Current Build", new Stage());
    }
    
    @FXML
    void handleQuitAction(ActionEvent event) {
        //this.stage.close();
        Platform.exit();
    }
}