package abstructFactory.divFactory;

import abstructFactory.factory.Item;
import abstructFactory.factory.Page;

public class DivPage extends Page {
  public DivPage(String title, String author) {
    super(title, author);
  }

  @Override
  public String makeHtml() {
    StringBuilder sb = new StringBuilder();
    sb.append("<!DOCTYPE html>\n");
    sb.append("<html><head><title>");
    sb.append(this.title);
    sb.append("</title><style>\n");
    sb.append("div.TRAY {}");
    sb.append("div.LINK {}");
    sb.append("</style></head><body>\n");
    sb.append("<h1>\n");
    sb.append(this.title);
    sb.append("</h1>\n");
    for (Item item : this.content) {
      sb.append(item.makeHtml());
    }
    sb.append("<hr><address>");
    sb.append(this.author);
    sb.append("</address>\n");
    sb.append("</body></html>\n");
    return sb.toString();
  }
}
