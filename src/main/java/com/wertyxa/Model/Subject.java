package com.wertyxa.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "subject")
public class Subject {
    private String nameSubject;
    private ObservableList<Group> listGroups = FXCollections.observableArrayList();

    public Subject() {
    }

    public Subject(String nameSubject, ObservableList<Group> listGroups) {
        this.nameSubject = nameSubject;
        this.listGroups = listGroups;
    }
    @XmlAttribute
    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }
    @XmlElements({@XmlElement(name = "group",type = Group.class)})
    public List<Group> getListGroups() {
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
