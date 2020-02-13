package util;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import obj.Assignment;
import obj.Cla;
import obj.Grade;

public class fxEditAssignment {

    public static Assignment assignment;
    
    @SuppressWarnings("unchecked")
    public static void start(Assignment a, Cla cla) {
        
        assignment = (a == null) ? new Assignment() : a;
        
        Stage stage = new Stage();
    
        TableView<Assignment> assignmentTableView = new TableView<Assignment>(cla.getAssignments());
        TableColumn<Assignment, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<Assignment, String>("name"));
        TableColumn<Assignment, String> type = new TableColumn<>("Type");
        type.setCellValueFactory(new PropertyValueFactory<Assignment, String>("type"));
        TableColumn<Assignment, String> grade = new TableColumn<>("Grade");
        grade.setCellValueFactory(new PropertyValueFactory<Assignment, String>("grade"));
        
        assignmentTableView.getColumns().addAll(name, type, grade);
        
        Button submit = new Button("Submit");
        
        GridPane gridPane = new GridPane();
        gridPane.add(assignmentTableView, 0, 0);
        
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public void createAssignment() {
        Dialog add = new Dialog();
        
        add.setTitle("Create Assignment");
        add.setContentText("Enter information below.");
        
        Label name = new Label("Name: ");
        Label grade = new Label("Grade: ");
        Label type = new Label("Type: ");
        TextField nameText  = new TextField();
        Spinner<Integer> gradeText = new Spinner<Integer>();
        TextField typeText = new TextField();
        
        GridPane gridPane = new GridPane();
        gridPane.add(name, 0, 0);
        gridPane.add(grade, 0, 1);
        gridPane.add(type, 0, 2);
        
        gridPane.add(nameText, 1, 0);
        gridPane.add(gradeText, 1, 1);
        gridPane.add(typeText, 1, 2);
        add.getDialogPane().setContent(gridPane);
        
        ButtonType buttonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonType1 = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        
        add.showAndWait();
        
    }

}
