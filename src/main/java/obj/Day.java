package obj;

import java.util.ArrayList;

public class Day {

    private String name;
    private int numClasses;
    private ArrayList<Class> classes;

    public Day() {
        this("");
    }

    public Day(String name) {
        this(name, 0);
    }

    public Day(String name, int numClasses) {
        this(name, numClasses, new ArrayList<Class>());
    }

    public Day(String name, int numClasses, ArrayList<Class> classes) {
        this.name = name;
        this.numClasses = numClasses;
        this.classes = classes;
    }

}
