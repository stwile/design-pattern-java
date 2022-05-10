package facade.pageMaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
  private Database() {}

  public static Properties getProperties(String dbName) throws IOException {
    String fileName = String.format("%s.txt", dbName);
    Properties prop = new Properties();
    System.out.println(new FileReader(fileName));
    prop.load(new FileReader(fileName));
    return prop;
  }
}
