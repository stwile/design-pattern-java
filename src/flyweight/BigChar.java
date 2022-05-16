package flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {

  private String fontData;

  public BigChar(char charName) {
    try {
      String fileName = String.format("big%s.txt", charName);
      StringBuilder sb = new StringBuilder();
      for (String line : Files.readAllLines(Path.of(fileName))) {
        sb.append(line);
        sb.append("\n");
      }
      this.fontData = sb.toString();
    } catch (IOException e) {
      this.fontData = String.format("%s?", charName);
    }
  }

  public void print() {
    System.out.print(fontData);
  }
}
