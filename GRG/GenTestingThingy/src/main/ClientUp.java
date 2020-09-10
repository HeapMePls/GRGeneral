package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import java.net.URL;

public class ClientUp extends Application {
    public void start(Stage primaryStage) throws Exception {
        URL sample = getClass().getResource("Sample.fxml");

        Parent root = FXMLLoader.load(sample);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("Test Generador");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
