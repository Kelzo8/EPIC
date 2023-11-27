import javax.swing.*;
import java.awt.*;

class QuizManager {
    private JFrame frame;
    private Timer timer;
    private int secondsPassed;

    public QuizManager() {
        this.frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void startQuiz() {
        DifficultyMenu difficultyMenu = new DifficultyMenu(frame, frame.getSize(), this);
        difficultyMenu.show();
    }

    public void startQuizWithDifficulty(int difficulty) {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        Quiz quiz;
        switch (difficulty) {
            case 0:
                quiz = new EasyQuiz(frame, frame.getSize(), this);
                break;
            case 1:
                quiz = new IntermediateQuiz(frame, frame.getSize(), this);
                break;
            case 2:
                quiz = new AdvancedQuiz(frame, frame.getSize(), this);
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty level");
        }

        quiz.start();
    }

    public void showTimeTaken() {
        int minutes = secondsPassed / 60;
        int seconds = secondsPassed % 60;
        String timeTaken = String.format("Time taken: %d minutes %d seconds", minutes, seconds);
        JOptionPane.showMessageDialog(frame, timeTaken, "Timer", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showRandomQuestions() {
        JOptionPane.showMessageDialog(frame, "Displaying random questions.", "Random Questions", JOptionPane.INFORMATION_MESSAGE);
    }
}

abstract class Quiz {
    protected JFrame frame;
    protected Dimension screenSize;
    protected QuizManager quizManager;

    public Quiz(JFrame frame, Dimension screenSize, QuizManager quizManager) {
        this.frame = frame;
        this.screenSize = screenSize;
        this.quizManager = quizManager;
    }

    public abstract void start();
}