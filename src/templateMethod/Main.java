package templateMethod;

public class Main {
  public static void main(String[] args) {
    // Hを持ったCharDisplayのインスタンスを一個作る
    AbstractDisplay d1 = new CharDisplay('H');

    // "Hello, world." をもったStringDisplayのインスタンスを一個作る
    AbstractDisplay d2 = new StringDisplay("Hello, world.");

    d1.display();
    d2.display();
  }
}
