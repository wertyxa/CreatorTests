package com.wertyxa.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "group")
public class Group {
    private String groupName;
    private ObservableList<TestName> listTestNames = FXCollections.observableArrayList();

    public Group() {
    }

    public Group(String groupName, ObservableList<TestName> listTestNames) {
        this.groupName = groupName;
        this.listTestNames = listTestNames;
    }
    @XmlAttribute
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    @XmlElements({@XmlElement(name = "testName", type = TestName.class)})
    public List<TestName> getListTestNames() {
        return listTestNames;
    }

    public void setListTestNames(ObservableList<TestName> listTestNames) {
        this.listTestNames = listTestNames;
    }

    @Override
    public String toString() {
        return groupName;
    }
}
