/*
 * Copyright (c) 2020. If you steal this code, Satan will rain down your throat with hot acid and kill your firstborn.
 *
 * @author BobdaFett
 */

package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import obj.Assignment;
import obj.Cla;
import tab.tabClass;

/**
 * All edit methods and windows.
 * This will theoretically create all windows that are required to create or edit any object.
 * <p></p>
 * <p>This is currently in a sort of beta state - it definitely doesn't have everything needed as of right now.</p>
 */

public class fxEdit {

    static Cla cl;
    static Stage stage;
    static Assignment assignment;
    static TableView<Assignment> tableView;

    /**
     * Create a new window to edit the information of the selected class, or create one if the Cla is null.
     *
     * @param c If c is null, this will create a new object. If not, it will get all of the information and display it.
     */
    public static void start(Cla c) {
        cl = (c == null) ? new Cla() : c;

        if (stage != null && stage.isShowing())
            stage.close(); // ensures that there's only one stage - you can only edit one class at a time.
        stage = new Stage();
        stage.setTitle((c == null) ? "Create Class" : "Edit Class " + c.getName());

        Button assignment = new Button((c == null || c.getAssignments().size() == 0) ? "Create Assignments..." : "Edit Assignments...");

        Button sub = new Button((c == null) ? "Create" : "Save");
        sub.setDefaultButton(true);

        Text nt = new Text("Name:");
        TextField nta = new TextField();
        nta.setText(cl.getName());
        nta.textProperty().addListener((e, o, n) -> cl.setName(n)); // (e, o, n) = (ActionEvent, oldValue, newValue)

        assignment.setOnAction(e -> fxEditAssignment.tryAgain(null)); // TODO need to change this method - this will only allow you to create an assignment, not look at them.

        sub.setOnAction(e -> {
            if (c == null) fxMain.classes.add(cl);
            tabClass.update();
            stage.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.add(nt, 0, 0);
        gridPane.add(nta, 1, 0);
        gridPane.add(assignment, 0, 1, 2, 1);
        gridPane.add(sub, 0, 2, 2, 1);

        gridPane.add(getAssignmentWindow(), 3, 0, 1, 3); // this may be the thing that's causing the non-refresh error.

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
     * This gets the TableView from the Cla object, and then add some functionality to it.
     *
     * @return A TableView with the Assignments that are part of the the Cla.
     */
    public static TableView<Assignment> getAssignmentWindow() {

        assignment = new Assignment(); // what is this for?

        tableView = cl.getAssignmentWindow(); // get the TableView from the object that was called for this class.

        tableView.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY)
                assignment = tableView.getSelectionModel().getSelectedItem();
            if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getClickCount() == 2)
                editAssignment(assignment);
        });

        return tableView;

    }

    /**
     * Creates a Dialog window that allows the user to edit or create an Assignment.
     */
    public static void editAssignment(Assignment a) {
        Dialog dialog = new Dialog();
        dialog.setTitle((a == null) ? "Create new Assignment" : "Edit Assignment");
        dialog.setHeaderText((a == null) ? "Enter information below." : "Enter new information below.");

        Assignment editing = (a == null) ? new Assignment() : a;

        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll("Homework", "Classwork", "Quiz", "Test");

        // Assignments have a name, a grade, and a type.
        TextField name = new TextField();
        Spinner<Double> grade = new Spinner<Double>();
        grade.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 1));
        ComboBox<String> type = new ComboBox<String>(options);

        // Create an OK and Cancel button.
        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");

        // Add functionality to the boxes.
        name.textProperty()
                .addListener((e, o, n) -> {
                    assignment.setName(n);
                });
        grade.valueProperty()
                .addListener((e, o, n) -> assignment.setGrade(n));
        type.setOnAction(e -> assignment.setType(type.getSelectionModel().getSelectedItem()));

        // Create the structure of the window.
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Name: "), 0, 0);
        gridPane.add(new Label("Grade: "), 0, 1);
        gridPane.add(new Label("Type: "), 0, 2);
        gridPane.add(name, 1, 0);
        gridPane.add(grade, 1, 1);
        gridPane.add(type, 1, 2);

        // Get the content and show the window.
        dialog.getDialogPane().setContent(gridPane);
        dialog.showAndWait();
    }

}
