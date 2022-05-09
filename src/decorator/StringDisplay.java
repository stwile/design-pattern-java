package decorator;

public class StringDisplay extends Display {
  private final String string;

  public StringDisplay(String string) {
    this.string = string;
  }

  @Override
  public int getColumns() {
    return this.string.length();
  }

  @Override
  public int getRows() {
    return 1;
  }

  @Override
  public String getRowText(int row) {
    if (row != 0) {
      throw new IndexOutOfBoundsException();
    }
    return this.string;
  }
}
