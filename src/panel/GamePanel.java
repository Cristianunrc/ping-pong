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
  
  static final int PADDLE_WIDTH = 25;
  
  static final int PADDLE_HEIGHT = 100;
  
  private Thread thread;
  
  Image image;
  
  private Graphics graphics;
  
  private Random random;
  
  private Paddle paddleOne;
  
  private Paddle paddleTwo;
  
  private Ball ball;
  
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
    random = new Random();
    ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), (GAME_HEIGHT / 2) - (BALL_DIAMETER / 2), BALL_DIAMETER, BALL_DIAMETER);
  }
  
  public void newPaddles() {
    paddleOne = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
    paddleTwo = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
  }
  
  public void paint(Graphics g) {
    image = createImage(getWidth(), getHeight());
    graphics = image.getGraphics();
    draw(graphics);
    g.drawImage(image, 0, 0, this);
  }
  
  public void draw(Graphics g) {
    paddleOne.draw(g);
    paddleTwo.draw(g);
    ball.draw(g);
  }
  
  public void move() {
    paddleOne.move();
    paddleTwo.move();
    ball.move();
  }
  
  public void checkCollision() {
    if (ball.y <= 0) {
      ball.setYDirection(-ball.yVelocity);
    }
    
    if (ball.y >= (GAME_HEIGHT - BALL_DIAMETER)) {
      ball.setYDirection(-ball.yVelocity);
    }
    
    checkCollisionBallOnPaddle(paddleOne);
    checkCollisionBallOnPaddle(paddleTwo);
    checkCollisionPaddleOnLimits(paddleOne);
    checkCollisionPaddleOnLimits(paddleTwo);
  }
  
  public void checkCollisionPaddleOnLimits(Paddle paddle) {
    if (paddle.y <= 0) {
      paddle.y = 0;
    }
    
    int spaceMove = GAME_HEIGHT - PADDLE_HEIGHT;
    if (paddle.y >= spaceMove) {
      paddle.y = spaceMove;
    }
  }
  
  public void checkCollisionBallOnPaddle(Paddle paddle) {
    if (ball.intersects(paddle)) {
      ball.xVelocity = Math.abs(ball.xVelocity);
      ball.xVelocity++;
      if (ball.yVelocity > 0) {
        ball.yVelocity++;
      } else {
        ball.yVelocity--;
      }
      int xVel = paddle.equals(paddleTwo) ? -ball.xVelocity : ball.xVelocity;
      ball.setXDirection(xVel);
      ball.setYDirection(ball.yVelocity);
    }
  }
  
  public void run() {
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    while (true) {
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;
      if (delta >= 1) {
        move();
        checkCollision();
        repaint();
        delta--;
      }
    }
  }
  
  public class AL extends KeyAdapter {
    
    public void keyPressed(KeyEvent e) {
      paddleOne.keyPressed(e);
      paddleTwo.keyPressed(e);
    }
    
    public void keyReleased(KeyEvent e) {
      paddleOne.keyReleased(e);
      paddleTwo.keyReleased(e);
    }
  }
}
