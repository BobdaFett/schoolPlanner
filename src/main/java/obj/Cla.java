package obj;

import java.util.ArrayList;

public class Cla {
    
    private String name;
    private ArrayList<Assignment> assignments;
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
        this(name, new ArrayList<Assignment>());
    }
    
    /**
     * Creates a cla object.
     *
     * @param name The name of the cla created.
     * @param assignments An ArrayList of Assignment objects.
     */
    public Cla(String name, ArrayList<Assignment> assignments) {
        this(name, assignments, "");
    }
    
    /**
     * Creates a cla object.
     *
     * @param name The name of the cla created.
     * @param assignments An ArrayList of Assignment objects.
     * @param letterGrade The overall letter grade that you have in the cla.
     */
    public Cla(String name, ArrayList<Assignment> assignments, String letterGrade) {
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
    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }
    
    /**
     * Set the Assignments in a cla.
     *
     * @param assignment The ArrayList<Assignment> to be set.
     */
    public void setAssignments(Assignment assignment) {
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
     * Set the letter grade of the cla.
     *
     * @param letterGrade The new letter grade of the cla.
     */
    public void setGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
    
}
