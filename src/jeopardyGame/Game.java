package jeopardyGame;

/**
 *
 * @author trinemedina
 *
 *         This class contains the main method to run the Jeopardy game.
 *
 */

public class Game {

	public static void main(String[] args) {

		JeopardyView view = new JeopardyView();
		JeopardyModel model = new JeopardyModel();

		JeopardyController controller = new JeopardyController(model, view);

		view.setVisible(true);

	}
}


