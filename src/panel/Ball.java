package panel;

import java.awt.*;
import java.util.*;

public class Ball extends Rectangle {
  
  private Random random;
  
  int xVelocity;
  
  int yVelocity;
  
  private int initialSpeed = 3;
  
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
  
  public void setXDirection(int randomXDirection) {
    this.xVelocity = randomXDirection;
  }
  
  public void setYDirection(int randomYDirection) {
    this.yVelocity = randomYDirection;
  }
  
  public void move() {
    x += this.xVelocity;
    y += this.yVelocity;
  }
  
  public void draw(Graphics g) {
    g.setColor(Color.white);
    g.fillOval(x, y, height, width);
  }

}
