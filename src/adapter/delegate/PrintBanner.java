package adapter.delegate;

import adapter.extend.Banner;

public class PrintBanner extends Print {
  private final Banner banner;

  public PrintBanner(String string) {
    this.banner = new Banner(string);
  }

  @Override
  public void printWeak() {
    this.banner.showWithParen();
  }

  @Override
  public void printStrong() {
    this.banner.showWithAster();
  }
}
