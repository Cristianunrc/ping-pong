package panel;

import java.awt.*;

public class Score extends Rectangle {
  
  static int GAME_WIDTH;
  
  static int GAME_HEIGHT;
  
  int playerOne;
  
  int playerTwo;
  
  public Score(int width, int height) {
    Score.GAME_WIDTH = width;
    Score.GAME_HEIGHT = height;
  }
  
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
