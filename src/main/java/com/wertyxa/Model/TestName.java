package com.wertyxa.Model;

import javafx.collections.ObservableList;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TestName {
    private String nameTest;
    private ObservableList<Question> listQuestions;

    public TestName() {
    }

    public TestName(String nameTest, ObservableList<Question> listQuestions) {
        this.nameTest = nameTest;
        this.listQuestions = listQuestions;
    }
    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }
    public ObservableList<Question> getListQuestions() {
        return listQuestions;
    }

    public void setListQuestions(ObservableList<Question> listQuestions) {
        this.listQuestions = listQuestions;
    }

    @Override
    public String toString() {
        return this.nameTest;
    }
}
