import javax.swing.*;
import java.awt.*;

public class DrawBox extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(50, 50, 100, 100); // Draw a rectangle (x, y, width, height)
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw a Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);

        DrawBox drawBox = new DrawBox();
        frame.add(drawBox);
        frame.setVisible(true);
    }
}