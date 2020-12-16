package com.wertyxa.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.wertyxa.Model.Answer;
import com.wertyxa.Model.Question;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;

public class PassPaneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public VBox listAnswers;

    @FXML
    private ListView<Question> listQuestion;

    @FXML
    private AnchorPane answersPane;

    @FXML
    private Button prevQuestionBut;

    @FXML
    private Button nextQuestionBut;

    @FXML
    void nextQuestion(ActionEvent event) {
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
    void prevQuestion(ActionEvent event) {
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

    @FXML
    void initialize() {
        loadButtonFunc();

        listQuestion.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue)
                        -> {
            if (newValue==null){
                return;
            }else {
                if (!newValue.getListAnswers().isEmpty()){
                    CheckBox n = new CheckBox();

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
    }

    public PassPaneController() {
    }
}
