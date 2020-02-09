package tab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

/**
 * This collects all the tabs together and is used to return them in fxMain.
 *
 * @author BobdaFett
 */

public class tabs {
    public static ObservableList<Tab> getTabs() {
        ObservableList<Tab> tabs = FXCollections.observableArrayList();
        tabs.add(tabClass.tab());
        return tabs;
    }
}
