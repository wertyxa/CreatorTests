package com.wertyxa.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "question")
public class Question {
    private int numQuestion;
    private String textQuestion;
    private ObservableList<Answer> listAnswers = FXCollections.observableArrayList();

    public Question() {
    }

    public Question(int numQuestion, String textQuestion, ObservableList<Answer> listAnswers) {
        this.numQuestion = numQuestion;
        this.textQuestion = textQuestion;
        this.listAnswers = listAnswers;
    }

    public Question(int numQues) {
        this.numQuestion = numQues;
    }
    @XmlElement
    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }
    @XmlElements({@XmlElement(name = "answer", type = Answer.class)})
    public List<Answer> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(ObservableList<Answer> listAnswers) {
        this.listAnswers = listAnswers;
    }
    @XmlAttribute
    public int getNumQuestion() {
        return numQuestion;
    }

    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }



    @Override
    public String toString() {
        if (numQuestion == 999){
            return "+";
        }else {
            return ""+numQuestion;
        }
    }
}
