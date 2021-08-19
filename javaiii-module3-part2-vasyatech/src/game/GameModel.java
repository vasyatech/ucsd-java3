package game;

import java.util.Random;

public class GameModel {

	private String outcome;
	
	private Turn computerTurn() {
		Random rand = new Random();
		return Turn.get(rand.nextInt(3));
	}
	
	public void calculateOutcome(Turn playerTurn){
		Turn computerTurn = computerTurn();
		String turns = "You: " + playerTurn.toString() + System.lineSeparator() + "Computer: " + computerTurn.toString() + System.lineSeparator();
		if (playerTurn.getNumVal() == computerTurn.getNumVal()) {
			outcome = turns + "Outcome: TIES"; 
		} else {
			if(((playerTurn.getNumVal()-computerTurn.getNumVal()+3)%3==1)) {
				outcome = turns + "Outcome: YOU WON! :-)";
			}
			else {
				outcome = turns + "Outcome: YOU LOSE... :-(";
			}
		}
	}
	
	public String getOutcome() {
		return outcome;
	}
}
