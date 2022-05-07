package abstructFactory.divFactory;

import abstructFactory.factory.Item;
import abstructFactory.factory.Tray;

public class DivTray extends Tray {
  public DivTray(String caption) {
    super(caption);
  }

  @Override
  public String makeHtml() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><b>");
    sb.append(this.caption);
    sb.append("</b></p>\n");
    sb.append("<div class=\"TRAY\">");
    for (Item item : this.tray) {
      sb.append(item.makeHtml());
    }
    sb.append("</div>\n");
    return sb.toString();
  }
}
