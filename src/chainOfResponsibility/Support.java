package chainOfResponsibility;

public abstract class Support {
  private final String name;
  private Support next;

  public Support(String name) {
    this.name = name;
    this.next = null;
  }

  public Support setNext(Support next) {
    this.next = next;
    return next;
  }

  @Override
  public String toString() {
    return String.format("[%s]", this.name);
  }

  public void support(Trouble trouble) {
    if (this.resolve(trouble)) {
      this.done(trouble);
    } else if (this.next != null) {
      next.support(trouble);
    } else {
      this.fail(trouble);
    }
  }

  protected abstract boolean resolve(Trouble trouble);

  protected void done(Trouble trouble) {
    System.out.printf("%s is resolved by %s.%n", trouble, this);
  }

  protected void fail(Trouble trouble) {
    System.out.printf("%s cannot be resolved%n", trouble);
  }
}
