package adapter.extend;

public class Banner {
  private final String string;

  public Banner(String string) {
    this.string = string;
  }

  public void showWithParen() {
    System.out.printf("(%s)\nPrint", this.string);
  }

  public void showWithAster() {
    System.out.printf("*%s*\n", this.string);
  }
}
