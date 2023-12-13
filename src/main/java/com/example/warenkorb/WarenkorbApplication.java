package com.example.warenkorb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WarenkorbApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WarenkorbApplication.class.getResource("Warenkorb-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Warenkorb");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}