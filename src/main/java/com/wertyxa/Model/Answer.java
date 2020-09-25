package com.wertyxa.Model;

public class Answer {
    private String textAnswer;
    private boolean rightAnswer;

    public Answer(){}

    public Answer(String textAnswer, boolean rightAnswer) {
        this.textAnswer = textAnswer;
        this.rightAnswer = rightAnswer;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

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
