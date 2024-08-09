package panel;

import java.awt.*;

/**
 * Representing the score points in the panel game.
 */
public class Score extends Rectangle {
  
  static int GAME_WIDTH;
  
  static int GAME_HEIGHT;
  
  int playerOne;
  
  int playerTwo;
  
  /**
   * Class constructor which initialize the width and
   * height of the game.
   * @param width an int representing the width of the game.
   * @param height an int representing the height of the game.
   */
  public Score(int width, int height) {
    Score.GAME_WIDTH = width;
    Score.GAME_HEIGHT = height;
  }
  
  /**
   * Draw the score numbers on the panel game.
   * @param g an Graphics instance. 
   */
  public void draw(Graphics g) {
    g.setColor(Color.white);
    g.setFont(new Font("Consolas", Font.PLAIN, 60));
    g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);
    
    String scorePlayerOne = String.valueOf(playerOne / 10) + String.valueOf(playerOne % 10);
    String scorePlayerTwo = String.valueOf(playerTwo / 10) + String.valueOf(playerTwo % 10);
    g.drawString(scorePlayerOne, (GAME_WIDTH / 2) - 85, 50);
    g.drawString(scorePlayerTwo, (GAME_WIDTH / 2) + 20, 50);
  }

}
