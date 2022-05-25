package interpreter;

import java.util.ArrayList;
import java.util.List;

public class CommandListNode extends Node {
  private final List<Node> list = new ArrayList<>();

  @Override
  public void parse(Context ctx) throws ParseException {
    while (true) {
      if (ctx.currentToken() == null) {
        throw new ParseException("Error: Missing 'end'");
      }
      if (ctx.currentToken().equals("end")) {
        ctx.skipToken("end");
        break;
      }
      Node commandNode = new CommandNode();
      commandNode.parse(ctx);
      list.add(commandNode);
    }
  }

  @Override
  public String toString() {
    return list.toString();
  }
}
