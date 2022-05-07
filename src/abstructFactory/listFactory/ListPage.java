package abstructFactory.listFactory;

import abstructFactory.factory.Item;
import abstructFactory.factory.Page;

public class ListPage extends Page {
  public ListPage(String title, String author) {
    super(title, author);
  }

  @Override
  public String makeHtml() {
    StringBuilder sb = new StringBuilder();
    sb.append("<!DOCTYPE html>\n");
    sb.append("<html>\n");
    sb.append("<head><title>");
    sb.append(this.title);
    sb.append("</head></title>\n");
    sb.append("<body>\n");
    sb.append("<h1>\n");
    sb.append(this.title);
    sb.append("</h1>\n");
    sb.append("<ul>");
    for (Item item : this.content) {
      sb.append(item.makeHtml());
    }
    sb.append("<ul>\n");
    sb.append("<hr><address>");
    sb.append(this.author);
    sb.append("</address>\n");
    sb.append("</body></html>\n");
    return sb.toString();
  }
}
