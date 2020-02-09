package tab;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import obj.Cla;

import static util.fxMain.classes;

/**
 * This is the Tab that displays all of the Classes.
 * For now it's just a simple TableView.
 *
 * @author BobdaFett
 */
public class tabClass {
    
    private static TableView<Cla> tableView;
    
    @SuppressWarnings("unchecked")
    public static Tab tab() {
        Tab t = new Tab("Classes");
    
        tableView  = new TableView<Cla>(classes);
        tableView.setPlaceholder(new Label("This is a test"));
    
        TableColumn<Cla, String> name = new TableColumn<Cla, String>("Name");
        name.setCellValueFactory(new PropertyValueFactory<Cla, String>("name"));
    
        TableColumn<Cla, String> grade = new TableColumn<Cla, String>("Grade");
        grade.setCellValueFactory(new PropertyValueFactory<Cla, String>("grade"));
        
        tableView.getColumns().addAll(name, grade);
        
        GridPane gridPane = new GridPane();
        gridPane.add(tableView,0,0);
        
        t.setContent(gridPane);
        
        return t;
    }
    
}
