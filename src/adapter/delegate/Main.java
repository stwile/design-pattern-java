package adapter.delegate;

import adapter.extend.Print;
import adapter.extend.PrintBanner;

public class Main {
  public static void main(String[] args) {
    Print p = new PrintBanner("Hello");
    p.printWeak();
    p.printStrong();
  }
}
