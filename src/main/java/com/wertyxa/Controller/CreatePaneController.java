package com.wertyxa.Controller;

import com.wertyxa.Model.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class CreatePaneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menuBar;

    @FXML
    private ComboBox<Subject> listSubject;

    @FXML
    private ComboBox<Group> listGroup;

    @FXML
    private TableView<Answer> listAnswers;

    @FXML
    private ListView<Question> listQuestion;

    @FXML
    private TextArea textQuestion;

    @FXML
    private TextField textNewNameTests;


    @FXML
    private ListView<TestName> listNameTest;

    ObservableList <Subject> emptySubject = FXCollections.observableArrayList();
    ObservableList <Group> emptyGroups = FXCollections.observableArrayList();
    ObservableList <Answer> emptyAnswer = FXCollections.observableArrayList();
    ObservableList <Question> emptyQuestion = FXCollections.observableArrayList();
    ObservableList <TestName> emptyTestName = FXCollections.observableArrayList();

    AllTests allTests = new AllTests(FXCollections.observableArrayList());

    @FXML
    void initialize() {
        listSubject.setItems(emptySubject);
        listAnswers.setItems(emptyAnswer);
        listQuestion.setItems(emptyQuestion);
        listNameTest.setItems(emptyTestName);
        listGroup.setItems(emptyGroups);
        getAllList();
        listSubject.setItems(allTests.getListSubject());
       // listSubject.setEditable(true);
      //  listGroup.setEditable(true);

 /*       listGroup.setDisable(true);
        listNameTest.setDisable(true);
        listQuestion.setDisable(true);
        listAnswers.setDisable(true);
*/
        //  Обробник подій для списку предметів
        SingleSelectionModel<Subject> subjectSelectionModel = listSubject.getSelectionModel();
        subjectSelectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });
        //  Обробник подій для списку груп
        SingleSelectionModel<Group> groupSelectionModel = listGroup.getSelectionModel();
        groupSelectionModel.selectedItemProperty().addListener(((observable, oldValue, newValue) -> {

        }));

        //  Обробник подій для списку Назв тестів
        MultipleSelectionModel<TestName> testNameSelectionModel = listNameTest.getSelectionModel();
        testNameSelectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });

        //  Обробник подій для списку Запитань
        MultipleSelectionModel<Question> questionSelectionModel = listQuestion.getSelectionModel();
        questionSelectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue!=null)oldValue.setListAnswers(listAnswers.getItems());
            if (newValue!=null) {
                textQuestion.setText(newValue.getTextQuestion());
                listAnswers.setItems(newValue.getListAnswers());
                listAnswers.refresh();
            }else {
                textQuestion.setText("");
                listAnswers.setItems(emptyAnswer);
                listAnswers.refresh();
            }
        });


        //  Обробник подій для тексту  запитання
        textQuestion.textProperty().addListener((observable, oldValue, newValue) -> {
            listQuestion.getSelectionModel().getSelectedItem().setTextQuestion(newValue);
        });
        configTabelAnswer();
    }

    private void configTabelAnswer() {
        listAnswers.setEditable(true);

        TableColumn<Answer, String> textAnswerCol = new TableColumn<>("Відповідь");
        TableColumn<Answer, Boolean> rightAnswerCol = new TableColumn<>("пр");

        // === Text Answer (TextField) ===
        textAnswerCol.setCellValueFactory(new PropertyValueFactory<>("textAnswer"));
        textAnswerCol.setCellFactory(TextFieldTableCell.forTableColumn());
        textAnswerCol.setMinWidth(550);

        // On cell edit commit (for Text Answer column)

        textAnswerCol.setOnEditCommit((TableColumn.CellEditEvent<Answer,String> event)->{
            TablePosition<Answer, String> pos = event.getTablePosition();
            String newTextAnswer = event.getNewValue();

            int row = pos.getRow();
            Answer answer = event.getTableView().getItems().get(row);
            answer.setTextAnswer(newTextAnswer);
        });

        rightAnswerCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Answer, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Answer, Boolean> param) {
                Answer answer = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(answer.isRightAnswer());


                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        answer.setRightAnswer(newValue);
                    }
                });
                return booleanProp;
            }
        });

        rightAnswerCol.setCellFactory(new Callback<TableColumn<Answer, Boolean>, TableCell<Answer, Boolean>>() {
            @Override
            public TableCell<Answer, Boolean> call(TableColumn<Answer, Boolean> param) {
                CheckBoxTableCell<Answer, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        listAnswers.getColumns().addAll(textAnswerCol,rightAnswerCol);
    }

    private void getAllList() {
        allTests.setListSubject(FXCollections.observableArrayList(
                new Subject("Math",FXCollections.observableArrayList(
                        new Group("ОПЗ-16",FXCollections.observableArrayList(
                                new TestName("Трикутники",FXCollections.observableArrayList()),
                                new TestName("Прямокутники",FXCollections.observableArrayList()),
                                new TestName("Фігури",FXCollections.observableArrayList())
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
    }

    public void addNewNameTest(ActionEvent actionEvent) {
        
    }

    public void delSelectionGroup(ActionEvent actionEvent) {

    }

    public void addNewGroup(ActionEvent actionEvent) {

    }

    public void delSelectionSubject(ActionEvent actionEvent) {

    }

    public void addNewSubject(ActionEvent actionEvent) {

    }

    public void addNewQuestion(ActionEvent actionEvent) {

    }
}
