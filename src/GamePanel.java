import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        g.fillRect(10, 10, 100, 100);
    }
}
