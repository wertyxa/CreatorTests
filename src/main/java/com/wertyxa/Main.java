package com.wertyxa;

import com.wertyxa.Controller.CreatePaneController;
import com.wertyxa.Controller.PassPaneController;
import com.wertyxa.Model.TestName;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {launch(args);}
    private static Stage globalStage;
    private static AnchorPane rootLayout;

    private static CreatePaneController createPaneController;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.globalStage=primaryStage;
        this.globalStage.setTitle("Brains");

        initRootLayout();
    }

    private void initRootLayout() throws IOException {
        FXMLLoader loader = loadTemplate("rootLayout");
        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        globalStage.setScene(scene);
        globalStage.setResizable(false);
        globalStage.show();
    }



    public static void loadCreateTestPane(String name) throws IOException {
        FXMLLoader loader = loadTemplate("createPane");
        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        globalStage.setScene(scene);
        globalStage.setWidth(1280);
        globalStage.setHeight(780);
        globalStage.show();
        createPaneController = loader.getController();
    }

    public static void loadWindowParamTests() throws IOException {
        FXMLLoader loader = loadTemplate("paramTests");
        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        globalStage.setScene(scene);
        globalStage.show();

    }

    public static void loadPassTestPane(TestName selectedItem) throws IOException {
        FXMLLoader loader = loadTemplate("passPane");
        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        globalStage.setScene(scene);
        globalStage.setWidth(rootLayout.getWidth());
        globalStage.setHeight(rootLayout.getHeight());
        System.out.println(rootLayout.getWidth()+" "+rootLayout.getHeight());
        globalStage.setTitle("Brains - "+selectedItem.getNameTest());

        PassPaneController ct =loader.getController();
        ct.loadListQuestion(FXCollections.observableList(selectedItem.getListQuestions()));
        //globalStage.show();
    }

    public static FXMLLoader loadTemplate(String nameFile) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/templates/" +nameFile+".fxml"));
        return loader;
    }

    public static CreatePaneController getCreatePaneController() {
        return createPaneController;
    }
}
