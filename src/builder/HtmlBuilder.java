package builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class HtmlBuilder extends Builder {
  private String fileName = "untitled.html";
  private final StringBuilder sb = new StringBuilder();

  @Override
  public void makeTitle(String title) {
    this.fileName = String.format("%s.html", title);
    sb.append("<!DOCTYPE html>\n");
    sb.append("<html>\n");
    sb.append("<head><title>");
    sb.append(title);
    sb.append("</head></title>\n");
    sb.append("<body>\n");
    sb.append("<h1>\n");
    sb.append(title);
    sb.append("</h1>\n");
  }

  @Override
  public void makeString(String str) {
    sb.append("<p>");
    sb.append(str);
    sb.append("</p>\n\n");
  }

  @Override
  public void makeItems(String[] items) {
    sb.append("<ul>");
    for (String s : items) {
      sb.append("<li>");
      sb.append(s);
      sb.append("</li>\n\n");
    }
    sb.append("<ul>\n\n");
  }

  @Override
  public void close() {
    sb.append("</body>");
    sb.append("</html>\n");
    try {
      Writer w = new FileWriter(this.fileName);
      w.write(sb.toString());
      w.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getHTMLResult() {
    return this.fileName;
  }
}
