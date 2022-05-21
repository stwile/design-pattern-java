package command;

import command.drawer.DrawCanvas;
import command.drawer.DrawCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
  // 描画履歴
  private final MacroCommand history = new MacroCommand();

  // 描画領域
  private final DrawCanvas canvas = new DrawCanvas(400, 400, history);

  public Main(String title) throws HeadlessException {
    super(title);

    this.addWindowListener(this);
    canvas.addMouseMotionListener(this);
    // 消去ボタン
    JButton clearButton = new JButton("clear");
    clearButton.addActionListener(
        e -> {
          history.clear();
          canvas.repaint();
        });

    Box buttonBox = new Box(BoxLayout.X_AXIS);
    buttonBox.add(clearButton);
    Box mainBox = new Box(BoxLayout.Y_AXIS);
    mainBox.add(buttonBox);
    mainBox.add(canvas);
    getContentPane().add(mainBox);

    pack();
    setVisible(true);
  }

  @Override
  public void mouseMoved(MouseEvent e) {}

  @Override
  public void mouseDragged(MouseEvent e) {
    Command cmd = new DrawCommand(canvas, e.getPoint());
    history.append(cmd);
    cmd.execute();
  }

  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }

  @Override
  public void windowActivated(WindowEvent e) {}

  @Override
  public void windowClosed(WindowEvent e) {}

  @Override
  public void windowDeactivated(WindowEvent e) {}

  @Override
  public void windowDeiconified(WindowEvent e) {}

  @Override
  public void windowIconified(WindowEvent e) {}

  @Override
  public void windowOpened(WindowEvent e) {}

  public static void main(String[] args) {
    new Main("Command Pattern Sample");
  }
}
