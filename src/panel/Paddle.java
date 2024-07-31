package panel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {
  
  int id;
  
  int yVelocity;
  
  public Paddle(int x, int y, int width, int height, int id) {
    super(x, y, width, height);
    this.id = id;
  }
  
  public void keyPressed(KeyEvent e) {
    
  }
  
  public void keyReleased(KeyEvent e) {
    
  }
  
  public void setYDirection(int yDirection) {
    
  }
  
  public void move() {
    
  }
  
  public void draw(Graphics g) {
    if (id == 1) {
      g.setColor(Color.blue);
    } else {
      g.setColor(Color.red);
    }
    g.fillRect(x, y, width, height);
  }

}
