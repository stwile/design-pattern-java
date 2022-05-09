package composite;

public abstract class Entry {
  public abstract String getName();

  public abstract int getSize();

  public void printList() {
    this.printList("");
  }

  protected abstract void printList(String prefix);

  @Override
  public String toString() {
    return String.format("%s (%d)", this.getName(), this.getSize());
  }
}
