import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel
        implements ActionListener, KeyListener {
    private final int MENU = 0;
    private final int GAME = 1;
    private final int END = 2;
    private int currentState = MENU;
    private Font titleFont;
    private Font otherFont;
    private Timer frameDraw;
    private Rocketship rocket = new Rocketship(250, 700, 50, 50);
    private ObjectManager objectManager = new ObjectManager(rocket);
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;
    private Timer alienSpawn;

    //so rocket is created here and because of the constructor it sends it over to the object manager class and there it is
// received by the object manager class and this.rocket passes all of the information on the original rocket over to the
// other rocket that is in object manager. that object manager rocket is then placed into the game.

    public GamePanel() {
        frameDraw = new Timer(1000 / 60, this);
        frameDraw.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        titleFont = new Font("Arial", Font.PLAIN, 40);
        otherFont = new Font("Arial", Font.PLAIN, 28);
        if (currentState == MENU) {
            drawMenuState(g);
        } else if (currentState == GAME) {
            drawGameState(g);
        } else if (currentState == END) {
            drawEndState(g);
        }
    }
    //checks what currentstate is set to

    void loadImage(String imageFile) {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
            gotImage = true;
        } catch (Exception e) {

        }
    }

    void updateMenuState() {

    }

    void updateGameState() {
        if(!rocket.isActive) {
            currentState=END;
            return;
        }
        objectManager.update();
    }

    void updateEndState() {

    }

    void drawMenuState(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, LeagueInvaders.gFrameWIDTH, LeagueInvaders.gFrameHEIGHT);
        g.setFont(titleFont);
        g.setColor(Color.YELLOW);
        g.drawString("LEAGUE INVADERS", 50, 150);
        g.setFont(otherFont);
        g.drawString("Press ENTER to Start", 100, 450);
        g.drawString("Press SPACE for Instructions", 60, 600);
    }

    void drawGameState(Graphics g) {
        loadImage("space.png");
        g.drawImage(image, 0, 0, 500, 800, null);
        objectManager.draw(g);
        g.setColor(Color.WHITE);
        g.drawString("Score: " + objectManager.getScore(),1,10);
    }

    void drawEndState(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, LeagueInvaders.gFrameWIDTH, LeagueInvaders.gFrameHEIGHT);
        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        g.drawString("YOU DIED", 150, 150);
        g.setFont(otherFont);
        g.drawString("You killed " + objectManager.getScore() + " enemies", 100, 450);
        g.drawString("Press ENTER to Restart", 75, 600);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (currentState == MENU) {
            updateMenuState();
            repaint();
        } else if (currentState == GAME) {
            updateGameState();
            repaint();
        } else if (currentState == END) {
            updateEndState();
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (currentState == END) {
                rocket = new Rocketship(250, 700, 50, 50);
                objectManager = new ObjectManager(rocket);
                currentState = MENU;
            } else {
                currentState++;
                startGame();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            rocket.up();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            rocket.down();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rocket.right();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rocket.left();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE && currentState == GAME) {
            objectManager.addProjectile(rocket.getProjectile());
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE && currentState == MENU) {
            JOptionPane.showMessageDialog(null, "Start the game with ENTER! Kill aliens with SPACE to gain a higher score! You can move around using UP, DOWN, LEFT, and RIGHT. Don't get killed by the aliens!");
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    void startGame() {
        if (currentState == GAME) {
            alienSpawn = new Timer(1000, objectManager);
            alienSpawn.start();
        } else if (currentState == END) {
            alienSpawn.stop();
        }
    }
}
