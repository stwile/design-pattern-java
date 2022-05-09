package chainOfResponsibility;

public class Trouble {
  private final int number;

  public Trouble(int number) {
    this.number = number;
  }

  public int getNumber() {
    return this.number;
  }

  @Override
  public String toString() {
    return String.format("[Trouble %d]", this.number);
  }
}
