package com.GRG.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.URL;

import static javafx.application.Application.launch;

@SpringBootApplication
public class GRGClientApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL sample = getClass().getResource("Sample.fxml");
        Parent root;
        root = FXMLLoader.load(sample);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("GRG");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        SpringApplication.run(GRGClientApplication.class, args);
        launch(args);
    }

}
