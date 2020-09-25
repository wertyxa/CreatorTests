package com.wertyxa.Model;

import javafx.collections.ObservableList;

public class Group {
    private String groupName;
    private ObservableList<TestName> listTestNames;

    public Group() {
    }

    public Group(String groupName, ObservableList<TestName> listTestNames) {
        this.groupName = groupName;
        this.listTestNames = listTestNames;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ObservableList<TestName> getListTestNames() {
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
