package panel;

import java.awt.*;
import java.awt.event.*;

/**
 * Representing the paddle component on the game panel.
 */
public class Paddle extends Rectangle {
  
  private int id;
  
  private int yVelocity;
  
  /**
   * Speed move of the paddles.
   */
  private static final int SPEED = 7;
  
  /**
   * Class constructor which create's and positioned the paddles.
   * @param x an int representing an position.
   * @param y an int representing an position.
   * @param width an int representing the paddle width.
   * @param height an int representing the paddle height.
   * @param id an int representing the id of the paddles.
   */
  public Paddle(int x, int y, int width, int height, int id) {
    super(x, y, width, height);
    this.id = id;
  }
  
  public void keyPressed(KeyEvent e) {
    switch(id) {
    case 1:
      if (e.getKeyCode() == KeyEvent.VK_W) {
        setYDirection(-SPEED);
        move();
      }
      if (e.getKeyCode() == KeyEvent.VK_S) {
        setYDirection(SPEED);
        move();
      }
      break;
    case 2:
      if (e.getKeyCode() == KeyEvent.VK_UP) {
        setYDirection(-SPEED);
        move();
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        setYDirection(SPEED);
        move();
      }
      break;
    }
  }
  
  public void keyReleased(KeyEvent e) {
    switch(id) {
    case 1:
      if (e.getKeyCode() == KeyEvent.VK_W) {
        setYDirection(0);
        move();
      }
      if (e.getKeyCode() == KeyEvent.VK_S) {
        setYDirection(0);
        move();
      }
      break;
    case 2:
      if (e.getKeyCode() == KeyEvent.VK_UP) {
        setYDirection(0);
        move();
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        setYDirection(0);
        move();
      }
      break;
    }
  }
  
  /**
   * Set's the yVelocity attribute.
   * @param yVelocity an int representing the velocity of the paddle.
   */
  public void setYDirection(int yVelocity) {
    this.yVelocity = yVelocity;
  }
  
  /**
   * Allow the movement of the paddle and increasing
   * the y attribute of the Rectangle class.
   */
  public void move() {
    y += yVelocity;
  }
  
  /**
   * Draw two paddles and set's color.
   * @param g an Graphics instance.
   */
  public void draw(Graphics g) {
    if (id == 1) {
      g.setColor(Color.blue);
    } else {
      g.setColor(Color.red);
    }
    g.fillRect(x, y, width, height);
  }

}
