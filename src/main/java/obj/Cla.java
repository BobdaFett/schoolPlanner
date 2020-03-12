/*
 * Copyright (c) 2020. If you steal this code, Satan will rain down your throat with hot acid and kill your firstborn.
 */

package obj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Cla {
    
    private String name;
    private ObservableList<Assignment> assignments = FXCollections.observableArrayList();
    private String letterGrade;
    private static TableView<Assignment> tableView;
    
    /**
     * Creates a cla object.
     */
    public Cla() {
        this("");
    }
    
    /**
     * Creates a cla object.
     * Removed calls to other constructors - seems to be a possible source of bugs.
     *
     * @param name The name of the cla created.
     */
    public Cla(String name) {
        this.name = name;
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
     * Set the list of Assignments in a cla.
     *
     * @param assignments The ObservableList<Assignment> to be set.
     */
    public void setAssignments(ObservableList<Assignment> assignments) {
        this.assignments = assignments;
    }

    /**
     * Add an Assignment to the list of Assignments.
     * @param assignment
     */
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


    /**
     * <p>This returns a full TableView that displays all of the assignments that have been created in this specific class object.</p>
     * <p>As of right now, nothing seems to work, it just displays a TableView that has the columns but no Assignments.</p>
     *
     * <p>I'll attempt to keep using this method, but it may be a possible bug.</p>
     *
     * <i>Maybe this isn't the best idea, but it should work.</i>
     *
     * @return
     */
    public TableView<Assignment> getAssignmentWindow() {

        Assignment selected = new Assignment();

        tableView = new TableView<Assignment>(getAssignments());

        TableColumn<Assignment, String> name = new TableColumn<Assignment, String>("Name");
        name.setCellValueFactory(new PropertyValueFactory<Assignment, String>("name"));

        TableColumn<Assignment, String> type = new TableColumn<Assignment, String>("Type");
        type.setCellValueFactory(new PropertyValueFactory<Assignment, String>("type"));

        TableColumn<Assignment, String> grade = new TableColumn<Assignment, String>("Grade");
        grade.setCellValueFactory(new PropertyValueFactory<Assignment, String>("grade"));

        tableView.getColumns().addAll(name, type, grade);

        return tableView;

    }

    public static void refresh() {
        tableView.refresh();
    }
    
    /**
     * Set the letter grade of the cla.
     *
     * @param letterGrade The new letter grade of the cla.
     */

    // TODO THIS METHOD IS NEVER BEING RUN
    public void setGrade(String letterGrade) {
        this.letterGrade = letterGrade;

        System.out.println("You got to this point.");
    }
    
}
