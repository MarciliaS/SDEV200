package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the image views
        GridPane pane = new GridPane();
        
        // Load and place images in the pane
        pane.add(new ImageView(new Image(getClass().getResourceAsStream("/flag1.gif"))), 0, 0);
        pane.add(new ImageView(new Image(getClass().getResourceAsStream("/flag2.gif"))), 1, 0);
        pane.add(new ImageView(new Image(getClass().getResourceAsStream("/flag6.gif"))), 0, 1);
        pane.add(new ImageView(new Image(getClass().getResourceAsStream("/flag7.gif"))), 1, 1);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

