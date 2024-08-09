package panel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Create's an game panel window and all components in it`s, like
 * paddles, ball and score.
 */
public class GamePanel extends JPanel implements Runnable {
  
  static final int GAME_WIDTH = 1000;
  
  static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));

  static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
  
  static final int BALL_DIAMETER = 20;
  
  static final int PADDLE_WIDTH = 25;
  
  static final int PADDLE_HEIGHT = 100;
  
  private Paddle paddleOne;
  
  private Paddle paddleTwo;
  
  private Ball ball;
  
  private Score score;
  
  private Graphics graphics;
  
  private Thread thread;
  
  private Image image;
  
  private Random random;
  
  /**
   * Constructor of class which initialize the game panel.
   */
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
  
  /**
   * Create a ball on the middle of panel in a randomly position.
   */
  public void newBall() {
    random = new Random();
    int x = (GAME_WIDTH / 2) - (BALL_DIAMETER / 2);
    int y = random.nextInt(GAME_HEIGHT - BALL_DIAMETER);
    ball = new Ball(x, y, BALL_DIAMETER, BALL_DIAMETER);
  }
  
  /**
   * Create two paddles on the side's left and right of the game panel
   * in the middle position.
   */
  public void newPaddles() {
    int x = GAME_WIDTH - PADDLE_WIDTH;
    int y = (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2);
    paddleOne = new Paddle(0, y, PADDLE_WIDTH, PADDLE_HEIGHT, 1);
    paddleTwo = new Paddle(x, y, PADDLE_WIDTH, PADDLE_HEIGHT, 2);
  }
  
  /**
   * Paint the panel game.
   */
  public void paint(Graphics g) {
    image = createImage(getWidth(), getHeight());
    graphics = image.getGraphics();
    draw(graphics);
    g.drawImage(image, 0, 0, this);
  }
  
  /**
   * Draw all components on the game panel which are paddles,
   * ball and score.
   * @param g an Graphics instance.
   */
  public void draw(Graphics g) {
    paddleOne.draw(g);
    paddleTwo.draw(g);
    ball.draw(g);
    score.draw(g);
  }
  
  /**
   * Allow the moves of the paddles and ball.
   */
  public void move() {
    paddleOne.move();
    paddleTwo.move();
    ball.move();
  }
  
  /**
   * Checks the ball make collision whit the limits of the game panel,
   * the paddles or well no make collision.
   */
  public void checkCollision() {
    if (ball.y <= 0 || ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
      ball.setYDirection(-ball.yVelocity);
    }
    
    checkCollisionBallOnPaddle(paddleOne);
    checkCollisionBallOnPaddle(paddleTwo);
    checkCollisionPaddleOnLimits(paddleOne);
    checkCollisionPaddleOnLimits(paddleTwo);
    checkNoCollision();
  }
  
  /**
   * Checks the ball make collision with limits of the panel game.
   * @param paddle an Paddle instance representing a paddle.
   */
  public void checkCollisionPaddleOnLimits(Paddle paddle) {
    if (paddle.y <= 0) {
      paddle.y = 0;
    }
    
    int spaceMove = GAME_HEIGHT - PADDLE_HEIGHT;
    if (paddle.y >= spaceMove) {
      paddle.y = spaceMove;
    }
  }
  
  /**
   * Checks if the ball make a collision with the paddles.
   * @param paddle an Paddle instance representing a paddle.
   */
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
  
  /**
   * Checks if an player make an point.
   */
  public void checkNoCollision() {
    if (ball.x <= 0) {
      score.playerTwo++;
      newPaddles();
      newBall();
    }
    
    if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
      score.playerOne++;
      newPaddles();
      newBall();
    }
  }
  
  /**
   * Run method of Runnable class.
   */
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
