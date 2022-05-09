package visitor;

public class ListVisitor extends Visitor {
  private String currentDir = "";

  @Override
  public void visit(File file) {
    // File訪問時
    System.out.printf("%s/%s%n", this.currentDir, file);
  }

  @Override
  public void visit(Directory directory) {
    System.out.printf("%s/%s%n", this.currentDir, directory);
    String saveDir = this.currentDir;
    this.currentDir = String.format("%s/%s", this.currentDir, directory.getName());
    for (Entry entry : directory) {
      entry.accept(this);
    }
    currentDir = saveDir;
  }
}
