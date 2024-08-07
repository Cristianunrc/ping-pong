package frame;

import java.awt.*;
import javax.swing.*;

import panel.GamePanel;

public class GameFrame extends JFrame {
  
  private GamePanel panel;
  
  public GameFrame() {
    panel = new GamePanel();
    this.add(panel);
    this.setTitle("Ping Pong");
    this.setResizable(false);
    this.setBackground(Color.black);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
    this.setLocationRelativeTo(null);
  }

}
