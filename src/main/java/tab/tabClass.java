package tab;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import obj.Cla;
import util.fxEditAssignment;
import util.fxMain;

import static util.fxMain.selected;

import static util.fxMain.classes;

/**
 * This is the Tab that displays all of the Classes.
 * For now it's just a simple TableView.
 *
 * @author BobdaFett
 */
public class tabClass {
    
    public static TableView<Cla> tableView;
    
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
        
        tableView.prefHeightProperty().bind(fxMain.stage.heightProperty());
        tableView.prefWidthProperty().bind(fxMain.stage.widthProperty());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        tableView.setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getButton() == MouseButton.PRIMARY)
                selected = tableView.getSelectionModel().getSelectedItem();
            if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getClickCount() == 2)
                fxEditAssignment.start(selected);
        });
        
        GridPane gridPane = new GridPane();
        gridPane.add(tableView,0,0);
        
        t.setContent(gridPane);
        t.setClosable(false);
        
        return t;
    }
    
    public static void update() {
        tableView.refresh();
    }
    
}
