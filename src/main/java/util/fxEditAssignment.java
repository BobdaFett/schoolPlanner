package util;

import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import obj.Assignment;
import obj.Cla;

import java.util.Optional;

import static util.fxEditClass.cl; // This makes it so that the method will only work off of what fxEditClass is editing.

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
        Optional<ButtonType> sub = add.showAndWait();
        if(sub.get() == ButtonType.OK) {
            if(a == null) cl.addAssignment(assignment);
            fxEditClass.update();
        }
        else add.close();

    }

}
