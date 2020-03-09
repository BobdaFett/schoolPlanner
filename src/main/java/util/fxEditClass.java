/*
 * Copyright (c) 2020. If you steal this code, Satan will rain down your throat with hot acid and kill your firstborn.
 */

package util;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import obj.Assignment;
import obj.Cla;
import tab.tabClass;

/**
 * This creates the Dialog window to edit an Assignment.
 *
 * @author BobdaFett
 */

public class fxEditClass {
    
    /**
     * TODO Create an area for the creation of Assignment objects. This means that you can get the assignments and create/edit them from here.
     *
     * TODO Make sure that this changes into a dialog - I don't want people changing other windows while this is open, that will create bugs.
     *  How do you create a dialog?
     */
    
    public static Cla cl;
    private static Stage stage;
    private static Assignment selected;
    private static TableView<Assignment> tableView;
    
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

        Button assignment = new Button((c == null || c.getAssignments().size() == 0) ? "Create Assignments..." : "Edit Assignments...");
        
        Button sub = new Button((c == null) ? "Create" : "Save");
        sub.setDefaultButton(true);
    
        Text nt = new Text("Name:");
        TextField nta = new TextField();
        nta.setText(cl.getName());
        nta.textProperty().addListener((e, o, n) -> cl.setName(n)); // (e, o, n) = (ActionEvent, oldValue, newValue)

        assignment.setOnAction(e -> fxEditAssignment.start(null)); // TODO need to change this method - this will only allow you to create an assignment, not look at them.
        
        sub.setOnAction(e -> {
            if(c == null) fxMain.classes.add(cl);
            tabClass.update();
            stage.close();
        });
    
        GridPane gridPane = new GridPane();
        gridPane.add(nt, 0, 0);
        gridPane.add(nta, 1, 0);
        gridPane.add(assignment, 0, 1, 2, 1);
        gridPane.add(sub, 0, 2, 2, 1);

        gridPane.add(editAssignment(), 3, 0, 1, 3);

        GridPane.setHalignment(sub, HPos.LEFT);
        GridPane.setValignment(sub, VPos.BOTTOM);

        GridPane.setHalignment(nt, HPos.RIGHT);

        GridPane.setHalignment(assignment, HPos.LEFT);
        GridPane.setValignment(assignment, VPos.TOP);

        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Doesn't do anything but get the TableView from the Cla object and return it inside of a VBox.
     * Now that I think about this, it could possibly create a bug, but shouldn't be a problem.
     *
     * @return VBox with a TableView on the inside of it.
     */
    @SuppressWarnings("unchecked")
    public static VBox editAssignment() {

        selected = new Assignment();

        tableView = cl.getAssignmentWindow(); // get the TableView from the object that was called for this class.

        tableView.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY)
                selected = tableView.getSelectionModel().getSelectedItem();
            if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getClickCount() == 2)
                fxEditAssignment.start(selected);
        });

        return new VBox(tableView);

    }

    /**
     * Should call the TableView from the Cla object again - this means that the values should update.
     * Theoretically would show the classes that you created.
     */
    public static void update() {
        tableView.refresh();
    }

}
