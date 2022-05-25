package interpreter;

public class RepeatCommandNode extends Node {
  private int number;
  private Node commandListNode;

  @Override
  public void parse(Context ctx) throws ParseException {
    ctx.skipToken("repeat");
    ;
    number = ctx.currentNumber();
    ctx.nextToken();
    commandListNode = new CommandListNode();
    commandListNode.parse(ctx);
  }

  @Override
  public String toString() {
    return String.format("[repeat %d %s]", number, commandListNode);
  }
}
