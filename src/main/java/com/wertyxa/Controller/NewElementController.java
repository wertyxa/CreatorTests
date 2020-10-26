package com.wertyxa.Controller;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.wertyxa.Main;
import com.wertyxa.Model.Group;
import com.wertyxa.Model.Question;
import com.wertyxa.Model.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewElementController<T> {

    @FXML
    public TextField textNewObject;

    @FXML
    public AnchorPane paneForList;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    ObservableList<Subject>  subjects = FXCollections.observableArrayList();
    ObservableList<Group>  groups = FXCollections.observableArrayList();
    ObservableList<Question>  questions = FXCollections.observableArrayList();


    private String typeElement;
    ListView<Subject> subjectList = new ListView<>();
    ListView<Group> groupList = new ListView<>();
    ListView<Question> questionList = new ListView<>();

    @FXML
    void addNewElement(ActionEvent event) {
        System.out.println(typeElement);
        switch (typeElement){
            case "Subject":
                subjectList.getItems().add(new Subject(textNewObject.getText(),FXCollections.observableArrayList()));
                break;
            case "Group":
                groupList.getItems().add(new Group(textNewObject.getText(),FXCollections.observableArrayList()));
                break;
            case "Question":
                questionList.getItems().add(new Question(questionList.getItems().size()+1,"",FXCollections.observableArrayList()));
            default:
                System.out.println("Not Type List");
        }
    }
    @FXML
    void closeAndSaveData(ActionEvent event) {
        paneForList.getScene().getWindow().hide();
        switch (typeElement){
            case "Subject":
                Main.getCreatePaneController().setListSubject(subjectList.getItems());
                break;
            case "Group":
                Main.getCreatePaneController().setListGroup(groupList.getItems());
                break;
            case "Question":
                Main.getCreatePaneController().setListQuestion(questionList.getItems());
                break;
            default:
                System.out.println("Not Type List");
        }

    }

    @FXML
    void initialize() {
        AnchorPane.setTopAnchor(subjectList,0.0);
        AnchorPane.setTopAnchor(groupList,0.0);
        AnchorPane.setTopAnchor(questionList,0.0);

        AnchorPane.setLeftAnchor(subjectList,0.0);
        AnchorPane.setLeftAnchor(groupList,0.0);
        AnchorPane.setLeftAnchor(questionList,0.0);

        AnchorPane.setRightAnchor(subjectList,0.0);
        AnchorPane.setRightAnchor(groupList,0.0);
        AnchorPane.setRightAnchor(questionList,0.0);

        AnchorPane.setBottomAnchor(subjectList,0.0);
        AnchorPane.setBottomAnchor(groupList,0.0);
        AnchorPane.setBottomAnchor(questionList,0.0);

    }
    public void addSubject(ObservableList<Subject> subjects){
        typeElement = "Subject";
        paneForList.getChildren().add(subjectList);
        subjectList.setItems(subjects);
    }
    public void addGroup(ObservableList<Group> groups){
        typeElement = "Group";
        paneForList.getChildren().add(groupList);
        groupList.setItems(groups);
    }

    public void addQuestion(ObservableList<Question> questions) {
        typeElement = "Question";
        paneForList.getChildren().add(questionList);
        Iterator<Question> iter = questionList.getItems().iterator();
        while (iter.hasNext()){
            iter.next().setNumQuestion(questionList.getItems().size()+1);
            questionList.getItems().add(iter.next());
        }
    }
}
