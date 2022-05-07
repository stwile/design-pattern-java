package templateMethod;

public abstract class AbstractDisplay {
  // open, print, closeはサブクラスに実装を任せる抽象メソッド
  public abstract void open();

  public abstract void print();

  public abstract void close();

  // displayはAbstractDisplayで実装しているメソッド
  public final void display() {
    this.open();
    for (int i = 0; i < 5; i++) {
      this.print();
    }
    this.close();
  }
}
