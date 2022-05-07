package prototype.framework;

public class UnderlinePen implements Product {
  private final char ulchar;

  public UnderlinePen(char ulchar) {
    this.ulchar = ulchar;
  }

  @Override
  public void use(String s) {
    int ulen = s.length();
    System.out.println(s);
    for (int i = 0; i < ulen; i++) {
      System.out.print(this.ulchar);
    }
    System.out.println();
  }

  @Override
  public Product createCopy() {
    try {
      return (Product) clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }
}
