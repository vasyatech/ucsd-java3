package counting_words;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class Controller {

	
	private FileOperations fileOperations;
	
	@FXML
    private TextArea resultText;

    @FXML
    private Button countButton;

    @FXML
    private Button addButton;

    @FXML
    private TextArea filesText;
    
    @FXML
    void addButtonPressed(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
		if (fileOperations == null) {
			fileOperations = new FileOperations();
		}
		if (selectedFile != null) {
			fileOperations.addFile(selectedFile);
			filesText.appendText(selectedFile.getName() + System.lineSeparator());
		} 
    }

    @FXML
    void countButtonPressed(ActionEvent event) throws IOException {
    	resultText.clear();
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for (File file : fileOperations.getFileList()) 
		{ 
			executor.execute(new Runnable() {
				public void run() {
					try {
						resultText.appendText(CountWords.getWordsNumber(file));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}
		executor.shutdown();
    }
}
