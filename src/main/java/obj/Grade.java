package obj;

public class Grade {

    private String letter;
    private double number;

    public Grade() {
        this("");
    }

    public Grade(String letter) {
        this(letter, 0.0);
    }

    public Grade(String letter, double number) {
        this.letter = letter;
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
