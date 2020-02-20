package obj;

public class Assignment {

    private String name;
    private double grade;
    private String type;

    public Assignment() {
        this("");
    }

    public Assignment(String name) {
        this(name, 0.0);
    }

    public Assignment(String name, Double grade) {
        this(name, grade, "");
    }
    
    public Assignment(String name, Double grade, String type) {
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

    public Double getGrade() {
        return this.grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
