package mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextFiled extends TextField implements TextListener, Colleague {
  private Mediator mediator;

  public ColleagueTextFiled(String text, int columns) {
    super(text, columns);
  }

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void setColleagueEnabled(boolean enabled) {
    this.setEnabled(enabled);
    // 有効/無効に合わせて背景色を変更する
    this.setBackground(enabled ? Color.white : Color.lightGray);
  }

  @Override
  public void textValueChanged(TextEvent e) {
    // 文字列が変化したらMediatorに通知する
    this.mediator.colleagueChanged();
  }
}
