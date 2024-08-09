package panel;

import java.awt.*;
import java.util.*;

/**
 * Representing the ball on the panel game.
 */
public class Ball extends Rectangle {
  
  private Random random;
  
  int xVelocity;
  
  int yVelocity;
  
  /**
   * Initial speed of the ball.
   */
  private int initialSpeed = 3;
  
  /**
   * Class constructor which create's an ball in randomly position
   * in the middle of the panel game.
   * @param x an int representing a position.
   * @param y an int representing a position.
   * @param width an int representing the ball diameter.
   * @param height an int representing the ball diameter.
   */
  public Ball(int x, int y, int width, int height) {
    super(x, y, width, height);
    random = new Random();
    int randomXDirection = random.nextInt(2);
    if (randomXDirection == 0) {
      randomXDirection--;
    }
    setXDirection(randomXDirection * this.initialSpeed);
    
    int randomYDirection = random.nextInt(2);
    if (randomYDirection == 0) {
      randomYDirection--;
    }
    setYDirection(randomYDirection * this.initialSpeed);
  }
  
  /**
   * Set's xVelocity attribute.
   * @param xVelocity an in representing the x velocity of the ball. 
   */
  public void setXDirection(int xVelocity) {
    this.xVelocity = xVelocity;
  }
  
  /**
   * Set's yVelocity attribute.
   * @param yVelocity an in representing the y velocity of the ball.
   */
  public void setYDirection(int yVelocity) {
    this.yVelocity = yVelocity;
  }
  
  /**
   * Generate the move of the ball, increasing the value's of the
   * x and y which come of the Rectangle class.
   */
  public void move() {
    x += this.xVelocity;
    y += this.yVelocity;
  }
  
  /**
   * Set's the color and give dimension of the ball.
   * @param g an Graphics instance.
   */
  public void draw(Graphics g) {
    g.setColor(Color.white);
    g.fillOval(x, y, height, width);
  }

}
