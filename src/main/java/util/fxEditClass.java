package util;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import obj.Cla;
import tab.tabClass;

/**
 * This creates the Dialog window to edit an Assignment.
 *
 * @author BobdaFettx
 */

public class fxEditClass {
    
    /**
     * TODO Create an area for the creation of Assignment objects. This means that you can get the assignments and create/edit them from here.
     */
    
    private static Cla cl;
    private static Stage stage;
    
    /**
     * Initialize the base window and get the contents.
     *
     * @param c The Class to be edited.
     */
    public static void start(Cla c) {
    
        cl = (c != null) ? c : new Cla();
        
        if(stage != null && stage.isShowing()) stage.close(); // ensures that there's only one stage - you can only edit one class at a time.
        stage = new Stage();
        stage.setTitle((c == null) ? "Create Class" : "Edit Class " + c.getName());
    
        Button assignment = new Button((c == null) ? "Create Assignments..." : "Edit Assignments...");
        
        Button sub = new Button((c == null) ? "Create" : "Save");
        sub.setDefaultButton(true);
    
        Text nt = new Text("Name:");
        TextField nta = new TextField();
        nta.setText(cl.getName());
        nta.textProperty().addListener((e, o, n) -> cl.setName(n)); // (e, o, n) = (ActionEvent, oldValue, newValue)
    
        assignment.setOnAction(e -> {
            fxEditAssignment.start(null, cl);
        });
        
        sub.setOnAction(e -> {
            if(c == null) fxMain.classes.add(cl);
            tabClass.update();
            stage.close();
        });
    
        GridPane gridPane = new GridPane();
        gridPane.add(nt, 0, 0);
        gridPane.add(nta, 1, 0);
        gridPane.add(assignment, 0, 1);
        gridPane.add(sub, 1, 2);
        
        GridPane.setHalignment(nt, HPos.RIGHT);
        
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.showAndWait();
        
    }

}
