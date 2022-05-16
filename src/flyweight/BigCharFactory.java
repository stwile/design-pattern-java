package flyweight;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
  private final Map<String, BigChar> pool = new HashMap<>();

  private static final BigCharFactory singleton = new BigCharFactory();

  private BigCharFactory() {}

  public static BigCharFactory getInstance() {
    return singleton;
  }

  public synchronized BigChar getBigChar(char charName) {
    BigChar bc = pool.get(String.valueOf(charName));
    if (bc != null) {
      return bc;
    }
    bc = new BigChar(charName);
    pool.put(String.valueOf(charName), bc);
    return bc;
  }
}
