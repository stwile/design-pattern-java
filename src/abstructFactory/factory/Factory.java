package abstructFactory.factory;

public abstract class Factory {
  public static Factory getFactory(String className) {
    try {
      return (Factory) Class.forName(className).getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public abstract Link createLink(String caption, String url);

  public abstract Tray createTray(String caption);

  public abstract Page createPage(String title, String author);
}
