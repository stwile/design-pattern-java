package facade.pageMaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
  private PageMaker() {}

  public static void makeWelcomePage(String mailAddress, String fileName) {
    try {
      Properties mailProp = Database.getProperties("mailData");
      String userName = mailProp.getProperty(mailAddress);
      HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
      writer.title(String.format("%s's web page", userName));
      writer.paragraph(String.format("Welcome to %s's web page!", userName));
      writer.paragraph("Nice to meet you!");
      writer.mailTo(mailAddress, userName);
      writer.close();
      System.out.printf("%s is created for %s (%s)", fileName, mailAddress, userName);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
