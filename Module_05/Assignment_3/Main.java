package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the Text
        Text text = new Text("SHOW THE CHANGE IN COLOR");
        text.setFont(Font.font("Verdana", 20));


        // Create four sliders
        Slider redSlider = createSlider();
        Slider greenSlider = createSlider();
        Slider blueSlider = createSlider();
        Slider opacitySlider = createSlider();

        // Create labels
        Label redLabel = new Label("Red");
        Label greenLabel = new Label("Green");
        Label blueLabel = new Label("Blue");
        Label opacityLabel = new Label("Opacity");

        // Layout for sliders and labels
        GridPane sliderPane = new GridPane();
        sliderPane.setHgap(10);
        sliderPane.setVgap(10);
        sliderPane.setPadding(new Insets(10));
        sliderPane.addRow(0, redLabel, redSlider);
        sliderPane.addRow(1, greenLabel, greenSlider);
        sliderPane.addRow(2, blueLabel, blueSlider);
        sliderPane.addRow(3, opacityLabel, opacitySlider);

        // Bind the color changes
        redSlider.valueProperty().addListener(e -> updateTextColor(text, redSlider, greenSlider, blueSlider, opacitySlider));
        greenSlider.valueProperty().addListener(e -> updateTextColor(text, redSlider, greenSlider, blueSlider, opacitySlider));
        blueSlider.valueProperty().addListener(e -> updateTextColor(text, redSlider, greenSlider, blueSlider, opacitySlider));
        opacitySlider.valueProperty().addListener(e -> updateTextColor(text, redSlider, greenSlider, blueSlider, opacitySlider));

        // Initial color setup
        updateTextColor(text, redSlider, greenSlider, blueSlider, opacitySlider);

        // Layout
        BorderPane pane = new BorderPane();
        pane.setCenter(text);
        pane.setBottom(sliderPane);
        BorderPane.setAlignment(text, Pos.CENTER);

        Scene scene = new Scene(pane, 500, 300);
        primaryStage.setTitle("Color Picker with Sliders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Create a slider from 0 to 255
    private Slider createSlider() {
        Slider slider = new Slider(0, 255, 0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(85);
        slider.setBlockIncrement(1);
        return slider;
    }

    // Update the text fill color
    private void updateTextColor(Text text, Slider red, Slider green, Slider blue, Slider opacity) {
        Color color = Color.rgb(
                (int) red.getValue(),
                (int) green.getValue(),
                (int) blue.getValue(),
                opacity.getValue() / 255.0
        );
        text.setFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

