import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Alien extends GameObject {
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;
    public Alien(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 1;
        if (needImage) {
            loadImage ("alien.png");
        }
    }
    //constructor stuff, loading image alien/png

    void update(){
        super.update();
        y+=speed;
    }
    //this is so it goes down constantly
    void draw(Graphics g){
        if (gotImage) {
            image.createGraphics().setComposite(AlphaComposite.Clear);
            g.drawImage(image, x, y, width, height, null);
        } else {
            g.fillRect(x, y, width, height);
        }
    }
    //if it has image it will draw it otherwise it will create a rectangle
    void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
                gotImage = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            needImage = false;
        }
    }
    //loads the imagefile
}
