package tab;

import javafx.scene.control.Tab;

/**
 * This is the Tab that displays the schedule view.
 *
 * @author BobdaFett
 */
public class tabDay {
    
    public static Tab tab() {
        Tab t = new Tab("Schedule");
    
        t.setClosable(false);
        
        return t;
    }
    
}
