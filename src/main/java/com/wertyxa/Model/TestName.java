package com.wertyxa.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "testName")
public class TestName {
    private String nameTest;
    private ObservableList<Question> listQuestions = FXCollections.observableArrayList();

    public TestName() {
    }

    public TestName(String nameTest, ObservableList<Question> listQuestions) {
        this.nameTest = nameTest;
        this.listQuestions = listQuestions;
    }
    @XmlAttribute
    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }
    @XmlElements({@XmlElement(name = "question", type = Question.class)})
    public List<Question> getListQuestions() {
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
