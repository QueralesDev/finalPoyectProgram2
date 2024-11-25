package com.example.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

       Initializer generateData = new Initializer();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/scenes/MAIN_MENU.fxml"));

        Scene scene = new Scene(fxmlLoader. load(), 600, 400);

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/icon.png")));
        stage.getIcons().add(icon);

        stage.setTitle("Sistema Gestión");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}