package com.wertyxa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {launch(args);}
    private static Stage globalStage;
    private static AnchorPane rootLayout;
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
        globalStage.setWidth(scene.getWidth());
        globalStage.setHeight(scene.getHeight());
        globalStage.show();
    }

    public static void loadPassTestPane(String name) throws IOException {
        FXMLLoader loader = loadTemplate("passPane");
        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        globalStage.setScene(scene);
        globalStage.setWidth(scene.getWidth());
        globalStage.setHeight(scene.getHeight());
        globalStage.show();
    }

    private static FXMLLoader loadTemplate(String nameFile) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/templates/" +nameFile+".fxml"));
        return loader;
    }
}
