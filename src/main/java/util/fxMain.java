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
    
    public static TabPane tabPane = new TabPane();
    public static ObservableList<Cla> classes = FXCollections.observableArrayList();
    public static Cla selected;
    
    public static Stage stage;

    public static void open(String[] args) {
        Application.launch(args);
    }

    public void start(Stage s) {
        
        stage = s;
        selected = null;
        
        GridPane gp = new GridPane();
        
        tabPane.getTabs().addAll(tabs.getTabs());
        
        gp.add(getMenus(), 0,0);
        gp.add(tabPane,0,1);
        
        Scene sc = new Scene(gp);
        stage.setScene(sc);
        stage.setMaximized(true);
        stage.show();

    }
    
    public MenuBar getMenus() {
        
        MenuBar menuBar = new MenuBar();
    
        Menu file = new Menu("File");
        MenuItem file1 = new MenuItem("_Create...");
        file1.setOnAction(e -> fxEditAssignment.start(null));
        MenuItem file2 = new MenuItem("Exit");
        file2.setOnAction(e -> stage.close());
        file.getItems().addAll(file1, file2);
        
        Menu edit = new Menu("Edit");
        MenuItem edit1 = new MenuItem("_Edit...");
        MenuItem edit2 = new MenuItem("_Delete...");
        edit.getItems().addAll(edit1, edit2);
        
        menuBar.getMenus().addAll(file, edit);
        
        return menuBar;
        
    }

}
