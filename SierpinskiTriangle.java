// Name: Harshith Kolli
// Student Number: 999904298
// Section: MSIS5103_032242S
// Assignment_9

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Class for rendering the Sierpinski Triangle using optimized pixel-based drawing.
 * @author Harshith Kolli
 */
class SierpinskiCanvas extends JPanel {

    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private static final int ITERATIONS = 50000;  // Number of points to plot

    private BufferedImage image;  // Buffered image for optimized rendering
    private int centerX, centerY; // Center position for text

    /**
     * Constructor initializes the drawing canvas and generates the fractal.
     */
    public SierpinskiCanvas() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        calculateCenter();
        generateSierpinski();
    }

    /**
     * Computes the centroid of the Sierpinski Triangle.
     */
    private void calculateCenter() {
        int x1 = WIDTH / 2, y1 = HEIGHT / 7;         // Top vertex (512, 109)
        int x2 = WIDTH / 7, y2 = 6 * HEIGHT / 7;     // Bottom-left vertex (146, 654)
        int x3 = 6 * WIDTH / 7, y3 = 6 * HEIGHT / 7; // Bottom-right vertex (876, 654)

        // Compute the centroid (average of the three vertices)
        centerX = (x1 + x2 + x3) / 3;
        centerY = (y1 + y2 + y3) / 3;
    }

    /**
     * Generates the Sierpinski Triangle by iteratively plotting points.
     */
    private void generateSierpinski() {
        Graphics2D g = image.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);  // Set background to white

        // Define the three main vertices of the triangle
        int[][] vertices = {
                {WIDTH / 2, HEIGHT / 7},        // Top vertex (512, 109)
                {WIDTH / 7, 6 * HEIGHT / 7},    // Bottom-left vertex (146, 654)
                {6 * WIDTH / 7, 6 * HEIGHT / 7} // Bottom-right vertex (876, 654)
        };

        // Start from an initial point inside the triangle
        Random rand = new Random();
        int x = WIDTH / 2;
        int y = HEIGHT / 2;

        // Set drawing color to black
        g.setColor(Color.BLACK);

        // Iteratively plot points
        for (int i = 0; i < ITERATIONS; i++) {
            g.fillRect(x, y, 2, 2); // Slightly larger pixel

            // Choose a random vertex
            int[] chosenVertex = vertices[rand.nextInt(3)];

            // Move halfway towards the chosen vertex
            x = (x + chosenVertex[0]) / 2;
            y = (y + chosenVertex[1]) / 2;
        }

        // Draw the title at the center of the triangle
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        g.setColor(Color.BLACK);  // White text to stand out
        g.drawString("Sierpinski Triangle", centerX - 60, centerY + 10);

        g.dispose(); // Free resources
    }

    /**
     * Paints the generated image onto the panel.
     * @param g The Graphics object used for rendering.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

/**
 * Class to create the application window for displaying the Sierpinski Triangle.
 * @author Harshith Kolli
 */
public class SierpinskiTriangle {

    /**
     * Main method to launch the application.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle - Unique Version");
        SierpinskiCanvas canvas = new SierpinskiCanvas();

        // Configure the JFrame settings
        frame.add(canvas);
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Center the window
        frame.setVisible(true);
    }
}
