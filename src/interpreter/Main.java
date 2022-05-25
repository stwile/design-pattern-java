package interpreter;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
  public static void main(String[] args) {
    try {
      for (String text : Files.readAllLines(Path.of("program.txt"))) {
        System.out.printf("text = \"%s\"%n", text);
        Node node = new ProgramNode();
        node.parse(new Context(text));
        System.out.printf("node = %s%n", node);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
