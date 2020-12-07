package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Build;
import model.Part;

public class BuildController extends Controller<Build> {
    @FXML
    private TableView<Part> buildTv;
    
    @FXML
    private Label totalLabel;

    @FXML
    private Button checkBtn;

    @FXML
    private Button removeFromBuildBtn;

    @FXML
    private Button closeBtn;
    
    public final Build getBuild() { return model; }
    
    @FXML
    private void initialize() {
        totalLabel.setText("Total: $"+model.totalPrice());
        int selectedNum = buildTv.getSelectionModel().getSelectedItems().size();
        if (selectedNum ==0){
            this.removeFromBuildBtn.setDisable(true);
        }
        buildTv.getSelectionModel().selectedItemProperty().addListener((obs,old,now)->{
            this.removeFromBuildBtn.setDisable(now==null);
        });
        this.buildTv.getItems().addListener(new ListChangeListener<Part>() {
                @Override
                public void onChanged(javafx.collections.ListChangeListener.Change<? extends Part> c) {
                        totalLabel.setText("Total: $"+model.totalPrice());
                }

        });
    }
    @FXML
    void handleCheckBuildAction(ActionEvent event) throws IOException {
        if (this.model.isValid()){
            ViewLoader.showStage(new String("The build is functional"), "/view/buildcheck.fxml", "Check Build Window", new Stage());
        } else {
            String s = new String("");
            if (!this.model.hasPartOfType("cpu")){
                s+=String.format("%s%n", "The build is missing a CPU.");
            }
            if (!this.model.hasPartOfType("motherboard")){
                s+=String.format("%s%n", "The build is missing a motherboard.");
            }
            if (!this.model.hasPartOfType("memory")){
                s+=String.format("%s%n", "The build is missing RAM.");
            }
            if (!this.model.hasPartOfType("case")){
                s+=String.format("%s%n", "The build is missing a case.");
            }
            if (!this.model.hasPartOfType("storage")){
                s+=String.format("%s%n", "The build is missing storage.");
            }
            ViewLoader.showStage(s, "/view/buildcheck.fxml", "Check Build Window", new Stage());
        }
    }
    
    
    @FXML
    void handleCloseAction(ActionEvent event) {
        this.stage.close();
    }

    @FXML
    void handleRemoveFromBuildAction(ActionEvent event) {
        int selectedNum = buildTv.getSelectionModel().getSelectedItems().size();
        if (selectedNum >1){
            this.model.remove(buildTv.getSelectionModel().getSelectedItems());
        } else if (selectedNum == 1){
            this.model.remove(buildTv.getSelectionModel().getSelectedItem());
        }
    }
}
