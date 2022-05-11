package mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
  private ColleagueCheckBox checkGuest;
  private ColleagueCheckBox checkLogin;
  private ColleagueTextFiled textUser;
  private ColleagueTextFiled textPass;
  private ColleagueButton buttonOk;
  private ColleagueButton buttonCancel;

  public LoginFrame(String title) throws HeadlessException {
    super(title);

    // 背景色を設定する
    this.setBackground(Color.lightGray);

    // レイアウトマネージャを使って4×2のグリッドを作る
    this.setLayout(new GridLayout(4, 2));

    // Colleagueたちを生成する
    this.createColleagues();

    // 配置する
    this.add(checkGuest);
    this.add(new Label("Username:"));
    this.add(textUser);
    this.add(new Label("Password:"));
    this.add(textPass);
    this.add(buttonOk);
    this.add(buttonCancel);

    // 有効/無効の初期指定をする
    this.colleagueChanged();

    // 表示をする
    this.pack();
    this.setVisible(true);
  }

  @Override
  public void createColleagues() {
    // CheckBox
    CheckboxGroup g = new CheckboxGroup();
    this.checkGuest = new ColleagueCheckBox("Guest", g, true);
    this.checkLogin = new ColleagueCheckBox("Login", g, false);

    // TextField
    this.textUser = new ColleagueTextFiled("", 10);
    this.textPass = new ColleagueTextFiled("", 10);
    this.textPass.setEchoChar('*');

    // Button
    this.buttonOk = new ColleagueButton("OK");
    this.buttonCancel = new ColleagueButton("Cancel");

    // Mediatorを設定する
    this.checkGuest.setMediator(this);
    this.checkLogin.setMediator(this);
    this.textUser.setMediator(this);
    this.textPass.setMediator(this);
    this.buttonOk.setMediator(this);
    this.buttonCancel.setMediator(this);

    // Listenerのセット
    this.checkGuest.addItemListener(this.checkGuest);
    this.checkLogin.addItemListener(this.checkLogin);
    this.textUser.addTextListener(this.textUser);
    this.textPass.addTextListener(this.textPass);
    this.buttonOk.addActionListener(this);
    this.textUser.addActionListener(this);
  }

  @Override
  public void colleagueChanged() {
    if (this.checkGuest.getState()) {
      // ゲストログイン
      this.textUser.setColleagueEnabled(false);
      this.textPass.setColleagueEnabled(false);
      this.buttonOk.setColleagueEnabled(true);
    } else {
      // ユーザログイン
      this.textUser.setColleagueEnabled(true);
      this.userPassChanged();
    }
  }

  private void userPassChanged() {
    if (this.textUser.getText().length() > 0) {
      this.textPass.setColleagueEnabled(true);
      this.buttonOk.setColleagueEnabled(this.textPass.getText().length() > 0);
    } else {
      this.textPass.setColleagueEnabled(false);
      this.buttonOk.setColleagueEnabled(false);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.toString());
    System.exit(0);
  }
}
