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
      if (element.compareTo(this.get(i)) <= 0) {
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
/*    int size = this.size();
    for (int i = 0; i < size; i++) {
      if (element.compareTo(this.get(i)) <= 0) {
        super.add(i, element);
        return true;
      }
    }
    return super.add(element);
*/
  }

  public void add(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("No nulls allowed.");
    }
    if (index > this.size()) {
      throw new IndexOutOfBoundsException("Index is larger than capacity.");
    }
    int size = this.size();
    for (int i = 0; i < size; i++) {
      if (element.compareTo(this.get(i)) <= 0) {
        super.add(i, element);
        break;
      }
    }
    super.add(size, element);
  }

  public T set(int index, T element) {
    if (element == null) {
      throw new IllegalArgumentException("No nulls allowed.");
    }
    if (index > this.size()) {
      throw new IndexOutOfBoundsException("Index is larger than capacity.");
    }
    T answer = this.get(index);
    int correctIndex = findIndex(element);
    this.remove(index);
    for (int j = super.size(); j > correctIndex; j--) {
      super.set(j, super.get(j - 1));
    }
    super.set(correctIndex, element);
    return answer;
  }

}
