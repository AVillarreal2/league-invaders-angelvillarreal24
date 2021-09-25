import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font bottomFont;
    Timer frameDraw;
    @Override
    public void paintComponent(Graphics g){
        if(currentState == MENU){
            drawMenuState(g);
        }else if(currentState == GAME){
            drawGameState(g);
        }else if(currentState == END){
            drawEndState(g);
        }
    }

    public GamePanel() {
        titleFont = new Font("Arial", Font.PLAIN, 40);
        bottomFont = new Font("Arial", Font.PLAIN, 28);
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
    }

    void updateMenuState() {

    }
    void updateGameState() {

    }
    void updateEndState()  {

    }
    void drawMenuState(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, LeagueInvaders.gFrameWIDTH, LeagueInvaders.gFrameHEIGHT);
        g.setFont(titleFont);
        g.setColor(Color.YELLOW);
        g.drawString("LEAGUE INVADERS", 50, 150);
        g.setFont(bottomFont);
        g.drawString("Press ENTER to Start", 100, 450);
        g.drawString("Press SPACE for Instructions", 60, 600);
    }
    void drawGameState(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, LeagueInvaders.gFrameWIDTH, LeagueInvaders.gFrameHEIGHT);
    }
    void drawEndState(Graphics g)  {
        g.setColor(Color.RED);
        g.fillRect(0, 0, LeagueInvaders.gFrameWIDTH, LeagueInvaders.gFrameHEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Action");
        if(currentState == MENU){
            updateMenuState();
        }else if(currentState == GAME){
            updateGameState();
        }else if(currentState == END){
            updateEndState();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER) {
            if (currentState == END) {
                currentState = MENU;
                System.out.println("Change Windows - " + currentState);
            } else {
                currentState++;
                System.out.println("Change Windows - " + currentState);
            }
        }
        if (e.getKeyCode()==KeyEvent.VK_UP) {
            System.out.println("UP");
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN) {
            System.out.println("DOWN");
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT) {
            System.out.println("LEFT");
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT");
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
