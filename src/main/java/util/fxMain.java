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
    public static Menu edit = new Menu("_Edit");

    public static void open(String[] args) {
        Application.launch(args);
    }

    public void start(Stage s) {
        
        GridPane gp = new GridPane();
    
        MenuBar menuBar = getMenus();
        
        tabPane.getTabs().addAll(tabs.getTabs());
        
        gp.add(tabPane,0,0);
        
        Scene sc = new Scene(gp);
        s.setScene(sc);
        s.show();

    }
    
    public MenuBar getMenus() {
        
        MenuBar menuBar = new MenuBar();
    
        Menu file = new Menu();
        MenuItem file1 = new MenuItem("_Create...");
        MenuItem file2 = new MenuItem("Exit");
        file.getItems().addAll(file1, file2);
        
        // this is for the edit Menu
        MenuItem edit1 = new MenuItem("_Edit...");
        MenuItem edit2 = new MenuItem("_Delete...");
        edit.getItems().addAll(edit1, edit2);
        
        return menuBar;
        
    }

}
