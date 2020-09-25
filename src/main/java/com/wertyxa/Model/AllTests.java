package com.wertyxa.Model;

import javafx.collections.ObservableList;

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
