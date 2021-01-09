import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    @Override
    public void paintComponent(Graphics g){
        titleFont = new Font("Arial", Font.PLAIN, 48);
        if(currentState == MENU){
            drawMenuState(g);
        }else if(currentState == GAME){
            drawGameState(g);
        }else if(currentState == END){
            drawEndState(g);
        }
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
        g.drawString("LEAGUE INVADERS", 1, 100);
        g.drawString("Press ENTER to Start", 1, 500);
        g.drawString("Press SPACE for Instructions", 1, 700);
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
