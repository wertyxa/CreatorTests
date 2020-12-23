package com.wertyxa.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.wertyxa.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RootLayoutController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private Button showCreatePaneButton;

    @FXML
    private Button showPassPaneButton;


    @FXML
    void showCreatePane(ActionEvent event) throws IOException {
        Main.loadCreateTestPane(loginField.getText());
        closeWindow();
    }

    @FXML
    void showPassPane(ActionEvent event) throws IOException {
        if (Main.pathName.equals("")){
            File file = openXmlFile();
            if (file!=null){
                Main.pathName=file.getAbsolutePath();
                Main.loadWindowParamTests();
            }
        }else {
            Main.loadWindowParamTests();
        }
        closeWindow();
    }
    private File openXmlFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Xml Data File");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XML","*.xml"),
                new FileChooser.ExtensionFilter("ALL","*.*"));
        return fileChooser.showOpenDialog(new Stage());
    }


    void closeWindow(){
        showCreatePaneButton.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        loginField.setText("Adminnn");
        showCreatePaneButton.setDisable(false);
        showPassPaneButton.setDisable(false);
    /*
        loginField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (observable.getValue().length()>4){
                showCreatePaneButton.setDisable(false);
                showPassPaneButton.setDisable(false);
            }else {
                showCreatePaneButton.setDisable(true);
                showPassPaneButton.setDisable(true);
            }
        });
*/
    }
}
