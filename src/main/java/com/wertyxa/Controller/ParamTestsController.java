package com.wertyxa.Controller;

import com.wertyxa.Main;
import com.wertyxa.Model.AllTests;
import com.wertyxa.Model.Group;
import com.wertyxa.Model.Subject;
import com.wertyxa.Model.TestName;
import com.wertyxa.utils.XmlAdapter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SingleSelectionModel;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ParamTestsController {

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
        startTestBut.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        AllTests tests = XmlAdapter.convertXmlToData(new File(Main.pathName));

        try {
            listSubjects.setItems(FXCollections.observableList(tests.getListSubject()));
        }catch (NullPointerException n){
            listSubjects.setItems(FXCollections.observableArrayList());
            n.printStackTrace();
        }
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
