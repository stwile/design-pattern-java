package builder;

public class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      usage();
      System.exit(0);
    }

    if (args[0].equals("text")) {
      TextBuilder tb = new TextBuilder();
      Director director = new Director(tb);
      director.construct();
      System.out.println(tb.getTextResult());
    } else if (args[0].equals("html")) {
      HtmlBuilder hb = new HtmlBuilder();
      Director director = new Director(hb);
      director.construct();
      System.out.println(hb.getHTMLResult());
    } else {
      usage();
      System.exit(0);
    }
  }

  public static void usage() {
    System.out.println("Usage java Main text テキストで文書作成");
    System.out.println("Usage java Main html HTMLファイルで文書作成");
  }
}
