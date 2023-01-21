import java.awt.*;
import javax.swing.*;

public class MyCanvas extends JComponent {
    @Override
  public void paint(Graphics g) {
    int alpha = 127;
    Color myColour = new Color(0, 0, 0, alpha);
    g.setColor(myColour);
    g.fillRect(0, 50, 800, 60);

  }
}