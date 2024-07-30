package panel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
  
  static final int GAME_WIDTH = 1000;
  
  static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));

  static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
  
  static final int BALL_DIAMETER = 20;
  
  static final int PANEL_WIDTH = 25;
  
  static final int PANEL_HEIGHT = 1000;
  
  private Thread thread;
  
  Image image;
  
  Graphics graphics;
  
  Random random;
  
  Paddle paddle;
  
  Ball ball;
  
  private Score score;
  
  public GamePanel() {
    newPaddles();
    newBall();
    score = new Score(GAME_WIDTH, GAME_HEIGHT);
    this.setFocusable(true);
    this.addKeyListener(new AL());
    this.setPreferredSize(SCREEN_SIZE);
    
    thread = new Thread(this);
    thread.start();
  }
  
  public void newBall() {
    
  }
  
  public void newPaddles() {
    
  }
  
  public void paint(Graphics g) {
    image = createImage(GAME_WIDTH, GAME_HEIGHT);
    graphics = image.getGraphics();
    draw(graphics);
    g.drawImage(image, 0, 0, this);
  }
  
  public void draw(Graphics g) {
    
  }
  
  public void move() {
    
  }
  
  public void checkCollision() {
    
  }
  
  public void run() {
    
  }
  
  public class AL extends KeyAdapter {
    
    public void keyPressed(KeyEvent e) {
      
    }
    
    public void keyReleased(KeyEvent e) {
      
    }
  }
}
