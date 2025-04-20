package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main<Vbox> extends Application {
	@Override
	public void start(Stage primaryStage) {
		//create a circle and set its properties
		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		
		//create a label to show the status
		Label status = new Label("No events yet");
		status.setFont(Font.font("Verdana",FontWeight.BOLD, FontPosture.ITALIC, 14));
		//Create a pane to hold the circle and status label
		
		
		//create a pane to hold the circle
		Pane pane = new Pane(circle);
		// Create a VBox to hold the pane and status label
		VBox root = new VBox(pane, status);
		
			
		//create a scene and place it in the stage
		Scene scene = new Scene(root,300,300);
		//set the stage title
		primaryStage.setTitle("Show Circle");
		
		// Mouse pressed - change to black
		scene.setOnMousePressed(event -> {
			circle.setFill(Color.BLACK);
			status.setText("Mouse Pressed - Circle is Black");
		});
		
		// Mouse released - change back to white
		pane.setOnMouseReleased(event -> {
			circle.setFill(Color.WHITE);
			status.setText("Mouse Released - Circle is White");
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
