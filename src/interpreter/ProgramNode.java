package interpreter;

public class ProgramNode extends Node {
  private Node commandListNode;

  @Override
  public void parse(Context ctx) throws ParseException {
    ctx.skipToken("program");
    commandListNode = new CommandListNode();
    commandListNode.parse(ctx);
  }

  @Override
  public String toString() {
    return String.format("[program %s]", commandListNode);
  }
}
