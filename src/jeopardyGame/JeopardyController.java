package jeopardyGame;

/**
 * @author trinemedina
 *
 * This is the controller class for the Jeopardy game.
 * It compares the players answer's to the correct answers and increases the score.
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JeopardyController {

	private JeopardyModel model;
	private JeopardyView view;
	private int playerScore = 0;


	JeopardyController(JeopardyModel model, JeopardyView view) {

		this.model = model;
		this.view = view;

		this.view.addAnswerListener(new AnswerListener());
	}


	class AnswerListener implements ActionListener {

		/**
		 * This method compares the player's answer against the correct answer
		 *
		 * @param question
		 * @param answer
		 */
		public void compareAnswers(String question, String answer) {

			String playerAnswer = view.getPlayerAnswer(question);

			try {

				if (playerAnswer.length() == 0) {
					throw new Exception();
				}

				if (playerAnswer.equalsIgnoreCase(answer)) {

					view.correctAnswer();

					playerScore += 100;

					view.setPlayerScore(playerScore);

				} else {

					view.incorrectAnswer();
				}

			} catch (Exception ex) {

			view.displayError("Please enter an answer to continue.");
		}
	}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == view.geographyQuestion100) {
				compareAnswers(model.geographyQuestion(), model.geographyAnswer());
			}

			if (e.getSource() == view.theOscarsQuestion100) {
					compareAnswers(model.oscarsQuestion(), model.oscarsAnswer());
			}

			if (e.getSource() == view.scienceQuestion100) {
				compareAnswers(model.scienceQuestion(), model.scienceAnswer());
			}
		}
	}
}






