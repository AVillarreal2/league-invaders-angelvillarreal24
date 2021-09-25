import javax.swing.*;

public class LeagueInvaders {
    JFrame gameFrame;
    GamePanel gamePanel;
    public static final int gFrameWIDTH = 500;
    public static final int gFrameHEIGHT = 800;
    public static void main(String[] args) {
        LeagueInvaders leagueInvaders = new LeagueInvaders();
        leagueInvaders.setup();
    }

    public LeagueInvaders() {
        gameFrame = new JFrame();
        gamePanel = new GamePanel();
    }

    void setup(){
        gameFrame.add(gamePanel);
        gameFrame.setSize(gFrameWIDTH, gFrameHEIGHT);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.addKeyListener(gamePanel);
    }
}
