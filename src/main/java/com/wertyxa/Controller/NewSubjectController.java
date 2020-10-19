package com.wertyxa.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.wertyxa.Main;
import com.wertyxa.Model.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class NewSubjectController {
    @FXML
    public ListView<Subject> listSubject;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textNewSubject;

    @FXML
    void addNewSubject(ActionEvent event) {
        listSubject.getItems().add(new Subject(textNewSubject.getText(), FXCollections.observableArrayList()));
    }

    @FXML
    void closeAndSaveData(ActionEvent event) {
        listSubject.getScene().getWindow().hide();
        Main.getCreatePaneController().setListSubject(listSubject.getItems());
    }

    @FXML
    void initialize() {
        listSubject.setItems(Main.getCreatePaneController().getListSubject());
    }

    public ObservableList<Subject> getListSubject() {
        return listSubject.getItems();
    }

    public void setListSubject(ObservableList<Subject> listSubject) {
        this.listSubject.setItems(listSubject);
    }
}
