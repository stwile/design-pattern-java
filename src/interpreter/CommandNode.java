package interpreter;

public class CommandNode extends Node {
  private Node node;

  @Override
  public void parse(Context ctx) throws ParseException {
    if (ctx.currentToken().equals("repeat")) {
      node = new RepeatCommandNode();
      node.parse(ctx);
      return;
    }
    node = new PrimitiveCommandNode();
    node.parse(ctx);
  }

  @Override
  public String toString() {
    return node.toString();
  }
}
