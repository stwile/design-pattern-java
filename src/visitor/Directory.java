package visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Entry implements Iterable<Entry> {
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

  public void add(Entry entry) {
    this.directory.add(entry);
  }

  @Override
  public Iterator<Entry> iterator() {
    return this.directory.iterator();
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
