package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;
import prototype.framework.UnderlinePen;

public class Main {
  public static void main(String[] args) {
      Manager manager = new Manager();
      UnderlinePen upen = new UnderlinePen('-');
      MessageBox mbox = new MessageBox('*');
      MessageBox sbox = new MessageBox('/');

      String sMessage = "strong message";
      String wBox = "warning box";
      String sBox = "slash box";

      manager.register(sMessage, upen);
      manager.register(wBox, mbox);
      manager.register(sBox, sbox);

      String helloWorld = "Hello, world.";

      Product p1 = manager.create(sMessage);
      p1.use(helloWorld);

      Product p2 = manager.create(wBox);
      p2.use(helloWorld);

      Product p3 = manager.create(sBox);
      p3.use(helloWorld);
  }
}
