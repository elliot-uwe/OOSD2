package oosd2assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file directly and set the controller
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));

        // Create a new Scene with the root node as the content
        Scene scene = new Scene(root, 600, 900);

        // Set the scene on the primary stage and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}


