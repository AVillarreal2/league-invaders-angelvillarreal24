import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Rocketship extends GameObject {

    public Rocketship(int x, int y, int width, int height) {
        super(x, y, width, height);
        if (needImage) {
            loadImage ("rocket.png");
        }
    }
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;

    void draw(Graphics g) {
        //g.fillRect(x, y, width, height);
        speed = 50;
        if (gotImage) {
            image.createGraphics().setComposite(AlphaComposite.Clear);
            g.drawImage(image, x, y, width, height, null);
        } else {
            g.fillRect(x, y, width, height);
        }
    }

    public void right() {
        if(x<500-50) {
            x+=speed;
        } else {
            x-=speed;
        }
    }
    public void left() {
        if(x>0) {
            x-=speed;
        } else {
            x+=speed;
        }
    }
    public void up() {
        if(y>0) {
            y-=speed;
        } else {
            y+=speed;
        }
    }
    public void down() {
        if(y<800-50) {
            y+=speed;
        } else {
            y-=speed;
        }
    }
    void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
                gotImage = true;
            } catch (Exception e) {

            }
            needImage = false;
        }
    }

    public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
    }

}
