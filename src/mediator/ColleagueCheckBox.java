package mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckBox extends Checkbox implements ItemListener, Colleague {
  private Mediator mediator;

  public ColleagueCheckBox(String caption, CheckboxGroup group, boolean state)
      throws HeadlessException {
    super(caption, group, state);
  }

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void setColleagueEnabled(boolean enabled) {
    this.setEnabled(enabled);
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    this.mediator.colleagueChanged();
  }
}
