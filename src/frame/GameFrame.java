package frame;

import java.awt.*;
import javax.swing.*;

import panel.GamePanel;

/**
 * Construct the window of an application with
 * graphics components.
 */
public class GameFrame extends JFrame {
  
  private GamePanel panel;
  
  /**
   * GameFrame constructor which create and construct
   * the window panel of the game.
   */
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
