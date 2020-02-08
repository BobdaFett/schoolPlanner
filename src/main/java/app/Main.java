package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage s) {



        String test = "This is a test";

        GridPane gp = new GridPane();
        Button b = new Button("Test");
        b.setOnAction(e -> b.setText("You clicked it"));

        gp.add(b,0,0);
        Scene sc = new Scene(gp);
        s.setScene(sc);
        s.show();

    }
}
