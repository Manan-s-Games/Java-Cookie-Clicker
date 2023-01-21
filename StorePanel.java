import java.awt.*;
import javax.swing.*;
public class StorePanel extends JPanel{
    ImageIcon img = new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\Cookie Clicker\\StoreBackground.png");
    StorePanel(JFrame f) {
        JLabel label = new JLabel(img);
        add(label);
        setBounds(40, 150, 300, 450);
    }
}
