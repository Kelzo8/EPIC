
import java.util.ArrayList;
import java.util.Collections;

// Class to represent a Player
class Player {
    private String name;
    private ArrayList<Integer> scores;

    // Constructor to initialize a player with a name
    public Player(String name) {
        this.name = name;
        this.scores = new ArrayList<>();
    }

    // Add a score to the player's list of scores
    public void addScore(int score) {
        scores.add(score);
    }

    // Get the player's name
    public String getName() {
        return name;
    }

    // Get the list of scores for the player
    public ArrayList<Integer> getScores() {
        return scores;
    }

    // Calculate the mean (average) of the player's scores
    public double calculateMean() {
        int sum = scores.stream().mapToInt(Integer::intValue).sum();
        return (double) sum / scores.size();
    }

    // Calculate the median of the player's scores
    public int calculateMedian() {
        Collections.sort(scores);
        int size = scores.size();
        return (size % 2 == 0) ? (scores.get(size / 2 - 1) + scores.get(size / 2)) / 2 : scores.get(size / 2);
    }

    // Calculate the standard deviation of the player's scores
    public double calculateStandardDeviation() {
        double mean = calculateMean();
        double sumOfSquares = scores.stream().mapToDouble(score -> Math.pow(score - mean, 2)).sum();
        return Math.sqrt(sumOfSquares / scores.size());
    }
}

