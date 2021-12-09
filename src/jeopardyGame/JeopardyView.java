package jeopardyGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @TrineMedina
 *
 *              This Class creates the UI for the Jeopardy game.
 */

public class JeopardyView extends JFrame {


	JFrame frame = new JFrame();
	JButton geographyQuestion100 = new JButton("100");
	JButton theOscarsQuestion100 = new JButton("100");
	JButton scienceQuestion100 = new JButton("100");
	JLabel geographyLabel = new JLabel("GEOGRAPHY", JLabel.CENTER);
	JLabel theOscarsLabel = new JLabel("THE OSCARS", JLabel.CENTER);
	JLabel scienceLabel = new JLabel("SCIENCE", JLabel.CENTER);
	JLabel playerScoreLabel = new JLabel("Player score:", JLabel.CENTER);
	JTextArea totalScore = new JTextArea(1, 10);


		public JeopardyView() {

			JPanel questionPanel = new JPanel();
			JPanel scorePanel = new JPanel();

			this.setTitle("JEOPARDY!!");
			this.setLayout(new GridLayout(2, 0));
			this.add(questionPanel);
			this.add(scorePanel);
			this.setSize(500, 200);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			questionPanel.setBackground(Color.BLUE);
			questionPanel.setLayout(new GridLayout(2, 3));
			questionPanel.add(geographyLabel);
			questionPanel.add(theOscarsLabel);
			questionPanel.add(scienceLabel);
			questionPanel.add(geographyQuestion100);
			questionPanel.add(theOscarsQuestion100);
			questionPanel.add(scienceQuestion100);

			scorePanel.setBackground(Color.BLUE);
			scorePanel.add(playerScoreLabel);
			scorePanel.add(totalScore);

			geographyLabel.setFont(new Font(null, Font.BOLD, 14));
			geographyLabel.setForeground(Color.WHITE);

			theOscarsLabel.setFont(new Font(null, Font.BOLD, 14));
			theOscarsLabel.setForeground(Color.WHITE);

			scienceLabel.setFont(new Font(null, Font.BOLD, 14));
			scienceLabel.setForeground(Color.WHITE);

			playerScoreLabel.setFont(new Font(null, Font.BOLD, 14));
			playerScoreLabel.setForeground(Color.WHITE);
		}

		/**
		 * This method takes the player's answer and returns it
		 *
		 * @param question
		 * @return playerAnswer
		 */
		public String getPlayerAnswer(String question) {

			String playerAnswer = JOptionPane.showInputDialog(this, question);

			return playerAnswer;
		}

		/**
		 * This method displays a message when the answer is correct.
		 */
		public void correctAnswer() {

			JOptionPane.showMessageDialog(this, "Congratulations! That is the correct answer!");
		}


		/**
		 * This method displays a message when the answer is incorrect.
		 */
		public void incorrectAnswer() {

			JOptionPane.showMessageDialog(this, "I'm sorry, that is not the correct answer.");
		}


		/**
		 * This method add's the player's score to the totalScore text field.
		 *
		 * @param score as an int
		 */
		public void setPlayerScore(int score) {

			totalScore.setText(Integer.toString(score));
		}


		/**
		 * This method adds an action listener to each of the buttons. This method is
		 * called in the JeopardyController class.
		 *
		 * @param listenForButton
		 */
		public void addAnswerListener(ActionListener listenForButton) {

			geographyQuestion100.addActionListener(listenForButton);
			theOscarsQuestion100.addActionListener(listenForButton);
			scienceQuestion100.addActionListener(listenForButton);
		}

		/**
		 * This method displays an error message when no answer is entered.
		 *
		 * @param errorMessage
		 */
		public void displayError(String errorMessage) {

			JOptionPane.showMessageDialog(this, errorMessage);
		}
}
