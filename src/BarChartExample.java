import javax.swing.*;
import java.awt.*;

public class BarChartExample extends JFrame {

    private int[] computerScienceData = {3, 4, 2, 5, 3}; // Sample data for Computer Science
    private int[] discreteMathsData = {4, 2, 3, 1, 5};    // Sample data for Discrete Maths
    private int[] computerOrganisationData = {3, 4, 1, 4, 3}; // Sample data for Computer Organisation

    public BarChartExample() {
        setTitle("Bar Chart Example");
        setSize(245, 400); // Increased height for better visualisation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BarChartPanel chartPanel = new BarChartPanel();
        add(chartPanel);

        setVisible(true);
    }

    class BarChartPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int barWidth = 50;
            int startX = 50;
            int startY = getHeight() - 100; // Adjusted Y position for better spacing
            int yScale = 50; // Pixels between each Y-axis label

            // Draw Y-axis labels (from 0 to 5)
            for (int i = 0; i <= 16; i++) {
                g.drawString(Integer.toString(i), startX - 30, startY - i * yScale + 5);
            }

            // Draw bars for Discrete Niall
            drawBars(g, startX, startY, barWidth, computerScienceData, Color.decode("#A2DDE4"), "Niall");

            // Draw bars for Kelly
            drawBars(g, startX + barWidth + 10, startY, barWidth, discreteMathsData, Color.decode("#A0E63F"), "Kelly");

            // Draw bars for James
            drawBars(g, startX + 2 * (barWidth + 10), startY, barWidth, computerOrganisationData, Color.decode("#F039b1"), "James");
        }

        private void drawBars(Graphics g, int startX, int startY, int barWidth, int[] data, Color color, String label) {
            for (int i = 0; i < data.length; i++) {
                int barHeight = data[i] * 50; // Scale the bar height for better visualization
                int x = startX + i * (barWidth + 10);
                int y = startY - barHeight;
                g.setColor(color);
                g.fillRect(x, y, barWidth, barHeight);

                // Draw labels below the first block
                if (label != null && i == 0) {
                    g.setColor(Color.black);
                    g.setFont(new Font("Arial", Font.BOLD, 12));
                    g.drawString(label, x + barWidth / 2 - 25, startY + 20);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BarChartExample());
    }
}
