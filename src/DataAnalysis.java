import javax.swing.*;
import java.awt.*;
import java.util.List;
class QuizQuestion{
	String question;
    String[] options;
    int correctAnswer;
    int userAnswer;
}
public class DataAnalysis {
	 private List<QuizQuestion> quizData;
	    private int totalQuestions;
	    private int correctAnswers;

	    // Constructor takes the quiz data as input
	    public DataAnalysis(List<QuizQuestion> quizData) {
	        this.quizData = quizData;
	        this.totalQuestions = quizData.size();
	        this.correctAnswers = 0;
	        QuizData(); // observe the quiz data to calculate correct answers
	        createAndShowGUI(); // Create and display the GUI
	    }

	    // observe quiz data to calculate correct answers
	    private void QuizData() {
	        for (QuizQuestion question : quizData) {
	            if (question.userAnswer == question.correctAnswer) {
	                correctAnswers++;
	            }
	        }
	    }

	    // Create and display the GUI
	    private void createAndShowGUI() {
	        // Create a JFrame (window) with BorderLayout
	        JFrame frame = new JFrame("Quiz Data Analysis");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Create labels to display information
	        JLabel scoreLabel = new JLabel("Your Score: " + correctAnswers + " out of " + totalQuestions);
	        JLabel totalQuestionsLabel = new JLabel("Total Questions: " + totalQuestions);
	        JLabel correctAnswersLabel = new JLabel("Correct Answers: " + correctAnswers);
	        JLabel percentageLabel = new JLabel("Percentage: " + ((double) correctAnswers / totalQuestions * 100) + "%");

	        // Create a JPanel with GridLayout to arrange labels vertically
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(4, 1));
	        panel.add(scoreLabel);
	        panel.add(totalQuestionsLabel);
	        panel.add(correctAnswersLabel);
	        panel.add(percentageLabel);

	        // Add panel to the centre of JFrame
	        frame.add(panel, BorderLayout.CENTER);

	        // Adjust the JFrame size based on components
	        frame.pack();

	        // Make JFrame visible
	        frame.setVisible(true);
	    }

	    // Main method (entry point of the program)
	    public static void main(String[] args) {
	        // Sample quiz data
	        // List<QuizQuestion> quizData = populateQuizData();
	        // new QuizDataAnalysisApp(quizData);
	    }
}