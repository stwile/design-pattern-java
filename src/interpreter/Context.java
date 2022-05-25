package interpreter;

public class Context {
  private final String[] tokens;
  private String lastToken;
  private int index = 0;

  public Context(String text) {
    this.tokens = text.split("\\s+");
    lastToken = nextToken();
  }

  public String nextToken() {
    if (index > tokens.length) {
      lastToken = null;
      return lastToken;
    }
    lastToken = tokens[index++];
    return lastToken;
  }

  public String currentToken() {
    return lastToken;
  }

  public void skipToken(String token) throws ParseException {
    String currentToken = currentToken();
    if (currentToken == null) {
      throw new ParseException(
          String.format("Error: %s is expected, but no more token is found", token));
    }
    if (!token.equals(currentToken)) {
      throw new ParseException(
          String.format("Error: %s is expected, but %s is found", token, currentToken));
    }
    lastToken = nextToken();
  }

  public int currentNumber() throws ParseException {
    String currentToken = currentToken();
    if (currentToken == null) {
      throw new ParseException("Error: No more token.");
    }
    int number;
    try {
      number = Integer.parseInt(currentToken);
    } catch (NumberFormatException e) {
      throw new ParseException(String.format("Error: %s", e));
    }
    return number;
  }
}
