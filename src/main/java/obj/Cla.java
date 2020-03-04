package obj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import util.fxEditAssignment;

import java.util.ArrayList;
import java.util.List;

public class Cla {
    
    private String name;
    private ObservableList<Assignment> assignments = FXCollections.observableArrayList();
    private String letterGrade;
    
    /**
     * Creates a cla object.
     */
    public Cla() {
        this("");
    }
    
    /**
     * Creates a cla object.
     *
     * @param name The name of the cla created.
     */
    public Cla(String name) {
        this(name, FXCollections.observableArrayList());
    }
    
    /**
     * Creates a cla object.
     *
     * @param name The name of the cla created.
     * @param assignments An ArrayList of Assignment objects.
     */
    public Cla(String name, ObservableList<Assignment> assignments) {
        this(name, assignments, "");
    }
    
    /**
     * Creates a cla object.
     *
     * @param name The name of the cla created.
     * @param assignments An ArrayList of Assignment objects.
     * @param letterGrade The overall letter grade that you have in the cla.
     */
    public Cla(String name, ObservableList<Assignment> assignments, String letterGrade) {
        this.name = name;
        this.assignments = assignments;
        this.letterGrade = letterGrade;
    }
    
    /**
     * Get the name of the cla.
     *
     * @return Returns the name of the cla.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the name of the cla.
     *
     * @param name The new name of the cla.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the Assignments in the cla.
     *
     * @return Returns an ArrayList<Assignment> of Assignment objects.
     */
    public ObservableList<Assignment> getAssignments() {
        return assignments;
    }
    
    /**
     * Set the Assignments in a cla.
     *
     * @param assignment The ArrayList<Assignment> to be set.
     */
    public void setAssignments(ObservableList<Assignment> assignment) {
        this.assignments = assignment;
    }
    
    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }
    
    /**
     * Get the letter grade of the cla.
     *
     * @return Returns a String of the letter grade.
     */
    public String getGrade() {
        return letterGrade;
    }

    public TableView getAssignmentWindow() {

        Assignment selected = new Assignment();

        TableView<Assignment> tableView = new TableView<Assignment>(getAssignments());

        TableColumn<Assignment, String> name = new TableColumn<Assignment, String>("Name");
        name.setCellValueFactory(new PropertyValueFactory<Assignment, String>("name"));

        TableColumn<Assignment, String> type = new TableColumn<Assignment, String>("Type");
        type.setCellValueFactory(new PropertyValueFactory<Assignment, String>("type"));

        TableColumn<Assignment, String> grade = new TableColumn<Assignment, String>("Grade");
        grade.setCellValueFactory(new PropertyValueFactory<Assignment, String>("grade"));

        tableView.getColumns().addAll(name, type, grade);

        return tableView;

    }
    
    /**
     * Set the letter grade of the cla.
     *
     * @param letterGrade The new letter grade of the cla.
     */
    public void setGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
    
}
