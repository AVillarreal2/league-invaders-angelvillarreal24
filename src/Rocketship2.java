import java.awt.*;

public class Rocketship2 extends GameObject{

    Rocketship2(int x, int y, int width, int height) {
        super(x,y,width,height);

    }
    void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
