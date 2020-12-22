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
    public static String pathName = "";

    private static CreatePaneController createPaneController;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.globalStage=primaryStage;
        this.globalStage.setTitle("Brains");
        globalStage.setOnCloseRequest(event -> {
            System.out.println("Exit");
        });
        initRootLayout();
    }

    private static void initRootLayout() throws IOException {
        FXMLLoader loader = loadTemplate("rootLayout");
        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        globalStage.setScene(scene);
        globalStage.setResizable(false);
        globalStage.show();
    }



    public static void loadCreateTestPane(String name) throws IOException {
        FXMLLoader loader = loadTemplate("createPane");
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setOnCloseRequest(event -> {
            stage.close();
            try {
                initRootLayout();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        stage.setScene(scene);
        stage.show();
        createPaneController = loader.getController();
    }

    public static void loadWindowParamTests() throws IOException {
        FXMLLoader loader = loadTemplate("paramTests");
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setOnCloseRequest(event -> {
            stage.close();
            try {
                initRootLayout();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        stage.setScene(scene);
        stage.show();


    }

    public static void loadPassTestPane(TestName selectedItem) throws IOException {
        FXMLLoader loader = loadTemplate("passPane");
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        System.out.println(root.getWidth()+" "+root.getHeight());
        stage.setTitle("Brains - "+selectedItem.getNameTest());

        PassPaneController ct =loader.getController();
        ct.loadListQuestion(FXCollections.observableList(selectedItem.getListQuestions()));
        stage.show();
        stage.setOnCloseRequest(event -> {
            stage.close();
            try {
                loadWindowParamTests();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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
