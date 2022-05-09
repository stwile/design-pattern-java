package decorator;

public class SideBorder extends Border {
  private final char borderChar;

  public SideBorder(Display display, char ch) {
    super(display);
    this.borderChar = ch;
  }

  @Override
  public int getColumns() {
    // 文字数は中身の両側に飾り文字を加えたもの
    return 1 + this.display.getColumns() + 1;
  }

  @Override
  public int getRows() {
    // 行数は中身の行数に同じ
    return this.display.getRows();
  }

  @Override
  public String getRowText(int row) {
    // 指定業の内容は、中身の指定業の両側に飾り文字を付けたもの
    return this.borderChar + this.display.getRowText(row) + this.borderChar;
  }
}
