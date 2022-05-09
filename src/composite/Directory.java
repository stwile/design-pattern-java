package composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
  private final String name;
  private final List<Entry> directory = new ArrayList<>();

  public Directory(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getSize() {
    int size = 0;
    for (Entry entry : this.directory) {
      size += entry.getSize();
    }
    return size;
  }

  @Override
  protected void printList(String prefix) {
    System.out.printf("%s/%s%n", prefix, this);
    for (Entry entry : this.directory) {
      entry.printList(String.format("%s/%s", prefix, this.name));
    }
  }

  public Entry add(Entry entry) {
    this.directory.add(entry);
    return this;
  }
}
