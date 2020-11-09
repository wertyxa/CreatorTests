package com.wertyxa.Controller;

import com.wertyxa.Main;
import com.wertyxa.Model.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreatePaneController {

    @FXML
    public Button nextQuesBut;

    @FXML
    public Button prevQuesBut;

    @FXML
    public Button prevNameTestBut;

    @FXML
    public Button nextNameTestBut;

    @FXML
    public Button delGroupBut;

    @FXML
    public Button addGroupBut;

    @FXML
    public Button delSubBut;

    @FXML
    public Button addSubBut;

    @FXML
    public Button addQueBut;

    @FXML
    public Button addAnswer;

    @FXML
    public AnchorPane pane1;

    @FXML
    public AnchorPane pane2;

    @FXML
    public AnchorPane pane3;

    @FXML
    public AnchorPane pane4;

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
    private MenuItem delSelAnswer;

    @FXML
    private MenuItem delSelQuestion;

    @FXML
    private MenuItem delSelNameTest;


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
        pane2.setDisable(true);
        pane3.setDisable(true);
        pane4.setDisable(true);
        listAnswers.setPlaceholder(new Label("Немає відповідей"));
        loadImageButton();
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
            if (oldValue==null){
                System.out.println("Немає попередно вибраного предмету");
            }else {
                if (listAnswers==null||listAnswers.equals(emptyAnswer)){
                    System.out.println("Список відповідей порожній");
                }else {
                    if(selectedQuestion()!=null){
                        selectedQuestion().setListAnswers(listAnswers.getItems());
                    }else {
                        System.out.println("Запитання не вибрано");
                    }
                }
                /**
                 * save Question
                 * */
                if(listQuestion==null||listQuestion.equals(emptyQuestion)){
                    System.out.println("Список запитань порожній");
                }else {
                    if (selectedTestName()!=null){
                        selectedTestName().setListQuestions(listQuestion.getItems());
                    }else {
                        System.out.println("Назву тесту не вибрано");
                    }
                }
                /**
                 * save NameTest
                 * */

                if (listNameTest==null||listNameTest.equals(emptyTestName)){
                    System.out.println("Список назв тестів порожній");
                }else {
                    if (selectedGroup()!=null){
                    selectedGroup().setListTestNames(listNameTest.getItems());
                    }else {
                        System.out.println("Групу не вибрано");
                    }
                }
                /*
                * save Group
                * */
                if (listGroup==null||listGroup.equals(emptyGroups)){
                    System.out.println("Список груп порожній");
                }else {
                    oldValue.setListGroups(listGroup.getItems());
                }
                /*
                * save Subject
                * */
            }
            if (newValue==null){
                Subject empty = new Subject("null",emptyGroups);
                newValue=empty;
                System.out.println("Вибраний прежмет чистий");
            }
            listGroup.setItems(newValue.getListGroups());
            pane2.setDisable(false);
            pane3.setDisable(true);
            pane4.setDisable(true);
        });
        //  Обробник подій для списку груп
        SingleSelectionModel<Group> groupSelectionModel = listGroup.getSelectionModel();
        groupSelectionModel.selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (oldValue==null){
                System.out.println("Немає попередьно вибраної групи");
            }else {
                if (listAnswers==null||listAnswers.equals(emptyAnswer)){
                    System.out.println("Список відповідей порожній");
                }else {
                    if(selectedQuestion()!=null){
                        selectedQuestion().setListAnswers(listAnswers.getItems());
                    }else {
                        System.out.println("Запитання не вибрано");
                    }
                }
                /**
                 * save Question
                 * */
                if(listQuestion==null||listQuestion.equals(emptyQuestion)){
                    System.out.println("Список запитань порожній");
                }else {
                    if (selectedTestName()!=null){
                        selectedTestName().setListQuestions(listQuestion.getItems());
                    }else {
                        System.out.println("Назву тесту не вибрано");
                    }
                }
                /**
                 * save NameTest
                 * */

                if (listNameTest==null||listNameTest.equals(emptyTestName)){
                    System.out.println("Список назв тестів порожній");
                }else {
                    oldValue.setListTestNames(listNameTest.getItems());
                }
                /**
                 * save Group
                 * */
            }
            if(newValue==null){
                Group empty = new Group("",emptyTestName);
                newValue=empty;
                System.out.println("Вибрана гупа порожня");
            }
            listNameTest.setItems(newValue.getListTestNames());
            pane3.setDisable(false);
            pane4.setDisable(true);
            /**
             * load NameTest
             * */
        }));

        //  Обробник подій для списку Назв тестів
        MultipleSelectionModel<TestName> testNameSelectionModel = listNameTest.getSelectionModel();
        testNameSelectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue==null){
                System.out.println("Немає поперднього Назв тесту");
            }else {
                if (listAnswers==null||listAnswers.equals(emptyAnswer)){
                    System.out.println("Список відповідей порожній");
                }
                else {if(selectedQuestion()!=null){selectedQuestion().setListAnswers(listAnswers.getItems());}else {
                    System.out.println("Запитання не вибрано");
                }}
                /*
                * save Question
                * */

                if (listQuestion==null||listQuestion.equals(emptyQuestion)){
                    System.out.println("Список запитань порожній");
                }else {
                    oldValue.setListQuestions(listQuestion.getItems());
                }
                /*
                * save NameTest
                * */
            }
            if (newValue == null){
                TestName empty = new TestName("",emptyQuestion);
                newValue = empty;
                System.out.println("Нова назва тесті порожня");
            }
            listQuestion.setItems(newValue.getListQuestions());
            pane4.setDisable(false);
            /*
            * load Question
            * */
        });

        //  Обробник подій для списку Запитань
        MultipleSelectionModel<Question> questionSelectionModel = listQuestion.getSelectionModel();
        questionSelectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue==null){
                System.out.println("немає поперенього запитання");
            }else {
                if (listAnswers==null||listAnswers.equals(emptyAnswer)){
                    System.out.println("Список відповідей порожній");
                }else {
                    oldValue.setListAnswers(listAnswers.getItems());
                }
                /*
                * save Question
                * */
            }
            if (newValue==null){
                Question empty = new Question(listQuestion.getItems().size()+1,"",emptyAnswer);
                newValue = empty;
                System.out.println("Нове запиння порожнє");

            }
            textQuestion.setText(newValue.getTextQuestion());
            listAnswers.setItems(newValue.getListAnswers());
            /*
            * load Answer
            * */
        });


        //  Обробник подій для тексту  запитання
        textQuestion.textProperty().addListener((observable, oldValue, newValue) -> {
            if(selectedQuestion()==null) {
                newValue = "";
            }else {
                listQuestion.getSelectionModel().getSelectedItem().setTextQuestion(newValue);
            }
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
        textAnswerCol.setMinWidth(505);

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
        rightAnswerCol.setMinWidth(30);
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
        TestName newTestName = new TestName(textNewNameTests.getText(),emptyQuestion);
        listNameTest.getItems().add(newTestName);
    }

    public void delSelectionGroup(ActionEvent actionEvent) {
        listGroup.getItems().remove(listGroup.getSelectionModel().getSelectedIndex());
        listGroup.getSelectionModel().clearSelection();
    }
    //ToDo
    public void addNewGroup(ActionEvent actionEvent) throws IOException {
        listGroup.getSelectionModel().clearSelection();
        loadTemplateForAddNewObject("Group");
    }

    public void delSelectionSubject(ActionEvent actionEvent) {
        listSubject.getItems().remove(listSubject.getSelectionModel().getSelectedIndex());
    }

    public void addNewSubject(ActionEvent actionEvent) throws IOException {
        listSubject.getSelectionModel().clearSelection();
        loadTemplateForAddNewObject("Subject");
    }

    private void loadTemplateForAddNewObject(String typeList) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = Main.loadTemplate("newElementToList");
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.alwaysOnTopProperty();
        NewElementController controller = loader.getController();
        switch (typeList){
            case "Subject":
                controller.addSubject(listSubject.getItems());
                stage.showAndWait();
                break;
            case "Group":
                controller.addGroup(listGroup.getItems());
                stage.showAndWait();
                break;
            case "Question":
                controller.addQuestion(listQuestion.getItems());
                stage.showAndWait();
                break;
            default:
                System.out.println("error Bad type list");
                break;
        }
    }
    //ToDo
    public void addNewQuestion(ActionEvent actionEvent) throws IOException {
        listQuestion.getSelectionModel().clearSelection();
        //loadTemplateForAddNewObject("Question");
        listQuestion.getItems().add(new Question(listQuestion.getItems().size()+1,"",FXCollections.observableArrayList()));
    }

    private Question selectedQuestion(){return listQuestion.getSelectionModel().getSelectedItem();}
    private TestName selectedTestName(){return listNameTest.getSelectionModel().getSelectedItem();}
    private Group selectedGroup(){return listGroup.getSelectionModel().getSelectedItem();}
    private Subject selectedSubject(){return listSubject.getSelectionModel().getSelectedItem();}

    public void setListSubject(ObservableList<Subject> listSubject) {
        this.listSubject.setItems(listSubject);
    }

    public ObservableList<Subject> getListSubject() {
        return listSubject.getItems();
    }

    private void loadImageButton(){
        nextNameTestBut.graphicProperty().setValue(new ImageView(new Image("img/stD.png")));
        prevNameTestBut.graphicProperty().setValue(new ImageView(new Image("img/stU.png")));
        prevQuesBut.graphicProperty().setValue(new ImageView(new Image("img/stL.png")));
        nextQuesBut.graphicProperty().setValue(new ImageView(new Image("img/stR.png")));

        delGroupBut.graphicProperty().setValue(new ImageView(new Image("img/min.png")));
        addGroupBut.graphicProperty().setValue(new ImageView(new Image("img/plus.png")));
        delSubBut.graphicProperty().setValue(new ImageView(new Image("img/min.png")));
        addSubBut.graphicProperty().setValue(new ImageView(new Image("img/plus.png")));
        addQueBut.graphicProperty().setValue(new ImageView(new Image("img/plus.png")));
        addAnswer.graphicProperty().setValue(new ImageView(new Image("img/plus.png")));

        nextNameTestBut.setBackground(Background.EMPTY);
        prevNameTestBut.setBackground(Background.EMPTY);
        prevQuesBut.setBackground(Background.EMPTY);
        nextQuesBut.setBackground(Background.EMPTY);

        delGroupBut.setBackground(Background.EMPTY);
        addGroupBut.setBackground(Background.EMPTY);
        delSubBut.setBackground(Background.EMPTY);
        addSubBut.setBackground(Background.EMPTY);
        addQueBut.setBackground(Background.EMPTY);
        addAnswer.setBackground(Background.EMPTY);

    }

    public void setListGroup(ObservableList<Group> items) {
        this.listGroup.setItems(items);
    }

    public void setListQuestion(ObservableList<Question> items) {
        this.listQuestion.setItems(items);
    }

    public void addNewAnswer(ActionEvent actionEvent) {
        listAnswers.getItems().add(new Answer("",false));
    }

    public void selNextQuestion(ActionEvent actionEvent) {
        MultipleSelectionModel<Question> selectionModel = listQuestion.getSelectionModel();
        if (selectionModel.getSelectedItem()==null){
            selectionModel.selectFirst();
        }else {
            if (selectionModel.getSelectedItem().getNumQuestion()==listQuestion.getItems().size()){
                selectionModel.selectFirst();
            }else {
                selectionModel.selectNext();
            }
        }
    }

    public void selPevQuestion(ActionEvent actionEvent) {
        MultipleSelectionModel<Question> selectionModel = listQuestion.getSelectionModel();
        if (selectionModel.getSelectedItem()==null){
            selectionModel.selectFirst();
        }else {
            if (selectionModel.getSelectedItem().getNumQuestion()==1){
                System.out.println(listQuestion.getItems().size());
                selectionModel.selectLast();
            }else {
                selectionModel.selectPrevious();
            }
        }
    }

    public void selUpTestN(ActionEvent actionEvent) {
        MultipleSelectionModel<TestName> selectionModel = listNameTest.getSelectionModel();
        if (selectionModel.getSelectedItem()==null){
            selectionModel.selectFirst();
        }else {
            if (selectionModel.getSelectedIndex()==0){
                selectionModel.selectLast();
            }else {
                selectionModel.selectPrevious();
            }
        }
    }

    public void selDownTestN(ActionEvent actionEvent) {
        MultipleSelectionModel<TestName> selectionModel = listNameTest.getSelectionModel();
        if (selectionModel.getSelectedItem()==null){
            selectionModel.selectFirst();
        }else {
            if (selectionModel.getSelectedIndex()==(listNameTest.getItems().size()-1)){
                selectionModel.selectFirst();
            }else {
                selectionModel.selectNext();
            }
        }
    }

    public void delSelA() {
        TableView.TableViewSelectionModel<Answer> selectionModel = listAnswers.getSelectionModel();
        if(selectionModel.getSelectedItem()!=null)
        listAnswers.getItems().remove(selectionModel.getSelectedIndex());
    }

    public void delSelNT() {
        MultipleSelectionModel<TestName> selectionModel = listNameTest.getSelectionModel();
        if(selectionModel.getSelectedItem()!=null)
        listNameTest.getItems().remove(selectionModel.getSelectedIndex());
    }

    public void delSelQ() {
        MultipleSelectionModel<Question> selectionModel = listQuestion.getSelectionModel();
        if(selectionModel.getSelectedItem()!=null)
        listQuestion.getItems().remove(selectionModel.getSelectedIndex());
    }
}
