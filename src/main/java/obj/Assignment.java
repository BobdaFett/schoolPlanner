package obj;

public class Assignment {

    private String name;
    private Grade grade;
    private String type;

    public Assignment() {
        this("");
    }

    public Assignment(String name) {
        this(name, new Grade());
    }

    public Assignment(String name, Grade grade) {
        this(name, grade, "");
    }
    
    public Assignment(String name, Grade grade, String type) {
        this.name = name;
        this.grade = grade;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade.getGrade();
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
