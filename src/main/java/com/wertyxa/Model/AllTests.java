package com.wertyxa.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Data")
public class AllTests {
    private ObservableList<Subject> listSubject = FXCollections.observableArrayList();

    public AllTests() {
    }

    public AllTests(ObservableList<Subject> listSubject) {
        this.listSubject = listSubject;
    }
    @XmlElements({@XmlElement(name = "subject", type = Subject.class)})
    public List<Subject> getListSubject() {
        return listSubject;
    }

    public void setListSubject(ObservableList<Subject> listSubject) {
        this.listSubject = listSubject;
    }

    @Override
    public String toString() {
        return "Data{" +
                "listSubject=" + listSubject +
                '}';
    }
}
