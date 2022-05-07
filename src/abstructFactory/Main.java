package abstructFactory;

import abstructFactory.factory.Factory;
import abstructFactory.factory.Link;
import abstructFactory.factory.Page;
import abstructFactory.factory.Tray;

public class Main {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java Main filename.html class.name.of.ConcreteFactory");
      System.out.println("Example 1: java Main list.html listfactory.ListFactory");
      System.out.println("Example 2: java Main div.html divfactory.DivFactory");
    }

    String fileName = args[0];
    String className = args[1];

    Factory factory = Factory.getFactory(className);

    final String url = "https://example.com/%s";

    // Blog
    Tray blogTray = factory.createTray("Blog Site");
    blogTray.add(factory.createLink("Blog 1", String.format(url, "blog1")));
    blogTray.add(factory.createLink("Blog 2", String.format(url, "blog2")));
    blogTray.add(factory.createLink("Blog 3", String.format(url, "blog3")));

    // News
    Link news1 = factory.createLink("News 1", String.format(url, "news1"));
    Link news2 = factory.createLink("News 2", String.format(url, "news2"));
    Tray news3 = factory.createTray("News 3");
    news3.add(factory.createLink("News 3 (US)", String.format(url, "news3us")));
    news3.add(factory.createLink("News 3 (Japan)", String.format(url, "news3jp")));

    Tray newsTray = factory.createTray("News Site");
    newsTray.add(news1);
    newsTray.add(news2);
    newsTray.add(news3);

    // Page
    Page page = factory.createPage("Blog and News", "Hiroshi Yuki");
    page.add(blogTray);
    page.add(newsTray);

    page.output(fileName);
  }
}
