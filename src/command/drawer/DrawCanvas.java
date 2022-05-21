package command.drawer;

import command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
  ;
  // 履歴
  private final MacroCommand history;

  public DrawCanvas(int width, int height, MacroCommand history) {
    setSize(width, height);
    setBackground(Color.white);
    this.history = history;
  }

  @Override
  public void paint(Graphics g) {
    history.execute();
  }

  // 描画
  @Override
  public void draw(int x, int y) {
    int radius = 6;
    Graphics g = getGraphics();
    g.setColor(Color.red);
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
  }
}
