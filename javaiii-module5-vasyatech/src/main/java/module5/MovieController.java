package module5;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MovieController {
	MovieQueries movieQueries;
	
	@FXML
    private Button resetButton;

    @FXML
    private Button addButton;

    @FXML
    private TableView<Movie> movieGrid;

    @FXML
    private TextField nameField;

    @FXML
    private TextField ratingField;

    @FXML
    private TextField descriptionField;
	
    @FXML
    void resetButtonPressed(ActionEvent event) throws SQLException {
    	movieQueries.resetExampleDatabase();
    	refreshTable();
    }

    @FXML
    void addButtonPressed(ActionEvent event) throws SQLException {
    	if (nameField.getText().isEmpty() || ratingField.getText().isEmpty() || descriptionField.getText().isEmpty()) {
    		showError("Values required");
    		return;
    	}
    	
    	movieQueries.addMovie(nameField.getText(), Integer.parseInt(ratingField.getText()), descriptionField.getText());
    	refreshTable();
    }
    
    @FXML
    void initialize() throws SQLException{
    	show();
    }
    
    private void refreshTable() throws SQLException {
    	ObservableList<Movie> movies = movieQueries.getMovies();
    	movieGrid.setItems(movies);
    }
    
    private void showError(String message) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Error Dialog");
    	alert.setHeaderText("Error:");
    	alert.setContentText(message);
    	alert.showAndWait();
    }
    
    public void show() throws SQLException {
		movieQueries = new MovieQueries();

		TableColumn<Movie,String> nameCol = new TableColumn<Movie,String>("Name");
		 nameCol.setCellValueFactory(new PropertyValueFactory("name"));
		 
		TableColumn<Movie,Integer> ratingCol = new TableColumn<Movie,Integer>("Rating");
		ratingCol.setCellValueFactory(new PropertyValueFactory("rating"));
			
		TableColumn<Movie,String> descriptionCol = new TableColumn<Movie,String>("Description");
		 descriptionCol.setCellValueFactory(new PropertyValueFactory("description"));
    	 
    	 movieGrid.getColumns().setAll(nameCol, ratingCol, descriptionCol);
    	 
    	 refreshTable();
    }
}
