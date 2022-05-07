package templateMethod;

public class StringDisplay extends AbstractDisplay {
  private final String string; // 表示すべき文字列
  private final int width; // 文字列の表示幅

  public StringDisplay(String string) {
    this.string = string;
    this.width = string.length();
  }

  @Override
  public void open() {
    this.printLine();
  }

  @Override
  public void print() {
    System.out.println("|" + this.string + "|");
  }

  @Override
  public void close() {
    this.printLine();
  }

  private void printLine() {
    System.out.print("+");
    for (int i = 0; i < this.width; i++) {
      System.out.print("-");
    }
    System.out.println("+");
  }
}
