import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DataAnalysisApp extends JFrame {
    private Leaderboard leaderboard;

    // Constructor for the main application
    public DataAnalysisApp() {
        super("Score Analyzer");

        // Initialize the leaderboard
        leaderboard = new Leaderboard();

        // Read scores from the CSV file
        readScoresFromCSV("C:/Users/User/OneDrive - University of Limerick/Desktop/login.csv.txt");

        // Set up the graphical user interface
        setupUI();
    }

    // Read scores from a CSV file and update the leaderboard
    private void readScoresFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 4) {
                    String playerName = tokens[0].trim();
                    int playerScore = Integer.parseInt(tokens[3].trim());
                    Player player = findOrCreatePlayer(playerName);
                    player.addScore(playerScore);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Find an existing player or create a new one
    private Player findOrCreatePlayer(String playerName) {
        for (Player player : leaderboard.getPlayers()) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        // Player not found, create a new one
        Player newPlayer = new Player(playerName);
        leaderboard.addPlayer(newPlayer);
        return newPlayer;
    }

    // Set up the graphical user interface
    private void setupUI() {
        // Set up the layout for the JFrame
        setLayout(new BorderLayout());
        JPanel leaderboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawLeaderboard(g);
            }
        };
        leaderboardPanel.setBackground(new Color(255, 255, 240));
        add(leaderboardPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Draw the leaderboard on the graphical user interface
    private void drawLeaderboard(Graphics g) {
        Font titleFont = new Font("Arial", Font.BOLD, 28);
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        g.setFont(titleFont);
        g.setColor(new Color(70, 130, 180)); // Set a nice blue color

        int startX = 50;
        int startY = 80;
        int lineHeight = 120; // Increased to accommodate each player's statistics

        g.drawString("Leaderboard", startX, startY); // Draw leaderboard title

        startY += 2 * lineHeight;
        g.setFont(labelFont);
        g.setColor(new Color(0, 128, 0)); // Set a nice green color

        for (Player player : leaderboard.getPlayers()) {
            g.drawString(player.getName(), startX, startY);
            g.drawString("Mean: " + player.calculateMean(), startX + 200, startY);
            g.drawString("Median: " + player.calculateMedian(), startX + 400, startY);
            g.drawString("Standard Deviation: " + player.calculateStandardDeviation(), startX + 600, startY);
            startY += lineHeight;
        }
    }

    // Draw statistics for a player on the graphical user interface
    private void drawPlayerStatistics(Graphics g, Player player) {
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
        g.drawString(player.getName(), startX, startY);
        g.drawString("Mean: " + player.calculateMean(), startX + 200, startY);
        g.drawString("Median: " + player.calculateMedian(), startX + 400, startY);
        g.drawString("Standard Deviation: " + player.calculateStandardDeviation(), startX + 600, startY);
    }

    // Entry point of the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DataAnalysisApp::new);
    }
}