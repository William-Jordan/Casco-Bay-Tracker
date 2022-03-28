import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map extends JPanel {

    final double north = 43.726469;
    final double south = 43.63424;
    final double east = -70.271945;
    final double west = -70.065720;
    final String e, p;
    public Map(String e, String p) {
        this.setLayout(new SpringLayout());
        this.e = e;
        this.p = p;
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(".\\src\\main\\resources\\blue.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        g2d.drawImage(image, 0, 0, this);

        g2d.setColor(Color.red);
        Coordinate[] latLon = Locate.getLocations(e, p);
        for (Coordinate c :
                latLon) {
            int[] location = c.getPixels(1200, 740, north, south, east, west);
            g2d.fillOval(location[0]-2, location[1]-2, 5, 5);
        }
        System.out.println("rpt");
        this.repaint();
    }
}
