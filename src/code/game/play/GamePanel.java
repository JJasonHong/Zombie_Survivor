package game.play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

class GamePanel extends JPanel implements ActionListener, KeyListener
{
    Player player;
    ArrayList<Bullet> bullets;
    ArrayList<Zombie> zombies;
    Timer timer;
    boolean[] keys;

    public GamePanel()
    {
        this.player = new Player(300, 300);
        this.bullets = new ArrayList<>();
        this.zombies = new ArrayList<>();
        this.keys = new boolean[256];

        this.timer = new Timer(30, this);  // 30 ms delay for game loop
        this.timer.start();

        setFocusable(true);
        addKeyListener(this);

        spawnZombies();
    }

    public void spawnZombies()
    {
        Random rand = new Random();
        for(int i = 0; i < 5; i++)
        {
            int x = rand.nextInt(600);
            int y = rand.nextInt(600);
            zombies.add(new Zombie(x, y));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        updateGame();
        repaint();
    }

    public void updateGame()
    {
        // Move player based on keys pressed
        if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP])
        {
            player.move(0, -1);  // Move up
        }
        if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN])
        {
            player.move(0, 1);   // Move down
        }
        if(keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT])
        {
            player.move(-1, 0);  // Move left
        }
        if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT])
        {
            player.move(1, 0);   // Move right
        }

        // Move bullets
        for(int i = 0; i < bullets.size(); i++)
        {
            bullets.get(i).move();
            if(bullets.get(i).x < 0 || bullets.get(i).x > getWidth() || bullets.get(i).y < 0 || bullets.get(i).y > getHeight())
            {
                bullets.remove(i);
                i--;
            }
        }

        // Move zombies toward player
        for(Zombie zombie : zombies)
        {
            zombie.moveTowardPlayer(player);
        }

        // Check for bullet-zombie collisions
        for(int i = 0; i < bullets.size(); i++)
        {
            Bullet bullet = bullets.get(i);
            for(int j = 0; j < zombies.size(); j++)
            {
                Zombie zombie = zombies.get(j);
                if(bullet.getBounds().intersects(zombie.getBounds()))
                {
                    zombies.remove(j);
                    bullets.remove(i);
                    i--;
                    break;
                }
            }
        }

        // Check for zombie-player collisions
        for(Zombie zombie : zombies)
        {
            if(zombie.getBounds().intersects(new Rectangle(player.x, player.y, player.width, player.height)))
            {
                // Player hit by a zombie, game over logic can go here
                System.out.println("Game Over! A zombie got you!");
                timer.stop();
                break;
            }
        }

        if(zombies.isEmpty())
        {
            System.out.println("You survived! All zombies defeated.");
            timer.stop();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        player.draw(g);
        for(Bullet bullet : bullets)
        {
            bullet.draw(g);
        }
        for(Zombie zombie : zombies)
        {
            zombie.draw(g);
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;

        // Shoot bullet in direction based on arrow keys or WASD
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP])
            {
                bullets.add(new Bullet(player.x + player.width / 2, player.y, 0, -1));  // Shoot up
            } else if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN])
            {
                bullets.add(new Bullet(player.x + player.width / 2, player.y + player.height, 0, 1));  // Shoot down
            } else if(keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT])
            {
                bullets.add(new Bullet(player.x, player.y + player.height / 2, -1, 0));  // Shoot left
            } else if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT])
            {
                bullets.add(new Bullet(player.x + player.width, player.y + player.height / 2, 1, 0));  // Shoot right
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }
}