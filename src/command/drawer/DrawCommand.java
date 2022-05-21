package command.drawer;

import command.Command;

import java.awt.*;

public class DrawCommand implements Command {
  // 描画対象
  protected Drawable drawable;

  // 描画位置
  private final Point position;

  public DrawCommand(Drawable drawable, Point position) {
    this.drawable = drawable;
    this.position = position;
  }

  @Override
  public void execute() {
    drawable.draw(position.x, position.y);
  }
}
