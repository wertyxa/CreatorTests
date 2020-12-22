package com.wertyxa.tests;

import com.wertyxa.Model.*;
import com.wertyxa.utils.XmlAdapter;
import javafx.collections.FXCollections;

import javax.xml.bind.JAXBException;

public class Test1 {
    public static void main(String[] args) throws JAXBException {
        String filename = "data.xml";

        AllTests allTests = new AllTests();
        allTests.setListSubject(FXCollections.observableArrayList(
                new Subject("Math",FXCollections.observableArrayList(
                        new Group("ОПЗ-16",FXCollections.observableArrayList(
                                new TestName("Трикутники",FXCollections.observableArrayList(
                                        new Question(1,"231231",FXCollections.observableArrayList(
                                                new Answer("qwerty?",true),
                                                new Answer("qwerty?",false),
                                                new Answer("qwerty?",true)
                                        )),
                                        new Question(2,"43",FXCollections.observableArrayList(
                                                new Answer("qwerty?",true),
                                                new Answer("qwerty?",false),
                                                new Answer("qwerty?",true)
                                        )),
                                        new Question(3,"54643",FXCollections.observableArrayList(
                                                new Answer("qwerty?",true),
                                                new Answer("qwerty?",false),
                                                new Answer("qwerty?",true)

                                        ))
                                )),
                                new TestName("Прямокутники",FXCollections.observableArrayList(
                                        new Question(1,"231231",FXCollections.observableArrayList(
                                                new Answer("qwerty?",true),
                                                new Answer("qwerty?",false),
                                                new Answer("qwerty?",true)
                                        )),
                                        new Question(2,"43",FXCollections.observableArrayList(
                                                new Answer("qwerty?",true),
                                                new Answer("qwerty?",false),
                                                new Answer("qwerty?",true)
                                        )),
                                        new Question(3,"54643",FXCollections.observableArrayList(
                                                new Answer("qwerty?",true),
                                                new Answer("qwerty?",false),
                                                new Answer("qwerty?",true)
                                        ))
                                )),
                                new TestName("Фігури",FXCollections.observableArrayList(
                                        new Question(1,"231231",FXCollections.observableArrayList()),
                                        new Question(2,"43",FXCollections.observableArrayList()),
                                        new Question(3,"54643",FXCollections.observableArrayList())
                                ))
                        )),
                        new Group("ЗВК-25",FXCollections.observableArrayList(
                                new TestName("Фігури",FXCollections.observableArrayList()),
                                new TestName("Трикутники",FXCollections.observableArrayList()),
                                new TestName("Прямокутники",FXCollections.observableArrayList())
                        )),
                        new Group("ВШП-41",FXCollections.observableArrayList(
                                new TestName("Прямокутники",FXCollections.observableArrayList()),
                                new TestName("Фігури",FXCollections.observableArrayList()),
                                new TestName("Трикутники",FXCollections.observableArrayList())
                        )))),
                new Subject("Ukrainian lang",FXCollections.observableArrayList(
                        new Group("ОПЗ-12",FXCollections.observableArrayList(
                                new TestName("Словосполучники",FXCollections.observableArrayList()),
                                new TestName("Прості речення",FXCollections.observableArrayList()),
                                new TestName("Складені речення",FXCollections.observableArrayList())
                        )),
                        new Group("ЗВК-22",FXCollections.observableArrayList(
                                new TestName("Складені речення",FXCollections.observableArrayList()),
                                new TestName("Прості речення",FXCollections.observableArrayList()),
                                new TestName("Словосполучники",FXCollections.observableArrayList())
                        )),
                        new Group("ВШП-42",FXCollections.observableArrayList(
                                new TestName("Прості речення",FXCollections.observableArrayList()),
                                new TestName("Складені речення",FXCollections.observableArrayList()),
                                new TestName("Словосполучники",FXCollections.observableArrayList())
                        )))),
                new Subject("History",FXCollections.observableArrayList(
                        new Group("ОПЗ-13",FXCollections.observableArrayList(
                                new TestName("Історія1",FXCollections.observableArrayList()),
                                new TestName("Історія12",FXCollections.observableArrayList()),
                                new TestName("Історія13",FXCollections.observableArrayList())
                        )),
                        new Group("ЗВК-23",FXCollections.observableArrayList(
                                new TestName("Історія13",FXCollections.observableArrayList()),
                                new TestName("Історія12",FXCollections.observableArrayList()),
                                new TestName("Історія1",FXCollections.observableArrayList())
                        )),
                        new Group("ВШП-43",FXCollections.observableArrayList(
                                new TestName("Історія12",FXCollections.observableArrayList()),
                                new TestName("Історія1",FXCollections.observableArrayList()),
                                new TestName("Історія13",FXCollections.observableArrayList())
                        ))))));
        XmlAdapter.convertDataToXML(allTests,filename);

    }

}
