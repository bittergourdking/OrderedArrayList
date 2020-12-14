public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T> {
  //constructors
  public OrderedArrayList() {
    super();
  }

  public OrderedArrayList(int initialCapacity) {
    super(initialCapacity);
  }
  //methods
  private int findIndex(T element) {
    if (element == null) {
      throw new IllegalArgumentException("No nulls allowed.");
    }
    int index = 0;
    while (index < size() - 1
        && element.compareTo(get(index + 1)) < 0) {
      index++;
    }
    return index;
  }

  public boolean add(T element) {
    super.add(findIndex(element), element);
    return true;
  }

  public void add(int index, T element) {
    super.add(findIndex(element), element);
  }

  public T set(int index, T element) {
    return super.set(findIndex(element), element);
  }

}
