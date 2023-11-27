import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EasyQuiz extends Quiz {
        private Timer timer;
        private int secondsPassed;

        public EasyQuiz(JFrame frame, Dimension screenSize, QuizManager quizManager) {
                super(frame, screenSize, quizManager);
        }

        @Override
        public void start() {
                int screenWidth = (int) screenSize.getWidth();
                int screenHeight = (int) screenSize.getHeight();

                JLabel questionLabel = new JLabel(" A proposition is a declarative sentence that is either true or false, but not both. (True/False)");
                questionLabel.setFont(new Font("Arial", Font.PLAIN, 24));
                questionLabel.setBounds(screenWidth / 4, (screenHeight / 6) + 100, 500, 50);

                JLabel questionLabel2 = new JLabel(": P ∧ q, means p and q. (True/False)");
                questionLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
                questionLabel2.setBounds(screenWidth / 4, (screenHeight / 6) + 100, 500, 100);

                JButton trueButton = new JButton("True");
                JButton falseButton = new JButton("False");


                trueButton.setBounds(screenWidth / 4, (screenHeight / 6) + 150, 100, 50);
                falseButton.setBounds(screenWidth / 4 + 120, (screenHeight / 6) + 150, 100, 50);

                trueButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                handleAnswer(true);
                        }
                });

                falseButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                handleAnswer(false);
                        }
                });

                JButton returnButton = new JButton("Return");
                returnButton.setBounds(screenWidth / 8, screenHeight - (screenHeight / 5), 150, 50);

                // Adding components to the frame
                frame.add(questionLabel);
                frame.add(questionLabel2);
                frame.add(trueButton);
                frame.add(falseButton);
                frame.add(returnButton);

                // Return button action listener
                returnButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                quizManager.startQuiz();
                        }
                });

                // Timer logic
                timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                secondsPassed++;
                        }
                });
                timer.start(); // Start the timer when the question is displayed
        }

        private void handleAnswer(boolean userAnswer) {
                // Stop the timer
                timer.stop();

                // Implement logic to check if the user's answer is correct
                boolean isCorrect = checkAnswer(userAnswer);

                // Display the results
                String resultMessage = isCorrect ? "Correct" : "Incorrect";
                JOptionPane.showMessageDialog(frame, resultMessage);

                // Proceed to the next question or display final results
                quizManager.showTimeTaken();
        }

        private boolean checkAnswer(boolean userAnswer) {
                // Replace this with the actual correct answer for the question
                boolean correctAnswer = true;

                // Check if the user's answer is correct
                return userAnswer == correctAnswer;
        }
}

