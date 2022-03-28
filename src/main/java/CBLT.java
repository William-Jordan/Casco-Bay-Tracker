import javax.swing.*;
import java.awt.*;

public class CBLT {

    Map m;
    public CBLT(String e, String p) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1222,785));
        frame.setResizable(false);
        frame.setTitle("Casco Bay Lines Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground( Color.DARK_GRAY);

        m = new Map(e, p);
        m.setBounds(3,3,1200,740);
        frame.add(m);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new CBLT(args[0], args[1]);
    }
}
