package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class CheckBuildController extends Controller<String>{
    @FXML
    private TextArea textArea;

    @FXML
    private Button closeBtn;


    @FXML
    private void initialize() {
        this.textArea.setText(this.model);
    }
    @FXML
    void handleCloseAction(ActionEvent event) {
        this.stage.close();
    }
}
