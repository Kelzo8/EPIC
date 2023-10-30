import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreAnalyzerGUI extends JFrame {
    private JLabel medianLabel, meanLabel, derivativeLabel;
    private JTextArea outputTextArea;

    // Constructor for the GUI
    public ScoreAnalyzerGUI() {
        super("Score Analyzer"); // Set the title of the window

        // Initialize labels for displaying median, mean, and derivative
        medianLabel = new JLabel("Median: ");
        meanLabel = new JLabel("Mean: ");
        derivativeLabel = new JLabel("Derivative: ");

        // Initialize a text area for displaying scores and analysis output
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false); // Make the text area read-only

        // Create a button to trigger score analysis
        JButton analyzeButton = new JButton("Analyze Scores");
        analyzeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                analyzeScores(); // Call the analyzeScores() method when the button is clicked
            }
        });

        // Create panels to organize components in the window
        JPanel inputPanel = new JPanel();
        inputPanel.add(analyzeButton); // Add the analyze button to the input panel

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new GridLayout(4, 1)); // Set layout for the output panel
        outputPanel.add(medianLabel); // Add median label to the output panel
        outputPanel.add(meanLabel);   // Add mean label to the output panel
        outputPanel.add(derivativeLabel); // Add derivative label to the output panel
        outputPanel.add(outputTextArea);  // Add output text area to the output panel

        // Set the layout for the main frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH); // Add input panel to the top of the frame
        add(outputPanel, BorderLayout.CENTER); // Add output panel to the center of the frame

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        pack(); // Pack components inside the frame
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
    }

    // Method to analyze scores from the CSV file
    private void analyzeScores() {
        // ArrayLists to store scores for Niall, Kelly, and James
        ArrayList<Integer> niallScores = new ArrayList<>();
        ArrayList<Integer> kellyScores = new ArrayList<>();
        ArrayList<Integer> jamesScores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/User/OneDrive - University of Limerick/Desktop/login.csv.txt"))) {
            String line;
            // Read each line from the CSV file
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 4) {
                    // Parse scores for Niall, Kelly, and James and add them to respective ArrayLists
                    int niallScore = Integer.parseInt(tokens[1]);
                    int kellyScore = Integer.parseInt(tokens[2]);
                    int jamesScore = Integer.parseInt(tokens[3]);

                    niallScores.add(niallScore);
                    kellyScores.add(kellyScore);
                    jamesScores.add(jamesScore);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort scores in ascending order
        Collections.sort(niallScores);
        Collections.sort(kellyScores);
        Collections.sort(jamesScores);

        // Calculate median, mean, and derivative for each individual
        int niallMedian = calculateMedian(niallScores);
        int kellyMedian = calculateMedian(kellyScores);
        int jamesMedian = calculateMedian(jamesScores);

        double niallMean = calculateMean(niallScores);
        double kellyMean = calculateMean(kellyScores);
        double jamesMean = calculateMean(jamesScores);

        int niallDerivative = calculateDerivative(niallScores);
        int kellyDerivative = calculateDerivative(kellyScores);
        int jamesDerivative = calculateDerivative(jamesScores);

        // Update labels with analysis results
        medianLabel.setText("Median: Niall-" + niallMedian + ", Kelly-" + kellyMedian + ", James-" + jamesMedian);
        meanLabel.setText("Mean: Niall-" + niallMean + ", Kelly-" + kellyMean + ", James-" + jamesMean);
        derivativeLabel.setText("Derivative: Niall-" + niallDerivative + ", Kelly-" + kellyDerivative + ", James-" + jamesDerivative);

        // Display scores and analysis results in the text area
        outputTextArea.setText("Niall Scores: " + niallScores.toString() + "\n" +
                                "Kelly Scores: " + kellyScores.toString() + "\n" +
                                "James Scores: " + jamesScores.toString());
    }

    // Method to calculate the median of a list of scores
    private int calculateMedian(ArrayList<Integer> scores) {
        int size = scores.size();
        if (size % 2 == 0) {
            return (scores.get(size / 2 - 1) + scores.get(size / 2)) / 2;
        } else {
            return scores.get(size / 2);
        }
    }

    // Method to calculate the mean of a list of scores
    private double calculateMean(ArrayList<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    // Method to calculate the derivative of a list of scores
    private int calculateDerivative(ArrayList<Integer> scores) {
        if (scores.size() < 2) {
            return 0;
        }
        return scores.get(scores.size() - 1) - scores.get(scores.size() - 2);
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Run the GUI construction in the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(() -> new ScoreAnalyzerGUI());
    }
}