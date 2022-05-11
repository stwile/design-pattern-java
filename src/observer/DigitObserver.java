package observer;

public class DigitObserver implements Observer {
  @Override
  public void update(NumberGenerator generator) {
    System.out.printf("DigitObserver: %d%n", generator.getNumber());
    try {
      Thread.sleep(100);
    } catch (InterruptedException ignored) {
    }
  }
}
