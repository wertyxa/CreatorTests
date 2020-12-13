package com.wertyxa.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.wertyxa.Main;
import com.wertyxa.Model.AllTests;
import com.wertyxa.Model.Group;
import com.wertyxa.Model.Subject;
import com.wertyxa.Model.TestName;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SingleSelectionModel;

public class ParamTestsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Subject> listSubjects;

    @FXML
    private ChoiceBox<Group> listGroups;

    @FXML
    private ListView<TestName> listNamesTests;

    @FXML
    private Button startTestBut;

    @FXML
    void startTest() throws IOException {

        Main.loadPassTestPane(listNamesTests.getSelectionModel().getSelectedItem());
    }

    @FXML
    void initialize() {
        AllTests tests = new AllTests();
        tests= new CreatePaneController().getAllList();

        listSubjects.setItems(FXCollections.observableList(tests.getListSubject()));

        SingleSelectionModel<Subject> selectionModelSubject = listSubjects.getSelectionModel();
        selectionModelSubject.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue==null){
                return;
            }else {
                listNamesTests.setItems(FXCollections.observableArrayList());
                listNamesTests.setDisable(true);
                startTestBut.setDisable(true);

                listGroups.setItems(FXCollections.observableList(newValue.getListGroups()));
                listGroups.setDisable(false);
            }
        });
        SingleSelectionModel<Group> selectionModelGroup = listGroups.getSelectionModel();
        selectionModelGroup.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue==null){
                return;
            }else {
                startTestBut.setDisable(true);

                listNamesTests.setItems(FXCollections.observableList(newValue.getListTestNames()));
                listNamesTests.setDisable(false);
            }
        });
        listNamesTests.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue==null){
                startTestBut.setDisable(true);
            }else {
                startTestBut.setDisable(false);
            }
        });
    }
}
