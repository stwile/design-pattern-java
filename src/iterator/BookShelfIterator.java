package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {
  private final BookShelf bookShelf;
  private int index;

  public BookShelfIterator(BookShelf bookShelf) {
    this.bookShelf = bookShelf;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return this.index < this.bookShelf.getLength();
  }

  @Override
  public Book next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException();
    }
    Book book = bookShelf.getBookAt(index);
    this.index++;
    return book;
  }
}
