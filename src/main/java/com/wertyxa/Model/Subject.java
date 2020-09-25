package com.wertyxa.Model;

import javafx.collections.ObservableList;

public class Subject {
    private String nameSubject;
    private ObservableList<Group> listGroups;

    public Subject() {
    }

    public Subject(String nameSubject, ObservableList<Group> listGroups) {
        this.nameSubject = nameSubject;
        this.listGroups = listGroups;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public ObservableList<Group> getListGroups() {
        return listGroups;
    }

    public void setListGroups(ObservableList<Group> listGroups) {
        this.listGroups = listGroups;
    }

    @Override
    public String toString() {
        return nameSubject;
    }
}
