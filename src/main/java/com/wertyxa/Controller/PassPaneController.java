package com.wertyxa.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.wertyxa.Model.Question;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

public class PassPaneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    }

    @FXML
    void prevQuestion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        loadButtonFunc();
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
