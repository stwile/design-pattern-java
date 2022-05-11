package state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {
  private final TextField textClock = new TextField(60);
  private final TextArea textScreen = new TextArea(10, 60);
  private final Button buttonUse = new Button("金庫使用");
  private final Button buttonAlarm = new Button("非常ベル");
  private final Button buttonPhone = new Button("通常通話");
  private final Button buttonExit = new Button("終了");

  private State state = DayState.getInstance();

  public SafeFrame(String title) throws HeadlessException {
    super(title);
    setBackground(Color.lightGray);
    setLayout(new BorderLayout());
    add(textClock);
    textClock.setEditable(false);
    add(textScreen, BorderLayout.CENTER);
    textScreen.setEditable(false);

    Panel panel = new Panel();
    panel.add(buttonUse);
    panel.add(buttonAlarm);
    panel.add(buttonPhone);
    panel.add(buttonExit);

    add(panel, BorderLayout.SOUTH);

    pack();
    setVisible(true);

    buttonUse.addActionListener(this);
    buttonAlarm.addActionListener(this);
    buttonPhone.addActionListener(this);
    buttonExit.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.toString());
    Object obj = e.getSource();
    if (obj == buttonUse) {
      state.doUse(this);
    } else if (obj == buttonAlarm) {
      state.doAlarm(this);
    } else if (obj == buttonPhone) {
      state.doPhone(this);
    } else if (obj == buttonExit) {
      System.exit(0);
    } else {
      System.out.println("?");
    }
  }

  @Override
  public void setClock(int hour) {
    String clockString = String.format("現在時刻は%02d:00", hour);
    System.out.println(clockString);
    textClock.setText(clockString);
    state.doClock(this, hour);
  }

  @Override
  public void changeState(State state) {
    System.out.printf("%sから%sへ状態が変化しました。%n", this.state, state);
    this.state = state;
  }

  @Override
  public void callSecurityCenter(String msg) {
    textScreen.append(String.format("call! %s%n", msg));
  }

  @Override
  public void recordLog(String msg) {
    textScreen.append(String.format("record ... %s%n", msg));
  }
}
