package interpreter;

public abstract class Node {
  public abstract void parse(Context ctx) throws ParseException;
}
