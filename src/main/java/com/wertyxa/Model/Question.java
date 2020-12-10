package com.wertyxa.Model;

import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Question {
    private int numQuestion;
    private String textQuestion;
    private ObservableList<Answer> listAnswers;

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
    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }
    public ObservableList<Answer> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(ObservableList<Answer> listAnswers) {
        this.listAnswers = listAnswers;
    }

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
