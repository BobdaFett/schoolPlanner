/*
 * Copyright (c) 2020. If you steal this code, Satan will rain down your throat with hot acid and kill your firstborn.
 */

package util;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import obj.Assignment;

import java.util.Optional;

import static util.fxEditClass.cl;

public class fxEditAssignment {

    public static Assignment assignment;

    // TODO This class needs a way to use the buttons that were created - they don't currently do anything and I don't know why
    // TODO This class can only currently create a class because of fxEditClass - this will need to be changed to be
    //  able to select what you can edit.

    // TODO I'm thinking that I could create this method (essentially) as part of a class.

    @SuppressWarnings("unchecked")
    public static void start(Assignment a) {
        
        assignment = (a == null) ? new Assignment() : a;

        int[][] something = new int[2][2];
        for(int[] some : something) {

        }

        Dialog add = new Dialog();

        add.setTitle((a == null) ? "Create Assignment" : "Edit Assignment");

        Label content = new Label("Enter information below.");
        TextField nameText  = new TextField(assignment.getName());
        nameText.textProperty()
                .addListener((e, o, n) -> assignment.setName(n));
        Spinner<Double> gradeText = new Spinner<Double>();
        gradeText.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,100,1)); // start at 0, max of 100, increment by 1
        gradeText.valueProperty()
                .addListener((e, o, n) -> assignment.setGrade(n));
        gradeText.setEditable(true);
        TextField typeText = new TextField();

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Enter information below."), 0, 0);
        gridPane.add(new Label("Name: "), 0, 1);
        gridPane.add(new Label("Grade: "), 0, 2);
        gridPane.add(new Label("Type: "), 0, 3);

        gridPane.add(nameText, 1, 1);
        gridPane.add(gradeText, 1, 2);
        gridPane.add(typeText, 1, 3);

        gridPane.setHgap(7);
        gridPane.setVgap(7);
        GridPane.setHalignment(content, HPos.CENTER);

        add.getDialogPane().setContent(gridPane);

        ButtonType buttonOK = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        add.getDialogPane()
                .getButtonTypes()
                .addAll(buttonOK, buttonCancel);

        //I don't think that this is the right way to do this...?
        // TODO EDIT: This is definitely not the right way to do this.
        Optional<ButtonType> sub = add.showAndWait();
        if (sub.get() == ButtonType.OK) {
            if (a == null) cl.addAssignment(assignment);
            cl.refresh();
            fxEditClass.update();
        } else add.close();

    }

    public static void tryAgain(Assignment a) {

        assignment = (a == null) ? new Assignment() : a;

        Dialog<Result> test = new Dialog<Result>();

        test.setTitle("WIP - Edit Assignment");
        test.setHeaderText("Enter all of the information below.");

        ButtonType sub = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);
        test.getDialogPane().getButtonTypes().addAll(sub, ButtonType.CANCEL);

        Node button = test.getDialogPane().lookupButton(sub);
        button.setDisable(true); // disabled by default

        TextField nameText = new TextField(assignment.getName());
        nameText.textProperty()
                .addListener((e, o, n) -> {
                    assignment.setName(n);
                    button.setDisable(n.trim().isEmpty()); // enabled if there is text in this box.
                });
        Spinner<Double> gradeText = new Spinner<Double>();
        gradeText.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 1)); // start at 0, max of 100, increment by 1
        gradeText.valueProperty()
                .addListener((e, o, n) -> assignment.setGrade(n));
        gradeText.setEditable(true);
        TextField typeText = new TextField();

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Enter information below."), 0, 0);
        gridPane.add(new Label("Name: "), 0, 1);
        gridPane.add(new Label("Grade: "), 0, 2);
        gridPane.add(new Label("Type: "), 0, 3);

        gridPane.add(nameText, 1, 1);
        gridPane.add(gradeText, 1, 2);
        gridPane.add(typeText, 1, 3);

        gridPane.setHgap(7);
        gridPane.setVgap(7);

        test.getDialogPane().setContent(gridPane);
        Platform.runLater(nameText::requestFocus);

        // only happens after the window is closed? Honestly no idea.
        // TODO Is there a way that I can change the name, grade, and type in real time? This seems a little clunky.
        test.setResultConverter(e -> {
            if (e == sub) return new Result(nameText.getText(), gradeText.getValue(), typeText.getText());
            return null;
        });

        Optional<Result> result = test.showAndWait();
        result.ifPresent(e -> {
            System.out.println("Name = " + nameText.getText() + " Type = " + typeText.getText() + " Grade = " + gradeText.getValue());
            System.out.println("This seems to work, updating TableView now...");
            cl.refresh(); // hopefully this works. it didn't
            fxEditClass.refresh(); // hopefully THIS works.
        });

    }

    // temp object to store results easily.
    // This is really only if the results aren't automatically saving, and for the testing Dialog.
    static class Result {
        String name;
        double grade;
        String type;

        Result(String name, double grade, String type) {
            this.name = name;
            this.grade = grade;
            this.type = type;
        }
    }

}
