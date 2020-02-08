package obj;

import java.util.ArrayList;

public class Class {

    private String name;
    private ArrayList<Assignment> assignments;
    private String letterGrade;

    /**
     * Creates a Class object.
     */
    public Class() {
        this("");
    }

    /**
     * Creates a Class object.
     *
     * @param name The name of the Class created.
     */
    public Class(String name) {
        this(name, new ArrayList<Assignment>());
    }

    /**
     * Creates a Class object.
     *
     * @param name The name of the Class created.
     * @param assignments An ArrayList of Assignment objects.
     */
    public Class(String name, ArrayList<Assignment> assignments) {
        this(name, assignments, "");
    }

    /**
     * Creates a Class object.
     *
     * @param name The name of the Class created.
     * @param assignments An ArrayList of Assignment objects.
     * @param letterGrade The overall letter grade that you have in the class.
     */
    public Class(String name, ArrayList<Assignment> assignments, String letterGrade) {
        this.name = name;
        this.assignments = assignments;
        this.letterGrade = letterGrade;
    }

    /**
     * Get the name of the Class.
     *
     * @return Returns the name of the Class.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the Class.
     *
     * @param name The new name of the Class.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the Assignments in the Class.
     *
     * @return Returns an ArrayList<Assignment> of Assignment objects.
     */
    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    /**
     * Set the Assignments in a Class.
     *
     * @param assignment The ArrayList<Assignment> to be set.
     */
    public void setAssignments(Assignment assignment) {
        this.assignments.add(assignment);
    }

    /**
     * Get the letter grade of the Class.
     *
     * @return Returns a String of the letter grade.
     */
    public String getLetterGrade() {
        return letterGrade;
    }

    /**
     * Set the letter grade of the Class.
     *
     * @param letterGrade The new letter grade of the Class.
     */
    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

}
