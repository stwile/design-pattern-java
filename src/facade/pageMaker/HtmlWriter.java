package facade.pageMaker;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {
  private final Writer writer;

  public HtmlWriter(Writer writer) {
    this.writer = writer;
  }

  public void title(String title) throws IOException {
    this.writer.write("<!DOCTYPE html>");
    this.writer.write("<html>");
    this.writer.write("<head>");
    this.writer.write(String.format("<title>%s</title>>", title));
    this.writer.write("</head>");
    this.writer.write("<body>");
    this.writer.write(String.format("<h1>%s</h1>>", title));
    this.writer.write("\n");
  }

  public void paragraph(String msg) throws IOException {
    this.writer.write(String.format("<p>%s</p>", msg));
    this.writer.write("\n");
  }

  public void link(String href, String caption) throws IOException {
      this.paragraph(String.format("<a href=\"%s\">%s</a>", href, caption));
  }

  public void mailTo(String mailAddress, String userName) throws IOException {
      this.link(String.format("mailto:%s", mailAddress), userName);
  }

  public void close() throws IOException {
      this.writer.write("</body>");
      this.writer.write("</html>");
      this.writer.write("\n");
      this.writer.close();
  }
}
