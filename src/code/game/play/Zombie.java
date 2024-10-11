package game.play;

import java.awt.*;

class Zombie {
    int x, y;
    int speed = 2;
    int width = 40, height = 40;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTowardPlayer(Player player) {
        int dx = player.x - x;
        int dy = player.y - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        x += (dx / distance) * speed;
        y += (dy / distance) * speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
