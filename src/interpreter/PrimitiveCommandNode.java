package interpreter;

public class PrimitiveCommandNode extends Node {
  private String name;

  @Override
  public void parse(Context ctx) throws ParseException {
    name = ctx.currentToken();
    if (name == null) {
      throw new ParseException("Error: Missing <primitive command>");
    }
    if (check()) {
      throw new ParseException(String.format("Error: Unknown <primitive command>: %s", name));
    }
    ctx.skipToken(name);
  }

  @Override
  public String toString() {
    return name;
  }

  private boolean check() {
    if (name.equals("go")) {
      return false;
    }
    if (name.equals("right")) {
      return false;
    }
    return name.equals("left");
  }
}
