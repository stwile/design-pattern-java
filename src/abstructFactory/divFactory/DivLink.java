package abstructFactory.divFactory;

import abstructFactory.factory.Link;

public class DivLink extends Link {
  public DivLink(String caption, String url) {
    super(caption, url);
  }

  @Override
  public String makeHtml() {
    return String.format(
        "<div class=\"LINK\"><a href=\"%s\">%s</a></div>\n", this.url, this.caption);
  }
}
