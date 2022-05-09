package decorator;

public class FullBorder extends Border {
  public FullBorder(Display display) {
    super(display);
  }

  @Override
  public int getColumns() {
    // 文字数は中身の両側に飾り文字を加えたもの
    return 1 + this.display.getColumns() + 1;
  }

  @Override
  public int getRows() {
    // 行数は中身の行数に飾り文字を加えたもの
    return 1 + this.display.getRows() + 1;
  }

  @Override
  public String getRowText(int row) {
    if (this.isTopOrBottom(row, this.display)) {
      return String.format(
          "+%s+", String.valueOf('-').repeat(Math.max(0, this.display.getColumns())));
    }
    return String.format("|%s|", this.display.getRowText(row - 1));
  }

  private boolean isTopOrBottom(int row, Display display) {
    if (row == 0) {
      return true;
    }
    return row == (display.getRows() + 1);
  }
}
