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
        tabs.addAll(tabClass.tab(), tabDay.tab());
        return tabs;
    }
}
