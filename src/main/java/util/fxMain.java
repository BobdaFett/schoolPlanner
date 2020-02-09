package util;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tab.tabs;
import obj.Cla;

/**
 * The main window of the application.
 * This creates the window and gets all corresponding information and elements.
 *
 * @author BobdaFett
 */

public class fxMain extends Application {
    
    public static TabPane tabPane;
    public static ObservableList<Cla> classes = FXCollections.observableArrayList();

    public static void open(String[] args) {
        Application.launch(args);
    }

    public void start(Stage s) {
        
        GridPane gp = new GridPane();

        Cla cla = new Cla("name");
        
        classes.add(cla);
        
        tabPane = new TabPane();
        tabPane.getTabs().addAll(tabs.getTabs());
        
        gp.add(tabPane,0,0);
        
        Scene sc = new Scene(gp);
        s.setScene(sc);
        s.show();

    }

}
