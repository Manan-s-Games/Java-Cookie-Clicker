import java.awt.*;
import javax.swing.*;
public class InfoPanel extends JPanel{
    ImageIcon img = new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\Cookie Clicker\\StoreBackground.png");
    public InfoPanel( JLabel lab) {
        JLabel label = new JLabel(img);
        setBounds(40, 10, 300, 130);
        add(lab);
        add(label);
        lab.setBounds(10, 10, 280, 110);
        lab.setFont(new Font("Merriweather", Font.BOLD, 15));
        lab.setForeground(Color.BLACK);
    }
}
