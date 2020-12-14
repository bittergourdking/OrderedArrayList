import java.util.ArrayList;
public class NoNullArrayList<T> extends ArrayList<T> {
  //constructors
  public NoNullArrayList() {
    super();
  }

  public NoNullArrayList(int initialCapacity) {
    super(initialCapacity);
  }
  //methods
  public boolean add(T element) {
    if (element == null) {
      throw new IllegalArgumentException("No nulls allowed.");
    }
    return super.add(element);
  }

  public void add(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("No nulls allowed.");
    }
    super.add(index, element);
  }

  public T set(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("No nulls allowed.");
    }
    return super.set(index, element);
  }

}
