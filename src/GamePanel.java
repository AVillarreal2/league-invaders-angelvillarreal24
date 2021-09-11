import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font bottomFont;
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
        titleFont = new Font("Arial", Font.PLAIN, 48);
        bottomFont = new Font("Arial", Font.PLAIN, 28);
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
    }
    void drawGameState(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, LeagueInvaders.gFrameWIDTH, LeagueInvaders.gFrameHEIGHT);
    }
    void drawEndState(Graphics g)  {
        g.setColor(Color.RED);
        g.fillRect(0, 0, LeagueInvaders.gFrameWIDTH, LeagueInvaders.gFrameHEIGHT);
    }

}
