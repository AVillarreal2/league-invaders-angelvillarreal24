import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
    Rocketship rocket;
    int score = 0;
    ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    ArrayList<Alien> aliens = new ArrayList<Alien>();

    public ObjectManager(Rocketship rocket) {
        //  rocket = new Rocketship(1, 1, 50, 50);
        this.rocket = rocket;
    }

    void addAlien() {
        Random random = new Random();
        aliens.add(new Alien(random.nextInt(LeagueInvaders.gFrameWIDTH), 0, 50, 50));
    }

    void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    void update() {
        if (rocket.isActive == false) {
            return;
        }
        updateAliens();
        updateProjectiles();
        checkCollision();
        purgeObjects();
    }

    private void updateAliens() {
        for (Alien alien : aliens) {
            alien.update();
            if (alien.y > LeagueInvaders.gFrameHEIGHT) {
                alien.isActive = false;
            }
        }
    }

    private void updateProjectiles() {
        for (Projectile projectile : projectiles) {
            projectile.update();
            if (projectile.y < 0) {
                projectile.isActive = false;
            }
        }
    }

    void draw(Graphics g) {
        drawRocket(g);
        for (Alien alien : aliens) {
            alien.draw(g);
        }
        for (Projectile projectile : projectiles) {
            projectile.draw(g);
        }
    }

    void purgeObjects() {
        if (aliens.isEmpty()) {
            return;
        }
        for (int i = 0; i < aliens.size(); i++) {
            if (!aliens.get(i).isActive) {
                aliens.remove(i);
            }
        }
        for (int i = 0; i < projectiles.size(); i++) {
            if (!projectiles.get(i).isActive) {
                projectiles.remove(i);
            }
        }
    }

    private void drawRocket(Graphics g) {
        rocket.draw(g);
    }

    private void drawAliens(Graphics g) {

    }

    private void drawProjectiles(Graphics g) {

    }

    void checkCollision() {
        for (Alien alien : aliens) {
            System.out.println(aliens.size());
            if (!rocket.isActive) {
                return;
            }
            if (alien.collisionBox.intersects(rocket.collisionBox)) {
                alien.isActive = false;
                rocket.isActive = false;
                System.out.println("rocket dead");
                return;
            }
            for (Projectile projectile : projectiles) {
                if (alien.collisionBox.intersects(projectile.collisionBox)) {
                    projectile.isActive = false;
                    alien.isActive = false;
                    System.out.println("hit projectile");
                    setScore(getScore() + 1);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        addAlien();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score1) {
        this.score = score1;
    }
}
