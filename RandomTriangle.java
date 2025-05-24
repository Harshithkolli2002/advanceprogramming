//Name: Harshith Kolli
//Student NUmber: 999904298
//Section:MSIS5103_032242S
//Assignment_9

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * TriangleCanvas handles the rendering of triangles.
 */
class TriangleCanvas extends JPanel {

    private static final int NUM_TRIANGLES = 500;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final Random random = new Random();

    /**
     * Paints random triangles on the panel.
     *
     * @param g The graphics object used to draw shapes.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < NUM_TRIANGLES; i++) {
            drawTriangle(g2d);
        }
    }

    /**
     * Draws a single triangle with random color and transparency.
     *
     * @param g2d The Graphics2D object used for rendering.
     */
    private void drawTriangle(Graphics2D g2d) {
        // Random color with transparency
        Color color = new Color(
                random.nextInt(256),       // Red
                random.nextInt(256),       // Green
                random.nextInt(256),       // Blue
                random.nextInt(100) + 155  // Alpha for slight transparency
        );

        // Random vertices using offsets to prevent clustering
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        for (int j = 0; j < 3; j++) {
            xPoints[j] = random.nextInt(WIDTH);
            yPoints[j] = random.nextInt(HEIGHT);

            // Add small random offsets for variation in shape
            xPoints[j] += random.nextInt(20) - 10;
            yPoints[j] += random.nextInt(20) - 10;
        }

        // Set the color and draw the triangle
        g2d.setColor(color);
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}

/**
 * TriangleFrame sets up the window and canvas.
 */
public class RandomTriangle {

    /**
     * Main method to launch the application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("500 Unique Random Triangles");
        TriangleCanvas canvas = new TriangleCanvas();

        // Configure the frame
        frame.add(canvas);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Center the window
        frame.setVisible(true);
    }
}
