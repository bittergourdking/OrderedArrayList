public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T> {
  //constructors
  public OrderedArrayList() {
    super();
  }

  public OrderedArrayList(int initialCapacity) {
    super(initialCapacity);
  }
  //methods
  private int findIndex(T element, int size) {
    if (element == null) {
      throw new IllegalArgumentException("You tried to set a null value! That is not allowed.");
    }
    int index = 0;
    for (int i = 0; i < size; i++) {
      if (super.get(i).compareTo(element) < 0) {
        i++;
      }
    }
    return index;
  }

  public boolean add(T element) {
    if (element == null) {
      throw new IllegalArgumentException("You tried to set a null value! That is not allowed.");
    }
    int size = this.size();
    for (int i = 0; i < size; i++) {
      if (element.compareTo(this.get(i)) <= 0) {
        super.add(i, element);
        return true;
      }
    }
    return super.add(element);
  }

  public void add(int index, T element) {
    super.add(findIndex(element, this.size()), element);
  }

  public T set(int index, T element) {
    return super.set(findIndex(element, this.size()), element);
  }

}
