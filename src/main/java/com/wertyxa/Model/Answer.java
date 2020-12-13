package com.wertyxa.Model;

import javax.xml.bind.annotation.*;

@XmlType(name = "answer")
public class Answer {
    private String textAnswer;
    private boolean rightAnswer;

    public Answer(){}

    public Answer(String textAnswer, boolean rightAnswer) {
        this.textAnswer = textAnswer;
        this.rightAnswer = rightAnswer;
    }
    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    @XmlElement
    public String getTextAnswer() {
        return textAnswer;
    }
    @XmlElement
    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return textAnswer;
    }
}
