import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    public Map() {
        this.setLayout(new SpringLayout());
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        JLabel p = new JLabel(new ImageIcon("C:\\Users\\willi\\Documents\\GitHub\\Casco-Bay-Tracker\\src\\main\\resources\\blue.png"));
        p.setBounds(0,0,1200,740);
        this.add(p);

    }
}
