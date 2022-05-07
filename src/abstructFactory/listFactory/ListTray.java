package abstructFactory.listFactory;

import abstructFactory.factory.Item;
import abstructFactory.factory.Tray;

public class ListTray extends Tray {
  public ListTray(String caption) {
    super(caption);
  }

  @Override
  public String makeHtml() {
    StringBuilder sb = new StringBuilder();
    sb.append("<li>\n");
    sb.append(this.caption);
    sb.append("</li>\n");
    sb.append("\n<ul>\n");
    for (Item item : this.tray) {
      sb.append(item.makeHtml());
    }
    sb.append("</ul>\n");
    sb.append("</li>\n");
    return sb.toString();
  }
}
