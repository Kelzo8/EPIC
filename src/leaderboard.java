import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class leaderboard extends JFrame {

    // ArrayLists to store scores for Niall, Kelly, and James
    private ArrayList<Integer> niallScores = new ArrayList<>();
    private ArrayList<Integer> kellyScores = new ArrayList<>();
    private ArrayList<Integer> jamesScores = new ArrayList<>();

    // Constructor for the Leaderboard class
    public leaderboard() {
        super("Score Analyzer"); // Set the title of the JFrame

        // Read scores from the CSV file
        readScoresFromCSV("C:/Users/User/OneDrive - University of Limerick/Desktop/login.csv.txt");

        // Calculate mean, median, and standard deviation for Niall, Kelly, and James
        double niallMean = calculateMean(niallScores);
        int niallMedian = calculateMedian(niallScores);
        double niallStandardDeviation = calculateStandardDeviation(niallScores);

        double kellyMean = calculateMean(kellyScores);
        int kellyMedian = calculateMedian(kellyScores);
        double kellyStandardDeviation = calculateStandardDeviation(kellyScores);

        double jamesMean = calculateMean(jamesScores);
        int jamesMedian = calculateMedian(jamesScores);
        double jamesStandardDeviation = calculateStandardDeviation(jamesScores);

        JPanel leaderboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw enhanced leaderboard with calculated statistics
                drawLeaderboard(g, niallMean, niallMedian, niallStandardDeviation,
                        kellyMean, kellyMedian, kellyStandardDeviation,
                        jamesMean, jamesMedian, jamesStandardDeviation);
            }
        };
        // Set up the layout for the JFrame
        setLayout(new BorderLayout());
        leaderboardPanel.setBackground(new Color(255, 255, 240)); // Set background color
        add(leaderboardPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on window close
        setSize(800, 600); // Set the initial size of the JFrame
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true); // Make the JFrame visible

    }

    // Method to read scores from a CSV file
    private void readScoresFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 4) {
                    // Parse scores for Niall, Kelly, and James from CSV
                    niallScores.add(Integer.parseInt(tokens[1]));
                    kellyScores.add(Integer.parseInt(tokens[2]));
                    jamesScores.add(Integer.parseInt(tokens[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle file reading errors
        }
    }

    // Method to calculate the mean of a list of scores
    private double calculateMean(ArrayList<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size(); // Return the mean value
    }

    // Method to calculate the median of a list of scores
    private int calculateMedian(ArrayList<Integer> scores) {
        int size = scores.size();
        Collections.sort(scores);
        if (size % 2 == 0) {
            return (scores.get(size / 2 - 1) + scores.get(size / 2)) / 2;
        } else {
            return scores.get(size / 2);
        }
    }

    // Method to calculate the standard deviation of a list of scores
    private double calculateStandardDeviation(ArrayList<Integer> scores) {
        int size = scores.size();
        double mean = calculateMean(scores);
        double sumOfSquares = 0;
        // Calculate the sum of squared differences from the mean
        for (int score : scores) {
            sumOfSquares += Math.pow(score - mean, 2);
        }
        // Calculate the standard deviation using the formula: sqrt(sumOfSquares / size)
        return Math.sqrt(sumOfSquares / size);
    }

 // Enhanced method to draw the leaderboard with calculated statistics
    private void drawLeaderboard(Graphics g, double niallMean, int niallMedian, double niallStandardDeviation,
                                  double kellyMean, int kellyMedian, double kellyStandardDeviation,
                                  double jamesMean, int jamesMedian, double jamesStandardDeviation) {
        Font titleFont = new Font("Arial", Font.BOLD, 28);
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        g.setFont(titleFont);
        g.setColor(new Color(70, 130, 180)); // Set a nice blue color

        int startX = 50;
        int startY = 80;
        int lineHeight = 40;

        g.drawString("Leaderboard", startX, startY); // Draw leaderboard title

        startY += 2 * lineHeight;
        g.setFont(labelFont);
        g.setColor(new Color(0, 128, 0)); // Set a nice green color
        g.drawString("Niall", startX, startY);
        g.drawString("Mean: " + niallMean, startX + 200, startY);
        g.drawString("Median: " + niallMedian, startX + 400, startY);
        g.drawString("Standard Deviation: " + niallStandardDeviation, startX + 600, startY);

        startY += lineHeight;
        g.setColor(new Color(178, 34, 34)); // Set a nice red color
        g.drawString("Kelly", startX, startY);
        g.drawString("Mean: " + kellyMean, startX + 200, startY);
        g.drawString("Median: " + kellyMedian, startX + 400, startY);
        g.drawString("Standard Deviation: " + kellyStandardDeviation, startX + 600, startY);

        startY += lineHeight;
        g.setColor(new Color(128, 0, 128)); // Set a nice purple color
        g.drawString("James", startX, startY);
        g.drawString("Mean: " + jamesMean, startX + 200, startY);
        g.drawString("Median: " + jamesMedian, startX + 400, startY);
        g.drawString("Standard Deviation: " + jamesStandardDeviation, startX + 600, startY);
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(leaderboard::new); // Start the enhanced leaderboard application
    }
}