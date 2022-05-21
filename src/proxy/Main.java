package proxy;

public class Main {
  public static void main(String[] args) {
    Printable p = new PrinterProxy("Alice");
    System.out.printf("名前は現在%sです%n", p.getPrinterName());
    p.setPrinterName("Bob");
    System.out.printf("名前は現在%sです%n", p.getPrinterName());
    p.print("Hello, world!");
  }
}
