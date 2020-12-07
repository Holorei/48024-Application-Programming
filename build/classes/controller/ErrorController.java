package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class ErrorController extends Controller<String> {
    
    @FXML
    private Label errorLabel;

    @FXML
    private Button okayBtn;
    
    @FXML
    private void initialize() {
        this.errorLabel.setText(this.model);
    }
    
    @FXML
    void handleOkeyAction(ActionEvent event) {
        this.stage.close();
    }
}
