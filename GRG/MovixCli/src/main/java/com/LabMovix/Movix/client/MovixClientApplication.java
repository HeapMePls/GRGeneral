package com.LabMovix.Movix.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

import static javafx.application.Application.launch;

@SpringBootApplication
public class MovixClientApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL sample = getClass().getResource("Sample.fxml");
        Parent root;
        root = FXMLLoader.load(sample);
        //Arrastrar programa
        primaryStage.setMaximized(true);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
//		primaryStage.getIcons().add(new Image("images/movix_icon.png"));
        primaryStage.setTitle("MoViX♣");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovixClientApplication.class, args);
        launch(args);
    }

}
