import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BarChartExample2 extends JFrame {

    // Lists to store data read from the CSV file
    private List<Integer> computerScienceData = new ArrayList<>();
    private List<Integer> discreteMathsData = new ArrayList<>();
    private List<Integer> computerOrganisationData = new ArrayList<>();

    public BarChartExample2() {
        // Set JFrame properties
        setTitle("Bar Chart Example");
        setSize(245, 400); // Increased height for better visualization
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Read data from CSV file
        readDataFromCSV("https://ulcampus-my.sharepoint.com/:t:/g/personal/23370858_studentmail_ul_ie/EVLt-jYC_2xGs6yZc7V7uPABZ2_Bo9aKKpVyoTlAIlpE7w?e=6LduKx"); //CSV file path

        // Create and add BarChartPanel to the JFrame
        BarChartPanel chartPanel = new BarChartPanel();
        add(chartPanel);

        // Make the JFrame visible
        setVisible(true);
    }

    // Method to read data from the CSV file
    private void readDataFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                // Split the line into values using comma as the delimiter
                String[] values = line.split(",");
                // Parse and add data to the respective lists
                computerScienceData.add(Integer.parseInt(values[0].trim()));
                discreteMathsData.add(Integer.parseInt(values[1].trim()));
                computerOrganisationData.add(Integer.parseInt(values[2].trim()));
            }
        } catch (IOException e) {
            // Handle IOException if file reading fails
            e.printStackTrace();
        }
    }

    // Inner class representing the panel for drawing the bar chart
    class BarChartPanel extends JPanel {
        // ... (rest of the code remains unchanged)
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Run the GUI code on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new BarChartExample());
    }
}