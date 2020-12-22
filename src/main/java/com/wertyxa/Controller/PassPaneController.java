package com.wertyxa.Controller;

import com.wertyxa.Main;
import com.wertyxa.Model.Answer;
import com.wertyxa.Model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PassPaneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox listAnswers;

    @FXML
    private ListView<Question> listQuestion;

    @FXML
    private AnchorPane answersPane;

    @FXML
    private Button prevQuestionBut;

    @FXML
    private Button nextQuestionBut;

    @FXML
    void nextQuestion() {
        MultipleSelectionModel<Question> selectionModel = listQuestion.getSelectionModel();
        if (selectionModel.getSelectedItem()==null){
            selectionModel.selectFirst();
        }else {
            if (selectionModel.getSelectedItem().getNumQuestion()==listQuestion.getItems().size()){
                selectionModel.selectFirst();
            }else {
                selectionModel.selectNext();
            }
        }

    }

    @FXML
    void prevQuestion() {
        MultipleSelectionModel<Question> selectionModel = listQuestion.getSelectionModel();
        if (selectionModel.getSelectedItem()==null){
            selectionModel.selectFirst();
        }else {
            if (selectionModel.getSelectedItem().getNumQuestion()==1){
                System.out.println(listQuestion.getItems().size());
                selectionModel.selectLast();
            }else {
                selectionModel.selectPrevious();
            }
        }

    }

    private ObservableList<Question> tmpListQuestion;

    int id;

    @FXML
    void initialize() {
        loadButtonFunc();
        tmpListQuestion =listQuestion.getItems();

        MultipleSelectionModel<Question> selectionModel = listQuestion.getSelectionModel();
        selectionModel
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue)
                        -> {
                    if (oldValue==null){
                        id = listQuestion.getSelectionModel().getSelectedIndex();
                    }

            if (newValue==null){
                return;
            }else {
                ObservableList<Answer> tmpListAnswer = FXCollections.observableArrayList();
                for (Node n :listAnswers.getChildren()){
                    CheckBox a = (CheckBox) n;
                    tmpListAnswer.add(new Answer(a.getText(),a.isSelected()));
                }

                    tmpListQuestion.get(id).setListAnswers(tmpListAnswer);
                if (!newValue.getListAnswers().isEmpty()){
                    //load next answer
                    listAnswers.getChildren().clear();
                    for (Answer answer :newValue.getListAnswers()){
                        listAnswers.getChildren().add(new CheckBox(answer.getTextAnswer()));
                    }
                }
            }
        });
    }

    private void loadButtonFunc() {
        prevQuestionBut.graphicProperty().setValue(new ImageView(new Image("img/stL.png")));
        nextQuestionBut.graphicProperty().setValue(new ImageView(new Image("img/stR.png")));

        prevQuestionBut.setBackground(Background.EMPTY);
        nextQuestionBut.setBackground(Background.EMPTY);
    }

    public void loadListQuestion(ObservableList<Question> questions){
        listQuestion.setItems(questions);
        tmpListQuestion =questions;
    }

    private Answer getAnswerById(int id){
        return listQuestion.getSelectionModel().getSelectedItem().getListAnswers().get(id);
    }

    public PassPaneController() {
    }

    public void getResult() {
        int successResult = 0;
        for (int i = 0; i<listQuestion.getItems().size();i++){
            if (listQuestion.getItems().get(i).getListAnswers().containsAll(tmpListQuestion.get(i).getListAnswers())) {
                successResult++;
            }
        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Результат");
        alert.setContentText(successResult+" правильних відповідей з "+listQuestion.getItems().size());
        alert.setOnCloseRequest(event -> {
            alert.close();
            listQuestion.getScene().getWindow().hide();
            try {
                Main.loadWindowParamTests();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        alert.showAndWait();
    }
}
