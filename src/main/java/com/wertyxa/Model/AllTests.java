package com.wertyxa.Model;

import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllTests {
    private ObservableList<Subject> listSubject;

    public AllTests() {
    }

    public AllTests(ObservableList<Subject> listSubject) {
        this.listSubject = listSubject;
    }
    public ObservableList<Subject> getListSubject() {
        return listSubject;
    }

    public void setListSubject(ObservableList<Subject> listSubject) {
        this.listSubject = listSubject;
    }
}
