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
    for (int i = 0; i < super.size(); i++) {
      if (element.compareTo(super.get(i)) <= 0) {
        return i;
      }
    }
    return super.size();
  }

  public boolean add(T element) {
    if (element == null) {
      throw new IllegalArgumentException("No nulls allowed.");
    }
    super.add(findIndex(element), element);
    return true;
  }

  public void add(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("No nulls allowed.");
    }
    if (index > super.size()) {
      throw new IndexOutOfBoundsException("Index is larger than capacity.");
    }
    super.add(findIndex(element), element);
  }

  public T set(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("No nulls allowed.");
    }
    if (index > super.size()) {
      throw new IndexOutOfBoundsException("Index is larger than capacity.");
    }
    T answer = super.get(index);
    super.remove(index);
    int correctIndex = findIndex(element);
    super.add(super.size(), super.get(super.size() - 1));
    for (int j = super.size() - 2; j > correctIndex; j--) {
        super.set(j, super.get(j - 1));
      }
    super.set(correctIndex, element);
    return answer;
  }
}
