package util;

import javafx.application.Application;
import javafx.stage.Stage;
import obj.Day;

public class fxEditSchedule {
    
    private static Day day;
    
    public void start(Day d) {
        
        day = (d == null) ? new Day() : d;
        
        
        
    }
    
}