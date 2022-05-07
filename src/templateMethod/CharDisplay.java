package templateMethod;

public class CharDisplay extends AbstractDisplay {

  private final char ch; // 表示すべき文字

  public CharDisplay(char ch) {
    this.ch = ch;
  }

  @Override
  public void open() {
    // 開始文字列として "<<" を表示する
    System.out.print("<<");
  }

  @Override
  public void print() {
    // フィールドに保存しておいた文字を一回表示する
    System.out.print(this.ch);
  }

  @Override
  public void close() {
    // 終了文字列として ">>" を表示する
    System.out.println("<<");
  }
}
