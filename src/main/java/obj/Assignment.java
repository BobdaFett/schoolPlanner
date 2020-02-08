package obj;

public class Assignment {

    private String name;
    private Grade grade;

    public Assignment() {
        this("");
    }

    public Assignment(String name) {
        this(name, new Grade());
    }

    public Assignment(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
