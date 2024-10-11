package game.play;

import javax.swing.*;

class ZombieSurvialGameGUI extends JFrame
{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Zombie Survival Game");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


