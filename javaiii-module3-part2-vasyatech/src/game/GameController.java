package game;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GameController {

    @FXML
    private TextArea resultText;

    @FXML
    private Button paperButton;

    @FXML
    private Button rockButton;

    @FXML
    private Button scissorsButton;

    @FXML
    void paperButtonPressed(ActionEvent event) {
    	play(Turn.PAPER);
    }

    @FXML
    void rockButtonPressed(ActionEvent event) {
    	play(Turn.ROCK);
    }

    @FXML
    void scissorsButtonPressed(ActionEvent event) {
    	play(Turn.SCICCORS);
    }
    
    void play(Turn playerTurn) {
    	GameModel gameModel = new GameModel();
    	gameModel.calculateOutcome(playerTurn);
    	resultText.setText(gameModel.getOutcome());
    }

}
